package org.lazicats.ecos.internal.payment.common.Allunion.ws.component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.lazicats.ecos.basecomponent.utils.DateUtils;
import org.lazicats.ecos.internal.payment.common.Allunion.db.Dao;
import org.lazicats.ecos.internal.payment.common.Allunion.http.HttpOperator;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotify;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotifyRsp;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayQuery;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayQueryRsp;
import org.lazicats.ecos.internal.payment.component.impl.PaymentComponentImpl;
import org.lazicats.ecos.order.common.OrderConstants;
import org.lazicats.ecos.order.service.component.IOrderComponent;
import org.lazicats.ecos.order.service.model.OrderDo;
import org.lazicats.ecos.order.service.model.OrderImportedDo;
import org.springframework.stereotype.Service;


/**
 * component serve as a manipulator of order for paytrans serivce i love you.
 * 
 * @author Jay
 *
 */
@Service
public class PayTransComponent {
  private static final Logger logger = Logger.getLogger(PayTransComponent.class);

  public static final String ALLINPAY_NOTIFY_DATE_FORMAT = "yyyyMMddHHmmss";
  public static final String SAVE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String ALLINPAY = "allinpay";
  public static final String AMOUNT_UNEQUAL = "9997";
  public static final String OTHER_ERROR = "9996";
  public static final String PAYMENT_OFFSET = "A0000003";
  public static final String PAYMENT_SUCCESS = "A0000002";
  public static final String SUCCESS = "0000";
  public static final String ILLEGAL_ORDER_NO = "9990";
  public static final String ALREADY_PAID = "9999";
  public static final String ORDER_LOCK_STATE_LOCKED = "1";
  public static final String NOT_CBT_ORDER = "9991";
  public static final BigDecimal ONEHUNDRED = new BigDecimal("100");

  @Resource
  private PaymentComponentImpl paymentComponent;

  @Resource
  private IOrderComponent orderComponent;

  @Resource
  private Dao dao;


  public PayQueryRsp checkOrder(PayQuery payQuery) {
    PayQueryRsp payQueryRsp = new PayQueryRsp();

    try {
      OrderDo orderDo = orderComponent.getOrderByOrderNo(payQuery.getBizseq());
      if (orderDo == null) {
        payQueryRsp.setRspcode(ILLEGAL_ORDER_NO);
        payQueryRsp.setRspmsg("非法订单号,系统不存在该订单！");
      } else {

        if (!("3".equals(orderDo.getOrderType()))) {
          payQueryRsp.setRspcode(NOT_CBT_ORDER);
          payQueryRsp.setRspmsg("非跨境订单！");
          return payQueryRsp;
        }

        if (ORDER_LOCK_STATE_LOCKED.equals(orderDo.getLockState())) {
          payQueryRsp.setRspcode(ILLEGAL_ORDER_NO);
          payQueryRsp.setRspmsg("非法订单号,该订单已被锁定！");
          return payQueryRsp;
        }

        if (OrderConstants.BASIC_STATE_CANCEL.equals(orderDo.getBasicState())) {
          payQueryRsp.setRspcode(ILLEGAL_ORDER_NO);
          payQueryRsp.setRspmsg("非法订单号,该订单已取消！");
          return payQueryRsp;
        }

        if (OrderConstants.PAYMENT_STATE_ALREADY.equals(orderDo.getPaymentState())) {
          payQueryRsp.setRspcode(ALREADY_PAID);
          payQueryRsp.setRspmsg("已缴费！");
          return payQueryRsp;
        }

        payQueryRsp.setRspcode(SUCCESS);
        payQueryRsp.setRspmsg("订单成功通过检验！");
        payQueryRsp.setAmount(getOrderAmountCentLong(orderDo));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return payQueryRsp;
  }



  private Long getOrderAmountCentLong(OrderDo orderDo) {
    BigDecimal orderAmount = new BigDecimal(orderDo.getFeeTotal().toString());
    BigDecimal centBig = orderAmount.multiply(ONEHUNDRED);
    String centBigStr = centBig.toString();
    String centStr = StringUtils.substringBeforeLast(centBigStr, ".");
    return Long.valueOf(centStr);
  }



  public PayNotifyRsp checkIn(PayNotify payNotify) {
    checkIdentity();

    PayNotifyRsp payNotifyRsp = new PayNotifyRsp();

    if (!dao.isTrxidExist(payNotify.getTrxid())) {
      dao.insertPaymentRef(payNotify);
    }

    try {
      OrderDo orderDo = orderComponent.getOrder(payNotify.getBizseq());

      if (orderDo == null) {
        payNotifyRsp.setRspcode(OTHER_ERROR);
        payNotifyRsp.setRspmsg("系统订单不存在！");
        return payNotifyRsp;
      }

      if (ORDER_LOCK_STATE_LOCKED.equals(orderDo.getLockState())) {
        payNotifyRsp.setRspcode(OTHER_ERROR);
        payNotifyRsp.setRspmsg("非法订单号,该订单已被锁定!");
        return payNotifyRsp;
      }

      if (OrderConstants.BASIC_STATE_CANCEL.equals(orderDo.getBasicState())) {
        payNotifyRsp.setRspcode(OTHER_ERROR);
        payNotifyRsp.setRspmsg("非法订单号,该订单已取消！");
        return payNotifyRsp;
      }

      if (OrderConstants.PAYMENT_STATE_ALREADY.equals(orderDo.getPaymentState())) {
        if (PAYMENT_OFFSET.equals(payNotify.getTrxcod())) {// 冲正，把已支付的订单改变待支付
          doWithPaymentOffset(payNotify, orderDo, payNotifyRsp);
        } else {
          payNotifyRsp.setRspcode(ALREADY_PAID);
          payNotifyRsp.setRspmsg("已缴费!");
          return payNotifyRsp;
        }

      } else if (SUCCESS.equals(payNotify.getPayresult())) {
        if (PAYMENT_SUCCESS.equals(payNotify.getTrxcod())) {
          doWithPaymentSuccess(payNotify, payNotifyRsp, orderDo);
        } else if (PAYMENT_OFFSET.equals(payNotify.getTrxcod())) {
          payNotifyRsp.setRspcode(OTHER_ERROR);
          payNotifyRsp.setRspmsg("未支付状态的订单，无法冲正!");
          return payNotifyRsp;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      payNotifyRsp.setRspcode(OTHER_ERROR);
      payNotifyRsp.setRspmsg("系统内部错误！");
    }

    return payNotifyRsp;
  }



  private void doWithPaymentOffset(PayNotify payNotify, OrderDo orderDo, PayNotifyRsp payNotifyRsp)
      throws Exception {

    if (OrderConstants.DELIVERY_STATE_ALREADY.equals(orderDo.getDeliveryState())) {
      payNotifyRsp.setRspcode(OTHER_ERROR);
      payNotifyRsp.setRspmsg("该订单已发货 ，不能做冲正操作！");
      logger.info("forbidden operation on an delivering order！ [" + orderDo.getOrderNo() + "]");
      return;
    }

    logger.info("starting to reset order status to paying...");
    orderDo.setOrderNo(payNotify.getBizseq());
    orderDo.setPaymentState(OrderConstants.PAYMENT_STATE_WAITING);
    orderDo.setBasicState(OrderConstants.BASIC_STATE_UNAUDIT);
    orderDo.setPaidTotal(0d);
    orderDo.setPaymentTime(null);
    orderComponent.updateOrder(orderDo);
  }



  private void doWithPaymentSuccess(PayNotify payNotify, PayNotifyRsp payNotifyRsp, OrderDo orderDo)
      throws ParseException, JAXBException {

    Long orderAmount = getOrderAmountCentLong(orderDo);
    Long bankPaidAmount = Long.valueOf(payNotify.getAmount());

    if (orderAmount.compareTo(bankPaidAmount) == 0) {
      double bankPaidAmountYuan = convertCentLong2YuanDouble(bankPaidAmount);

      Date payDate = DateUtils.parseDate(payNotify.getTimestamp(), ALLINPAY_NOTIFY_DATE_FORMAT);
      try {
        logger.info("starting to update order status...");
        paymentComponent.payInform(payNotify.getBizseq(), ALLINPAY, payNotify.getTrxid(),
            DateUtils.formatDate(payDate, SAVE_DATE_FORMAT), String.valueOf(bankPaidAmountYuan));
      } catch (Exception e) {
        payNotifyRsp.setRspcode(OTHER_ERROR);
        payNotifyRsp.setRspmsg("更新订单状态时发生异常!");
      }

      payNotifyRsp.setRspcode(SUCCESS);
      payNotifyRsp.setRspmsg("订单已处理成功!");

      logger.info("starting to send the declaraction to custom...");
      double feeWithoutPaidTaxDeliveryFee =
          calculateFeeWithoutTaxAndDeliveryFee(orderDo, bankPaidAmountYuan);
      HttpOperator.sendDeclaration(orderDo, payNotify.getTrxid(),
          getPaytimeInGoodFormat(payNotify), feeWithoutPaidTaxDeliveryFee);

    } else {
      payNotifyRsp.setRspcode(AMOUNT_UNEQUAL);
      payNotifyRsp.setRspmsg("金额不一致!");
      logger.info("unequal amount [amount from bank:" + bankPaidAmount + " vs amount from order:"
          + orderAmount + "]");
    }
  }



  private double calculateFeeWithoutTaxAndDeliveryFee(OrderDo orderDo, double bankPaidAmountYuan) {
    OrderImportedDo orderImported = orderDo.getOrderImported();
    double feeWithoutPaidTaxDeliveryFee = calculate(bankPaidAmountYuan, orderImported.getPaidTax(), orderDo
                .getDeliveryFeeTotal());
    return feeWithoutPaidTaxDeliveryFee;
  }
  
 /* @Test
  public void testName() throws Exception {
       double bankPaidAmountYuan = 192.12;
       String paidTax = "12.39";
       Double deliveryFeeTotal = new Double("13.21");
       
       double expected = 166.52;
       double actual = calculate(bankPaidAmountYuan, paidTax, deliveryFeeTotal);
       Assert.assertEquals(expected, actual);
  }*/
  
  private double calculate(double bankPaidAmountYuan,String paidTax, Double deliveryFeeTotal) {
    BigDecimal otherFee =
        new BigDecimal(paidTax).add(BigDecimal.valueOf(deliveryFeeTotal));
    double feeWithoutPaidTaxDeliveryFee =
        BigDecimal.valueOf(bankPaidAmountYuan).subtract(otherFee).doubleValue();
    return feeWithoutPaidTaxDeliveryFee;
  }

  private String getPaytimeInGoodFormat(PayNotify payNotify) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(HttpOperator.MSGID_DATE_FORMAT);
    SimpleDateFormat sdf2 = new SimpleDateFormat(HttpOperator.CURRENT_DATE_FORMAT);
    return sdf2.format(sdf.parse(payNotify.getTimestamp()));
  }

  private double convertCentLong2YuanDouble(Long bankPaidAmount) {

    BigDecimal bankPaidAmountCent = new BigDecimal(bankPaidAmount);
    double bankPaidAmountYuan = bankPaidAmountCent.divide(ONEHUNDRED).doubleValue();
    return bankPaidAmountYuan;
  }

  private void checkIdentity() {
    // TODO Auto-generated method stub

  }


}

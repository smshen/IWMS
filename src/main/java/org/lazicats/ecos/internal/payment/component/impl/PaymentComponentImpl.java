package org.lazicats.ecos.internal.payment.component.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.component.PaymenComponent;
import org.lazicats.ecos.order.cacheprocess.IOrderPayment;
import org.springframework.stereotype.Service;

/**
 * @FileName PaymentComponent.java
 * @PackageName org.lazicats.ecos.internal.payment.component.impl
 * @功能
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-26上午11:22:30
 * 
 */
@Service
public class PaymentComponentImpl implements PaymenComponent{
	
	private static final Logger log = Logger.getLogger(PaymentComponentImpl.class);

	/*
	 * 订单支付回调hessian接口
	 */
	@Resource(name = "IOrderPayment")
	private IOrderPayment iOrderPayment;
	
	/**
	 * 
	 * @param order_no	订单号
	 * @param payment	支付方式
	 * @param trade_no	流水号
	 * @param payTime	支付时间
	 * @param payAmount	支付金额
	 * @throws Exception
	 */
	public void payInform(String order_no, String payment,
			String trade_no, String payTime, String payAmount) throws Exception{
		log.info("充值开始回调--payInform=="+CommonPayInfo.BankPayInfo.get("pay_request_prefix"));
		String pay_request_prefix = CommonPayInfo.BankPayInfo.get("pay_request_prefix");
		String order_prefix = order_no.substring(0, pay_request_prefix.length());
		log.info("pay_request_prefix.equalsIgnoreCase(order_prefix)="+pay_request_prefix.equalsIgnoreCase(order_prefix));
		if (!pay_request_prefix.equalsIgnoreCase(order_prefix)) {
			log.info("商城订单支付回调，订单号："+order_no);
			orderPayInform(order_no, payment, trade_no);
		} else {
			log.info("充值金支付回调，订单号："+order_no);
			topUpMoneyPayInform(order_no, payment, trade_no, payTime, payAmount);
		}
	}

	/**
	 * 商城订单支付回调
	 * 
	 * @param order_no
	 * @param payment
	 * @param trade_no
	 * @throws Exception
	 */
	private void orderPayInform(String order_no, String payment,
			String trade_no) throws Exception {
		iOrderPayment.modifyOrderPaymentState(order_no, payment, trade_no);
	}
	
	/**
	 * 充值金支付回调
	 * 
	 * @param order_no
	 * @param payment
	 * @param trade_no
	 * @throws Exception 
	 */
	private void topUpMoneyPayInform(String order_no, String payment,
			String trade_no, String payTime, String payAmount) throws Exception{
		try {
			log.info("充值开始回调--iOrderPayment.rechargeBack，订单号："+order_no);
			iOrderPayment.rechargeBack(order_no, trade_no, payAmount, payTime, payment);
			log.info("充值结束回调--iOrderPayment.rechargeBack，订单号："+order_no);
		} catch (Exception e) {
			log.info(e.getMessage(),e);
			throw e;
			// TODO: handle exception
		}
		
	}
}

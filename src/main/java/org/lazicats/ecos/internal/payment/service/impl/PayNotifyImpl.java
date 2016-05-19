package org.lazicats.ecos.internal.payment.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Abchina.AbcpayUtils;
import org.lazicats.ecos.internal.payment.common.AlipayDb.AlipayNotify;
import org.lazicats.ecos.internal.payment.common.Boc.BocPayUtils;
import org.lazicats.ecos.internal.payment.common.Ccb.CcbPayUtils;
import org.lazicats.ecos.internal.payment.common.Icbc.IcbcPayUtils;
import org.lazicats.ecos.internal.payment.common.Rmbport.RmbportUtils;
import org.lazicats.ecos.internal.payment.common.Tenpay.ClientResponseHandler;
import org.lazicats.ecos.internal.payment.common.Tenpay.RequestHandler;
import org.lazicats.ecos.internal.payment.common.Tenpay.ResponseHandler;
import org.lazicats.ecos.internal.payment.common.Tenpay.TenpayHttpClient;
import org.lazicats.ecos.internal.payment.common.Unionpay.UnionPayConf;
import org.lazicats.ecos.internal.payment.common.Unionpay.UnionPayUtils;
import org.lazicats.ecos.internal.payment.common.Upoppay.PayConf;
import org.lazicats.ecos.internal.payment.common.Upoppay.PayUtils;
import org.lazicats.ecos.internal.payment.common.Upoppay.UpopPayUtils;
import org.lazicats.ecos.internal.payment.component.PaymenComponent;
import org.lazicats.ecos.internal.payment.dao.UPOPPaymentDao;
import org.lazicats.ecos.internal.payment.service.PayNotifyService;
import org.lazicats.ecos.internal.payment.vo.PayResultVo;
import org.lazicats.ecos.internal.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：
 */
@Service
public class PayNotifyImpl implements PayNotifyService {

  private final Logger log = Logger.getLogger(PayNotifyImpl.class);

  // @Resource(name="IOrderPayment")
  // private IOrderPayment iOrderPayment;
  @Resource
  private PaymenComponent paymenComponent;

  @Resource
  private UPOPPaymentDao paymentDao;

  /**
   * 财付通 后台通知 处理
   */
  public void notifyTenpay(HttpServletRequest request, HttpServletResponse response) {
    // 创建支付应答对象
    ResponseHandler resHandler = new ResponseHandler(request, response);
    resHandler.setKey(CommonPayInfo.BankPayInfo.get("tenpay_key"));

    log.info("后台回调返回参数:" + resHandler.getAllParameters());

    try {
      // 判断签名
      if (resHandler.isTenpaySign()) {
        // 通知id
        String notify_id = resHandler.getParameter("notify_id");
        // 创建请求对象
        RequestHandler queryReq = new RequestHandler(null, null);
        // 通信对象
        TenpayHttpClient httpClient = new TenpayHttpClient();
        // 应答对象
        ClientResponseHandler queryRes = new ClientResponseHandler();
        // 通过通知ID查询，确保通知来至财付通
        queryReq.init();
        queryReq.setKey(CommonPayInfo.BankPayInfo.get("tenpay_key"));
        queryReq.setGateUrl(CommonPayInfo.BankPayInfo.get("tenpay_queryUrl"));
        queryReq.setParameter("partner", CommonPayInfo.BankPayInfo.get("tenpay_partner"));
        queryReq.setParameter("notify_id", notify_id);

        // 通信对象
        httpClient.setTimeOut(45);
        // 设置请求内容
        httpClient.setReqContent(queryReq.getRequestURL());

        log.info("验证ID请求字符串:" + queryReq.getRequestURL());

        // 后台调用
        if (httpClient.call()) {
          // 设置结果参数
          queryRes.setContent(httpClient.getResContent());
          log.info("验证ID返回字符串:" + httpClient.getResContent());
          queryRes.setKey(CommonPayInfo.BankPayInfo.get("tenpay_key"));
          // 获取id验证返回状态码，0表示此通知id是财付通发起
          String retcode = queryRes.getParameter("retcode");
          // 商户订单号
          String out_trade_no = resHandler.getParameter("out_trade_no");
          // 财付通订单号
          String transaction_id = resHandler.getParameter("transaction_id");
          // 金额,以分为单位
          String total_fee = resHandler.getParameter("total_fee");
          // 如果有使用折扣券，discount有值，total_fee+discount=原请求的total_fee
          String discount = resHandler.getParameter("discount");
          // 支付结果
          String trade_state = resHandler.getParameter("trade_state");
          // 交易模式，1即时到账，2中介担保
          String trade_mode = resHandler.getParameter("trade_mode");

          // 判断签名及结果
          if (queryRes.isTenpaySign() && "0".equals(retcode)) {
            log.info("验证成功！");

            if ("1".equals(trade_mode)) { // 即时到账
              if ("0".equals(trade_state)) {
                // ------------------------------
                // 即时到账处理业务开始
                // ------------------------------

                // 处理数据库逻辑
                // 注意交易单不要重复处理
                // 注意判断返回金额

                // ------------------------------
                // 即时到账处理业务完毕
                // ------------------------------

                log.info("财付通支付成功。");
                // 给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
                resHandler.sendToCFT("success");
              } else {
                log.error("即时到账支付失败。");
                resHandler.sendToCFT("fail");
              }
            } else { // 中介担保
              log.error("财付通返回错误，非即时到帐。");
            }
          } else {
            log.error("查询验证签名失败或id验证失败" + ",retcode:" + queryRes.getParameter("retcode"));
          }
        } else {
          log.error("后台调用通信失败,\n" + httpClient.getResponseCode() + "\n" + httpClient.getErrInfo());
          // 有可能因为网络原因，请求已经处理，但未收到应答。
        }
      } else {
        log.error("回调验证签名失败。");
      }
    } catch (UnsupportedEncodingException e) {
      log.error(e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      log.error("向财付通发送通知失败，" + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 财付通 回调 处理 2013年9月6日15:25:37，因客户财付通暂时不连接代码未完善
   * 
   * @param request
   * @param response
   * @throws Exception
   */
  public PayResultVo returnTenpay(HttpServletRequest request, HttpServletResponse response) {
    PayResultVo payResult = new PayResultVo();

    ResponseHandler resHandler = new ResponseHandler(request, response);
    resHandler.setKey(CommonPayInfo.BankPayInfo.get("tenpay_key"));

    log.info("前台回调返回参数:" + resHandler.getAllParameters());

    // 判断签名
    if (resHandler.isTenpaySign()) {
      // 通知id
      String notify_id = resHandler.getParameter("notify_id");
      // 商户订单号
      String out_trade_no = resHandler.getParameter("out_trade_no");
      // 财付通订单号
      String transaction_id = resHandler.getParameter("transaction_id");
      // 金额,以分为单位
      String total_fee = resHandler.getParameter("total_fee");
      // 如果有使用折扣券，discount有值，total_fee+discount=原请求的total_fee
      String discount = resHandler.getParameter("discount");
      // 支付结果
      String trade_state = resHandler.getParameter("trade_state");
      // 交易模式，1即时到账，2中介担保
      String trade_mode = resHandler.getParameter("trade_mode");

      if ("1".equals(trade_mode)) {
        if ("0".equals(trade_state)) {

          log.info("即时到帐付款成功，订单号：" + out_trade_no);
        } else {
          log.info("即时到帐付款失败，订单号：" + out_trade_no);
        }
      } else {
        log.error("财付通处理数据异常，非即时到帐业务。");
      }
    } else {
      log.error("财付通签名认证失败，订单号：" + resHandler.getParameter("out_trade_no"));
    }
    return payResult;
  }

  /**
   * 支付宝支付回调处理
   * 
   * @param request
   * @param response
   * @param map
   * @throws Exception
   */
  public PayResultVo returnAlipay(HttpServletRequest request) {
    PayResultVo payResult = new PayResultVo();
    // 获取支付宝GET过来反馈信息
    Map params = new HashMap();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
      try {
        valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      params.put(name, valueStr);
    }

    String mysign = AlipayNotify.GetMysign(params, CommonPayInfo.BankPayInfo.get("alipay_key"));
    String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
    String sign = request.getParameter("sign");


    String trade_no = request.getParameter("trade_no"); // 支付宝交易号
    String order_no = request.getParameter("out_trade_no"); // 获取订单号
    String total_fee = request.getParameter("price"); // 获取总金额
    try {
      String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"), "UTF-8");// 商品名称、订单名称
      String body = "";
      if (request.getParameter("body") != null) {
        body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");// 商品描述、订单备注、描述
      }
      String buyer_email = request.getParameter("buyer_email"); // 买家支付宝账号
      String receive_name = "";// 收货人姓名
      if (request.getParameter("receive_name") != null) {
        receive_name =
            new String(request.getParameter("receive_name").getBytes("ISO-8859-1"), "UTF-8");
      }
      String receive_address = "";// 收货人地址
      if (request.getParameter("receive_address") != null) {
        new String(request.getParameter("receive_address").getBytes("ISO-8859-1"), "UTF-8");
      }
      String receive_zip = "";// 收货人邮编
      if (request.getParameter("receive_zip") != null) {
        new String(request.getParameter("receive_zip").getBytes("ISO-8859-1"), "UTF-8");
      }
      String receive_phone = "";// 收货人电话
      if (request.getParameter("receive_phone") != null) {
        new String(request.getParameter("receive_phone").getBytes("ISO-8859-1"), "UTF-8");
      }
      String receive_mobile = "";// 收货人手机
      if (request.getParameter("receive_mobile") != null) {
        new String(request.getParameter("receive_mobile").getBytes("ISO-8859-1"), "UTF-8");
      }
    } catch (UnsupportedEncodingException e) {
      log.error("支付宝回调，" + e.getMessage());
      e.printStackTrace();
    }

    String trade_status = request.getParameter("trade_status"); // 交易状态

    String verifyStatus = "";

    log.info("支付宝页面跳转，responseTxt=" + responseTxt + ",订单号：" + order_no + ",交易状态：" + trade_status
        + ",mysign=" + mysign + ",sign=" + sign);
    // if(mysign.equals(sign) && responseTxt.equals("true")){
    if (responseTxt.equals("true")) {
      if (trade_status.equals("TRADE_SUCCESS")) {
        payResult.setBool(true);
        payResult.setOrderNo(order_no);
      }
      verifyStatus = "验证成功";
    } else {
      verifyStatus = "验证失败";
    }
    return payResult;
  }

  /**
   * 支付宝服务器异步通知页面
   * 
   * @param request
   * @param response
   */
  public void notifyAlipay(HttpServletRequest request, HttpServletResponse response) {
    // 获取支付宝POST过来反馈信息
    Map<String, String> params = new LinkedHashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
      // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
      params.put(name, valueStr);
    }

    // 判断responsetTxt是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
    // responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
    // mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    String mysign = AlipayNotify.GetMysign(params, CommonPayInfo.BankPayInfo.get("alipay_key"));
    String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
    String sign = request.getParameter("sign");

    // 写日志记录（若要调试，请取消下面两行注释）
    // String sWord = "responseTxt=" + responseTxt + "\n notify_url_log:sign=" + sign + "&mysign=" +
    // mysign + "\n notify回来的参数：" + AlipayFunction.CreateLinkString(params);
    // AlipayFunction.LogResult(sWord);

    // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
    String trade_no = request.getParameter("trade_no"); // 支付宝交易号
    String order_no = request.getParameter("out_trade_no"); // 获取订单号
    String total_fee = request.getParameter("price"); // 获取总金额

    String trade_status = request.getParameter("trade_status"); // 交易状态
    String notify_time = request.getParameter("notify_time");
    // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
    log.info("sign=" + mysign.equals(sign) + "  responseTxt=" + responseTxt + " order_no="
        + order_no);
    PrintWriter out = null;
    try {
      out = response.getWriter();
      if (mysign.equals(sign) && responseTxt.equals("true")) {// 验证成功

        log.info("支付宝异步通知验证成功。。。。。。trade_status=" + trade_status);
        // ////////////////////////////////////////////////////////////////////////////////////////
        // 请在这里加上商户的业务逻辑程序代码

        // ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

        if (trade_status.equals("TRADE_FINISHED")) {
          // 判断该笔订单是否在商户网站中已经做过处理
          // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
          // 如果有做过处理，不执行商户的业务程序
          // 判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）

        } else if (trade_status.equals("TRADE_SUCCESS")) {
          // 判断该笔订单是否在商户网站中已经做过处理
          // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
          // 如果有做过处理，不执行商户的业务程序
          try {
            /*
             * String orderNo,String paymentModel,String paymentSequence
             */
            // iOrderPayment.modifyOrderPaymentState(order_no,
            // CommonPayInfo.PAYMENT_ALIPAY, trade_no);
            paymenComponent.payInform(order_no, CommonPayInfo.PAYMENT_ALIPAY, trade_no,
                notify_time, total_fee);
            log.info("支付宝支付成功回调通知多渠道成功，支付宝交易号：" + trade_no);
          } catch (Exception e) {
            log.error("支付宝后台通知修改订单状态异常......订单号:" + trade_no);
            e.printStackTrace();
          }
          // 注意：
          // 该种交易状态只在一种情况下出现——开通了高级即时到账，买家付款成功后。
        }

        // ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

        out.println("success"); // 请不要修改或删除

        // ////////////////////////////////////////////////////////////////////////////////////////
      } else {// 验证失败
        log.info("支付宝异步通知验证失败。。。。。。");
        out.println("fail");
      }


    } catch (IOException e) {
      log.error("支付宝异步通知，" + e.getMessage());
      e.printStackTrace();
    } finally {
      if (out != null) {
        out.flush();
        out.close();
      }
    }
  }

  /**
   * 银联 支付回调
   * 
   * @param request
   * @throws Exception
   */
  public void notifyUnionpay(HttpServletRequest request) {
    // 后台通知进行商户的数据库等处理,前台通知实现客户浏览器跳转
    try {
      request.setCharacterEncoding(CommonPayInfo.BankPayInfo.get("unionPay_charset"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    /*
     * 银联 支付回调对象
     */
    String[] resArr = new String[UnionPayConf.notifyVo.length];

    for (int i = 0; i < UnionPayConf.notifyVo.length; i++) {
      resArr[i] = request.getParameter(UnionPayConf.notifyVo[i]);
    }
    String signature = request.getParameter(UnionPayConf.signature);
    String signMethod = request.getParameter(UnionPayConf.signMethod);
    Boolean signatureCheck = new UnionPayUtils().checkSign(resArr, signMethod, signature);
    if (signatureCheck) {// 签名正确
      log.info("支付前台返回-银联  商户订单号" + resArr[8] + "交易流水号：" + resArr[9] + "时间：" + resArr[15]);
      try {
        // iOrderPayment.modifyOrderPaymentState(resArr[8], CommonPayInfo.PAYMENT_UNIONPAY,
        // resArr[9]);
        paymenComponent.payInform(resArr[8], CommonPayInfo.PAYMENT_UNIONPAY, resArr[9],
            StringUtils.formatDate(resArr[15], "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"),
            StringUtils.calculateDataRetainDecimal(resArr[13], "100", 2).toString());
      } catch (Exception e) {
        log.error("支付回调修改订单状态异常......");
        e.printStackTrace();
      }
    } else {
      log.error("验证签名失败，银联支付前台回调错误,错误码：" + resArr[10]);
    }
  }

  /**
   * 银联支付前端页面返回
   * 
   * @param request
   * @throws Exception
   */
  public PayResultVo returnUnionpay(HttpServletRequest request) {
    PayResultVo payResult = new PayResultVo();
    // 后台通知进行商户的数据库等处理,前台通知实现客户浏览器跳转
    try {
      request.setCharacterEncoding(CommonPayInfo.BankPayInfo.get("unionPay_charset"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    /*
     * 银联 支付回调对象
     */
    String[] resArr = new String[UnionPayConf.notifyVo.length];

    for (int i = 0; i < UnionPayConf.notifyVo.length; i++) {
      resArr[i] = request.getParameter(UnionPayConf.notifyVo[i]);
    }
    String signature = request.getParameter(UnionPayConf.signature);
    String signMethod = request.getParameter(UnionPayConf.signMethod);
    Boolean signatureCheck = new UnionPayUtils().checkSign(resArr, signMethod, signature);
    if (signatureCheck) {// 签名正确
      log.info("支付前台返回-银联  商户订单号" + resArr[8] + "交易流水号：" + resArr[9]);
      payResult.setBool(true);
      payResult.setOrderNo(resArr[8]);
    } else {
      log.error("验证签名失败，银联支付前台回调错误,错误码：" + resArr[10]);
    }
    return payResult;
  }

  /**
   * 建行支付后台服务器通知
   * 
   * @param request
   */
  public void notifyCcbpay(HttpServletRequest request) {
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
      params.put(name, valueStr);
    }
    /*
     * 验证回调签名
     */
    if (CcbPayUtils.getSign(params) && params.get("SUCCESS").equals("Y")) {
      try {
        log.info("建行支付成功，订单号：" + params.get("ORDERID"));
        // iOrderPayment.modifyOrderPaymentState(params.get("ORDERID"), CommonPayInfo.PAYMENT_CCB,
        // params.get("ORDERID"));
        paymenComponent.payInform(params.get("ORDERID"), CommonPayInfo.PAYMENT_CCB,
            params.get("ORDERID"), StringUtils.getSystemCurrentTime("yyyy-MM-dd HH:mm:ss"),
            params.get("PAYMENT"));
      } catch (Exception e) {
        log.error("建行支付回调修改订单状态异常......");
        e.printStackTrace();
      }
    } else {
      log.error("建行支付后台回调校验失败,订单号：" + params.get("ORDERID"));
    }
  }

  /**
   * 建行支付回调校验
   * 
   * @param request
   */
  public PayResultVo returnCcbpay(HttpServletRequest request) {
    PayResultVo payResult = new PayResultVo();
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
      params.put(name, valueStr);
    }
    /*
     * 验证回调签名
     */
    if (CcbPayUtils.getSign(params)) {
      payResult.setBool(true);
      payResult.setOrderNo(params.get("ORDERID"));
    } else {
      log.error("建行支付回调校验失败,订单号：" + params.get("ORDERID"));
    }
    return payResult;
  }

  /**
   * 工行支付服务端回调
   * 
   * @param request
   */
  public void notifyIcbcpay(HttpServletRequest request, HttpServletResponse response) {
    StringBuilder returnUrl = new StringBuilder(CommonPayInfo.BankPayInfo.get("icbcPay_returnUrl"));
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
      params.put(name, valueStr);
    }


    boolean bool = IcbcPayUtils.checkSign(params);

    /*
     * 1-“交易成功，已清算”； 2-“交易失败”； 3-“交易可疑”
     */
    if (bool == true) {
      log.info("工行后端服务器通知签名验证成功，订单号：" + params.get("orderid") + ",	订单状态：" + params.get("tranStat"));
      if ("1".equals(params.get("tranStat"))) {
        try {
          // iOrderPayment.modifyOrderPaymentState(
          // params.get("orderid"), CommonPayInfo.PAYMENT_ICBC,
          // params.get("TranSerialNo"));
          paymenComponent.payInform(params.get("orderid"), CommonPayInfo.PAYMENT_ICBC, params
              .get("TranSerialNo"), StringUtils.formatDate(params.get("notifyDate"),
              "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"),
              StringUtils.calculateDataRetainDecimal(params.get("amount"), "100", 2).toString());
        } catch (Exception e1) {
          log.error("工行支付回调修改订单状态异常，订单号：" + params.get("orderid") + "交易流水号："
              + params.get("TranSerialNo"));
          e1.printStackTrace();
        }
        /*
         * 返回展示地址
         */
        PrintWriter out = null;
        try {
          out = response.getWriter();
          out.print(returnUrl.toString());
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (out != null) {
            out.close();
          }
        }
      }
    } else {
      log.error("工行后端服务器通知签名验证失败，订单号：" + params.get("orderid"));
    }
  }

  /**
   * 工行前端页面跳转
   * 
   * @param request
   */
  public PayResultVo returnIcbcpay(HttpServletRequest request) {
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
      params.put(name, valueStr);
    }

    PayResultVo payResultVo = new PayResultVo();

    boolean bool = IcbcPayUtils.checkSign(params);

    /*
     * 1-“交易成功，已清算”； 2-“交易失败”； 3-“交易可疑”
     */
    if (bool == true) {
      log.info("工行前端页面跳转签名验证成功，订单号：" + params.get("orderid") + ",	订单状态：" + params.get("tranStat"));
      if ("1".equals(params.get("tranStat"))) {
        payResultVo.setBool(true);
        payResultVo.setOrderNo(params.get("orderid"));
      }
    } else {
      log.error("工行前端页面跳转签名验证失败，订单号：" + params.get("orderid"));
    }
    return payResultVo;
  }

  /**
   * 中行 支付通知(银行主动通知)
   * 
   * @param request
   */
  public PayResultVo notifyBocpay(HttpServletRequest request) {
    PayResultVo payResult = new PayResultVo();
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      params.put(name, valueStr);
    }

    boolean bool = BocPayUtils.checkSign(params);
    if (bool == true) {
      /*
       * 订单的处理状态 0：未处理 1：支付 2：撤销 3：退货 4：未明 5：失败
       */
      if ("1".equals(params.get("orderStatus"))) {
        try {
          // iOrderPayment.modifyOrderPaymentState(
          // params.get("orderNo"), CommonPayInfo.PAYMENT_BOC,
          // params.get("orderSeq"));
          paymenComponent.payInform(params.get("orderNo"), CommonPayInfo.PAYMENT_BOC, params
              .get("orderSeq"), StringUtils.formatDate(params.get("payTime"), "yyyyMMddHHmmss",
              "yyyy-MM-dd HH:mm:ss"), params.get("payAmount"));
          log.info("中行支付成功，银行主动通知：订单号：" + params.get("orderNo") + "交易流水号：" + params.get("orderSeq"));
        } catch (Exception e) {
          log.error("中行支付修改订单状态异常，订单号：" + params.get("orderNo") + "交易流水号：" + params.get("orderSeq"));
          e.printStackTrace();
        }
        payResult.setBool(true);
        payResult.setOrderNo(params.get("orderNo"));
      } else {
        log.error("中行支付失败，订单号：" + params.get("orderNo") + "交易流水号：" + params.get("orderSeq"));
      }
    } else {
      log.error("中行验证签名失败，订单号：" + params.get("orderNo"));
    }

    return payResult;
  }

  /**
   * 快钱后台通知接收处理
   * 
   * @param request
   * @param response
   * @throws Exception
   */
  public void notifyRmbport(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      params.put(name, valueStr);
    }
    // 获取参数校验结果
    boolean signatureVerificationPassed = RmbportUtils.verifySign(params);

    log.info("result of signature verification:" + signatureVerificationPassed);
    int rtnOK = 0;
    String orderNo = params.get("orderId");
    if (signatureVerificationPassed) {
      boolean paySuccess = Integer.parseInt(params.get("payResult")) == 10;
      if (paySuccess) {
        try {
          log.info("订单号-" + orderNo + "-支付方式-" + CommonPayInfo.PAYMENT_PAYPAL + "-成功");

          paymenComponent.payInform(orderNo, // 订单号

              CommonPayInfo.PAYMENT_PAYPAL, // 银行代码

              params.get("dealId"), // 交易号

              StringUtils.formatDate(params.get("dealTime"), "yyyyMMddHHmmss",
                  "yyyy-MM-dd HH:mm:ss"), // 交易时间

              StringUtils.calculateDataRetainDecimal(params.get("payAmount"), "100", 2) // 交易金额
                  .toString());
        } catch (Exception e) {
          log.error("快钱支付回调修改订单状态异常，" + e.getMessage());
          throw new Exception();
        }
        rtnOK = 1;
      } else {
        log.info("订单号-" + orderNo + "-支付方式-" + CommonPayInfo.PAYMENT_PAYPAL + "-失败");
      }

    } else {
      log.info("订单号-" + orderNo + "-验签失败");
    }

    // 返回快钱已收到信息
    String returnRmbportXml =
        "<result>" + rtnOK + "</result><redirecturl>"
            + CommonPayInfo.BankPayInfo.get("rmbport_pageUrl") + "</redirecturl>";
    PrintWriter out = null;
    try {
      out = response.getWriter();
      out.print(returnRmbportXml);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }

  /**
   * 快钱 前端页面 展示
   * 
   * @param request
   * @param response
   * @return
   */
  public PayResultVo returnRmbport(HttpServletRequest request) {
    PayResultVo payResult = new PayResultVo();
    Map<String, String> params = new HashMap<String, String>();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
      String name = (String) iter.next();
      String[] values = (String[]) requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
      }
      params.put(name, valueStr);
    }
    // 获取参数校验结果
    boolean bool = RmbportUtils.verifySign(params);

    if (bool) {
      switch (Integer.parseInt(params.get("payResult"))) {
        case 10:
          // 此处商户可以做业务逻辑处理
          payResult.setBool(true);
          payResult.setOrderNo(params.get("orderId"));
          break;
        default:
          break;
      }
    }
    return payResult;
  }

  /**
   * 农行支付后台通知
   * 
   * @param request
   * @param response
   */
  public void notifyAbchina(HttpServletRequest request, HttpServletResponse response) {
    Map<String, String> payResult = AbcpayUtils.getPayResult(request);
    StringBuilder returnUrl =
        new StringBuilder("<URL>" + CommonPayInfo.BankPayInfo.get("abchina_returnUrl") + "</URL>");

    log.error("农行支付后台通知执行......订单号：" + payResult.get("OrderNo"));
    if (payResult.get("isSuccess").equals("true")) {
      try {
        // iOrderPayment.modifyOrderPaymentState(
        // payResult.get("OrderNo"), CommonPayInfo.PAYMENT_ABC,
        // payResult.get("iRspRef"));
        paymenComponent.payInform(payResult.get("OrderNo"), CommonPayInfo.PAYMENT_ABC, payResult
            .get("iRspRef"), StringUtils.formatDate(
            payResult.get("HostDate") + " " + StringUtils.getSplitTime(payResult.get("HostTime")),
            "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss"), payResult.get("Amount"));
        // StringUtils.calculateDataRetainDecimal(
        // , "100", 2).toString());
      } catch (Exception e) {
        log.error("农行后台通知修改订单状态异常......订单号：" + payResult.get("OrderNo"));
        e.printStackTrace();
      }
    }

    /*
     * 返回展示地址
     */
    PrintWriter out = null;
    try {
      out = response.getWriter();
      out.print(returnUrl.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }

  /**
   * 农行支付前端页面展示
   * 
   * @param request
   * @param response
   * @return
   */
  public PayResultVo returnAbchina(HttpServletRequest request) {
    Map<String, String> payResult = AbcpayUtils.getPayResult(request);
    PayResultVo payResultVo = new PayResultVo();

    log.error("农行支付前端展示执行......");// http://news.qq.com/zt2014/sdcs/index.htm

    if (payResult.get("isSuccess").equals("true")) {
      payResultVo.setBool(true);
      payResultVo.setOrderNo(payResult.get("OrderNo"));
    } else {
      payResultVo.setBool(false);
    }
    return payResultVo;
  }
  

  /**
   * determine payment result - true or false
   * @param needProccessOrderPayment 
   * @throws UnsupportedEncodingException 
   */
  public PayResultVo determinePayResult(HttpServletRequest request, boolean needProccessOrderPayment) throws UnsupportedEncodingException {
    /*try {
      request.setCharacterEncoding("GBK");
      log.info("reset character encoding to GBK");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }*/
    
    PayResultVo payResult = new PayResultVo();
    String[] messages = new String[PayConf.notifyVo.length];
    
    String msg = assembleMsg(request, messages);
    String key = CommonPayInfo.BankPayInfo.get("upop_pkey");
    String signature = request.getParameter(PayConf.signature);
    Boolean msgIntact = PayUtils.verifyMsg(msg, key, signature);

    String orderNoWithSuffix = messages[0];
    String orderNo = orderNoWithSuffix.substring(0, orderNoWithSuffix.length() - 1);
    String paymentSequence = messages[1];
    String paymentTime = messages[6];
    log.info("receive payment params from upop - {orderNo:" + quote(orderNoWithSuffix)
        + ",paymentSeqence:" + quote(paymentSequence) + ",time:" + quote(paymentSequence) + "}");

    if (msgIntact) {
      final String respCode = messages[5];
      if ("00".equals(respCode)) {
        log.info("success code check passed!");
        if(needProccessOrderPayment){
          final String paymentAmount = messages[2];
          log.info("start proccessing order payment ...");
          processOrderPayment(orderNo, orderNoWithSuffix, 
              paymentSequence, paymentTime, paymentAmount);
        }

        payResult.setBool(true);
        payResult.setOrderNo(orderNo);
      } else {
        log.info("success code check failed! - code:" + respCode);
      }
    } else {
      log.error("signature check failed! "
          + "- {msg:" + Arrays.deepToString(messages) + ",signature:" + quote(signature) + "}");
    }

    return payResult;
  }
  
  private String quote(String str){
    return "\"" + str + "\"";
  }
  
  private void processOrderPayment(String orderNo, String orderNoWithSuffix,
      String paymentSequence, String paymentTime, String paymentAmount) {
    try {
      SimpleDateFormat inFormat = new SimpleDateFormat("MMdd");
      SimpleDateFormat saveFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      paymenComponent.payInform(orderNo,// orderNo
          CommonPayInfo.PAYMENT_UPOP,// payment type
          paymentSequence,// trade No.
          saveFormat.format(inFormat.parse(paymentTime)),// payment time
          paymentAmount);// payment amount

      paymentDao.savePaymentResl(orderNoWithSuffix, orderNo);
    } catch (Exception e) {
      log.error("upop支付回调修改订单状态异常......");
      e.printStackTrace();
    }
  }

  private String assembleMsg(HttpServletRequest request, String[] resArr) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < PayConf.notifyVo.length; i++) {
      resArr[i] = request.getParameter(PayConf.notifyVo[i]);
      sb.append(resArr[i]);
    }
    return sb.toString();
  }


  /*
   * public static void notifyAliforex(HttpServletRequest request) {
   * 
   * 
   * Map params = new HashMap(); //获得POST 过来参数设置到新的params中 Map requestParams =
   * request.getParameterMap(); for (Iterator iter = requestParams.keySet().iterator(); iter
   * .hasNext();) { String name = (String) iter.next(); String[] values = (String[])
   * requestParams.get(name); String valueStr = ""; for (int i = 0; i < values.length; i++) {
   * valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ","; }
   * params.put(name, valueStr); }
   * 
   * String mysign = SignatureHelper.sign(params,Payment.KEY);
   * 
   * boolean check = getCheckResp(request).equals("true"); check = true; if
   * (mysign.equals(request.getParameter("sign")) && check ){ System.out.println("ok"); } else {
   * System.out.println("not ok"); }
   * 
   * }
   * 
   * public static String getCheckResp(HttpServletRequest request) { String alipayNotifyURL =
   * "https://mapi.alipay.net/trade/notify_query.do?" + "partner=" + Payment.PARNER_ID +
   * "&notify_id=" + request.getParameter("notify_id");
   * 
   * String responseTxt = CheckURL.check(alipayNotifyURL);
   * 
   * return responseTxt; }
   */

}

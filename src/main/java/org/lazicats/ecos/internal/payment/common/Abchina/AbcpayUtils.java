package org.lazicats.ecos.internal.payment.common.Abchina;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;

import com.hitrust.trustpay.client.MerchantConfig;
import com.hitrust.trustpay.client.TrxException;
import com.hitrust.trustpay.client.TrxResponse;
import com.hitrust.trustpay.client.XMLDocument;
import com.hitrust.trustpay.client.b2c.Order;
import com.hitrust.trustpay.client.b2c.OrderItem;
import com.hitrust.trustpay.client.b2c.PaymentRequest;
import com.hitrust.trustpay.client.b2c.PaymentResult;
import com.hitrust.trustpay.client.b2c.QueryOrderRequest;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：农行支付请求 公共方法类
 */

public class AbcpayUtils {

	private final static Logger log = Logger.getLogger(AbcpayUtils.class);
	
	/**
	 * 生成支付请求form
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String crateAbcPayHtml(Map<String, String> map){
		
		MerchantConfig tMerchantConfig;
		String sTrustPayIETrxURL = "";// 支付请求地址
		String sErrorUrl = "";// 异常错误地址
		String returnUrl = "";// 请求支付回调地址
		try {
			tMerchantConfig = MerchantConfig.getUniqueInstance();
			sTrustPayIETrxURL = tMerchantConfig.getTrustPayIETrxURL();
			sErrorUrl = tMerchantConfig.getMerchantErrorURL();
			returnUrl = tMerchantConfig.getParameterByName("MerchantReturnURL");
		} catch (TrxException e) {
			e.printStackTrace();
		}
		
		String signature = AbcpayUtils.getPayPojo(map, AbcpayUtils.getOrderVo(map), returnUrl);
		StringBuilder submitStr = new StringBuilder();
		submitStr.append("<form id=\"abcForm\" name=\"abcForm\" action=\"").append(sTrustPayIETrxURL).append("\" method=\"post\">\n");
		submitStr.append("<input type=\"hidden\" name=\"Signature\" value=\"" + signature + "\">\n");
		submitStr.append("<input type=\"hidden\" name=\"errorPage\" value=\"" + sErrorUrl + "\">\n");
		submitStr.append("</form>\n");
		submitStr.append("<script>document.forms['abcForm'].submit();</script>");
		
		return submitStr.toString();
	}
	
	
	/**
	 * 生成农行订单对象
	 * 
	 * @param map
	 * @return
	 */
	private static Order getOrderVo(Map<String, String> map){
		Order tOrder = new Order();
		String currTime = new SimpleDateFormat("yyyy/MM/ddHH:mm:ss").format(new Date());
		tOrder.setOrderNo(map.get("out_trade_no")); //设定订单编号 （必要信息）
		tOrder.setExpiredDate(30); //设定订单有效期 （必要信息）
		tOrder.setOrderDesc(""); //设定订单说明
		tOrder.setOrderDate(currTime.substring(0, 10)); //设定订单日期 （必要信息 - YYYY/MM/DD）
		tOrder.setOrderTime(currTime.substring(10, 18)); //设定订单时间 （必要信息 - HH:MM:SS）
		tOrder.setOrderAmount(Double.parseDouble(map.get("total_fee"))); //设定订单金额 （必要信息）
		tOrder.setOrderURL(""); //设定订单网址
		tOrder.setBuyIP("");       //设定订单IP
		return tOrder;
	}
	
	/**
	 * 生成支付请求对象
	 * 
	 * @param map
	 * @param order
	 * @return
	 */
	private static String getPayPojo(Map<String, String> map,Order order, String MerchantReturnURL){
		String tSignature = "";
		PaymentRequest tPaymentRequest = new PaymentRequest();
		tPaymentRequest.setOrder(order); //设定支付请求的订单 （必要信息）
		tPaymentRequest.setProductType("2"); //设定商品种类 （必要信息）
		                                              //PaymentRequest.PRD_TYPE_ONE：非实体商品，如服务、IP卡、下载MP3、...
		                                              //PaymentRequest.PRD_TYPE_TWO：实体商品
		tPaymentRequest.setPaymentType("1"); //设定支付类型
		                                              //PaymentRequest.PAY_TYPE_ABC：农行卡支付
		                                              //PaymentRequest.PAY_TYPE_INT：国际卡支付
		tPaymentRequest.setNotifyType("1");   //设定商户通知方式
		                                              //0：URL页面通知
		                                              //1：服务器通知
		tPaymentRequest.setResultNotifyURL(MerchantReturnURL); //设定支付结果回传网址 （必要信息）
		tPaymentRequest.setMerchantRemarks(""); //设定商户备注信息
		tPaymentRequest.setPaymentLinkType("1");//设定支付接入方式
		
		try{
		 tSignature = tPaymentRequest.genSignature(1);
		}catch (TrxException e){
			log.error("农行生成支付请求对象异常，" + e.getMessage());
			e.printStackTrace();
		} 
		return tSignature;
	}
	
	/**
	 * 获取支付结果对象
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getPayResult(HttpServletRequest request) {
		Map<String, String> payResult = new HashMap<String, String>();
		// 1、取得MSG参数，并利用此参数值生成支付结果对象
		PaymentResult tResult = null;
		try {
			String msg = request.getParameter("MSG") == null ? "" : request
					.getParameter("MSG");
			tResult = new PaymentResult(msg);
		} catch (TrxException e) {
			e.printStackTrace();
		}
		if (tResult != null) {
			// 2、判断支付结果状态，进行后续操作
			if (tResult.isSuccess()) {
				// 3、支付成功
				payResult.put("isSuccess", "true");
				for (int i = 0; i < AbchinaConf.payResultVo.length; i++) {
					payResult.put(AbchinaConf.payResultVo[i],
							tResult.getValue(AbchinaConf.payResultVo[i]));
				}
			} else {
				// 4、支付失败
				payResult.put("isSuccess", "false");
				for (int i = 0; i < AbchinaConf.payFailureResult.length; i++) {
					payResult.put(AbchinaConf.payFailureResult[i],
							tResult.getValue(AbchinaConf.payFailureResult[i]));
				}
			}
		} else {
			// 获取支付回调对象失败
			payResult.put("isSuccess", "false");
		}
		return payResult;
	}
	
	/**
	 * 支付结果查询
	 * 
	 * @param orderId
	 * @return
	 */
	public static QueryOrderMessage queryOrder(String orderId){
		
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		Map<String, String> map = new HashMap<String, String>();
		//生成商户订单查询请求对象
		QueryOrderRequest tRequest = new QueryOrderRequest();
		tRequest.setOrderNo(orderId);  //订单号           （必要信息）
		tRequest.enableDetailQuery(false);//是否查询详细信息 （必要信息）
		
		//传送商户订单查询请求并取得订单查询结果
		TrxResponse tResponse = tRequest.postRequest();
		
		//判断商户订单查询结果状态，进行后续操作
		if (tResponse.isSuccess()) {
			// 5、生成订单对象
			Order tOrder = new Order(new XMLDocument(tResponse.getValue("Order")));
//			out.println("OrderNo      = [" + tOrder.getOrderNo() + "]<br>");
//			out.println("OrderAmount  = [" + tOrder.getOrderAmount() + "]<br>");
//			out.println("OrderDesc    = [" + tOrder.getOrderDesc() + "]<br>");
//			out.println("OrderDate    = [" + tOrder.getOrderDate() + "]<br>");
//			out.println("OrderTime    = [" + tOrder.getOrderTime() + "]<br>");
//			out.println("OrderURL     = [" + tOrder.getOrderURL() + "]<br>");
//			out.println("PayAmount    = [" + tOrder.getPayAmount() + "]<br>");
//			out.println("RefundAmount = [" + tOrder.getRefundAmount() + "]<br>");
//			out.println("OrderStatus  = [" + tOrder.getOrderStatus() + "]<br>");
			
			if("03".equals(tOrder.getOrderStatus()) || "04".equals(tOrder.getOrderStatus())){
				map.put("success", "true");
				queryOrderMessage.setSuccess(true);
				queryOrderMessage.setOrder(tOrder.getOrderNo());
				queryOrderMessage.setAmount(tOrder.getOrderAmount()+"");
				queryOrderMessage.setMessage("支付成功");
			}else {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("支付未成功");
			}
			
//			//取得订单明细
//			ArrayList tOrderItems = tOrder.getOrderItems();
//			for (int i = 0; i < tOrderItems.size(); i++) {
//				OrderItem tOrderItem = (OrderItem) tOrderItems.get(i);
//			}
		} else {
			//商户订单查询失败
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage(tResponse.getErrorMessage());
		}
		return queryOrderMessage;
	}
}

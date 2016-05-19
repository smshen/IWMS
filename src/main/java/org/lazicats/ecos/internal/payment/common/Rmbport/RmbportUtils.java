package org.lazicats.ecos.internal.payment.common.Rmbport;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Rmbport.dto.gatewayquery.GatewayOrderDetail;
import org.lazicats.ecos.internal.payment.common.Rmbport.dto.gatewayquery.GatewayOrderQueryRequest;
import org.lazicats.ecos.internal.payment.common.Rmbport.dto.gatewayquery.GatewayOrderQueryResponse;
import org.lazicats.ecos.internal.payment.common.Rmbport.services.gatewayOrderQuery.GatewayOrderQueryServiceLocator;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;
import org.lazicats.ecos.internal.utils.StringUtils;

/**
 * @author MingJun_Guo
 * @创建日期：2013-9-3上午9:16:45
 * 
 * @说明：快钱支付utils
 */
public class RmbportUtils {

	/**
	 * 创建支付提交form
	 * 
	 * @param valueVo
	 * @return
	 */
	public static String crateRmbportPayHtml(String valueVo[]) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < RmbportConf.rmbportPay.length; i++) {
			map.put(RmbportConf.rmbportPay[i], valueVo[i]);
		}
		map.put(RmbportConf.signMsg, RmbportUtils.sginData(map));

		return RmbportUtils.generateAutoSubmitForm(map);
	}
	
	/**
	 * 验证支付回调参数
	 * 
	 * @param map
	 * @return
	 */
	public static boolean verifySign(Map<String, String> map){
		boolean flag = SignRmbportUtils.enCodeByCer(RmbportUtils.verifySignData(map), map.get("signMsg"));
		return flag;
	}
	
	/**
	 * 订单支付结果查询
	 *  
	 * @param orderId
	 * @return
	 */
	public static QueryOrderMessage orderQuery(String orderId){
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		queryOrderMessage = RmbportUtils.getOrderQueryMessage(orderId);
		return queryOrderMessage;
	}
	
	/**
	 * 支付私钥加密字符串封装极其 SSL证书加密
	 * 
	 * @param map
	 * @return
	 */
	private static String sginData(Map<String, String> map){
		StringBuilder signMsgVal = new StringBuilder();
		signMsgVal = appendParam(signMsgVal, "inputCharset", map.get("inputCharset"));
		signMsgVal = appendParam(signMsgVal, "pageUrl", map.get("pageUrl"));
		signMsgVal = appendParam(signMsgVal, "bgUrl", map.get("bgUrl"));
		signMsgVal = appendParam(signMsgVal, "version", map.get("version"));
		signMsgVal = appendParam(signMsgVal, "language", map.get("language"));
		signMsgVal = appendParam(signMsgVal, "signType", map.get("signType"));
		signMsgVal = appendParam(signMsgVal, "merchantAcctId",map.get("merchantAcctId"));
		signMsgVal = appendParam(signMsgVal, "payerName", map.get("payerName"));
		signMsgVal = appendParam(signMsgVal, "payerContactType",map.get("payerContactType"));
		signMsgVal = appendParam(signMsgVal, "payerContact", map.get("payerContact"));
		signMsgVal = appendParam(signMsgVal, "orderId", map.get("orderId"));
		signMsgVal = appendParam(signMsgVal, "orderAmount", map.get("orderAmount"));
		signMsgVal = appendParam(signMsgVal, "orderTime", map.get("orderTime"));
		signMsgVal = appendParam(signMsgVal, "productName", map.get("productName"));
		signMsgVal = appendParam(signMsgVal, "productNum", map.get("productNum"));
		signMsgVal = appendParam(signMsgVal, "productId", map.get("productId"));
		signMsgVal = appendParam(signMsgVal, "productDesc", map.get("productDesc"));
		signMsgVal = appendParam(signMsgVal, "ext1", map.get("ext1"));
		signMsgVal = appendParam(signMsgVal, "ext2", map.get("ext2"));
		signMsgVal = appendParam(signMsgVal, "payType", map.get("payType"));
		signMsgVal = appendParam(signMsgVal, "bankId", map.get("bankId"));
		signMsgVal = appendParam(signMsgVal, "redoFlag", map.get("redoFlag"));
		signMsgVal = appendParam(signMsgVal, "pid", map.get("pid"));
		return SignRmbportUtils.signMsg(signMsgVal.toString());
	}
	
	/**
	 * 支付回调加密字符串明文
	 * 
	 * @param map
	 * @return
	 */
	private static String verifySignData(Map<String, String> map){
		StringBuilder merchantSignMsgVal = new StringBuilder();
		merchantSignMsgVal = appendParam(merchantSignMsgVal,"merchantAcctId", map.get("merchantAcctId"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "version",map.get("version"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "language",map.get("language"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "signType",map.get("signType"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "payType",map.get("payType"));
		if(StringUtils.isEmpty(map.get("bankId"))){
			merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankId",map.get("bankId"));
		}
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderId",map.get("orderId"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderTime",map.get("orderTime"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderAmount",map.get("orderAmount"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealId",map.get("dealId"));
		if(StringUtils.isEmpty(map.get("bankDealId"))){
			merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankDealId",map.get("bankDealId"));
		}
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealTime",map.get("dealTime"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "payAmount",map.get("payAmount"));
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "fee", map.get("fee"));
		if(StringUtils.isEmpty(map.get("ext1"))){
			merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext1", map.get("ext1"));
		}
		if(StringUtils.isEmpty(map.get("ext2"))){
			merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext2", map.get("ext2"));
		}
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "payResult",map.get("payResult"));
		if(StringUtils.isEmpty(map.get("errCode"))){
			merchantSignMsgVal = appendParam(merchantSignMsgVal, "errCode",map.get("errCode"));
		}
		return merchantSignMsgVal.toString();
	}
	
	private static StringBuilder appendParam(StringBuilder returns,
			String paramId, String paramValue) {
		if (returns.length() > 0) {
			if (paramValue != "") {
				returns.append("&" + paramId + "=" + paramValue);
			}
		} else {
			if (paramValue != "") {
				returns.append(paramId + "=" + paramValue);
			}
		}
		return returns;
	}
	
	/**
	 * 封装支付提交form
	 * 
	 * @param map
	 * @return
	 */
	private static String generateAutoSubmitForm(Map<String, String> map) {
		StringBuilder html = new StringBuilder();
		html.append("<form name=\"rmbportPay\" action=\"").append(CommonPayInfo.BankPayInfo.get("rmbport_url")).append("\" method=\"post\">\n");

		for (String key : map.keySet()) {
		    if(!map.get(key).isEmpty())
			html.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" + map.get(key) + "\">\n");
		}
		html.append("</form>\n");
		html.append("<script>document.forms['rmbportPay'].submit();</script>");
		return html.toString();
	}
	
	/**
	 * 订单支付结果查询
	 * 
	 * @param orderId
	 * @return
	 */
	private static QueryOrderMessage getOrderQueryMessage(String orderId){
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		/*
		 * 生成请求加密字符串，极其MD5加密
		 */
		String signMsg = "";
		try {
			signMsg = MD5Util.md5Hex(RmbportUtils.getOrderQueryMsgParam(orderId).getBytes("UTF-8")).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		 * 封装查询请求对象
		 */
		GatewayOrderQueryRequest queryRequest = new GatewayOrderQueryRequest();
		queryRequest.setInputCharset("1");
		queryRequest.setVersion("v2.0");
		queryRequest.setSignType(Integer.parseInt("1"));
		queryRequest.setMerchantAcctId(CommonPayInfo.BankPayInfo.get("rmbport_merCode"));
		queryRequest.setQueryType(Integer.parseInt("0"));
		queryRequest.setQueryMode(Integer.parseInt("1"));
		queryRequest.setOrderId(orderId);
		queryRequest.setStartTime("");
		queryRequest.setEndTime("");
		queryRequest.setRequestPage("");
		queryRequest.setSignMsg(signMsg);

		/*
		 * 调用WebService执行查询请求
		 */
		GatewayOrderQueryServiceLocator locator = new GatewayOrderQueryServiceLocator();
		GatewayOrderQueryResponse queryResponse = new GatewayOrderQueryResponse();
		try {
			queryResponse = locator.getgatewayOrderQuery().gatewayOrderQuery(queryRequest);
			
			GatewayOrderDetail[] orders = queryResponse.getOrders();
			
			if (orders.length > 0) {
				GatewayOrderDetail gatewayOrderDetail = orders[0];
				//本地签名生成
				String mySignMsg = RmbportUtils.getOrderQueryMsgByGeteway(gatewayOrderDetail);
				String signMsgGateway = gatewayOrderDetail.getSignInfo();
				if(mySignMsg.endsWith(signMsgGateway)){
					/*
					 * 签名校验成功
					 */
					queryOrderMessage.setSuccess(true);
					queryOrderMessage.setOrder(gatewayOrderDetail.getOrderId());
					/*
					 * 计算金额
					 */
					double f = gatewayOrderDetail.getOrderAmount();  
					f = f/100;
					BigDecimal b = new BigDecimal(f);  
					double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					queryOrderMessage.setAmount(String.valueOf(f1));
				} else {
					queryOrderMessage.setSuccess(false);
					queryOrderMessage.setMessage("没有相关订单信息,校验签名失败");
				}
			} else {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("没有相关订单信息");
			}
		} catch (RemoteException e) {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("程序调用快钱接口异常，" + e.getMessage());
			e.printStackTrace();
		} catch (ServiceException e) {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("程序调用快钱接口异常，" + e.getMessage());
			e.printStackTrace();
		}
		
		return queryOrderMessage;
	}
	
	/**
	 * 订单查询加密字符串封装
	 * 
	 * @param orderId
	 * @return
	 */
	private static String getOrderQueryMsgParam(String orderId) {
		StringBuilder signMsgParam = new StringBuilder();
		signMsgParam = appendParam(signMsgParam, "inputCharset", "1");
		signMsgParam = appendParam(signMsgParam, "version", "v2.0");
		signMsgParam = appendParam(signMsgParam, "signType", "1");
		signMsgParam = appendParam(signMsgParam, "merchantAcctId", CommonPayInfo.BankPayInfo.get("rmbport_merCode"));
		signMsgParam = appendParam(signMsgParam, "queryType", "0");
		signMsgParam = appendParam(signMsgParam, "queryMode", "1");
		signMsgParam = appendParam(signMsgParam, "startTime", "");
		signMsgParam = appendParam(signMsgParam, "endTime", "");
		signMsgParam = appendParam(signMsgParam, "requestPage", "");
		signMsgParam = appendParam(signMsgParam, "orderId", orderId);
		signMsgParam = appendParam(signMsgParam, "key", CommonPayInfo.BankPayInfo.get("rmbport_querykey"));
		return signMsgParam.toString();
	}
	
	/**
	 * 订单查询签名验证-本地生成签名
	 * @param queryResponse
	 * @return
	 */
	private static String getOrderQueryMsgByGeteway(GatewayOrderDetail detail) {
		StringBuilder signMsgVal = new StringBuilder();
		String mysignMsg = "";
		signMsgVal = appendParam(signMsgVal, "orderId", detail.getOrderId());
		signMsgVal = appendParam(signMsgVal, "orderAmount", "" + detail.getOrderAmount());
		signMsgVal = appendParam(signMsgVal, "orderTime", detail.getOrderTime());
		signMsgVal = appendParam(signMsgVal, "dealTime", detail.getDealTime());
		signMsgVal = appendParam(signMsgVal, "payResult", detail.getPayResult());
		signMsgVal = appendParam(signMsgVal, "payType", detail.getPayType());
		signMsgVal = appendParam(signMsgVal, "payAmount", "" + detail.getPayAmount());
		signMsgVal = appendParam(signMsgVal, "fee", "" + detail.getFee());
		signMsgVal = appendParam(signMsgVal, "dealId", detail.getDealId());
		signMsgVal = appendParam(signMsgVal, "key", CommonPayInfo.BankPayInfo.get("rmbport_querykey"));
		mysignMsg = MD5Util.md5Hex(signMsgVal.toString().getBytes()) .toUpperCase();
		return mysignMsg;
	}
}

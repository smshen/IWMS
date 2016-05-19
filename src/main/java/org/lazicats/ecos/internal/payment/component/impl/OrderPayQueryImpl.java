package org.lazicats.ecos.internal.payment.component.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Abchina.AbcpayUtils;
import org.lazicats.ecos.internal.payment.common.AlipayOrderQuery.AlipaySubmit;
import org.lazicats.ecos.internal.payment.common.Boc.BocPayUtils;
import org.lazicats.ecos.internal.payment.common.Ccb.CcbPayUtils;
import org.lazicats.ecos.internal.payment.common.Icbc.IcbcPayUtils;
import org.lazicats.ecos.internal.payment.common.Rmbport.RmbportUtils;
import org.lazicats.ecos.internal.payment.common.Unionpay.UnionPayQuery;
import org.lazicats.ecos.internal.payment.component.OrderPayQueryment;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @FileName OrderPayQueryImpl.java
 * @PackageName org.lazicats.ecos.internal.payment.component.impl
 * @功能 订单状态查询
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-16下午12:01:56
 * 
 */
@Service
public class OrderPayQueryImpl implements OrderPayQueryment {

	private static final Logger log = Logger.getLogger(OrderPayQueryImpl.class);

	/**
	 * 订单支付状态查询
	 */
	public String orderPayQuery(String payMent, Map<String, String> queryMap) {

		if (CommonPayInfo.PAYMENT_BOC.equals(payMent)) {
			return OrderPayQueryImpl.bocPayOrderQueryMessage(queryMap);
		} else if (CommonPayInfo.PAYMENT_ICBC.equals(payMent)) {
			return OrderPayQueryImpl.icbcPayOrderQueryMessage(queryMap);
		} else if(CommonPayInfo.PAYMENT_ABC.equals(payMent)){
			return OrderPayQueryImpl.abchinaPayOrderQueryMessage(queryMap);
		} else if(CommonPayInfo.PAYMENT_CCB.equals(payMent)){
			return OrderPayQueryImpl.ccbPayOrderQueryMessaget(queryMap);
		} else if(CommonPayInfo.PAYMENT_UNIONPAY.equals(payMent)){
			return OrderPayQueryImpl.unionPayOrderQueryMessage(queryMap);
		} else if(CommonPayInfo.PAYMENT_PAYPAL.equals(payMent)){
			return OrderPayQueryImpl.rmbportPayOrderQueryMessage(queryMap);
		} else if(CommonPayInfo.PAYMENT_ALIPAY.equals(payMent)){
			return OrderPayQueryImpl.alipayPayOrderQueryMessage(queryMap);
		}
		
		return "";
	}

	/**
	 * 中行订单查询
	 * 
	 * @param queryVo
	 * @return
	 */
	private static String bocPayOrderQueryMessage(Map<String, String> queryMap) {
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		//封装请求VO
		String queryVo[] = {
				CommonPayInfo.BankPayInfo.get("bocPay_merCode"),
				queryMap.get("orderId")
		};
		
		queryOrderMessage = BocPayUtils.queryOrder(queryVo);
		//将请求对象转为json
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(queryOrderMessage);
		return json;
	}

	/**
	 * 工行订单查询
	 * 
	 * @param valueVo
	 * @return
	 */
	private static String icbcPayOrderQueryMessage(Map<String, String> queryMap) {
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//封装请求vo
		try{
			String queryVo[] = {
					queryMap.get("orderId"),
					format.format(df.parse(queryMap.get("tranDate")))
			};
			queryOrderMessage = IcbcPayUtils.orderPayQuery(queryVo);
		} catch (java.text.ParseException e) {
			log.error("工行支付订单查询，日期格式转换异常！");
			queryOrderMessage.setMessage("工行支付订单查询，日期格式转换异常");
			e.printStackTrace();
		}
		
		//将请求对象转为json
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(queryOrderMessage);
		return json;
	}
	
	/**
	 * 农行订单支付状态查询
	 * 
	 * @param queryMap
	 * @return
	 */
	private static String abchinaPayOrderQueryMessage(Map<String, String> queryMap){
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		queryOrderMessage = AbcpayUtils.queryOrder(queryMap.get("orderId"));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(queryOrderMessage);
		return json;
	}
	
	/*
	 * 建行未测
	 */
	private static String ccbPayOrderQueryMessaget(Map<String, String> queryMap){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			String queryVo[] = {
					format.format(df.parse(queryMap.get("tranDate"))),
					queryMap.get("orderId"),
					""
			};
			CcbPayUtils.queryOrder(queryVo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 银联支付查询
	 * 
	 * @param queryMap
	 * @return
	 */
	private static String unionPayOrderQueryMessage(Map<String, String> queryMap){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		try {
			queryOrderMessage = UnionPayQuery.queryTrans("01", queryMap.get("orderId"), format.format(df.parse(queryMap.get("tranDate"))));
		} catch (ParseException e) {
			log.error("银联支付查询请求异常");
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().create();
		return gson.toJson(queryOrderMessage);
	}
	
	/**
	 * 快钱支付查询
	 * 
	 * @param queryMap
	 * @return
	 */
	private static String rmbportPayOrderQueryMessage(Map<String, String> queryMap) {
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		queryOrderMessage = RmbportUtils.orderQuery(queryMap.get("orderId"));
		
		Gson gson = new GsonBuilder().create();
		return gson.toJson(queryOrderMessage);
	}
	
	/**
	 * 支付宝支付查询
	 * 
	 * @param queryMap
	 * @return
	 */
	private static String alipayPayOrderQueryMessage(Map<String, String> queryMap) {
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		queryOrderMessage = AlipaySubmit.orderQuery(queryMap.get("orderId"), queryMap.get("trandeNo"));

		Gson gson = new GsonBuilder().create();
		return gson.toJson(queryOrderMessage);
	}
}

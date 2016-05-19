package org.lazicats.ecos.internal.payment.common.Tenpay;

/**
 * 名称：财付通支付配置类
 * 功能：配置类
 * 类属性：公共类
 * */

public class TenpayConfig {
	//收款方
	public final static String spname = "财付通双接口测试";  
	//商户号
	public final static String partner = "1900000113";
	//密钥
	public final static String key = "e82573dc7e6136ba414f2e2affbe39fa";
	//交易完成后跳转的URL
	public final static String return_url = "http://127.0.0.1:8080/EC-Mall/mall/pay/callbackTenpay.ihtml";

	//接收财付通通知的URL
	public final static String notify_url = "http://127.0.0.1:8080/EC-Mall/mall/pay/serverTenpay.ihtml";
	//设置支付网关
//	reqHandler.setGateUrl("https://gw.tenpay.com/gateway/pay.htm");
	
}
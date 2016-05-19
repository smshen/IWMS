package org.lazicats.ecos.internal.payment.common.Tenpay;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * 类说明：
 */

public class TenPayConf {

	//签名字段
	public static final String sign = "sign";
	
	/*
	 * 字符数组
	 */
	public static String payVo[] = new String[]{
			"partner",//商户号
			"out_trade_no",//商家订单号
			"total_fee",//商品金额,以分为单位
			"return_url",//交易完成后跳转的URL
			"notify_url",//接收财付通通知的URL
			"body",//商品描述
			"bank_type",//银行类型(中介担保时此参数无效)
			"spbill_create_ip",//用户的公网ip，不是商户服务器IP
			"fee_type",//币种，1人民币\
			"subject",//商品名称(中介交易时必填)
			"sign_type",//签名类型,默认：MD5
			"service_version",//版本号，默认为1.0
			"input_charset",//字符编码
			"sign_key_index",//密钥序号
			"attach", //附加数据，原样返回
			"product_fee",//商品费用
			"transport_fee",//物流费用
			"time_start",//订单生成时间，格式为yyyymmddhhmmss
			"time_expire",//订单失效时间，格式为yyyymmddhhmmss
			"buyer_id",//买方财付通账号
			"goods_tag",//商品标记
			"trade_mode",//交易模式，1即时到账(默认)，2中介担保，3后台选择（买家进支付中心列表选择）
			"transport_desc",//物流说明
			"trans_type",//交易类型，1实物交易，2虚拟交易
			"agentid",//平台ID
			"agent_type",//代理模式，0无代理(默认)，1表示卡易售模式，2表示网店模式
			"seller_id"//卖家商户号，为空则等同于partner
	};
	
}

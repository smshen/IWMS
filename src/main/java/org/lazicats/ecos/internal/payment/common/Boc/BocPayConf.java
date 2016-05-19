package org.lazicats.ecos.internal.payment.common.Boc;

/**
 * 中行 基础信息类
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 */
public class BocPayConf {

	/*
	 * 商户签名
	 */
	protected static String signData = "signData";// 商户签名数据串格式，各项数据用冒号分隔（其中多笔订单号使用管道符分隔）
	
	/*
	 * 支付提交参数
	 */
	protected final static String[] payVo = new String[] { 
		"merchantNo",
		"payType", 
		"orderNo", 
		"curCode", 
		"orderAmount", 
		"orderTime",
		"orderNote", 
		"orderUrl", 
		"orderTimeoutDate" 
	};
	
	/*
	 * 中行查询封装对象
	 */
	protected final static String[] queryVo = new String[]{
		"merchantNo",//BOC商户ID
		"orderNos",//商户系统产生的订单号，支持输入多个订单号进行查询，最多支持50个订单号的查询
	};
}

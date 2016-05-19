package org.lazicats.ecos.internal.payment.common.Abchina;

/**
 * AbchinaConf.java
 * 
 * @author MingJun_Guo
 * @创建日期：2013-10-11上午9:00:23
 * 
 */
public class AbchinaConf {

	/*
	 * 支付回调返回对象
	 */
	protected final static String[] payResultVo = new String[]{
		"OrderNo",//订单号
		"Amount",//订单金额
		"BatchNo",//交易批次号
		"VoucherNo",//交易凭证号（建议使用iRspRef 作为对账依据）
		"HostDate",//银行交易日期（YYYY/MM/DD）
		"HostTime",// 银行交易时间（HH:MM:SS）
		"MerchantRemarks",//商户备注信息（商户在支付请求时所提交的信息）
		"PayType",//消费者支付方式
		"NotifyType",//支付结果通知方式
		"iRspRef"//银行返回交易流水号
	};

	/*
	 * 支付失败回调信息
	 */
	protected final static String[] payFailureResult = new String[]{
		"ReturnCode",//返回结果代码
		"ErrorMessage"//错误信息
	};
}

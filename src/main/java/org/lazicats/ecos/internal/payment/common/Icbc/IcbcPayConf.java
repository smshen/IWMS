package org.lazicats.ecos.internal.payment.common.Icbc;

/**
 * 工行
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-12 上午10:40:16
 * 
 */
public class IcbcPayConf {

	/*
	 * 签名字段
	 */
	public static String merSignMsg = "merSignMsg";// 订单签名
	public static String merCert = "merCert";// 商城证书公钥

	/*
	 * 支付请求对象(不包含签名)
	 */
	protected final static String[] payVo = new String[]{
		"interfaceName",
		"interfaceVersion",
		"orderid",
		"amount",
		"curType",
		"merID",
		"merAcct",
		"verifyJoinFlag",
		"notifyType",
		"merURL",
		"resultType",
		"goodsID",
		"goodsName",
		"goodsNum",
		"carriageAmt",
		"merHint",
		"orderDate",
		"remark1",
		"remark2"
	};

	/*
	 * 工行支付回调对象(包含签名字段)
	 */
	protected final static String[] callBack = new String[] { 
			"interfaceName",// 接口名称
			"interfaceVersion",// 接口版本号
			"orderid",// 订单号
			"TranSerialNo",// 银行指令序号
			"amount",// 订单金额
			"curType",// 支付币种
			"merID",// 商户代码
			"merAcct",// 商城账号
			"verifyJoinFlag",// 检验联名标志
			"JoinFlag",// 客户联名标志
			"UserNum",// 联名会员号
			"resultType",// 结果发送类型
			"orderDate",// 交易日期时间
			"notifyDate",// 返回通知日期时间
			"tranStat",// 订单处理状态
			"comment",// 错误描述
			"remark1",// 备注1
			"remark2",// 备注2
			"signMsg"// 通知消息银行签名数据
	};
	
	/*
	 *工行订单查询参数传递对象 
	 */
	protected final static String[] queryVo = new String[] {
		"orderId",//订单号码
		"tranDate"//订单时间
	};
}

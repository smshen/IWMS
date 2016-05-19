package org.lazicats.ecos.internal.payment.common.Ccb;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：建行 参数对象类
 */

public class CcbPayConf {

	/*
	 * MAC校验域
	 */
	protected static String mac = "MAC";
	
	/*
	 * 数字签名（页面通知、服务器通知）
	 */
	protected static String sign = "SIGN";
	
	/*
	 * 支付请求对象
	 */
	protected static String ccbPay[] = new String[]{
		"MERCHANTID",//	商户代码	CHAR(15)	由建行统一分配
		"POSID",//商户柜台代码	CHAR(9)	由建行统一分配，缺省为000000000
		"BRANCHID",//分行代码	CHAR(9)	由建行统一指定
		"ORDERID",//定单号	CHAR(30)	由商户提供，最长30位,按实际长度给出
		"PAYMENT",//付款金额	NUMBER(16,2)	由商户提供，按实际金额给出
		"CURCODE",//币种	CHAR(2)	缺省为01－人民币（只支持人民币支付）
		"REMARK1",//备注1	CHAR(30)	网银不处理，直接传到城综网
		"REMARK2",//备注2	CHAR(30)	网银不处理，直接传到城综网
		"TXCODE",//交易码	CHAR(6)	由建行统一分配为520100
		"TYPE",
		"PUB",
		"GATEWAY",
		"CLIENTIP",
		"REGINFO",
		"PROINFO",
		"REFERER"
	};
	
	/*
	 * 页面通知对象
	 */
	protected static String ccbInform[] = new String[]{
		"POSID",//商户柜台代码	CHAR(9)	从商户传送的信息中获得
		"BRANCHID",//分行代码	CHAR(9)	从商户传送的信息中获得
		"ORDERID",//定单号	CHAR(30)	从商户传送的信息中获得
		"PAYMENT",//付款金额	NUMBER(16,2)	从商户传送的信息中获得
		"CURCODE",//币种	CHAR(2)	从商户传送的信息中获得
		"REMARK1",//备注一	CHAR(30)	从商户传送的信息中获得
		"REMARK2",//备注二	CHAR(30)	从商户传送的信息中获得
		"SUCCESS",//成功标志	CHAR(1)	成功时返回Y
		"TYPE",
		"REFERER",
		"CLIENTIP",
		"ACCDATE",
		"USRMSG",
		"SIGN"
	};
	
	/*
	 * 服务器通知对象
	 */
	protected static String ccbServerInform[] = new String[]{
		"POSID",//商户柜台代码	CHAR(9)	从商户传送的信息中获得
		"BRANCHID",//分行代码	CHAR(9)	从商户传送的信息中获得
		"ORDERID",//定单号	CHAR(30)	从商户传送的信息中获得
		"PAYMENT",//付款金额	NUMBER(16,2)	从商户传送的信息中获得
		"CURCODE",//币种	CHAR(2)	从商户传送的信息中获得
		"REMARK1",//备注一	CHAR(30)	从商户传送的信息中获得
		"REMARK2",//备注二	CHAR(30)	从商户传送的信息中获得
		"ACC_TYPE",//账户类型	CHAR(2)	仅服务器通知中有此字段，页面通知不用。
		"SUCCESS",//成功标志	CHAR(1)	成功时返回Y
		"TYPE",
		"REFERER",
		"CLIENTIP",
		"ACCDATE",
		"USRMSG",
		"SIGN"
	};
	
	
	/*
	 * 订单查询对象
	 */
	protected static String ccbQueryOrder[] = new String []{
		"ORDERDATE",//订单时间
		"BEGORDERID",//开始订单
		"ENDORDERID"//结束订单
	};
}

package org.lazicats.ecos.internal.payment.common.Unionpay;

/**
 * 
 * @FileName UnionPayConf.java
 * @PackageName org.lazicats.ecos.internal.payment.common.Unionpay
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-16下午2:51:23
 *
 */
public class UnionPayConf{

	// 加密方式
	public final static String signType = "MD5";

	// 签名
	public final static String signature = "signature";
	public final static String signMethod = "signMethod";

	//组装消费请求包
	protected final static String[] reqVo = new String[]{
			"version",
            "charset",
            "transType",//交易类型
            "origQid",//原始交易流水号
            "merId",//商户代码
            "merAbbr",//商户名称
            "acqCode",//收单机构代码
            "merCode",//商户类型
            "commodityUrl",//商品URL
            "commodityName",//商品名称
            "commodityUnitPrice",//商品单价
            "commodityQuantity",//商品数量
            "commodityDiscount",//优惠信息
            "transferFee",//运输费用
            "orderNumber",//商户订单号
            "orderAmount",//orderAmount
            "orderCurrency",//orderCurrency
            "orderTime",//交易开始日期时间
            "customerIp",//持卡人IP
            "customerName",//持卡人姓名
            "defaultPayType",//默认支付方式
            "defaultBankNumber",//默认银行编码
            "transTimeout",//交易超时时间
            "frontEndUrl",//返回URL
            "backEndUrl",//通知URL
            "merReserved"//商户保留域
	};

	public final static String[] notifyVo = new String[]{
            "charset",
            "cupReserved",
            "exchangeDate",//兑换日期
            "exchangeRate",//清算汇率
            "merAbbr",//商户名称
            "merId",//商户代码
            "orderAmount",//交易金额
            "orderCurrency",//交易币种
            "orderNumber",//商户订单号  --8
            "qid",//交易流水号 -9
            "respCode",//响应码   -10
            "respMsg",//响应信息 -11
            "respTime",//交易完成时间   -12
            "settleAmount",//清算金额
            "settleCurrency",//清算币种
            "settleDate",//清算日期
            "traceNumber",//系统跟踪号
            "traceTime",//系统跟踪时间
            "transType",//交易类型
            "version"
	};

	protected final static String[] queryVo = new String[]{
		"version",
		"charset",
		"transType",
		"merId",
		"orderNumber",
		"orderTime",
		"merReserved"
	};

}

package org.lazicats.ecos.internal.payment.common.Rmbport;

/**
 * @author MingJun_Guo
 * @创建日期：2013-9-3上午9:20:41
 * 
 * @说明：
 */

public class RmbportConf {

	//快钱加密字段
	protected static String signMsg = "signMsg";
	
	//快钱支付提交字段(除加密字段)
	protected static String rmbportPay[] = new String[]{
			"inputCharset",
			"pageUrl",
			"bgUrl",
			"version",
			"language",
			"signType",
			"merchantAcctId",
			"payerName",
			"payerContactType",
			"payerContact",
			"orderId",
			"orderAmount",
			"orderTime",
			"productName",
			"productNum",
			"productId",
			"productDesc",
			"ext1",
			"ext2",
			"payType",
			"bankId",
			"redoFlag",
			"pid"
	};
}

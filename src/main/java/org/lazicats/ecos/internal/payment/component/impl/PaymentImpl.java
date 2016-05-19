package org.lazicats.ecos.internal.payment.component.impl;



import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lazicats.ecos.basecomponent.utils.RandomUtils;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Abchina.AbcpayUtils;
import org.lazicats.ecos.internal.payment.common.AlipayDb.AlipayConfig;
import org.lazicats.ecos.internal.payment.common.AlipayDb.AlipayService;
import org.lazicats.ecos.internal.payment.common.Boc.BocPayUtils;
import org.lazicats.ecos.internal.payment.common.Ccb.CcbPayUtils;
import org.lazicats.ecos.internal.payment.common.Icbc.IcbcPayUtils;
import org.lazicats.ecos.internal.payment.common.Rmbport.RmbportUtils;
import org.lazicats.ecos.internal.payment.common.Tenpay.TenPayUtils;
import org.lazicats.ecos.internal.payment.common.Unionpay.UnionPayConf;
import org.lazicats.ecos.internal.payment.common.Unionpay.UnionPayUtils;
import org.lazicats.ecos.internal.payment.common.Upoppay.UpopPayUtils;
import org.lazicats.ecos.internal.payment.common.Upoppay.model.BusinessType;
import org.lazicats.ecos.internal.payment.common.Upoppay.model.CbeParam;
import org.lazicats.ecos.internal.payment.common.Upoppay.model.SplitParam;
import org.lazicats.ecos.internal.payment.common.Upoppay.model.UPOPPaymentParam;
import org.lazicats.ecos.internal.payment.component.IPayment;
import org.lazicats.ecos.internal.utils.StringUtils;
import org.lazicats.ecos.internal.utils.UnicodeChange;
import org.springframework.stereotype.Service;

/**
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-12 下午03:32:50
 * 
 */
@Service
public class PaymentImpl implements IPayment {

	private static Logger log = Logger.getLogger(PaymentImpl.class);

	/**
	 * 支付请求
	 */
	public String pay(String payMent, Map<String, String> payentMent)
			throws Exception {
		if (CommonPayInfo.PAYMENT_UNIONPAY.equals(payMent.trim())) {
			// 银联
			return PaymentImpl.unionPay(payentMent);
		} else if (CommonPayInfo.PAYMENT_ALIPAY.equals(payMent.trim())) {
			// 支付宝
			return PaymentImpl.alipayPay(payentMent);
		} else if (CommonPayInfo.PAYMENT_ICBC.equals(payMent.trim())) {
			// 工行
			return PaymentImpl.icbcPay(payentMent);
		} else if (CommonPayInfo.PAYMENT_BOC.equals(payMent.trim())) {
			// 中行
			return PaymentImpl.bocPay(payentMent);
		} else if (CommonPayInfo.PAYMENT_TENPAY.equals(payMent.trim())) {
			// 财付通
			return PaymentImpl.tenPay(payentMent);
		} else if (CommonPayInfo.PAYMENT_CCB.equals(payMent.trim())) {
			// 建行
			return PaymentImpl.ccbPay(payentMent);
		} else if (CommonPayInfo.PAYMENT_ABC.equals(payMent.trim())) {
			// 农行
			return PaymentImpl.abcPay(payentMent);
		} else if(CommonPayInfo.PAYMENT_PAYPAL.equals(payMent.trim())){
			//快钱
			return PaymentImpl.rmbportPay(payentMent);
		}else if(CommonPayInfo.PAYMENT_UPOP.equals(payMent.trim())){
			//银联跨境支付
			return PaymentImpl.payViaUpop(payentMent);
		}
		return CommonPayInfo.BankPayInfo.get("exceptionUrl");
	}

	

	/**
	 * 支付宝
	 */
	private static String alipayPay(Map<String, String> payentment)
			throws Exception {
		String logistics_fee = "0.00"; // 物流费用，即运费。
		String logistics_type = "express"; // 物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
		String logistics_payment = "SELLER_PAY"; // 物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）

		String quantity = "1"; // 商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。

		// 扩展参数——买家收货信息（推荐作为必填）
		// 该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
		// 若要使用该功能，请至少保证receive_name、receive_address有值
		//String receive_name = "郭明军"; // 收货人姓名，如：张三
		//String receive_address = "广东省深圳市南山区高新技术产业园北区"; // 收货人地址，如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
		String receive_zip = ""; // 收货人邮编，如：123456
		//String receive_phone = ""; // 收货人电话号码，如：0571-81234567
		//String receive_mobile = "15223371867"; // 收货人手机号码，如：13312341234

		// 扩展参数——第二组物流方式
		// 物流方式是三个为一组成组出现。若要使用，三个参数都需要填上数据；若不使用，三个参数都需要为空
		// 有了第一组物流方式，才能有第二组物流方式，且不能与第一个物流方式中的物流类型相同，
		// 即logistics_type="EXPRESS"，那么logistics_type_1就必须在剩下的两个值（POST、EMS）中选择
		String logistics_fee_1 = ""; // 物流费用，即运费。
		String logistics_type_1 = ""; // 物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
		String logistics_payment_1 = ""; // 物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）

		// 扩展参数——第三组物流方式
		// 物流方式是三个为一组成组出现。若要使用，三个参数都需要填上数据；若不使用，三个参数都需要为空
		// 有了第一组物流方式和第二组物流方式，才能有第三组物流方式，且不能与第一组物流方式和第二组物流方式中的物流类型相同，
		// 即logistics_type="EXPRESS"、logistics_type_1="EMS"，那么logistics_type_2就只能选择"POST"
		String logistics_fee_2 = ""; // 物流费用，即运费。
		String logistics_type_2 = ""; // 物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
		String logistics_payment_2 = ""; // 物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）

		// 扩展功能参数——其他
		String buyer_email = ""; // 默认买家支付宝账号
		String discount = ""; // 折扣，是具体的金额，而不是百分比。若要使用打折，请使用负数，并保证小数点最多两位数

		// //构造函数，生成请求URL
		log.info("客户传来的金额：" + payentment.get("total_fee"));
		log.info("客户传来的单号：" + payentment.get("out_trade_no"));
		String str= AlipayService.BuildForm(
				CommonPayInfo.BankPayInfo.get("alipay_partner"),
				CommonPayInfo.BankPayInfo.get("alipay_seller_email"),
				CommonPayInfo.BankPayInfo.get("alipay_returnUrl"),
				CommonPayInfo.BankPayInfo.get("alipay_notifyUrl"),
				"",
				payentment.get("out_trade_no"),
				payentment.get("subject"),
				"",
				payentment.get("total_fee"),
				quantity,
				receive_zip,
				StringUtils.isEmpty(payentment.get("receive_phone")) == true ? payentment
						.get("receive_phone") : "",
				logistics_fee_1,
				logistics_type_1, logistics_payment_1, logistics_fee_2,
				logistics_type_2, logistics_payment_2, buyer_email,
				discount, CommonPayInfo.BankPayInfo
						.get("alipay_input_charset"),
				CommonPayInfo.BankPayInfo.get("alipay_key"),
				AlipayConfig.sign_type);
		log.info("支付宝请求"+str);
		
		return str;
	}

	/**
	 * 银联支付请求
	 * 
	 * @param payMentVo
	 * @return
	 */
	private static String unionPay(Map<String, String> payentMent) {
		// 商户需要组装如下对象的数据
		String[] valueVo = new String[] {
				CommonPayInfo.BankPayInfo.get("unionPay_version"),// 协议版本
				CommonPayInfo.BankPayInfo.get("unionPay_charset"),// 字符编码
				"01",// 交易类型
				"",// 原始交易流水号
				CommonPayInfo.BankPayInfo.get("unionPay_merCode"),// 商户代码
				CommonPayInfo.BankPayInfo.get("unionPay_merName"),// 商户简称
				"",// 收单机构代码（仅收单机构接入需要填写）
				"",// 商户类别（收单机构接入需要填写）
				StringUtils.removeSpace(payentMent.get("show_url")),// 商品URL
				payentMent.get("subject"),// 商品名称
				"",// 商品单价 单位：分
				"",// 商品数量 传递
				"",// 折扣 单位：分
				"",// 运费 单位：分
				StringUtils.removeSpace(payentMent.get("out_trade_no")),// 订单号（需要商户自己生成）
				String.valueOf(new BigDecimal(payentMent.get("total_fee")
						.toString()).multiply(new BigDecimal(100)).intValue()),// 交易金额
																				// 单位：分String.valueOf(a*100)
				CommonPayInfo.BankPayInfo.get("unionPay_currency"),// 交易币种
				payentMent.get("create_order_time"),// 交易时间 new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
				StringUtils.removeSpace(payentMent.get("exter_invoke_ip")),// 用户IP
				"",// 用户真实姓名
				"",// 默认支付方式
				"",// 默认银行编号
				StringUtils.removeSpace(CommonPayInfo.BankPayInfo
						.get("unionPay_outTime")),// 交易超时时间 配置
				CommonPayInfo.BankPayInfo.get("unionPay_frontUrl"),// 前端回调地址
				CommonPayInfo.BankPayInfo.get("unionPay_afterUrl"),// 后台回调地址
				""// 商户保留域
		};

		String signType = UnionPayConf.signType;
		return new UnionPayUtils().createPayHtml(valueVo, signType);// 跳转到银联页面支付
	}

	/**
	 * 工行B2C支付请求
	 * 
	 * @param map
	 * @return
	 */
	private static String icbcPay(Map<String, String> map) {
		String icbcValVo[] = new String[] {};

		try {
			icbcValVo = new String[] {
					CommonPayInfo.BankPayInfo.get("icbcPay_portName"),// 接口名称，取值：ICBC_PERBANK_B2C
					CommonPayInfo.BankPayInfo.get("icbcPay_version"),// 接口版本号，取值：1.0.0.0
					StringUtils.removeSpace(map.get("out_trade_no")),// 订单号
					String.valueOf(new BigDecimal(map.get("total_fee")
							.toString()).multiply(new BigDecimal(100))
							.intValue()),// 订单金额
					"001",// 支付币种,目前工行只支持使用人民币（001）支付。取值：001
					CommonPayInfo.BankPayInfo.get("icbcPay_merCode"),// 商户代码
					CommonPayInfo.BankPayInfo.get("icbcPay_merAcct"),// 商城账号
					"0",// 检验联名标志/verifyJoinFlag
					CommonPayInfo.BankPayInfo.get("icbcPay_notifyType"),// 通知类型
					CommonPayInfo.BankPayInfo.get("icbcPay_merURL"),// 接收支付结果信息通知程序地址
					CommonPayInfo.BankPayInfo.get("icbcPay_resultType"),// 结果发送类型
					"",// 商品id
					StringUtils.removeSpace(new String(map.get("subject")
							.getBytes("UTF-8"), "GBK").toString()),// 商品名称
					"",// 商品数量
					"",// 已含运费金额
					"",// 商城提示
					map.get("create_order_time"),// 交易日期时间 new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
					"",// 备注字段1
					""// 备注字段1
			};
		} catch (UnsupportedEncodingException e) {
			log.error("工行支付接口商品名称转换字符集错误！");
			e.printStackTrace();
		}
		return IcbcPayUtils.crateIcbcPayHtml(icbcValVo);
	}

	/**
	 * 中行B2C支付请求
	 * 
	 * @param map
	 * @return
	 */
	private static String bocPay(Map<String, String> map) {
		log.info("中国银行订单金额："+map.get("total_fee"));
		String body=map.get("body");
	    body="shit";
		log.info("body="+body +"sdg="+(body==null||body.trim()==""));
		String bocValueVo[] = new String[] {
				CommonPayInfo.BankPayInfo.get("bocPay_merCode"),// 商户号
				"1", // 商户支付服务类型 1：网上购物
				map.get("out_trade_no"), // 商户订单号 orderNo
				"001", // 订单币种,目前只支持001：人民币,固定填001
				map.get("total_fee"),
				// StringUtils.leftAddZero(map.get("total_fee"), 13),
				// //订单金额,格式：整数位不前补零,小数位补齐2位
				map.get("create_order_time"),// 订单时间 new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
				body, // 订单说明,orderNote
				CommonPayInfo.BankPayInfo.get("bocPay_merUrl"), // 商户接收通知URL,orderUrl
				""// 超时时间
		};

		return BocPayUtils.crateIcbcPayHtml(bocValueVo);
	}

	/**
	 * 财付通支付请求
	 * 
	 * @param payVo
	 * @param userState
	 * @return
	 * @throws Exception
	 */
	private static String tenPay(Map<String, String> map) throws Exception {
		// 支付 数组对象
		String tenValueVo[] = new String[] {
				CommonPayInfo.BankPayInfo.get("tenpay_partner"),// 商户号
				map.get("out_trade_no"),// 商家订单号
				String.valueOf(new BigDecimal(map.get("total_fee").toString())
						.multiply(new BigDecimal(100)).intValue()),// 商品金额,以分为单位
				CommonPayInfo.BankPayInfo.get("tenpay_returnUrl"),// 交易完成后跳转的URL
				CommonPayInfo.BankPayInfo.get("tenpay_notifyUrl"),// 接收财付通通知的URL
				map.get("subject"),// 商品描述
				"DEFAULT",// 银行类型(中介担保时此参数无效)
				map.get("exter_invoke_ip"),// 用户的公网ip，不是商户服务器IP
				"1",// 币种，1人民币
				map.get("subject"),// 商品名称(中介交易时必填)
				"MD5",// 签名类型,默认：MD5
				"1.0",// 版本号，默认为1.0
				"UTF-8",// 字符编码
				"1",// 密钥序号
				"",// 附加数据，原样返回
				"",// 商品费用
				"0",// 物流费用
				map.get("create_order_time"),// 订单生成时间 TenpayUtil.getCurrTime()
				"",// 订单失效时间
				"",// 买方财付通账号
				"",// 商品标记
				"1",// 交易模式
				"",// 物流说明
				"1",// 交易类型，1实物交易，2虚拟交易
				"",// 平台ID
				"",// 代理模式
				""// 卖家商户号
		};

		return TenPayUtils.crateTenPayHtml(tenValueVo);
	}

	/**
	 * 建行支付请求
	 * 
	 * @param map
	 * @return
	 */
	private static String ccbPay(Map<String, String> map) {
	    log.info("建设银行订单金额："+map.get("total_fee"));
		String pubCompare = "37a1b1660aac1fd093e13ca9020111";
		String pubkey = CommonPayInfo.BankPayInfo.get("ccbPay_pubkey");
		
		String pub = pubkey.substring(pubkey.length()-30);
		assert pubCompare == pub;
		String ccbValueVo[] = new String[] {
				CommonPayInfo.BankPayInfo.get("ccbPay_merCode"),// 商户代码 CHAR(15)
																// 由建行统一分配
				CommonPayInfo.BankPayInfo.get("ccbPay_posid"),// 商户柜台代码 CHAR(9)
																// 由建行统一分配，缺省为000000000
				CommonPayInfo.BankPayInfo.get("ccbPay_branchId"),// 分行代码 CHAR(9)
																	// 由建行统一指定
				map.get("out_trade_no"),// 定单号 CHAR(30) 由商户提供，最长30位,按实际长度给出
				map.get("total_fee"),// 付款金额 NUMBER(16,2) 由商户提供，按实际金额给出
				"01",// 币种 CHAR(2) 缺省为01－人民币（只支持人民币支付）
				"",// 备注1 CHAR(30) 网银不处理，直接传到城综网
				"",// 备注2 CHAR(30) 网银不处理，直接传到城综网
				"520100",// 交易码 CHAR(6) 由建行统一分配为520100
				"1",
				pub,
				"", //网关类型
				map.get("clientIp"),
				UnicodeChange.chinaToUnicode(map.get("reginfo"), "%u"), //注册信息
				UnicodeChange.chinaToUnicode(map.get("proinfo"), "%u"), //商品信息
				map.get("referer")
				
		};
		return CcbPayUtils.crateCcbPayHtml(ccbValueVo);
	}

	/**
	 * 农行支付请求
	 * 
	 * @param map
	 * @return
	 */
	private static String abcPay(Map<String, String> map) {
		log.info("生成农行支付页面订单号："+map.get("out_trade_no")+"时间:"+new Date()+"金额:"+map.get("total_fee"));
		return AbcpayUtils.crateAbcPayHtml(map);
	}
	
	/**
	 * 快钱支付
	 * 
	 * @param map
	 * @return
	 */
	private static String rmbportPay(Map<String, String> map) {
		String rmbportValueVo[] = new String[] {
				"1",//编码方式，1代表 UTF-8; 2 代表 GBK; 3代表 GB2312 默认为1,该参数必填。
				CommonPayInfo.BankPayInfo.get("rmbport_pageUrl"),//接收支付结果的页面地址，该参数一般置为空即可。
				CommonPayInfo.BankPayInfo.get("rmbport_bgUrl"),//服务器接收支付结果的后台地址，该参数务必填写，不能为空。*
				"v2.0",//网关版本，固定值：v2.0,该参数必填。*
				"1",//语言种类，1代表中文显示，2代表英文显示。默认为1,该参数必填。*
				"4",//签名类型,该值为4，代表PKI加密方式,该参数必填。*
				CommonPayInfo.BankPayInfo.get("rmbport_merCode"),//人民币网关账号，该账号为11位人民币网关商户编号+01,该参数必填。*
				"",//支付人姓名,可以为空。
				"",//支付人联系类型，1 代表电子邮件方式；2 代表手机联系方式。可以为空。
				"",//支付人联系方式，与payerContactType设置对应，payerContactType为1，则填写邮箱地址；payerContactType为2，则填写手机号码。可以为空。
				map.get("out_trade_no"),//商户订单号 *
				String.valueOf(new BigDecimal(map.get("total_fee").toString()).multiply(new BigDecimal(100)).intValue()),//订单金额，金额以“分”为单位 *
				map.get("create_order_time"),//订单提交时间，格式：yyyyMMddHHmmss new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()) *
				"",//商品名称，可以为空。
				"",//商品数量，可以为空。
				"",//商品代码，可以为空。
				"",//商品描述，可以为空。
				"",//扩展字段1，商户可以传递自己需要的参数，支付完快钱会原值返回，可以为空。
				"",//扩展自段2，商户可以传递自己需要的参数，支付完快钱会原值返回，可以为空。
				"00",//支付方式，一般为00，代表所有的支付方式。如果是银行直连商户，该值为10，必填。 *
				"",//银行代码，如果payType为00，该值可以为空；如果payType为10，该值必须填写，具体请参考银行列表。
				"0",//同一订单禁止重复提交标志，实物购物车填1，虚拟产品用0。1代表只能提交一次，0代表在支付不成功情况下可以再提交。可为空。
				""//快钱合作伙伴的帐户号，即商户编号，可为空。
		};
		return RmbportUtils.crateRmbportPayHtml(rmbportValueVo);
	}
	
	private static String payViaUpop(Map<String, String> orderInfo) {
		//获得支付订单信息
		UPOPPaymentParam paymentOrderInfo = getPaymentOrderInfo(orderInfo);
		
		//生成支付表单html
		String paymentFormHtml = UpopPayUtils.createHtmlPaymentForm("SendOrderForm",
								    CommonPayInfo.BankPayInfo.get("upop_gateway"), paymentOrderInfo);
		return paymentFormHtml;
	}



	private static UPOPPaymentParam getPaymentOrderInfo(
			Map<String, String> orderInfo) {
		UPOPPaymentParam upoppaymentParam = new UPOPPaymentParam();
		upoppaymentParam.setMerId(CommonPayInfo.BankPayInfo.get("upop_merId"));
		upoppaymentParam.setPkey(CommonPayInfo.BankPayInfo.get("upop_pkey"));
		upoppaymentParam.setCurrCode(CommonPayInfo.BankPayInfo.get("upop_currCode"));
		upoppaymentParam.setCallBackUrl(CommonPayInfo.BankPayInfo.get("upop_callbackUrl"));
		upoppaymentParam.setEntryMode(CommonPayInfo.BankPayInfo.get("upop_entryMode"));
		upoppaymentParam.setBankCode(CommonPayInfo.BankPayInfo.get("upop_bankCode"));
		upoppaymentParam.setOrderType(CommonPayInfo.BankPayInfo.get("upop_orderType"));
		upoppaymentParam.setResultMode(CommonPayInfo.BankPayInfo.get("upop_resultMode"));
		upoppaymentParam.setLangType("gb2312");;
		upoppaymentParam.setBuzType(BusinessType.REALNAME);
		
		//订单信息中必须包括的信息 
		//upoppaymentParam.setOrderNo(payentMent.get("orderNo")); 
		upoppaymentParam.setOrderNo(orderInfo.get("orderNo")+RandomUtils.getRandomAlphamericStr(1)); 
		upoppaymentParam.setOrderAmount(orderInfo.get("orderAmount"));
		//upoppaymentParam.setReserved01(getReserve1Info(payentMent));
		upoppaymentParam.setReserved01(getReserve1InfoV12(orderInfo));
		upoppaymentParam.setReserved02("");
		return upoppaymentParam;
	}

	/*private static String getReserve1Info(Map<String, String> payentMent) {
		
		CbeParam cbeP = new CbeParam();
		cbeP.setRealName(payentMent.get("realName")); 
		cbeP.setGoodsAmount(payentMent.get("goodsAmount"));
		cbeP.setTaxAmount(payentMent.get("taxAmount"));
		cbeP.setFreight(payentMent.get("freight"));
		cbeP.setCredentialsNo(payentMent.get("credentialsNo"));
		
		cbeP.setCredentialsType(CbeParam.CredentialsType.ID);
		cbeP.setEcommerceCode(CommonPayInfo.BankPayInfo.get("upop_eCommerceCode"));
		cbeP.setMerCode(CommonPayInfo.BankPayInfo.get("upop_merCode"));
		return cbeP.get();
	}*/
	
	private static String getReserve1InfoV12(Map<String, String> payentMent) {
		
		CbeParam cbeP = new CbeParam();
		cbeP.setRealName(payentMent.get("realName")); 
		cbeP.setGoodsAmount(payentMent.get("goodsAmount"));
		cbeP.setTaxAmount(payentMent.get("taxAmount"));
		cbeP.setFreight(payentMent.get("freight"));
		cbeP.setCredentialsNo(payentMent.get("credentialsNo"));
		
		cbeP.setCredentialsType(CbeParam.CredentialsType.ID);
		cbeP.setEcommerceCode(CommonPayInfo.BankPayInfo.get("upop_eCommerceCode"));
		cbeP.setMerCode(CommonPayInfo.BankPayInfo.get("upop_merCode"));
		
		cbeP.setBizTypeCode(payentMent.get("bizTypeCode")); //发货模式
		cbeP.setOriOrderNo(payentMent.get("orderNo"));
		cbeP.setPaymentType("0");
		cbeP.setIEType("I");
		cbeP.setCustomsCode(payentMent.get("customsCode")); //海关编码
		cbeP.setCreTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		
		return cbeP.get();
	}
	
	/*private static String getReserve2Info(Map<String, String> payentMent) {
		SplitParam splitParam = new SplitParam();
		return splitParam.get();
	}*/
}

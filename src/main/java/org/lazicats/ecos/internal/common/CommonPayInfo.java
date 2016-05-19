package org.lazicats.ecos.internal.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共参数类
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-9 上午11:24:46
 * 
 */
public class CommonPayInfo {

	/*
	 * 银行基本信息
	 */
	public static Map<String, String> BankPayInfo = new HashMap<String, String>();
	
	public static String get(String key) {
		return BankPayInfo.get(key);
	}
	
	public static String put(String key,String val) {
		return BankPayInfo.put(key, val);
	}
	
	/*
	 * 支付宝
	 */
	public final static String PAYMENT_ALIPAY = "alipay";

	/*
	 * 财付通
	 */
	public final static String PAYMENT_TENPAY = "tenpay";

	/*
	 * 快钱
	 */
	public final static String PAYMENT_PAYPAL = "paypal";

	/*
	 * 银联
	 */
	public final static String PAYMENT_UNIONPAY = "unionpay";

	/*
	 * 中行
	 */
	public final static String PAYMENT_BOC = "boc";

	/*
	 * 工行
	 */
	public final static String PAYMENT_ICBC = "icbc";

	/*
	 * 农行
	 */
	public final static String PAYMENT_ABC = "abc";

	/*
	 * 建行
	 */
	public final static String PAYMENT_CCB = "ccb";
	
	/**
	 * 银联跨境支付
	 */
	public static final String PAYMENT_UPOP = "upop";
	
	/**
	 * 支付宝跨境支付
	 */
	public static final String PAYMENT_ALIFOREX = "aliforex";

}

package org.lazicats.ecos.internal.payment.component;

import java.util.Map;

/**
 * 银行支付接口
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-9 下午03:50:49
 * 
 */
public interface IPayment {

	/**
	 * 支付
	 * 
	 * @param payMent
	 * @param payentMent
	 * @return
	 * @throws Exception
	 */
	public String pay(String payMent, Map<String, String> payentMent)
			throws Exception;

}

package org.lazicats.ecos.internal.payment.component;

import java.util.Map;

/**
 * ISendGoodsmend.java
 * 
 * @author MingJun_Guo
 * @创建日期：2013-10-22下午4:55:53
 * 
 */
public interface ISendGoodsment {

	/**
	 * 发货请求
	 * 
	 * @param payPlatform
	 * @param paramMap
	 * @return
	 */
	public boolean sendGoods(String payPlatform, Map<String, String> paramMap);
}

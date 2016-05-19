package org.lazicats.ecos.internal.payment.component;

import java.util.Map;

/**
 * 
 * @FileName OrderPayQueryment.java
 * @PackageName org.lazicats.ecos.internal.payment.component
 * @功能 订单支付状态查询 
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-16下午12:02:41
 *
 */
public interface OrderPayQueryment {

	/**
	 * 订单查询
	 * 
	 * @param payMent
	 * @param queryVo
	 * @return
	 */
	public String orderPayQuery(String payMent, Map<String, String> queryMap);
}

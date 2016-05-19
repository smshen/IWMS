package org.lazicats.ecos.internal.payment.component;

/**
 * @FileName PaymenComponent.java
 * @PackageName org.lazicats.ecos.internal.payment.component
 * @功能	支付回调修改订单、充值金支付状态
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-26上午11:43:21
 * 
 */
public interface PaymenComponent {

	/**
	 * 
	 * @param order_no	订单号
	 * @param payment	支付方式
	 * @param trade_no	流水号
	 * @param payTime	支付时间
	 * @param payAmount	支付金额
	 * @throws Exception
	 */
	public void payInform(String order_no, String payment, String trade_no,
			String payTime, String payAmount) throws Exception;
}

/**  
 * @Project: EC-Mall
 * @Title: OrderPaymentStateDo.java
 * @Package org.lazicats.ecos.mall.service.order.model
 * @Description: TODO
 * @author: yong
 * @date 2013-5-13 下午06:13:12
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/**
* @ClassName: OrderPaymentStateDo 
 * @Description: TODO
 * @author: yong
 * @date 2013-5-13 下午06:13:12
 *  
 */
public class OrderPaymentStateDo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String orderNo;
	private String paymentState;
	/** 
	 * @return orderNo 
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/** 
	 * @return paymentState 
	 */
	public String getPaymentState() {
		return paymentState;
	}
	/**
	 * @param paymentState the paymentState to set
	 */
	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}
}

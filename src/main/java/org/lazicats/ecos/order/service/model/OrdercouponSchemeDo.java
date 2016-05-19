/**  
 * @author: yong
 * @date 2013-8-2 上午08:29:49
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/** 
 * 订单活动发放优惠券
 * @author: yong
 * @date 2013-8-2 上午08:29:49 
 */
public class OrdercouponSchemeDo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String distributeNo;		//优惠券发放方案编号
	
	private String distributeName;		//优惠券发放方案名称
	
	private Integer quantity;			//优惠券数量
	
	private Double couponsPrice;		//优惠券发放金额(用于展示).

	private String orderNo;				//订单编号
	
	private String activityNo;			//活动编号
	
	/** 
	 * @return id 
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** 
	 * @return distributeNo 
	 */
	public String getDistributeNo() {
		return distributeNo;
	}

	/**
	 * @param distributeNo the distributeNo to set
	 */
	public void setDistributeNo(String distributeNo) {
		this.distributeNo = distributeNo;
	}

	/** 
	 * @return couponsPrice 
	 */
	public Double getCouponsPrice() {
		return couponsPrice;
	}

	/**
	 * @param couponsPrice the couponsPrice to set
	 */
	public void setCouponsPrice(Double couponsPrice) {
		this.couponsPrice = couponsPrice;
	}

	/** 
	 * @return distributeName 
	 */
	public String getDistributeName() {
		return distributeName;
	}

	/**
	 * @param distributeName the distributeName to set
	 */
	public void setDistributeName(String distributeName) {
		this.distributeName = distributeName;
	}

	/** 
	 * @return quantity 
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

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
	 * @return activityNo 
	 */
	public String getActivityNo() {
		return activityNo;
	}

	/**
	 * @param activityNo the activityNo to set
	 */
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}
	
}

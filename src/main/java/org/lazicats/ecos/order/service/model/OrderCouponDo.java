package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
/**
 * 
 * @ClassName: OrderCouponVo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-3-25 下午4:24:12
 *
 */
public class OrderCouponDo implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	/**订单优惠券数据编号*/
	private String orderCouponsNo;
	/**订单编号*/
	private String orderNo;
	/**优惠券编号*/
	private String couponNo;
	/**优惠券名称*/
	private String couponName;
	/**优惠券种类*/
	private String couponsType;
	/**面值*/
	private double faceValue;
	/**优惠券方案编号*/
	private String schemeNo;
	/**抵用金额*/
	private double couponValue;
	
	/**
	 * @return the orderCouponsNo
	 */
	public String getOrderCouponsNo() {
		return orderCouponsNo;
	}
	/**
	 * @param orderCouponsNo the orderCouponsNo to set
	 */
	public void setOrderCouponsNo(String orderCouponsNo) {
		this.orderCouponsNo = orderCouponsNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}
	public double getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(double couponValue) {
		this.couponValue = couponValue;
	}
	/** 
	 * @return couponName 
	 */
	public String getCouponName() {
		return couponName;
	}
	/**
	 * @param couponName the couponName to set
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	/** 
	 * @return couponsType 
	 */
	public String getCouponsType() {
		return couponsType;
	}
	/**
	 * @param couponsType the couponsType to set
	 */
	public void setCouponsType(String couponsType) {
		this.couponsType = couponsType;
	}
	/** 
	 * @return faceValue 
	 */
	public double getFaceValue() {
		return faceValue;
	}
	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(double faceValue) {
		this.faceValue = faceValue;
	}
	/** 
	 * @return schemeNo 
	 */
	public String getSchemeNo() {
		return schemeNo;
	}
	/**
	 * @param schemeNo the schemeNo to set
	 */
	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}
}

/*
 * 
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class OrderQueryResult.
 */
public class OrderQueryGBResult implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 订单编号 */
	private String orderNo;

	/** 创建时间 */
	private Date createTime;

	/** 买家昵称 */
	private String buyerNickName;

	/** 收货人 */
	private String cosignee;

	/** 支付方式 */
	private String paymentType;

	/** 支付状态 */
	private String paymentState;

	/** 订单总金额 */
	private double orderAmount;

	/*** 订单状态 */
	private String orderState;

	/** 是否备注 */
	private boolean isRemark;

	/** 配送方式 */
	private String deliveryType;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBuyerNickName() {
		return buyerNickName;
	}

	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}

	public String getCosignee() {
		return cosignee;
	}

	public void setCosignee(String cosignee) {
		this.cosignee = cosignee;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public boolean isRemark() {
		return isRemark;
	}

	public void setRemark(boolean isRemark) {
		this.isRemark = isRemark;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

}
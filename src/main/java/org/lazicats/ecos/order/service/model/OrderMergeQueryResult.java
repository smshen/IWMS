/*
 * 
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/**
 * The Class OrderQueryResult.
 */
public class OrderMergeQueryResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The 订单号. */
	private String orderNo;

	/** 订单渠道. */
	private String orderChanel;

	/** 买家昵称 */
	private String buyerNickName;

	/** 收货人 */
	private String consignee;

	/** 支付方式 */
	private String paymentType;

	/** 支付状态 */
	private String paymentState;

	/** 订单总金额. */
	private Double orderTotalFee;

	/** 订单状态. */
	private String orderState;

	/** 备注审核状态 */
	private String remarkCheckState;

	/** 是否备注. */
	private String hasRemark;
	
	/** 锁定说明*/
	private String lockReason;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderChanel() {
		return orderChanel;
	}
	public void setOrderChanel(String orderChanel) {
		this.orderChanel = orderChanel;
	}
	public String getBuyerNickName() {
		return buyerNickName;
	}
	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consinee) {
		this.consignee = consinee;
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
	public Double getOrderTotalFee() {
		return orderTotalFee;
	}
	public void setOrderTotalFee(Double orderTotalFee) {
		this.orderTotalFee = orderTotalFee;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getRemarkCheckState() {
		return remarkCheckState;
	}
	public void setRemarkCheckState(String remarkCheckState) {
		this.remarkCheckState = remarkCheckState;
	}
	public String getHasRemark() {
		return hasRemark;
	}
	public void setHasRemark(String hasRemark) {
		this.hasRemark = hasRemark;
	}
	public String getLockReason() {
		return lockReason;
	}
	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}
	
	
}

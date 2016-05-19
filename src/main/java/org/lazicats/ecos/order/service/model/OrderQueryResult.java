/*
 * 
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class OrderQueryResult.
 */
public class OrderQueryResult implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 订单编号 */
	private String orderNo;
    private String tradeNo; // 交易编号 (临时对象编号)

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
	/**配送状态**/
	private String deliveryState;
	/** 订单总金额 */
	private Double orderAmount;

	/*** 订单状态 */
	private String orderState;

	/** 是否备注 */
	private boolean isRemark;
	/** 配送方式 */
	private String deliveryType;
	/** 支付时间 */
	private Date paymentTime;
	/** 运费 */
	private Double deliveryFee;
	/*** 锁定状态 */
	private String lockState;
	/*** 锁定人 */
	private String lockOperator;
	/**买家留言*/
	private String buyerMsg;

	/**
	 * 已付金额
	 */
	private Double walletFee;
	/**
	 * 订单类型
	 */
	private String orderType;//1：百货类（广百）  2:电器类（金力）3:跨境类
	
	private String channelId;			// 渠道ID 1:官网 2:tmall 3:善融
	private String externalOrderNo;		// 外部订单号
	private String isSync;				// 状态是否同步
	
	
	
	public Double getWalletFee() {
		return walletFee;
	}

	public void setWalletFee(Double walletFee) {
		this.walletFee = walletFee;
	}


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

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
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

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public String getLockState() {
		return lockState;
	}

	public void setLockState(String lockState) {
		this.lockState = lockState;
	}

	public String getLockOperator() {
		return lockOperator;
	}

	public void setLockOperator(String lockOperator) {
		this.lockOperator = lockOperator;
	}

	public String getBuyerMsg() {
		return buyerMsg;
	}

	public void setBuyerMsg(String buyerMsg) {
		this.buyerMsg = buyerMsg;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getExternalOrderNo() {
		return externalOrderNo;
	}

	public void setExternalOrderNo(String externalOrderNo) {
		this.externalOrderNo = externalOrderNo;
	}

	public String getIsSync() {
		return isSync;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	

	
}

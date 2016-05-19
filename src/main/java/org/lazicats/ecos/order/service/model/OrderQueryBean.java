/*
 * 
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * 查询条件对象.
 * 
 * @author Stanley
 */
public class OrderQueryBean implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/** 开始日期. */
	private Date startDate;
	
	/** 结束日期. */
	private Date endDate;
	
	/** 订单编号. */
	private String orderNo;
	/** 订单类型. */
	private String orderType;//1 广百  2金力

	/**收货人*/
	private String consignee;

	/**  商品名. */
	private String commodityName;

	/** 订单状态. */
	private String orderState;
	
	/**支付方式*/
	private String paymentType;
	
	/** 买家昵称. */
	private String buyerNickName;
	
	/**商品编码*/
	private String commodityNo;
	
	/**支付状态*/
	private String paymentState;
	
	/** 是否备注. */
	private Boolean remark;
	
	/**收货人手机*/
	private String consigneePhone;
	/**
	 * 会员编号
	 */
	private String buyerNo;
	
	private String deliveryState;
	
	private String subPackageNo;//包裹号
	
	private Date paymentStartTime;
	
	private Date paymentEndTime;

	private String channelId;			// 渠道ID 1:官网 2:tmall 3:善融
	
	private Date deliveryStarTime; //发货时间查询
	
	private Date deliveryEndTime;	
	
	public OrderQueryBean() {
		super();
	}

	public OrderQueryBean(Date startDate, Date endDate, String orderNo,
			String consignee, String commodityName, String orderState,
			String paymentType, String buyerNickName, String paymentState,
			String commodityNo, boolean remark, String consigneePhone) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderNo = orderNo;
		this.consignee = consignee;
		this.commodityName = commodityName;
		this.orderState = orderState;
		this.paymentType = paymentType;
		this.buyerNickName = buyerNickName;
		this.paymentState = paymentState;
		this.commodityNo = commodityNo;
		this.remark = remark;
		this.consigneePhone = consigneePhone;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBuyerNickName() {
		return buyerNickName;
	}

	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public Boolean getRemark() {
		return remark;
	}

	public void setRemark(Boolean remark) {
		this.remark = remark;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getBuyerNo() {
		return buyerNo;
	}

	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getSubPackageNo() {
		return subPackageNo;
	}

	public void setSubPackageNo(String subPackageNo) {
		this.subPackageNo = subPackageNo;
	}

	public Date getPaymentStartTime() {
		return paymentStartTime;
	}

	public void setPaymentStartTime(Date paymentStartTime) {
		this.paymentStartTime = paymentStartTime;
	}

	public Date getPaymentEndTime() {
		return paymentEndTime;
	}

	public void setPaymentEndTime(Date paymentEndTime) {
		this.paymentEndTime = paymentEndTime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getDeliveryStarTime() {
		return deliveryStarTime;
	}

	public void setDeliveryStarTime(Date deliveryStarTime) {
		this.deliveryStarTime = deliveryStarTime;
	}

	public Date getDeliveryEndTime() {
		return deliveryEndTime;
	}

	public void setDeliveryEndTime(Date deliveryEndTime) {
		this.deliveryEndTime = deliveryEndTime;
	}
	
}

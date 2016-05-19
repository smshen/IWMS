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
public class OrderQueryGBBean implements Serializable {	
	
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

	
	
	public OrderQueryGBBean() {
		super();
	}

	public OrderQueryGBBean(Date startDate, Date endDate, String orderNo,
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
	

}

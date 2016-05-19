package org.lazicats.ecos.order.service.model;

// Generated 2012-11-22 15:58:19 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;

public class OrderMergeDo implements Serializable {
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	/** id */
	private String id;
	/** 渠道来源 */
	private String channelType;
	/** 订单编号 */
	private String orderNo;
	/** 收货人 */
	private String consignee;
	/** 收货地址 */
	private String address;
	/** 省 */
	private String province;
	/** 市 */
	private String city;
	/** 区 */
	private String district;
	/** 手机号 */
	private String consigneeCellPhone;
	/** 是否发票 */
	private String orderInvoice;
	/** 支付方式 */
	private String paymentType;
	/** 支付状态 */
	private String paymentState;
	/** 订单总金额 */
	private Double orderAmount;
	/** 订单状态 */
	private String orderState;
	/** 锁定说明 */
	private String lockReason;
	/**拆单标志**/
	private String splitFlag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getConsigneeCellPhone() {
		return consigneeCellPhone;
	}
	public void setConsigneeCellPhone(String consigneeCellPhone) {
		this.consigneeCellPhone = consigneeCellPhone;
	}
	public String getOrderInvoice() {
		return orderInvoice;
	}
	public void setOrderInvoice(String orderInvoice) {
		this.orderInvoice = orderInvoice;
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
	public String getLockReason() {
		return lockReason;
	}
	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}
	public String getSplitFlag() {
		return splitFlag;
	}
	public void setSplitFlag(String splitFlag) {
		this.splitFlag = splitFlag;
	}

}

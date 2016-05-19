package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/**
 * @author jun
 *
 */
public class OrderReportQueryBean implements Serializable{

	/**
	 * 订单数据报表的数据对象
	 */
	private static final long serialVersionUID = 2323529880014051211L;
	
	private String orderNo;
	private String channelId;
	private String createTime;
	private String prodNo;
	private String prodName;
	private String specification;
	private Double oriPrice;
	private Double discountFee;
	private Double couponsFee;
	private Double finalPrice;
	private Integer quantity;
	private Double totalPrice;
	private String paymentType;
	private String deliveryState;
	private String basicState;
	private String cancelReason;
	
	private String createTimeBeg;
	private String createTimeEnd;
	
	private Integer pageNo;   //当前页
	private Integer pageSize; //每页记录数
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Double getOriPrice() {
		return oriPrice;
	}
	public void setOriPrice(Double oriPrice) {
		this.oriPrice = oriPrice;
	}
	public Double getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}
	public Double getCouponsFee() {
		return couponsFee;
	}
	public void setCouponsFee(Double couponsFee) {
		this.couponsFee = couponsFee;
	}
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public String getBasicState() {
		return basicState;
	}
	public void setBasicState(String basicState) {
		this.basicState = basicState;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getCreateTimeBeg() {
		return createTimeBeg;
	}
	public void setCreateTimeBeg(String createTimeBeg) {
		this.createTimeBeg = createTimeBeg;
	}
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
}

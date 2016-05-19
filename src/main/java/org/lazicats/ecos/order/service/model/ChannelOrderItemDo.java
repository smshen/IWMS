package org.lazicats.ecos.order.service.model;


public class ChannelOrderItemDo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String itemNo;
	private String skuNo;
	private String skuName;
	private String orderNo;
	private Double skuPrice;
	private Double skuPresentPrice;
	private Integer buyNum;
	private Double discountFee;
	private Double payment;
	private String commodityNo;
	private String brand;
	private String category;
	private String picPath;
	private String giftPoint;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getSkuNo() {
		return skuNo;
	}
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getSkuPrice() {
		return skuPrice;
	}
	public void setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
	}
	public Double getSkuPresentPrice() {
		return skuPresentPrice;
	}
	public void setSkuPresentPrice(Double skuPresentPrice) {
		this.skuPresentPrice = skuPresentPrice;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Double getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getCommodityNo() {
		return commodityNo;
	}
	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getGiftPoint() {
		return giftPoint;
	}
	public void setGiftPoint(String giftPoint) {
		this.giftPoint = giftPoint;
	}
}

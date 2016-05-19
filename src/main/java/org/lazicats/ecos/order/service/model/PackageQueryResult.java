package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

public class PackageQueryResult implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	/**订单中心单号*/
	private String orderNo;
	/**包裹单号*/
	private String packageNo;
	/**渠道*/
	private String channelNo;
	/**买家昵称*/
	private String buyerNickName;
	/**收货人*/
	private String consignee;
	/**快递单号*/
	private String deliveryNo;
	/**包裹单状态*/
	private String packageState;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPackageNo() {
		return packageNo;
	}
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	public String getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
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
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getPackageState() {
		return packageState;
	}
	public void setPackageState(String packageState) {
		this.packageState = packageState;
	}
	
	
}

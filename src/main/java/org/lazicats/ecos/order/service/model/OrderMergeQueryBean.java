/*
 * 
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * 查询条件对象.
 * 
 * @author Stanley
 */
public class OrderMergeQueryBean implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	/**  商品名. */
	private String commodityName;
	
	/**  商品编号. */
	private String commodityNo;
	
	/** 订单编号. */
	private String orderNo;
	
	/** 收货人  */
	private String consignee;
	
	/**订单状态*/
	private String orderState;

	/**支付状态*/
	private String paymentState;

	/**渠道编号*/
	private String channelNo;
	
	/** 收货人手机. */
	private String consigneeCellphone;

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
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

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String chanelNo) {
		this.channelNo = chanelNo;
	}

	public String getConsigneeCellphone() {
		return consigneeCellphone;
	}

	public void setConsigneeCellphone(String consigneeCellphone) {
		this.consigneeCellphone = consigneeCellphone;
	}

	
}

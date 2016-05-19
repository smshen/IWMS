package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

public class ChannelOrderPromotionDo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;   //id（主键）
	private String orderPromotionNo;   //订单优惠编号
	private String orderNo;   //订单编号
	private String orderItemNo;   //订单编号/订单货品编号
	private String promotionName;   //优惠信息的名称
	private Double discountFee;   //优惠金额(单位：元)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderPromotionNo() {
		return orderPromotionNo;
	}
	public void setOrderPromotionNo(String orderPromotionNo) {
		this.orderPromotionNo = orderPromotionNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(String orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public Double getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}
	
	
}

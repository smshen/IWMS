package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderAftersaleBean implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String orderNo;//订单编号
	private String aftersaleNo;//售后编号
	private String prodName;//商品名
	private String prodNo;//货品编号
	private  List<OrderAftersaleCommodityDo> commodities;
	private String aftersaleType;//售后类型
	private String problemType;//问题类型
	private String problemDescribe;//问题描述
	private Date applyTime;//申请时间
	private String aftersaleState;//售后状态
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getAftersaleType() {
		return aftersaleType;
	}
	public void setAftersaleType(String aftersaleType) {
		this.aftersaleType = aftersaleType;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public String getProblemDescribe() {
		return problemDescribe;
	}
	public void setProblemDescribe(String problemDescribe) {
		this.problemDescribe = problemDescribe;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getAftersaleState() {
		return aftersaleState;
	}
	public void setAftersaleState(String aftersaleState) {
		this.aftersaleState = aftersaleState;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getAftersaleNo() {
		return aftersaleNo;
	}
	public void setAftersaleNo(String aftersaleNo) {
		this.aftersaleNo = aftersaleNo;
	}
	public List<OrderAftersaleCommodityDo> getCommodities() {
		return commodities;
	}
	public void setCommodities(List<OrderAftersaleCommodityDo> commodities) {
		this.commodities = commodities;
	}
	
	
}

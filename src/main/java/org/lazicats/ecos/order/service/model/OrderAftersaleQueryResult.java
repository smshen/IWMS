package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: OrderAftersaleQueryResult 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-17 下午3:31:27
 *
 */
public class OrderAftersaleQueryResult implements Serializable {
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String orderNo;//订单号
	private String aftersaleNo;//售后单号
	private String aftersaleType;//售后类型
	private String applicant;//申请人
	private String problemType;//问题类型
	private Date applyTime;//申请时间
	private String consignee;//收货人
	private String paymentType;//支付方式
	private String paymentState;//支付状态
	private String aftersaleState;//处理状态
	private String  orderType;// 1：百货类  2：电器类
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAftersaleNo() {
		return aftersaleNo;
	}
	public void setAftersaleNo(String aftersaleNo) {
		this.aftersaleNo = aftersaleNo;
	}
	public String getAftersaleType() {
		return aftersaleType;
	}
	public void setAftersaleType(String aftersaleType) {
		this.aftersaleType = aftersaleType;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
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
	public String getAftersaleState() {
		return aftersaleState;
	}
	public void setAftersaleState(String aftersaleState) {
		this.aftersaleState = aftersaleState;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
}


package org.lazicats.ecos.internal.jlscm.model;

import java.io.Serializable;

public class JlRefundList implements Serializable{
	
	private String orderNo;
	// 合计退款金额
	private Double refundAmount;
	// 退款原因
	private String refundReason;
	// 收款行
	private String receiveBank;
	// 收款开户支行
	private String opeingBank;
	//收款账号
	private String receiveAccount;
	// 收款户名
	private String receiveName;
	// 退款渠道
	private String refundPattern;
	
	private String refundType;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getReceiveBank() {
		return receiveBank;
	}
	public void setReceiveBank(String receiveBank) {
		this.receiveBank = receiveBank;
	}
	public String getOpeingBank() {
		return opeingBank;
	}
	public void setOpeingBank(String opeingBank) {
		this.opeingBank = opeingBank;
	}
	public String getReceiveAccount() {
		return receiveAccount;
	}
	public void setReceiveAccount(String receiveAccount) {
		this.receiveAccount = receiveAccount;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getRefundPattern() {
		return refundPattern;
	}
	public void setRefundPattern(String refundPattern) {
		this.refundPattern = refundPattern;
	}
	public String getRefundType() {
		return refundType;
	}
	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}
}


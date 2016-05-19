package org.lazicats.ecos.internal.payment.common.Allunion.model.custom;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"customICP"
		,"orderNo"
		,"payTransactionNo"
		,"payChnlID"
		,"payTime"
		,"payGoodsAmount"
		,"payTaxAmount"
		,"freight"
		,"payCurrency"
		,"payerName"
		,"payerDocumentType"
		,"payerDocumentNumber"})
@XmlRootElement(name="MessageBody")
public class MessageBody {
	private String customICP;
	private String orderNo;
	private String payTransactionNo;
	private String payChnlID;
	private String payTime;
	private String payGoodsAmount;
	private String payTaxAmount;
	private String freight;
	private String payCurrency;
	private String payerName;
	private String payerDocumentType;
	private String payerDocumentNumber;
	public String getCustomICP() {
		return customICP;
	}
	public void setCustomICP(String customICP) {
		this.customICP = customICP;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPayTransactionNo() {
		return payTransactionNo;
	}
	public void setPayTransactionNo(String payTransactionNo) {
		this.payTransactionNo = payTransactionNo;
	}
	public String getPayChnlID() {
		return payChnlID;
	}
	public void setPayChnlID(String payChnlID) {
		this.payChnlID = payChnlID;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPayGoodsAmount() {
		return payGoodsAmount;
	}
	public void setPayGoodsAmount(String payGoodsAmount) {
		this.payGoodsAmount = payGoodsAmount;
	}
	public String getPayTaxAmount() {
		return payTaxAmount;
	}
	public void setPayTaxAmount(String payTaxAmount) {
		this.payTaxAmount = payTaxAmount;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getPayCurrency() {
		return payCurrency;
	}
	public void setPayCurrency(String payCurrency) {
		this.payCurrency = payCurrency;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerDocumentType() {
		return payerDocumentType;
	}
	public void setPayerDocumentType(String payerDocumentType) {
		this.payerDocumentType = payerDocumentType;
	}
	public String getPayerDocumentNumber() {
		return payerDocumentNumber;
	}
	public void setPayerDocumentNumber(String payerDocumentNumber) {
		this.payerDocumentNumber = payerDocumentNumber;
	}

}

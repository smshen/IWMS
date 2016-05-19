package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: OrderRefundList 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-15 上午11:20:45
 *
 */
public class OrderRefundListDo implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	public String id;
	/**退款单单号*/
	public String refundNo;
	/**退款订单号*/
	public String orderNo;
	/**商品编码*/
	public String prodNo;
	/**商品售价合计*/
	public Double priceTotal;
	/**这款扣减合计*/
	public Double disccountTotal;
	/**退货运费*/
	public Double refundDeliveryFee;
	/**补邮费*/
	public Double additionalDeliveryFee;
	/**补差价*/
	public Double additionalPrice;
	/**退款金额合计*/
	public Double refundAmountTotal;
	/**收款人姓名*/
	public String receiveName;
	/**退款账户*/
	public String receiveAccount;
	/**开户名*/
	public String accountName;
	/**开户行*/
	public String accountBank;
	/**身份证号码*/
	public String idcardNo;
	/**手机号码*/
	public String cellphone;
	/**售后申请单号*/
	public String orderaftersaleNo;
	
	private Integer refundType;
	
	private String cancelNo;
	
	private Integer refundPattern;
	
	private Integer auditState;
	
	// 实际退款总额
	private Double realRefundAmountTotal;
	// 退款构成如：中国银行:128.20,快钱:12.80
	private String refundConstitute;
	
	private List<OrderAftersaleAmountDo> aftersaleAmount;
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRefundNo() {
		return refundNo;
	}
	
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getProdNo() {
		return prodNo;
	}
	
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	
	public Double getPriceTotal() {
		return priceTotal;
	}
	
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}
	
	public Double getDisccountTotal() {
		return disccountTotal;
	}
	
	public void setDisccountTotal(Double disccountTotal) {
		this.disccountTotal = disccountTotal;
	}
	
	public Double getRefundDeliveryFee() {
		return refundDeliveryFee;
	}
	
	public void setRefundDeliveryFee(Double refundDeliveryFee) {
		this.refundDeliveryFee = refundDeliveryFee;
	}
	
	public Double getAdditionalDeliveryFee() {
		return additionalDeliveryFee;
	}
	
	public void setAdditionalDeliveryFee(Double additionalDeliveryFee) {
		this.additionalDeliveryFee = additionalDeliveryFee;
	}
	
	public Double getAdditionalPrice() {
		return additionalPrice;
	}
	
	public void setAdditionalPrice(Double additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
	
	public Double getRefundAmountTotal() {
		return refundAmountTotal;
	}
	
	public void setRefundAmountTotal(Double refundAmountTotal) {
		this.refundAmountTotal = refundAmountTotal;
	}
	
	public String getReceiveName() {
		return receiveName;
	}
	
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	
	public String getReceiveAccount() {
		return receiveAccount;
	}
	
	public void setReceiveAccount(String receiveAccount) {
		this.receiveAccount = receiveAccount;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getAccountBank() {
		return accountBank;
	}
	
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	
	public String getIdcardNo() {
		return idcardNo;
	}
	
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getOrderaftersaleNo() {
		return orderaftersaleNo;
	}

	public void setOrderaftersaleNo(String orderaftersaleNo) {
		this.orderaftersaleNo = orderaftersaleNo;
	}

	public List<OrderAftersaleAmountDo> getAftersaleAmount() {
		return aftersaleAmount;
	}

	public void setAftersaleAmount(List<OrderAftersaleAmountDo> aftersaleAmount) {
		this.aftersaleAmount = aftersaleAmount;
	}

	public Integer getRefundType() {
		return refundType;
	}

	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}

	public String getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(String cancelNo) {
		this.cancelNo = cancelNo;
	}

	public Integer getRefundPattern() {
		return refundPattern;
	}

	public void setRefundPattern(Integer refundPattern) {
		this.refundPattern = refundPattern;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public Double getRealRefundAmountTotal() {
		return realRefundAmountTotal;
	}

	public void setRealRefundAmountTotal(Double realRefundAmountTotal) {
		this.realRefundAmountTotal = realRefundAmountTotal;
	}

	public String getRefundConstitute() {
		return refundConstitute;
	}

	public void setRefundConstitute(String refundConstitute) {
		this.refundConstitute = refundConstitute;
	}
	
	
}

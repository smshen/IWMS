package org.lazicats.ecos.order.service.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: OrderAftersaleDo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-12 下午8:49:39
 *
 */
public class OrderAftersaleDo implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** */
	private String id;
	/**退换货订单编号*/
	private String aftersaleNo;
	/**渠道退换货订单编号*/
	private String channelAftersaleNo;
	/**订单编号*/
	private String orderNo;
	/**售后类别*/
	private String aftersaleType;
	/**问题类型*/
	private String problemType;
	/**拍照附件*/
	private String prodPic;
	/**问题描述*/
	private String problemDescribe;
	/**运费计算(0:买家承担,1:公司承担)*/
	private String feeType;
	/**合计退款金额*/
	private Double refundAmount;
	/**1:退款倒电子账户，2:退款倒银行卡*/
	private String refundType;
	/**收款行*/
	private String receiveBank;
	/**开户行*/
	private String opeingBank;
	/**收款账号*/
	private String receiveAccount;
	/**收款户名*/
	private String receiveName;
	/**收货人*/
	private String consignee;
	/**收货人手机*/
	private String consigneePhone;
	/**固定电话*/
	private String telephone;
	/**邮箱*/
	private String email;
	/**物流公司*/
	private String logisticsCompany;
	/**收货地址*/
	private String receiveAddress;
	/**邮编*/
	private String zipCode;
	/**寄回运单号*/
	private String deliveryNo;
	/**
	 * 售后状态
	 */
	private String aftersaleState;
	/**申请人*/
	private String applicant;
	/**申请时间*/
	private Date applyTime;
	
	/**审核不通过原因*/
	private String reason;
	/**是否需要发票**/
	private String hasInvoice;
	
	/**渠道编号**/
	private String channelNo;
	
	private Integer refundPattern;
	
	private List<OrderAftersaleAmountDo> aftersaleAmount;
	
	private List<OrderAftersaleCommodityDo> aftersaleCommodities;
	
	private List<OrderAftersaleCommodityDo> aftersaleCommoditieHH;//广百荟中的换货清单对象
	
	private String  orderType;// 1：百货类  2：电器类
	
	private String afterDeliveryNo; 		// 售后寄出物流单号
	
	private String afterDeliveryCompany; 	// 售后寄出物流公司
	
	private String afterDeliveryCompanyUrl; 	// 售后寄出物流公司

	/** default constructor */
	public OrderAftersaleDo() {
	}

	/** minimal constructor */
	public OrderAftersaleDo(String id, String orderNo) {
		this.id = id;
		this.orderNo = orderNo;
	}

	/** full constructor */
	public OrderAftersaleDo(String id, String aftersaleNo, String orderNo,
			String aftersaleType, String problemType, String prodPic,
			String problemDescribe, String feeType, Double refundAmount,
			String refundType, String receiveBank, String opeingBank,
			String receiveAccount, String receiveName, String consignee,
			String consigneePhone, String telephone, String email,
			String logisticsCompany, String receiveAddress, String zipCode,
			String deliveryNo,String aftersaleState) {
		this.id = id;
		this.aftersaleNo = aftersaleNo;
		this.orderNo = orderNo;
		this.aftersaleType = aftersaleType;
		this.problemType = problemType;
		this.prodPic = prodPic;
		this.problemDescribe = problemDescribe;
		this.feeType = feeType;
		this.refundAmount = refundAmount;
		this.refundType = refundType;
		this.receiveBank = receiveBank;
		this.opeingBank = opeingBank;
		this.receiveAccount = receiveAccount;
		this.receiveName = receiveName;
		this.consignee = consignee;
		this.consigneePhone = consigneePhone;
		this.telephone = telephone;
		this.email = email;
		this.logisticsCompany = logisticsCompany;
		this.receiveAddress = receiveAddress;
		this.zipCode = zipCode;
		this.deliveryNo = deliveryNo;
		this.aftersaleState = aftersaleState;
		
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAftersaleNo() {
		return this.aftersaleNo;
	}

	public void setAftersaleNo(String aftersaleNo) {
		this.aftersaleNo = aftersaleNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAftersaleType() {
		return this.aftersaleType;
	}

	public void setAftersaleType(String aftersaleType) {
		this.aftersaleType = aftersaleType;
	}

	public String getProblemType() {
		return this.problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	public String getProdPic() {
		return this.prodPic;
	}

	public void setProdPic(String prodPic) {
		this.prodPic = prodPic;
	}

	public String getProblemDescribe() {
		return this.problemDescribe;
	}

	public void setProblemDescribe(String problemDescribe) {
		this.problemDescribe = problemDescribe;
	}

	public String getFeeType() {
		return this.feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Double getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundType() {
		return this.refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	public String getReceiveBank() {
		return this.receiveBank;
	}

	public void setReceiveBank(String receiveBank) {
		this.receiveBank = receiveBank;
	}

	public String getOpeingBank() {
		return this.opeingBank;
	}

	public void setOpeingBank(String opeingBank) {
		this.opeingBank = opeingBank;
	}

	public String getReceiveAccount() {
		return this.receiveAccount;
	}

	public void setReceiveAccount(String receiveAccount) {
		this.receiveAccount = receiveAccount;
	}

	public String getReceiveName() {
		return this.receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneePhone() {
		return this.consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogisticsCompany() {
		return this.logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getReceiveAddress() {
		return this.receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDeliveryNo() {
		return this.deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getAftersaleState() {
		return aftersaleState;
	}

	public void setAftersaleState(String aftersaleState) {
		this.aftersaleState = aftersaleState;
	}

	public List<OrderAftersaleAmountDo> getAftersaleAmount() {
		return aftersaleAmount;
	}

	public void setAftersaleAmount(List<OrderAftersaleAmountDo> aftersaleAmount) {
		this.aftersaleAmount = aftersaleAmount;
	}

	public List<OrderAftersaleCommodityDo> getAftersaleCommodities() {
		return aftersaleCommodities;
	}

	public void setAftersaleCommodities(List<OrderAftersaleCommodityDo> aftersaleCommodities) {
		this.aftersaleCommodities = aftersaleCommodities;
	}
	
	public List<OrderAftersaleCommodityDo> getAftersaleCommoditieHH() {
		return aftersaleCommoditieHH;
	}

	public void setAftersaleCommoditieHH(List<OrderAftersaleCommodityDo> aftersaleCommoditieHH) {
		this.aftersaleCommoditieHH = aftersaleCommoditieHH;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getHasInvoice() {
		return hasInvoice;
	}

	public void setHasInvoice(String hasInvoice) {
		this.hasInvoice = hasInvoice;
	}

	public String getChannelAftersaleNo() {
		return channelAftersaleNo;
	}

	public void setChannelAftersaleNo(String channelAftersaleNo) {
		this.channelAftersaleNo = channelAftersaleNo;
	}

	public Integer getRefundPattern() {
		return refundPattern;
	}

	public void setRefundPattern(Integer refundPattern) {
		this.refundPattern = refundPattern;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getAfterDeliveryNo() {
		return afterDeliveryNo;
	}

	public void setAfterDeliveryNo(String afterDeliveryNo) {
		this.afterDeliveryNo = afterDeliveryNo;
	}

	public String getAfterDeliveryCompany() {
		return afterDeliveryCompany;
	}

	public void setAfterDeliveryCompany(String afterDeliveryCompany) {
		this.afterDeliveryCompany = afterDeliveryCompany;
	}

	public String getAfterDeliveryCompanyUrl() {
		return afterDeliveryCompanyUrl;
	}

	public void setAfterDeliveryCompanyUrl(String afterDeliveryCompanyUrl) {
		this.afterDeliveryCompanyUrl = afterDeliveryCompanyUrl;
	}
}
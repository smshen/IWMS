package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 渠道分类
 * @author tanggangyi
 *
 */
public class ChannelOrderInfoDo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String orderNo; //渠道订单编号
	private Integer orderState;//订单状态
	private Date createOrderTime;//下单时间
	private Date paymentTime;//付款时间
	private String paymentSequence;//支付流水号
	private Double orderItemAmount;//订单货品总金额(单个货品金额=sku单价*购买数量)
	private Double discountFee;//优惠金额
	private Double postFee;//邮费、运费
	private Double orderPayment;//订单应付金额、实付金额(应付金额=货品总金额-优惠金额+运费)
	private String receiverName;//收货人的姓名
	private String receiverState;//收货人的所在省份
	private String receiverCity;//收货人的所在城市
	private String receiverDistrict;//收货人的所在地区
	private String receiverAddress;//收货人的详细地址
	private String receiverZip;//收货人的邮编
	private String receiverMobile;//收货人的手机号码
	private String receiverPhone;//收货人的电话号码
	private String invoiceInfo;//发票信息
	private String buyerNick;//买家昵称/买家编号
	private String buyerEmail;//买家邮件地址
	private String buyerMessage;//买家留言
	private Integer isNeedInvoice;//发票需要情况: 0 不需要，1旧版普通，2新版普通，3增值税发票
	//支付方式（0:账户支付; 1: 在线支付; 2:货到付款;3 :邮局汇款;4 :银行转账; 5:pos机; 6:万里通; 7:分期付款; 8:合同账期; 9:货到转账; 10:货到付支票;11:自提;12:公司转账）
	private Integer payType;
	//送货（日期）类型（1-只工作日送货(双休日、假日不用送);2-只双休日、假日送货(工作日不用送);3-工作日、双休日与假日均可送货;0-返回“任意时间”）
	private Integer deliveryType;
	private String channelCode;//渠道编码（gwsc:官网商场；taobao:淘宝；jd:京东；yhd：1号店）
	private Double offsetAmount ;   //抵用总金额(积分等抵现金额合计)
	private Double invoiceAmount;   //开票金额（发票金额）
	private Integer payState;//支付状态(1:待支付;2:已支付;3:部分支付;4:已退款)
	private Integer isBuyerMessage;//是否留言(1:有<是>;2:无<否>)
	private  Integer buyerMessageState;//留言审核状态(1:待审核;2:待复核;3:已审核)
	private Integer shippingType;//配送方式(1:送货上门;2:到店自提)
	private Integer shippingState;//配送状态(1:准备;2:待发货;3:部分发货;4:已发货;5:已签收;6:已拒收;7:部分退货;8:已退货;9:终止发货)
	private String orderNoMerge; //合并订单号
	
	private String lockPerson;//
	private Integer  lockState;
	private Date lockTime;
	private List<ChannelOrderItemDo> channelOrderItems; //商品
	private List<ChannelOrderPromotionInfoDo> channelOrderPromotionInfos; //优惠信息
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public Date getCreateOrderTime() {
		return createOrderTime;
	}
	public void setCreateOrderTime(Date createOrderTime) {
		this.createOrderTime = createOrderTime;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public String getPaymentSequence() {
		return paymentSequence;
	}
	public void setPaymentSequence(String paymentSequence) {
		this.paymentSequence = paymentSequence;
	}
	public Double getOrderItemAmount() {
		return orderItemAmount;
	}
	public void setOrderItemAmount(Double orderItemAmount) {
		this.orderItemAmount = orderItemAmount;
	}
	public Double getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}
	public Double getPostFee() {
		return postFee;
	}
	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}
	public Double getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(Double orderPayment) {
		this.orderPayment = orderPayment;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverState() {
		return receiverState;
	}
	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public String getReceiverDistrict() {
		return receiverDistrict;
	}
	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverZip() {
		return receiverZip;
	}
	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getInvoiceInfo() {
		return invoiceInfo;
	}
	public void setInvoiceInfo(String invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}
	public String getBuyerNick() {
		return buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerMessage() {
		return buyerMessage;
	}
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}
	public Integer getIsNeedInvoice() {
		return isNeedInvoice;
	}
	public void setIsNeedInvoice(Integer isNeedInvoice) {
		this.isNeedInvoice = isNeedInvoice;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public Double getOffsetAmount() {
		return offsetAmount;
	}
	public void setOffsetAmount(Double offsetAmount) {
		this.offsetAmount = offsetAmount;
	}
	public Double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public Integer getPayState() {
		return payState;
	}
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	public Integer getIsBuyerMessage() {
		return isBuyerMessage;
	}
	public void setIsBuyerMessage(Integer isBuyerMessage) {
		this.isBuyerMessage = isBuyerMessage;
	}
	public Integer getBuyerMessageState() {
		return buyerMessageState;
	}
	public void setBuyerMessageState(Integer buyerMessageState) {
		this.buyerMessageState = buyerMessageState;
	}
	public Integer getShippingType() {
		return shippingType;
	}
	public void setShippingType(Integer shippingType) {
		this.shippingType = shippingType;
	}
	public Integer getShippingState() {
		return shippingState;
	}
	public void setShippingState(Integer shippingState) {
		this.shippingState = shippingState;
	}
	public List<ChannelOrderItemDo> getChannelOrderItems() {
		return channelOrderItems;
	}
	public void setChannelOrderItems(List<ChannelOrderItemDo> channelOrderItems) {
		this.channelOrderItems = channelOrderItems;
	}
	public List<ChannelOrderPromotionInfoDo> getChannelOrderPromotionInfos() {
		return channelOrderPromotionInfos;
	}
	public void setChannelOrderPromotionInfos(
			List<ChannelOrderPromotionInfoDo> channelOrderPromotionInfos) {
		this.channelOrderPromotionInfos = channelOrderPromotionInfos;
	}
	public String getOrderNoMerge() {
		return orderNoMerge;
	}
	public void setOrderNoMerge(String orderNoMerge) {
		this.orderNoMerge = orderNoMerge;
	}
	public String getLockPerson() {
		return lockPerson;
	}
	public void setLockPerson(String lockPerson) {
		this.lockPerson = lockPerson;
	}
	public Integer getLockState() {
		return lockState;
	}
	public void setLockState(Integer lockState) {
		this.lockState = lockState;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	
}

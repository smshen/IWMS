package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

public class OrderAdvertiserQueryResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1767242907774710669L;

	public OrderAdvertiserQueryResult(String orderNo, String buyerNo,
			String sellerNo, Double priceTotal, Double discountTotal,
			Double deliveryFeeTotal, Double discountDeliveryFeeTotal,
			Integer usedScore, Double payByScore, Double feeTotal,
			Integer scoreTotal, String paymentType, String paymentBank,
			String paymentActivity, Double paymentBankAmount,
			String deliveryType, Date paymentTime, Date goPaymentTime,
			Double paidTotal, String basicState, String paymentState,
			String deliveryState, String rejectGoodsState,
			String returnGoodsState, String refundState, String promotions,
			Byte needInvoice, String invoiceNo, Integer prodQuantity,
			Double weightTotal, Double volumeTotal, Integer sentProdQuantity,
			String originalOrderNo, String remark, Long orderTimestamp,
			Byte deleteFlag, Date createTime, Date updateTime,
			String buyerMessage, Byte chkfirstInstock, String buyerNickName,
			String afterSaleService, String paymentSequence,
			Double disccountAmount, String lockState, String lockOperator,
			String cancelReason, Date cancelTime, String msgCheckState,
			String allowSplitOrder, Double invoiceAmount, String splitFlag,
			String pushERPFlag, String logisticsInfo, Double voucherFee,
			Double userDisFee, Double couponsFee, Double paymentPrefrFee,
			Byte supportInvoice, Byte hasDelivery, String campaignId,
			String siteId, String feedBack, int orderCount, double orderTp,
			Date cpscreateTime, String encoding, String cpsCode,
			String cpsName, int status, String resField1, String resField2,
			String resField3) {
		super();
		this.orderNo = orderNo;
		this.buyerNo = buyerNo;
		this.sellerNo = sellerNo;
		this.priceTotal = priceTotal;
		this.discountTotal = discountTotal;
		this.deliveryFeeTotal = deliveryFeeTotal;
		this.discountDeliveryFeeTotal = discountDeliveryFeeTotal;
		this.usedScore = usedScore;
		this.payByScore = payByScore;
		this.feeTotal = feeTotal;
		this.scoreTotal = scoreTotal;
		this.paymentType = paymentType;
		this.paymentBank = paymentBank;
		this.paymentActivity = paymentActivity;
		this.paymentBankAmount = paymentBankAmount;
		this.deliveryType = deliveryType;
		this.paymentTime = paymentTime;
		this.goPaymentTime = goPaymentTime;
		this.paidTotal = paidTotal;
		this.basicState = basicState;
		this.paymentState = paymentState;
		this.deliveryState = deliveryState;
		this.rejectGoodsState = rejectGoodsState;
		this.returnGoodsState = returnGoodsState;
		this.refundState = refundState;
		this.promotions = promotions;
		this.needInvoice = needInvoice;
		this.invoiceNo = invoiceNo;
		this.prodQuantity = prodQuantity;
		this.weightTotal = weightTotal;
		this.volumeTotal = volumeTotal;
		this.sentProdQuantity = sentProdQuantity;
		this.originalOrderNo = originalOrderNo;
		this.remark = remark;
		this.orderTimestamp = orderTimestamp;
		this.deleteFlag = deleteFlag;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.buyerMessage = buyerMessage;
		this.chkfirstInstock = chkfirstInstock;
		this.buyerNickName = buyerNickName;
		this.afterSaleService = afterSaleService;
		this.paymentSequence = paymentSequence;
		this.disccountAmount = disccountAmount;
		this.lockState = lockState;
		this.lockOperator = lockOperator;
		this.cancelReason = cancelReason;
		this.cancelTime = cancelTime;
		this.msgCheckState = msgCheckState;
		this.allowSplitOrder = allowSplitOrder;
		this.invoiceAmount = invoiceAmount;
		this.splitFlag = splitFlag;
		this.pushERPFlag = pushERPFlag;
		this.logisticsInfo = logisticsInfo;
		this.voucherFee = voucherFee;
		this.userDisFee = userDisFee;
		this.couponsFee = couponsFee;
		this.paymentPrefrFee = paymentPrefrFee;
		this.supportInvoice = supportInvoice;
		this.hasDelivery = hasDelivery;
		this.campaignId = campaignId;
		this.siteId = siteId;
		this.feedBack = feedBack;
		this.orderCount = orderCount;
		this.orderTp = orderTp;
		this.cpscreateTime = cpscreateTime;
		this.encoding = encoding;
		this.cpsCode = cpsCode;
		this.cpsName = cpsName;
		this.status = status;
		this.resField1 = resField1;
		this.resField2 = resField2;
		this.resField3 = resField3;
	}
	
	public OrderAdvertiserQueryResult(){};
	
	
	/** 订单编号*/
	private String orderNo;
	/** 买家编号*/
	private String buyerNo;
	/**卖家编号*/
	private String sellerNo;
	/** 总金额*/
	private Double priceTotal;
	/**优惠总金额*/
	private Double discountTotal;
	/** 配送费用总额*/
	private Double deliveryFeeTotal;
	/** 优惠配送费*/
	private Double discountDeliveryFeeTotal;
	/** 使用积分*/
	private Integer usedScore;
	/** 使用积分对应金额*/
	private Double payByScore;
	/** 订单付费总计*/
	private Double feeTotal;
	/** 用户可获积分总计*/
	private Integer scoreTotal;
	/**付款方式*/
	private String paymentType;
	/**支付银行或某些支付平台编号(银行，支付宝，财富通)*/
	private String paymentBank;
	/**支付活动*/
	private String paymentActivity;
	/**支付银行或某些支付平台金额数(银行，支付宝，财富通)*/
	private Double paymentBankAmount;
	/**递送方式*/
	private String deliveryType;
	/**支付时间*/
	private Date paymentTime;
	/**去支付时间*/
	private Date goPaymentTime;
	/** 已付金额*/
	private Double paidTotal;
	/**订单基本状态*/
	private String basicState;
	/** 订单支付状态*/
	private String paymentState;
	/**订单配送状态*/
	private String deliveryState;
	/** 货物拒收状态*/
	private String rejectGoodsState;
	/** 退货状态*/
	private String returnGoodsState;
	/** 退款状态*/
	private String refundState;
	/** 优惠活动名*/
	private String promotions;
	/** 发票抬头*/
	private Byte needInvoice;
	/** 发票编号	*/
	private String invoiceNo;
	/** 貨品數量*/
	private Integer prodQuantity;
	/** 重量*/
	private Double weightTotal;
	/**体积 单位立方米*/
	private Double volumeTotal;
	/** 已发送的货品数量*/
	private Integer sentProdQuantity;
	/** 退换货产生的新订单引用原定单*/
	private String originalOrderNo;
	/** 备注信息*/
	private String remark;
	/** 订单生成时间戳*/
	private Long orderTimestamp;
	/** 删除状态*/
	private Byte deleteFlag;
	/** 创建时间*/
	private Date createTime;
	/** 修改时间*/
	private Date updateTime;
	/** 买家留言*/
	private String buyerMessage;
	/** 先发有货的商品*/
	private Byte chkfirstInstock;
	/** 买家昵称*/
	private String buyerNickName;
	/** 售后服务*/
	private String afterSaleService;
	/** 支付流水号*/
	private String paymentSequence;
	/**支付方式所产生的优惠金额*/
	private Double disccountAmount;
	/**锁定状态*/
	private String lockState;
	/**锁定人*/
	private String lockOperator;
	/**订单取消原因**/
	private String cancelReason;
	/**取消时间*/
	private Date cancelTime;
	/**留言审核状态*/
	private String msgCheckState;
	/**是否允许拆单*/
	private String allowSplitOrder;
	/**发票金额*/
	private Double invoiceAmount;
	/**拆单标志1:已拆单，0:未拆单**/
	private String splitFlag;
	/**推送ERP标志1:已推送，0:未推送**/
	private String pushERPFlag = "0";
	
	private String logisticsInfo;
	
	/**添加属性 by xiexianghua 2013-10-05*/
	
	/** 代金券金额*/
	private Double voucherFee;          
	/** 用户折扣优惠*/
	private Double userDisFee;          
	/** 优惠券抵用金额*/
	private Double couponsFee;  	  
	/** 支付方式优惠金额*/
	private Double paymentPrefrFee;	  
	/** 是否支持发票*/
	private Byte supportInvoice;  
	/** 是否包邮*/
	private Byte hasDelivery;	  
	
	
	/**活动id */
	public String campaignId;
	/**站点id*/
	public String siteId;
	/**反馈标签 */
	public String feedBack;
	/**订单数量 */
	public int orderCount;
	/**订单总额 */
	public double orderTp;
	/**创建时间（下单时间) */
	public Date cpscreateTime;
	/**字符集 */
	public String encoding;
	/**广告商编码 */
	public String cpsCode;
	/**广告商名称 */
	public String cpsName;
	/**状态 */
	public int status;
	/**备用字段1 */
	public String resField1;
	/**备用字段2 */
	public String resField2;
	/**备用字段3 */
	public String resField3;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	public Double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public Double getDiscountTotal() {
		return discountTotal;
	}
	public void setDiscountTotal(Double discountTotal) {
		this.discountTotal = discountTotal;
	}
	public Double getDeliveryFeeTotal() {
		return deliveryFeeTotal;
	}
	public void setDeliveryFeeTotal(Double deliveryFeeTotal) {
		this.deliveryFeeTotal = deliveryFeeTotal;
	}
	public Double getDiscountDeliveryFeeTotal() {
		return discountDeliveryFeeTotal;
	}
	public void setDiscountDeliveryFeeTotal(Double discountDeliveryFeeTotal) {
		this.discountDeliveryFeeTotal = discountDeliveryFeeTotal;
	}
	public Integer getUsedScore() {
		return usedScore;
	}
	public void setUsedScore(Integer usedScore) {
		this.usedScore = usedScore;
	}
	public Double getPayByScore() {
		return payByScore;
	}
	public void setPayByScore(Double payByScore) {
		this.payByScore = payByScore;
	}
	public Double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(Double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public Integer getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(Integer scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentBank() {
		return paymentBank;
	}
	public void setPaymentBank(String paymentBank) {
		this.paymentBank = paymentBank;
	}
	public String getPaymentActivity() {
		return paymentActivity;
	}
	public void setPaymentActivity(String paymentActivity) {
		this.paymentActivity = paymentActivity;
	}
	public Double getPaymentBankAmount() {
		return paymentBankAmount;
	}
	public void setPaymentBankAmount(Double paymentBankAmount) {
		this.paymentBankAmount = paymentBankAmount;
	}//
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public Date getGoPaymentTime() {
		return goPaymentTime;
	}
	public void setGoPaymentTime(Date goPaymentTime) {
		this.goPaymentTime = goPaymentTime;
	}
	public Double getPaidTotal() {
		return paidTotal;
	}
	public void setPaidTotal(Double paidTotal) {
		this.paidTotal = paidTotal;
	}
	public String getBasicState() {
		return basicState;
	}
	public void setBasicState(String basicState) {
		this.basicState = basicState;
	}
	public String getPaymentState() {
		return paymentState;
	}
	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public String getRejectGoodsState() {
		return rejectGoodsState;
	}
	public void setRejectGoodsState(String rejectGoodsState) {
		this.rejectGoodsState = rejectGoodsState;
	}
	public String getReturnGoodsState() {
		return returnGoodsState;
	}
	public void setReturnGoodsState(String returnGoodsState) {
		this.returnGoodsState = returnGoodsState;
	}
	public String getRefundState() {
		return refundState;
	}
	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}
	public String getPromotions() {
		return promotions;
	}
	public void setPromotions(String promotions) {
		this.promotions = promotions;
	}
	public Byte getNeedInvoice() {
		return needInvoice;
	}
	public void setNeedInvoice(Byte needInvoice) {
		this.needInvoice = needInvoice;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Integer getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(Integer prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public Double getWeightTotal() {
		return weightTotal;
	}
	public void setWeightTotal(Double weightTotal) {
		this.weightTotal = weightTotal;
	}
	public Double getVolumeTotal() {
		return volumeTotal;
	}
	public void setVolumeTotal(Double volumeTotal) {
		this.volumeTotal = volumeTotal;
	}
	public Integer getSentProdQuantity() {
		return sentProdQuantity;
	}
	public void setSentProdQuantity(Integer sentProdQuantity) {
		this.sentProdQuantity = sentProdQuantity;
	}
	public String getOriginalOrderNo() {
		return originalOrderNo;
	}
	public void setOriginalOrderNo(String originalOrderNo) {
		this.originalOrderNo = originalOrderNo;
	}//
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getOrderTimestamp() {
		return orderTimestamp;
	}
	public void setOrderTimestamp(Long orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}
	public Byte getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Byte deleteFlag) {
		this.deleteFlag = deleteFlag;
	}//
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}//
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getBuyerMessage() {
		return buyerMessage;
	}
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}//
	public Byte getChkfirstInstock() {
		return chkfirstInstock;
	}
	public void setChkfirstInstock(Byte chkfirstInstock) {
		this.chkfirstInstock = chkfirstInstock;
	}//
	public String getBuyerNickName() {
		return buyerNickName;
	}
	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}
	public String getAfterSaleService() {
		return afterSaleService;
	}
	public void setAfterSaleService(String afterSaleService) {
		this.afterSaleService = afterSaleService;
	}
	public String getPaymentSequence() {
		return paymentSequence;
	}
	public void setPaymentSequence(String paymentSequence) {
		this.paymentSequence = paymentSequence;
	}
	public Double getDisccountAmount() {
		return disccountAmount;
	}
	public void setDisccountAmount(Double disccountAmount) {
		this.disccountAmount = disccountAmount;
	}
	public String getLockState() {
		return lockState;
	}
	public void setLockState(String lockState) {
		this.lockState = lockState;
	}
	public String getLockOperator() {
		return lockOperator;
	}
	public void setLockOperator(String lockOperator) {
		this.lockOperator = lockOperator;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getMsgCheckState() {
		return msgCheckState;
	}
	public void setMsgCheckState(String msgCheckState) {
		this.msgCheckState = msgCheckState;
	}
	public String getAllowSplitOrder() {
		return allowSplitOrder;
	}
	public void setAllowSplitOrder(String allowSplitOrder) {
		this.allowSplitOrder = allowSplitOrder;
	}
	public Double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getSplitFlag() {
		return splitFlag;
	}
	public void setSplitFlag(String splitFlag) {
		this.splitFlag = splitFlag;
	}//
	public String getPushERPFlag() {
		return pushERPFlag;
	}
	public void setPushERPFlag(String pushERPFlag) {
		this.pushERPFlag = pushERPFlag;
	}//
	public String getLogisticsInfo() {
		return logisticsInfo;
	}
	public void setLogisticsInfo(String logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}//
	public Double getVoucherFee() {
		return voucherFee;
	}
	public void setVoucherFee(Double voucherFee) {
		this.voucherFee = voucherFee;
	}//
	public Double getUserDisFee() {
		return userDisFee;
	}
	public void setUserDisFee(Double userDisFee) {
		this.userDisFee = userDisFee;
	}//
	public Double getCouponsFee() {
		return couponsFee;
	}
	public void setCouponsFee(Double couponsFee) {
		this.couponsFee = couponsFee;
	}//jj
	public Double getPaymentPrefrFee() {
		return paymentPrefrFee;
	}
	public void setPaymentPrefrFee(Double paymentPrefrFee) {
		this.paymentPrefrFee = paymentPrefrFee;
	}
	public Byte getSupportInvoice() {
		return supportInvoice;
	}
	public void setSupportInvoice(Byte supportInvoice) {
		this.supportInvoice = supportInvoice;
	}
	public Byte getHasDelivery() {
		return hasDelivery;
	}
	public void setHasDelivery(Byte hasDelivery) {
		this.hasDelivery = hasDelivery;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public double getOrderTp() {
		return orderTp;
	}
	public void setOrderTp(double orderTp) {
		this.orderTp = orderTp;
	}
	public Date getCpscreateTime() {
		return cpscreateTime;
	}
	public void setCpscreateTime(Date cpscreateTime) {
		this.cpscreateTime = cpscreateTime;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getCpsCode() {
		return cpsCode;
	}
	public void setCpsCode(String cpsCode) {
		this.cpsCode = cpsCode;
	}
	public String getCpsName() {
		return cpsName;
	}
	public void setCpsName(String cpsName) {
		this.cpsName = cpsName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResField1() {
		return resField1;
	}
	public void setResField1(String resField1) {
		this.resField1 = resField1;
	}
	public String getResField2() {
		return resField2;
	}
	public void setResField2(String resField2) {
		this.resField2 = resField2;
	}
	public String getResField3() {
		return resField3;
	}
	public void setResField3(String resField3) {
		this.resField3 = resField3;
	}
	
	
}

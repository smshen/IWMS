package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ClassName: OrderDo 
 * @author: Stanley
 * @date 2013-7-18 下午2:07:47
 * @version
 */
public class OrderDo  implements Serializable{
	/**
	 * id
	 */
	private String id;
	/**
	 * 优惠配送费
	 */
	private Double discountDeliveryFeeTotal;
	/**
	 * 优惠活动名
	 */
	private String promotions;
	/**
	 * 发票编号	
	 */
	private String invoiceNo;
	/**
	 * 已发送的货品数量
	 */
	private Integer sentProdQuantity;
	/**
	 * 退换货产生的新订单引用原定单
	 */
	private String originalOrderNo;
	/**
	 * 订单生成时间戳
	 */
	private Long orderTimestamp;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNo;                  //订单编号
	private String tradeNo;	                 //交易编号 (临时对象编号)
	private String buyerNo;                  //买家编号
	private String buyerNickName;			 //买家昵称
	private String sellerNo;                 //卖家编号
	private String sellerName;               //卖家名称(需要卖家名称做为前台展示)
	
	private Double priceTotal;               //商品总价格
	private Double discountTotal;            //优惠总计(活动优惠金额)
	
	private Double deliveryFeeTotal;         //运费
//	private Double discountDeliveryFeeTotal; //运费拆扣总计
	/**去支付时间*/
	private Date goPaymentTime;
	private Integer usedScore;               //使用积分
	private Double payByScore;               //使用积分对应的金额
	
	private Double couponsFee;  			 //优惠券抵用金额
	private Double paymentPrefrFee;			 //支付方式优惠金额
	
	private Double feeTotal;                 //订单付费总计
	private Integer scoreTotal;              //用户可获积分总计
	
	/**组合包优惠券分摊价格*/
	private List<PromotionGroupSharePrice> groupCouponsPrices ;
	/**条目优惠券分摊价格*/
	private List<PromotionItemSharePrice> imteCouponsPrices;
	
	/**已付金额*/
	private Double paidTotal;
	/**付款方式*/
	private String paymentType;
	/**递送方式*/
	private String deliveryType;
	
	private Byte needInvoice;          //是否需要发票
	private boolean supportInvoice;    //是否支持发票
	private boolean hasDelivery;	   //是否包邮
	private Integer prodQuantity;      //货品数量
	private double weightTotal;	       //重量
	private double volumeTotal;		   //体积 单位立方米
	private boolean chkfirstInstock;   //先发有货的商品
	private String buyerMessage;       //买家留言
	private double disccountAmount;    
	/**
	 * 售后服务
	 */
	private String afterSaleService;
	/**订单支付状态*/
	private String paymentState;
	/**订单配送状态*/
	private String deliveryState;
	/**货物拒收状态*/
	private String rejectGoodsState;
	/**退货状态*/
	private String returnGoodsState;
	/**退款状态*/
	private String refundState;
	
	/**删除状态*/
	private Byte deleteFlag;
	
	/**支付流水号*/
	private String paymentSequence;
	
	/**添加订单状态属性，by xiexianghua  2013-03-28*/
	private String basicState;
	
	/**添加订单生成时间属性，by xiexianghua  2013-04-01*/
	
	/**支付银行或某些支付平台编号(银行，支付宝，财富通)**/
	private String paymentBank;
	/**支付活动*/
	private String paymentActivity;
	/**支付银行或某些支付平台金额数(银行，支付宝，财富通)*/
	private Double paymentBankAmount;
	
	private Date createTime;
	private Date paymentTime;
	private OrderInvoiceDo orderInvoice;    //发票
	private OrderAddressDo orderAddress;    //订单地址
	private List<OrderItemDo> orderItems;   //购物清单
	private List<OrderGroupItemDo> orderGroupItems;//购物组合清单
	private List<OrderActivityGroupDo> orderActivitys;//活动
	private List<OrderCouponDo> orderCoupons;  //优惠券
	private String lockState;//锁定状态 0正常，1锁定
	private String lockOperator;//锁定人
	private String cancelReason;//取消原因
	private Date cancelTime;//取消时间
	private String msgCheckState;//留言审核状态
	/**是否允许拆单*/
	private String allowSplitOrder;
	/**
	 * 备注信息
	 */
	private String remark;
	private Double invoiceAmount;
	private String splitFlag;
	private List<OrderLogsDo> orderLogsDo;
	private String pushERPFlag = "0";
	
	private String logisticsInfo;
	
	/**添加属性 by xiexianghua 2013-10-05*/
	private Double voucherFee;          //代金额金额
	private Double userDisFee;          //用户折扣优惠
	private Double walletFee;//电子钱包支付部分金额
	private String orderType;//订单类型  1：百货类订单   2：电器类订单 3：跨境订单
	
	private String channelId;			// 渠道ID 1:官网 2:tmall 3:善融
	private String externalOrderNo;		// 外部订单号
	private String isSync;				// 状态是否同步
	
	private String payOrderNo;			// 支付时传给银行的订单号参数
	
	private String relaPayOrderNo;		// 关联支付（与本订单一起支付的订单）订单号
	
	private OrderImportedDo orderImported;//跨境订单扩展属性
	
	private List<OrderItemSplitInfoDo> orderItemSplitInfoDo;//跨境订单明细
	
	private Long memberId;
	
	public List<OrderItemSplitInfoDo> getOrderItemSplitInfoDo() {
		return orderItemSplitInfoDo;
	}

	public void setOrderItemSplitInfoDo(
			List<OrderItemSplitInfoDo> orderItemSplitInfoDo) {
		this.orderItemSplitInfoDo = orderItemSplitInfoDo;
	}

	public Double getWalletFee() {
		return walletFee;
	}

	public void setWalletFee(Double walletFee) {
		this.walletFee = walletFee;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBasicState() {
		return basicState;
	}

	public void setBasicState(String basicState) {
		this.basicState = basicState;
	}

	/**
	 * @Title: getOrderNo 
	 * @return  
	 * @author: Stanley
	 * @date: 2013-7-18下午2:04:11
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * 
	 * @Title: setOrderNo 
	 * @Description: TODO
	 * @param orderNo  
	 * @author: Stanley
	 * @date: 2013-7-18下午2:02:19
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/** 
	 * @return buyerNo 
	 */
	
	public String getBuyerNo() {
		return buyerNo;
	}

	/**
	 * @param buyerNo the buyerNo to set
	 */
	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}

	/** 
	 * @return sellerNo 
	 */
	
	public String getSellerNo() {
		return sellerNo;
	}

	/**
	 * @param sellerNo the sellerNo to set
	 */
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	/** 
	 * @return priceTotal 
	 */
	
	public Double getPriceTotal() {
		return priceTotal;
	}

	/**
	 * @param priceTotal the priceTotal to set
	 */
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	/** 
	 * @return discountTotal 
	 */
	
	public Double getDiscountTotal() {
		return discountTotal;
	}

	/**
	 * @param discountTotal the discountTotal to set
	 */
	public void setDiscountTotal(Double discountTotal) {
		this.discountTotal = discountTotal;
	}

	/** 
	 * @return deliveryFeeTotal 
	 */
	
	public Double getDeliveryFeeTotal() {
		return deliveryFeeTotal;
	}

	/**
	 * @param deliveryFeeTotal the deliveryFeeTotal to set
	 */
	public void setDeliveryFeeTotal(Double deliveryFeeTotal) {
		this.deliveryFeeTotal = deliveryFeeTotal;
	}

//	/** 
//	 * @return discountDeliveryFeeTotal 
//	 */
//	
//	public Double getDiscountDeliveryFeeTotal() {
//		return discountDeliveryFeeTotal;
//	}
//
//	/**
//	 * @param discountDeliveryFeeTotal the discountDeliveryFeeTotal to set
//	 */
//	public void setDiscountDeliveryFeeTotal(Double discountDeliveryFeeTotal) {
//		this.discountDeliveryFeeTotal = discountDeliveryFeeTotal;
//	}

	/** 
	 * @return usedScore 
	 */
	
	public Integer getUsedScore() {
		return usedScore;
	}

	/**
	 * @param usedScore the usedScore to set
	 */
	public void setUsedScore(Integer usedScore) {
		this.usedScore = usedScore;
	}

	/** 
	 * @return payByScore 
	 */
	
	public Double getPayByScore() {
		return payByScore;
	}

	/**
	 * @param payByScore the payByScore to set
	 */
	public void setPayByScore(Double payByScore) {
		this.payByScore = payByScore;
	}

	/** 
	 * @return feeTotal 
	 */
	
	public Double getFeeTotal() {
		return feeTotal;
	}

	/**
	 * @param feeTotal the feeTotal to set
	 */
	public void setFeeTotal(Double feeTotal) {
		this.feeTotal = feeTotal;
	}

	/** 
	 * @return scoreTotal 
	 */
	
	public Integer getScoreTotal() {
		return scoreTotal;
	}

	/**
	 * @param scoreTotal the scoreTotal to set
	 */
	public void setScoreTotal(Integer scoreTotal) {
		this.scoreTotal = scoreTotal;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItemDo> orderItems) {
		this.orderItems = orderItems;
	}

	/** 
	 * @return orderGroupItems 
	 */
	
	public List<OrderGroupItemDo> getOrderGroupItems() {
		return orderGroupItems;
	}

	/**
	 * @param orderGroupItems the orderGroupItems to set
	 */
	public void setOrderGroupItems(List<OrderGroupItemDo> orderGroupItems) {
		this.orderGroupItems = orderGroupItems;
	}

	/** 
	 * @return shopingActivitys 
	 */
	
	public List<OrderActivityGroupDo> getOrderActivitys() {
		return orderActivitys;
	}

	/**
	 * @param shopingActivitys the shopingActivitys to set
	 */
	public void setOrderActivitys(List<OrderActivityGroupDo> orderActivitys) {
		this.orderActivitys = orderActivitys;
	}

	/** 
	 * @return orderCoupons 
	 */
	
	public List<OrderCouponDo> getOrderCoupons() {
		return orderCoupons;
	}

	/**
	 * @param orderCoupons the orderCoupons to set
	 */
	public void setOrderCoupons(List<OrderCouponDo> orderCoupons) {
		this.orderCoupons = orderCoupons;
	}


	/** 
	 * @return tradeNo 
	 */
	public String getTradeNo() {
		return tradeNo;
	}

	/**
	 * @param tradeNo the tradeNo to set
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	/** 
	 * @return needInvoice 
	 */
	public Byte getNeedInvoice() {
		return needInvoice;
	}

	/**
	 * @param needInvoice the needInvoice to set
	 */
	public void setNeedInvoice(Byte needInvoice) {
		this.needInvoice = needInvoice;
	}

	/** 
	 * @return prodQuantity 
	 */
	public Integer getProdQuantity() {
		return prodQuantity;
	}

	/**
	 * @param prodQuantity the prodQuantity to set
	 */
	public void setProdQuantity(Integer prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	/** 
	 * @return chkfirstInstock 
	 */
	public boolean isChkfirstInstock() {
		return chkfirstInstock;
	}

	/**
	 * @param chkfirstInstock the chkfirstInstock to set
	 */
	public void setChkfirstInstock(boolean chkfirstInstock) {
		this.chkfirstInstock = chkfirstInstock;
	}

	/** 
	 * @return buyerMessage 
	 */
	public String getBuyerMessage() {
		return buyerMessage;
	}

	/**
	 * @param buyerMessage the buyerMessage to set
	 */
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	/** 
	 * @return orderInvoice 
	 */
	public OrderInvoiceDo getOrderInvoice() {
		return orderInvoice;
	}

	/**
	 * @param orderInvoice the orderInvoice to set
	 */
	public void setOrderInvoice(OrderInvoiceDo orderInvoice) {
		this.orderInvoice = orderInvoice;
	}

	/** 
	 * @return orderAddress 
	 */
	public OrderAddressDo getOrderAddress() {
		return orderAddress;
	}

	/**
	 * @param orderAddress the orderAddress to set
	 */
	public void setOrderAddress(OrderAddressDo orderAddress) {
		this.orderAddress = orderAddress;
	}

	/** 
	 * @return orderItems 
	 */
	public List<OrderItemDo> getOrderItems() {
		return orderItems;
	}

	/** 
	 * @return sellerName 
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * @param sellerName the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	/** 
	 * @return supportInvoice 
	 */
	public boolean isSupportInvoice() {
		return supportInvoice;
	}

	/**
	 * @param supportInvoice the supportInvoice to set
	 */
	public void setSupportInvoice(boolean supportInvoice) {
		this.supportInvoice = supportInvoice;
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

	public Byte getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Byte deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getPaymentSequence() {
		return paymentSequence;
	}

	public void setPaymentSequence(String paymentSequence) {
		this.paymentSequence = paymentSequence;
	}

	public String getBuyerNickName() {
		return buyerNickName;
	}

	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}

	public double getWeightTotal() {
		return weightTotal;
	}

	public void setWeightTotal(double weightTotal) {
		this.weightTotal = weightTotal;
	}

	public double getDisccountAmount() {
		return disccountAmount;
	}

	public void setDisccountAmount(double disccountAmount) {
		this.disccountAmount = disccountAmount;
	}

	public String getAfterSaleService() {
		return afterSaleService;
	}

	public void setAfterSaleService(String afterSaleService) {
		this.afterSaleService = afterSaleService;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public double getVolumeTotal() {
		return volumeTotal;
	}

	public void setVolumeTotal(double volumeTotal) {
		this.volumeTotal = volumeTotal;
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

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Double getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(Double paidTotal) {
		this.paidTotal = paidTotal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** 
	 * @return couponsFee 
	 */
	public Double getCouponsFee() {
		return couponsFee;
	}

	/**
	 * @param couponsFee the couponsFee to set
	 */
	public void setCouponsFee(Double couponsFee) {
		this.couponsFee = couponsFee;
	}

	/** 
	 * @return paymentPrefrFee 
	 */
	public Double getPaymentPrefrFee() {
		return paymentPrefrFee;
	}

	/**
	 * @param paymentPrefrFee the paymentPrefrFee to set
	 */
	public void setPaymentPrefrFee(Double paymentPrefrFee) {
		this.paymentPrefrFee = paymentPrefrFee;
	}

	/** 
	 * @return groupCouponsPrices 
	 */
	public List<PromotionGroupSharePrice> getGroupCouponsPrices() {
		return groupCouponsPrices;
	}

	/**
	 * @param groupCouponsPrices the groupCouponsPrices to set
	 */
	public void setGroupCouponsPrices(
			List<PromotionGroupSharePrice> groupCouponsPrices) {
		this.groupCouponsPrices = groupCouponsPrices;
	}

	/** 
	 * @return imteCouponsPrices 
	 */
	public List<PromotionItemSharePrice> getImteCouponsPrices() {
		return imteCouponsPrices;
	}

	/**
	 * @param imteCouponsPrices the imteCouponsPrices to set
	 */
	public void setImteCouponsPrices(List<PromotionItemSharePrice> imteCouponsPrices) {
		this.imteCouponsPrices = imteCouponsPrices;
	}
	public String getPaymentBank() {
		return paymentBank;
	}

	public void setPaymentBank(String paymentBank) {
		this.paymentBank = paymentBank;
	}

	public String getSplitFlag() {
		return splitFlag;
	}

	public void setSplitFlag(String splitFlag) {
		this.splitFlag = splitFlag;
	}

	public List<OrderLogsDo> getOrderLogsDo() {
		return orderLogsDo;
	}

	public void setOrderLogsDo(List<OrderLogsDo> orderLogsDo) {
		this.orderLogsDo = orderLogsDo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getDiscountDeliveryFeeTotal() {
		return discountDeliveryFeeTotal;
	}

	public void setDiscountDeliveryFeeTotal(Double discountDeliveryFeeTotal) {
		this.discountDeliveryFeeTotal = discountDeliveryFeeTotal;
	}

	public String getPromotions() {
		return promotions;
	}

	public void setPromotions(String promotions) {
		this.promotions = promotions;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	}

	public Long getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Long orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/** 
	 * @return paymentActivity 
	 */
	public String getPaymentActivity() {
		return paymentActivity;
	}

	/**
	 * @param paymentActivity the paymentActivity to set
	 */
	public void setPaymentActivity(String paymentActivity) {
		this.paymentActivity = paymentActivity;
	}

	/** 
	 * @return paymentBankAmount 
	 */
	public Double getPaymentBankAmount() {
		return paymentBankAmount;
	}

	/**
	 * @param paymentBankAmount the paymentBankAmount to set
	 */
	public void setPaymentBankAmount(Double paymentBankAmount) {
		this.paymentBankAmount = paymentBankAmount;
	}

	public String getPushERPFlag() {
		return pushERPFlag;
	}

	public void setPushERPFlag(String pushERPFlag) {
		this.pushERPFlag = pushERPFlag;
	}

	public String getLogisticsInfo() {
		return logisticsInfo;
	}

	public void setLogisticsInfo(String logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}

	public Double getVoucherFee() {
		return voucherFee;
	}

	public void setVoucherFee(Double voucherFee) {
		this.voucherFee = voucherFee;
	}

	public Double getUserDisFee() {
		return userDisFee;
	}

	public void setUserDisFee(Double userDisFee) {
		this.userDisFee = userDisFee;
	}
	
	
	/** 
	 * @return hasDelivery 
	 */
	public boolean isHasDelivery() {
		return hasDelivery;
	}
	
	/** 
	 * @return hasDelivery 
	 */
	public boolean getHasDelivery() {
		return hasDelivery;
	}

	/**
	 * @param hasDelivery the hasDelivery to set
	 */
	public void setHasDelivery(boolean hasDelivery) {
		this.hasDelivery = hasDelivery;
	}

	/** 
	 * @return goPaymentTime 
	 */
	public Date getGoPaymentTime() {
		return goPaymentTime;
	}

	/**
	 * @param goPaymentTime the goPaymentTime to set
	 */
	public void setGoPaymentTime(Date goPaymentTime) {
		this.goPaymentTime = goPaymentTime;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getExternalOrderNo() {
		return externalOrderNo;
	}

	public void setExternalOrderNo(String externalOrderNo) {
		this.externalOrderNo = externalOrderNo;
	}

	public String getIsSync() {
		return isSync;
	}

	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}

	public String getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getRelaPayOrderNo() {
		return relaPayOrderNo;
	}

	public void setRelaPayOrderNo(String relaPayOrderNo) {
		this.relaPayOrderNo = relaPayOrderNo;
	}

	public void setOrderImported(OrderImportedDo orderImported) {
		this.orderImported = orderImported;
	}

	public OrderImportedDo getOrderImported() {
		return orderImported;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	
}
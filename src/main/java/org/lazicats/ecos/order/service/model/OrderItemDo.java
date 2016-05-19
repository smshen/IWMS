package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

public class OrderItemDo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String itemNo;        //条目编号(保存时使用)
	private String orderNo;		  //订单编号
	private String prodNo;        //商品编号
	private Integer quantity;	  //数量
	private Double weight;	      //重量
	private Double volume;		  //体积
	private String itemState;     //是否缺货
	private String brand;         //品牌
	private String category;      //分类
	
	private String prodName;        //商品的名称+SKU规格（比如 XXX商品 红色 XL）
	private Double oriPrice;        //原价
	private Double price;           //促销后价(活动价)
	private Double finalPrice;      //最终价(原价 －活动优惠价－优惠券优惠价－积分优惠价)
	private Double discountFee;	    //总优惠金额
	
	private Integer usedScore;      //使用积分
	private Double payByScore;      //使用积分对应的金额
	private Double couponsFee;		//优惠券金额
	private Double userDisFee;      //用户折扣优惠
	
	private Double saleTotalFee;	//销售总价(促销价 × 商品的数量 )
	private Double disCountTotalFee;//优惠总金额(商品单个的优惠金额×商品的数量)
	
	private Double cashBack;        //返现
	private Integer	integral;		//积分(赠送积分)
	private String groupNo;         //组合商品编号
	private Integer itemType;      //0  赠品,1 条目 ,2 组合商品条目,3 换购 , 4组合包活动商品
	
	private String stockinfo;		//仓库信息,多仓库用逗号隔开
	private String prodInfo;        //产品信息 ,规格信息
	private String prodPic;		    //产品图片 
	private String commodityNo;     //商品编号
	private String buyerNo;         //买家编号
	private Integer returnQuantity;
	
	private Double showPrice;  //显示价格
	private Double showSubtractPre; //显示用的:总优惠要减去的值(如在换购情况下。优惠分摊到商品,但显示不能分摊，所以要减回去原优惠)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getItemState() {
		return itemState;
	}

	public void setItemState(String itemState) {
		this.itemState = itemState;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getOriPrice() {
		return oriPrice;
	}

	public void setOriPrice(Double oriPrice) {
		this.oriPrice = oriPrice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCashBack() {
		return cashBack;
	}

	public void setCashBack(Double cashBack) {
		this.cashBack = cashBack;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Double getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getStockinfo() {
		return stockinfo;
	}

	public void setStockinfo(String stockinfo) {
		this.stockinfo = stockinfo;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public String getProdPic() {
		return prodPic;
	}

	public void setProdPic(String prodPic) {
		this.prodPic = prodPic;
	}

	public String getBuyerNo() {
		return buyerNo;
	}

	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

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
	 * @return saleTotalFee 
	 */
	public Double getSaleTotalFee() {
		return saleTotalFee;
	}

	/**
	 * @param saleTotalFee the saleTotalFee to set
	 */
	public void setSaleTotalFee(Double saleTotalFee) {
		this.saleTotalFee = saleTotalFee;
	}

	/** 
	 * @return disCountTotalFee 
	 */
	public Double getDisCountTotalFee() {
		return disCountTotalFee;
	}

	/**
	 * @param disCountTotalFee the disCountTotalFee to set
	 */
	public void setDisCountTotalFee(Double disCountTotalFee) {
		this.disCountTotalFee = disCountTotalFee;
	}

	public Double getShowPrice() {
		return showPrice;
	}
	public void setShowPrice(Double showPrice) {
		this.showPrice = showPrice;
	}

	/** 
	 * @return userDisFee 
	 */
	public Double getUserDisFee() {
		return userDisFee;
	}

	/**
	 * @param userDisFee the userDisFee to set
	 */
	public void setUserDisFee(Double userDisFee) {
		this.userDisFee = userDisFee;
	}
	
	/** 
	 * @return returnQuantity 
	 */
	public Integer getReturnQuantity() {
		return returnQuantity;
	}

	/**
	 * @param returnQuantity the returnQuantity to set
	 */
	public void setReturnQuantity(Integer returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	/** 
	 * @return showSubtractPre 
	 */
	public Double getShowSubtractPre() {
		return showSubtractPre;
	}

	/**
	 * @param showSubtractPre the showSubtractPre to set
	 */
	public void setShowSubtractPre(Double showSubtractPre) {
		this.showSubtractPre = showSubtractPre;
	}
	
	
}

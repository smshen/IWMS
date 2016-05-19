/**  
 * @Project: EC-Mall
 * @Title: OrderGroupItemDo.java
 * @Package org.lazicats.ecos.mall.service.order.model
 * @Description: TODO
 * @author: yong
 * @date 2013-1-21 下午01:25:33
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.order.service.model;
import java.io.Serializable;
import java.util.List;

/** 
 * @ClassName: OrderGroupItemDo 
 * @Description: TODO
 * @author: yong
 * @date 2013-1-21 下午01:25:33
 *  
 */

public class OrderGroupItemDo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupNo;       //商品组条目编号
	private String orderNo;       //订单编号
	private String groupProdNo;   //组合商品编号(组合包时动态生成的编号)
	private Integer type;		  //组类型(0组合商品,1组合包活动)
	private int quantity;         //数量
	private double weight;		  //重量
	private double volume;		  //体积 单位立方米
	private String stockGroupNo;  //仓库编号
	
	private String groupName;       //组条目名
	private Double oriPrice;        //原价
	private Double price;           //价格(活动价)
	private Double finalPrice;      //最终价(原价 －活动优惠价－优惠券优惠价－积分优惠价)
	private Double discountFee;	    //总优惠金额

	private Integer usedScore;      //使用积分
	private Double payByScore;      //使用积分对应的金额
	private Double couponsFee;		//优惠券金额
	private Double userDisFee;      //用户折扣优惠
	
	private Double saleTotalFee;	//销售总价(促销价 × 商品的数量 )
	private Double disCountTotalFee;//优惠总金额(商品单个的优惠金额×商品的数量)
	
	private int ProductQuantity;	//组合包中货品数理(单个组合包)
	private double cashBack;        //返现
	private Integer integral;		//积分(赠送积分)
	private String stockState;		//库存状况
	private String stockAddress;    //仓库地址
	
	private List<OrderItemDo> groupItems;//子条目
	
	private Double showPrice;  //显示价格

	public Double getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(Double showPrice) {
		this.showPrice = showPrice;
	}

	/** 
	 * @return groupNo 
	 */
	
	public String getGroupNo() {
		return groupNo;
	}

	/**
	 * @param groupNo the groupNo to set
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	/** 
	 * @return orderNo 
	 */
	
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/** 
	 * @return groupProdNo 
	 */
	
	public String getGroupProdNo() {
		return groupProdNo;
	}

	/**
	 * @param groupProdNo the groupProdNo to set
	 */
	public void setGroupProdNo(String groupProdNo) {
		this.groupProdNo = groupProdNo;
	}
	/** 
	 * @return type 
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/** 
	 * @return quantity 
	 */
	
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/** 
	 * @return stockGroupNo 
	 */
	
	public String getStockGroupNo() {
		return stockGroupNo;
	}

	/**
	 * @param stockGroupNo the stockGroupNo to set
	 */
	public void setStockGroupNo(String stockGroupNo) {
		this.stockGroupNo = stockGroupNo;
	}

	/** 
	 * @return groupName 
	 */
	
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Double getOriPrice() {
		return oriPrice;
	}

	public void setOriPrice(Double oriPrice) {
		this.oriPrice = oriPrice;
	}

	/** 
	 * @return price 
	 */
	
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/** 
	 * @return cashBack 
	 */
	public double getCashBack() {
		return cashBack;
	}

	/**
	 * @param cashBack the cashBack to set
	 */
	public void setCashBack(double cashBack) {
		this.cashBack = cashBack;
	}

	/** 
	 * @return integral 
	 */
	
	public int getIntegral() {
		return integral;
	}

	/**
	 * @param integral the integral to set
	 */
	public void setIntegral(int integral) {
		this.integral = integral;
	}

	/** 
	 * @return stockAddress 
	 */
	
	public String getStockAddress() {
		return stockAddress;
	}

	/**
	 * @param stockAddress the stockAddress to set
	 */
	public void setStockAddress(String stockAddress) {
		this.stockAddress = stockAddress;
	}

	/** 
	 * @return groupItems 
	 */
	
	public List<OrderItemDo> getGroupItems() {
		return groupItems;
	}

	/**
	 * @param groupItems the groupItems to set
	 */
	public void setGroupItems(List<OrderItemDo> groupItems) {
		this.groupItems = groupItems;
	}

	/** 
	 * @return stockState 
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * @param stockState the stockState to set
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	public double getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
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
	 * @return finalPrice 
	 */
	public Double getFinalPrice() {
		return finalPrice;
	}

	/**
	 * @param finalPrice the finalPrice to set
	 */
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
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

	/**
	 * @param discountFee the discountFee to set
	 */
	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}

	/**
	 * @param integral the integral to set
	 */
	public void setIntegral(Integer integral) {
		this.integral = integral;
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
	 * @return productQuantity 
	 */
	public int getProductQuantity() {
		return ProductQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
}

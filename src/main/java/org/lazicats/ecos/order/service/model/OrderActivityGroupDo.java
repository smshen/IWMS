/**  
 * @Project: EC-Mall
 * @Title: OrderActivityGroupDo.java
 * @Package org.lazicats.ecos.mall.service.order.model
 * @Description: TODO
 * @author: yong
 * @date 2013-1-18 上午10:27:40
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.List;

/** 
 * @ClassName: OrderActivityGroupDo 
 * @Description:订单活动组
 * @author: yong
 * @date 2013-1-18 上午10:27:40
 *  
 */
public class OrderActivityGroupDo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**活动组编号*/
	private String orderActGroupNo;
	/**订单编号(商家订单时填写)*/
	private String orderNo;
	/**活动编号*/
	private String activityNo;
	/**活动规则*/
	private String ruleNo;
	/**活动名称*/
	private String activityName;
	/**活动优惠金额合计*/
	private double discountTotal;
	/**活动积分*/
	private Integer scoreTotal;
	/**活动类型*/
	private String activityType;
	/** 活动主办方编号(商城，商家编号)*/
	private String sponsor;
	/**是否可使用优惠券*/
	private boolean hasUseCoupon;
	
	/**活动版本号*/
	private String activityVersion;
	/**活动赠品*/
	private List<OrderItemDo> orderGift;
	private List<OrdercouponSchemeDo> coupones;//赠券.
	
	private List<String> itemsNos;		//活动对应的购物车清单编号(本活动有哪些商品参加)
	private List<String> prodGroupNos;	//活动对应的购物车组合清单编号(本活动有哪些商品组参加)	
	private List<Double> itemsPres;//活动对应的购物车清单优惠分摊(本活动有哪些商品参加)
	private List<Double> groupProdPres;//组合商品活动分摊
	/** 
	 * @return orderActGroupNo 
	 */
	
	public String getOrderActGroupNo() {
		return orderActGroupNo;
	}

	/**
	 * @param orderActGroupNo the orderActGroupNo to set
	 */
	public void setOrderActGroupNo(String orderActGroupNo) {
		this.orderActGroupNo = orderActGroupNo;
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
	 * @return activityNo 
	 */
	
	public String getActivityNo() {
		return activityNo;
	}

	/**
	 * @param activityNo the activityNo to set
	 */
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}

	/** 
	 * @return activityName 
	 */
	
	public String getActivityName() {
		return activityName;
	}

	/**
	 * @param activityName the activityName to set
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	
	/** 
	 * @return discountTotal 
	 */
	public double getDiscountTotal() {
		return discountTotal;
	}

	/**
	 * @param discountTotal the discountTotal to set
	 */
	public void setDiscountTotal(double discountTotal) {
		this.discountTotal = discountTotal;
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
	 * @return sponsor 
	 */
	public String getSponsor() {
		return sponsor;
	}

	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	/** 
	 * @return orderGift 
	 */
	
	public List<OrderItemDo> getOrderGift() {
		return orderGift;
	}

	/**
	 * @param orderGift the orderGift to set
	 */
	public void setOrderGift(List<OrderItemDo> orderGift) {
		this.orderGift = orderGift;
	}

	/** 
	 * @return itemsNos 
	 */
	public List<String> getItemsNos() {
		return itemsNos;
	}

	/**
	 * @param itemsNos the itemsNos to set
	 */
	public void setItemsNos(List<String> itemsNos) {
		this.itemsNos = itemsNos;
	}

	/** 
	 * @return prodGroupNos 
	 */
	public List<String> getProdGroupNos() {
		return prodGroupNos;
	}

	/**
	 * @param prodGroupNos the prodGroupNos to set
	 */
	public void setProdGroupNos(List<String> prodGroupNos) {
		this.prodGroupNos = prodGroupNos;
	}

	/** 
	 * @return activityType 
	 */
	public String getActivityType() {
		return activityType;
	}

	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}

	public String getActivityVersion() {
		return activityVersion;
	}

	public void setActivityVersion(String activityVersion) {
		this.activityVersion = activityVersion;
	}

	/** 
	 * @return hasUseCoupon 
	 */
	public boolean isHasUseCoupon() {
		return hasUseCoupon;
	}

	/**
	 * @param hasUseCoupon the hasUseCoupon to set
	 */
	public void setHasUseCoupon(boolean hasUseCoupon) {
		this.hasUseCoupon = hasUseCoupon;
	}

	/** 
	 * @return coupones 
	 */
	public List<OrdercouponSchemeDo> getCoupones() {
		return coupones;
	}

	/**
	 * @param coupones the coupones to set
	 */
	public void setCoupones(List<OrdercouponSchemeDo> coupones) {
		this.coupones = coupones;
	}

	/** 
	 * @return itemsPres 
	 */
	public List<Double> getItemsPres() {
		return itemsPres;
	}

	/**
	 * @param itemsPres the itemsPres to set
	 */
	public void setItemsPres(List<Double> itemsPres) {
		this.itemsPres = itemsPres;
	}

	/** 
	 * @return groupProdPres 
	 */
	public List<Double> getGroupProdPres() {
		return groupProdPres;
	}

	/**
	 * @param groupProdPres the groupProdPres to set
	 */
	public void setGroupProdPres(List<Double> groupProdPres) {
		this.groupProdPres = groupProdPres;
	}
	
	
}
 
/**  
 * @author: yong
 * @date 2013-7-25 下午12:25:18
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.List;

/** 
 * 商品组活动分摊
 * @author: yong
 * @date 2013-7-25 下午12:25:18 
 */
public class PromotionGroupSharePrice  implements Serializable{
	
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;

	/** 促销编号*/
	private String promotionNo;
	
	/**促销类型,Act 活动,CUP 优惠券,SCR 积分分摊*/
	private String promotionType;
	
	/**组类型(0组合商品,1组合包活动)*/
	private Integer groupType;
	
	/**组编号*/
	private String groupNo;
	
	/**组合商品中的条目编号*/
	private List<String> gitemNo;
	
	/**组合商品中的条目优惠分摊价*/
	private List<Double> sharePrice;
	

	/** 
	 * @return promotionNo 
	 */
	public String getPromotionNo() {
		return promotionNo;
	}

	/**
	 * @param promotionNo the promotionNo to set
	 */
	public void setPromotionNo(String promotionNo) {
		this.promotionNo = promotionNo;
	}

	/** 
	 * @return promotionType 
	 */
	public String getPromotionType() {
		return promotionType;
	}

	/**
	 * @param promotionType the promotionType to set
	 */
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	/** 
	 * @return groupType 
	 */
	public Integer getGroupType() {
		return groupType;
	}

	/**
	 * @param groupType the groupType to set
	 */
	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
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
	 * @return gitemNo 
	 */
	public List<String> getGitemNo() {
		return gitemNo;
	}

	/**
	 * @param gitemNo the gitemNo to set
	 */
	public void setGitemNo(List<String> gitemNo) {
		this.gitemNo = gitemNo;
	}

	/** 
	 * @return sharePrice 
	 */
	public List<Double> getSharePrice() {
		return sharePrice;
	}

	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(List<Double> sharePrice) {
		this.sharePrice = sharePrice;
	}
}

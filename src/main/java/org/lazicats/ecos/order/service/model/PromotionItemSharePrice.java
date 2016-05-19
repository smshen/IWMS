/**  
 * @author: yong
 * @date 2013-7-25 下午12:24:59
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/** 
 * 商品Item活动分摊
 * @author: yong
 * @date 2013-7-25 下午12:24:59 
 */
public class PromotionItemSharePrice implements Serializable{
	
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;

	/**促销编号*/
	private String promotionNo;
	
	/**促销类型,Act活动,CUP 优惠券*/
	private String promotionType;
	
	/**条目编号*/
	private String productNo;
	
	/**条目类型
	 * 0  赠品,1 条目 ,2 组合商品条目,3 换购,4组合包商品*/
	private Integer itemType;
	
	/**优惠分摊价*/
	private Double sharePrice;
	
	

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
	 * @return productNo 
	 */
	public String getProductNo() {
		return productNo;
	}

	/**
	 * @param productNo the productNo to set
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	/** 
	 * @return itemType 
	 */
	public Integer getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	/** 
	 * @return sharePrice 
	 */
	public Double getSharePrice() {
		return sharePrice;
	}

	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(Double sharePrice) {
		this.sharePrice = sharePrice;
	}
}

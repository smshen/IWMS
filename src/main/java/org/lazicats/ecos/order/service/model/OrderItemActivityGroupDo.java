package org.lazicats.ecos.order.service.model;

// Generated 2012-11-22 15:58:19 by Hibernate Tools 3.4.0.CR1


public class OrderItemActivityGroupDo implements java.io.Serializable {

	private static final long serialVersionUID = -1l;
	private String id;
	private String itemNo;
	private Integer type;  //1.为商品条目,2.为组合商品条目
	private String activityGroupNo;
	private String activityNo;
	private Double activityAmount;//活动金额
	public OrderItemActivityGroupDo() {
	}

	public OrderItemActivityGroupDo(String id, String itemNo,
			String activityGroupNo) {
		this.id = id;
		this.itemNo = itemNo;
		this.activityGroupNo = activityGroupNo;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemNo() {
		return this.itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getActivityGroupNo() {
		return this.activityGroupNo;
	}

	public void setActivityGroupNo(String activityGroupNo) {
		this.activityGroupNo = activityGroupNo;
	}
	public String getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}

	/** 
	 * @return activityAmount 
	 */
	public Double getActivityAmount() {
		return activityAmount;
	}

	/**
	 * @param activityAmount the activityAmount to set
	 */
	public void setActivityAmount(Double activityAmount) {
		this.activityAmount = activityAmount;
	}

}

package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author liuxiaolong
 * 订单商家广告do实体
 */
public class OrderAdvertiserDo implements Serializable{
	
	private static final long serialVersionUID = 935390123595929628L;
	
	/**表id */
	public String id;
	/**活动id */
	public String campaignId;
	/**站点id*/
	public String siteId;
	/**反馈标签 */
	public String feedBack;
	/**订单编号 */
	public String orderNo;
	/**订单数量 */
	public int orderCount;
	/**订单总额 */
	public double orderTp;
	/**创建时间（下单时间) */
	public Date createTime;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

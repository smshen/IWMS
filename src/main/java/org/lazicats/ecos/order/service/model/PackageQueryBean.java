package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 类名: PackageQueryBean 
 * @author: Stanley
 * @date 2013-7-28 上午11:00:18
 * @version
 */
public class PackageQueryBean implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	/**开始时间*/
	private Date startTime;
	/**结束时间*/
	private Date endTime;
	/**订单中心编号*/
	private String orderNo;
	/**包裹编号*/
	private String packageNo;
	/**商品名*/
	private String prodName;
	/**商品编号*/
	private String prodNo;
	/**买家昵称*/
	private String buyerNickName;
	/**渠道编号*/
	private String channelType;
	/**收货人*/
	private String consignee;
	/**收货人手机*/
	private String consigneeCellPhone;
	/**物流公司**/
	private String logisticsCompany;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPackageNo() {
		return packageNo;
	}
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getBuyerNickName() {
		return buyerNickName;
	}
	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneeCellPhone() {
		return consigneeCellPhone;
	}
	public void setConsigneeCellPhone(String consigneeCellPhone) {
		this.consigneeCellPhone = consigneeCellPhone;
	}
	public String getLogisticsCompany() {
		return logisticsCompany;
	}
	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}
	
}

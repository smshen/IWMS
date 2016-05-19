package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: OrderAftersaleQueryBean 
 * @Description: TODO
 * @author: Stanley 
 * @date 2013-7-17 下午4:14:43
 *
 */
public class OrderAftersaleQueryBean implements Serializable {
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String orderNo;//订单编号
	private String aftersaleNo;//售后编号
	private String consignee;//收货人
	private String consigneePhone;//收货人电话
	private Date startTime;
	private Date endTime;
	private String aftersaleState;//处理状态
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAftersaleNo() {
		return aftersaleNo;
	}
	public void setAftersaleNo(String aftersaleNo) {
		this.aftersaleNo = aftersaleNo;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
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
	public String getAftersaleState() {
		return aftersaleState;
	}
	public void setAftersaleState(String aftersaleState) {
		this.aftersaleState = aftersaleState;
	}
	
}

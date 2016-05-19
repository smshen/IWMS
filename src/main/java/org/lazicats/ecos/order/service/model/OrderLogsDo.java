package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: OrderLogsVo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-3-25 下午4:23:42
 *
 */
public class OrderLogsDo implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String orderNo;
	private String operatorNo;
	private String operationType;
	private String operationRemark;
	private Date operationTime;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOperatorNo() {
		return operatorNo;
	}
	public void setOperatorNo(String operatorNo) {
		this.operatorNo = operatorNo;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getOperationRemark() {
		return operationRemark;
	}
	public void setOperationRemark(String operationRemark) {
		this.operationRemark = operationRemark;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

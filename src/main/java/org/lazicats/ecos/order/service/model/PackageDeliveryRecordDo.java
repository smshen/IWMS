package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: PackageDeliveryRecordDo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-8 下午2:18:45
 *
 */
public class PackageDeliveryRecordDo implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	public String id;
	public String subOrderNo;//包裹单号
	public Date deliveryDate;//发货日期
	public String deliveryNo;//发货单号/发货明细
	public String logisticsNo;//物流单号
	public Double deliveryFee;//快递费用
	public String deliveryStorehouse;//发货仓库
	public String deliveryOperator;//发货操作人
	
	public PackageDeliveryRecordDo() {
		super();
	}
	public PackageDeliveryRecordDo(String id,String subOrderNo, Date deliveryDate,
			String deliveryNo, String logisticsNo, Double deliveryFee,
			String deliveryStorehouse, String deliveryOperator) {
		super();
		this.id=id;
		this.subOrderNo = subOrderNo;
		this.deliveryDate = deliveryDate;
		this.deliveryNo = deliveryNo;
		this.logisticsNo = logisticsNo;
		this.deliveryFee = deliveryFee;
		this.deliveryStorehouse = deliveryStorehouse;
		this.deliveryOperator = deliveryOperator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubOrderNo() {
		return subOrderNo;
	}
	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getLogisticsNo() {
		return logisticsNo;
	}
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	public Double getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public String getDeliveryStoreHouse() {
		return deliveryStorehouse;
	}
	public void setDeliveryStoreHouse(String deliveryStorehouse) {
		this.deliveryStorehouse = deliveryStorehouse;
	}
	public String getDeliveryOperator() {
		return deliveryOperator;
	}
	public void setDeliveryOperator(String deliveryOperator) {
		this.deliveryOperator = deliveryOperator;
	}
	
	
}

package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;
import java.util.Date;

/*
 * 预入库详细信息
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class PreStackInDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number="";
	private String preStackInOrderNumber="";
	private String commodityNumber="";
	private String skuNumber="";
	private String batchNumber="";
	private Date productionDate;
	private Date invalidDate;
	private Date validDate;
	private int quantity;
	private int urgentLogo;//加急标识
	private String decription="";//备注
	private  Double price;//单价
	
	
	
	private Double unPrice;//不含税成本价
	/**
	 * 获取编号
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置编号
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 设置所属的预入库单编号
	 * @return
	 */
	public String getPreStackInOrderNumber() {
		return preStackInOrderNumber;
	}
	/**
	 * 设置所属的预入库单编号
	 * @param preStackInOrderNumber
	 */
	public void setPreStackInOrderNumber(String preStackInOrderNumber) {
		this.preStackInOrderNumber = preStackInOrderNumber;
	}
	/**
	 * 获取商品编号
	 * @return
	 */
	public String getCommodityNumber() {
		return commodityNumber;
	}
	/**
	 * 设置商品编号
	 * @param commodityNumber
	 */
	public void setCommodityNumber(String commodityNumber) {
		this.commodityNumber = commodityNumber;
	}
	/**
	 * 获取SKU编号
	 * @return
	 */
	public String getSkuNumber() {
		return skuNumber;
	}
	/**
	 * 设置SKU编号
	 * @param skuNumber
	 */
	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}
	/**
	 * 获取批次编号
	 * @return
	 */
	public String getBatchNumber() {
		return batchNumber;
	}
	/**
	 * 设置批次编号
	 * @param batchNumber
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	/**
	 * 获取生产日期
	 * @return
	 */
	public Date getProductionDate() {
		return productionDate;
	}
	/**
	 * 设置生产日期
	 * @param productionDate
	 */
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	/**
	 * 获取失效时间
	 * @return
	 */
	public Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 设置失效时间
	 * @param invalidDate
	 */
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	/**
	 * 获取有效时间
	 * @return
	 */
	public Date getValidDate() {
		return validDate;
	}
	/**
	 * 设置有效时间
	 * @param validDate
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	/**
	 * 获取数量
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * 设置数量
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUrgentLogo() {
		return urgentLogo;
	}
	public void setUrgentLogo(int urgentLogo) {
		this.urgentLogo = urgentLogo;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getUnPrice() {
		return unPrice;
	}
	public void setUnPrice(Double unPrice) {
		this.unPrice = unPrice;
	}
	
	
}

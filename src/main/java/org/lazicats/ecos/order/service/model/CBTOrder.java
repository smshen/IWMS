package org.lazicats.ecos.order.service.model;

import java.util.List;

/**
 * 跨境子订单,可以是以下的其中一种：
 *  - 供应商订单
 *  - 海关订单
 *  - 物流商订单
 *  
 * @author Jay
 */
public class CBTOrder {
	private String orderNo; //跨境子订单编号
	
	private String supplierCode; //供应商编码
	private String customeCode;  //海关编码
	private String logisticsCode; //物流商编码
	
	private String ieFlag; //进出口标志（I-进口 E-出口）
	
	private Double goodTotal; //商品总金额（元)
	private Double freight; //运费(订单运费)
	private Double tax; //税费(根据商品总金额计算得) （300 + 300 ）  60 
	 
	private CBTCustomer customer; //顾客信息

	private CBTDelivery delivery; //配送

	private List<CBTItem> items;  //订单项

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getCustomeCode() {
		return customeCode;
	}

	public void setCustomeCode(String customeCode) {
		this.customeCode = customeCode;
	}

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	public String getIeFlag() {
		return ieFlag;
	}

	public void setIeFlag(String ieFlag) {
		this.ieFlag = ieFlag;
	}

	public Double getGoodTotal() {
		return goodTotal;
	}

	public void setGoodTotal(Double goodTotal) {
		this.goodTotal = goodTotal;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public CBTCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CBTCustomer customer) {
		this.customer = customer;
	}

	public CBTDelivery getDelivery() {
		return delivery;
	}

	public void setDelivery(CBTDelivery delivery) {
		this.delivery = delivery;
	}

	public List<CBTItem> getItems() {
		return items;
	}

	public void setItems(List<CBTItem> items) {
		this.items = items;
	}
	
	
}


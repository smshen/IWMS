package org.lazicats.ecos.order.service.model;

public class CBTItem {
	
	private String sequence; //序号
	
	private String sku; //商品编码
	private String name; //商品名称
	private String unit; 
	private String price; 
	private String quantity;
	private String total;
	
	private String customsRegNo; //商品海关备案号
	private String entRegNo; //电商商户企业备案号
	private String entRegName; //电商商户企业备案名称
	
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCustomsRegNo() {
		return customsRegNo;
	}
	public void setCustomsRegNo(String customsRegNo) {
		this.customsRegNo = customsRegNo;
	}
	public String getEntRegNo() {
		return entRegNo;
	}
	public void setEntRegNo(String entRegNo) {
		this.entRegNo = entRegNo;
	}
	public String getEntRegName() {
		return entRegName;
	}
	public void setEntRegName(String entRegName) {
		this.entRegName = entRegName;
	}
	
	

}

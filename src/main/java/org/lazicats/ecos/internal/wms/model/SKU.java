package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;

/**
 * SKU
 * @author 肖锋
 *
 */
public class SKU implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number="";
    private String name="";
    private String commodityNumber="";
    private String spec="";
    private String barcode="";
    private String color="";
    private String size="";//尺码
    private String brandName="";//商标
    private Byte prodStatus;//是否被禁用
    /**
     * 获取sku编号
     * @return
     */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置sku编号
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取SKU名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置SKU名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取SKU所属的产品编号
	 * @return
	 */
	public String getCommodityNumber() {
		return commodityNumber;
	}
	/**
	 * 设置SKU所属的产品编号
	 * @param commodityNumber
	 */
	public void setCommodityNumber(String commodityNumber) {
		this.commodityNumber = commodityNumber;
	}
	/**
	 * 获取SKU规格
	 * @return
	 */
	public String getSpec() {
		return spec;
	}
	/**
	 * 设置SKU规格
	 * @param spec
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	 * 获取SKU条码
	 * @return
	 */
	public String getBarcode() {
		return barcode;
	}
	/**
	 * 设置SKU条码
	 * @param barcode
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Byte getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(Byte prodStatus) {
		this.prodStatus = prodStatus;
	}
	
	
}

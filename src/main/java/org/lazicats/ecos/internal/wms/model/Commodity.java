package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;

/**
 * 商品信息
 * @author Administrator
 *
 */
public class Commodity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number="";
    private String name="";
    private String alphabetical="";
    private String unit="";
    private String productionPlace="";
    private String classifyNumber="";
    private String supplierName="";
    private int effectiveTime;
    private String brandName="";
    
    
    /**
     *获取商品所属的品牌名称
     * @return
     */
    public String getBrandName() {
		return brandName;
	}
    /**
     * 设置商品所属的品牌名称
     * @param brandName
     */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
     * 获取商品编号
     * @return
     */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置商品编号
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取商品名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置商品名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取商品拼音
	 * @return
	 */
	public String getAlphabetical() {
		return alphabetical;
	}
	/**
	 * 设置商品拼音
	 * @param alphabetical
	 */
	public void setAlphabetical(String alphabetical) {
		this.alphabetical = alphabetical;
	}
	/**
	 * 获取商品单位
	 * @return
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置商品单位
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取商品产地
	 * @return
	 */
	public String getProductionPlace() {
		return productionPlace;
	}
	/**
	 * 设置商品产地
	 * @param productionPlace
	 */
	public void setProductionPlace(String productionPlace) {
		this.productionPlace = productionPlace;
	}
	/**
	 * 获取商品所属的分类编号
	 * @return
	 */
	public String getClassifyNumber() {
		return classifyNumber;
	}
	/**
	 * 设置商品所属的分类编号
	 * @param classifyNumber
	 */
	public void setClassifyNumber(String classifyNumber) {
		this.classifyNumber = classifyNumber;
	}
	/**
	 * 获取供应商名称
	 * @return
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * 设置供应商名称
	 * @param supplierName
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取有效期
	 * @return
	 */
	public Integer getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Integer effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	
}

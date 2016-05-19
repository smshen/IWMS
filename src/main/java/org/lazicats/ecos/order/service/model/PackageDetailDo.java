package org.lazicats.ecos.order.service.model;


/**
 * TblPackageDetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PackageDetailDo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String id;
	private String subOrderNo;//子单号
	private String picPath;//图片
	private String prodNo;//商品编码
	private String prodName;//商品名称
	private Integer prodQuantity;//数量
	private Double salePrice;//售价
	private Double finalPrice;//最终价
	private String brand;//品牌
	private String deliveryState;//发货状态
	private String commodityNo;//商品编码
	private String IsVirtualStock;//是否虚库
	private String commodityName;//商品名称
	private String supplierNo;//供应商
	private String buyType;//请购类型
	private String defaultStockNo;//默认仓库Id
	private String defaultSuplierNo;//默认供应商
	// Constructors

	/** default constructor */
	public PackageDetailDo() {
	}

	/** minimal constructor */
	public PackageDetailDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PackageDetailDo(String id, String subOrderNo, String picPath,
			String prodNo, String prodName, Integer prodQuantity,
			Double salePrice, Double finalPrice, String brand,
			String deliveryState) {
		this.id = id;
		this.subOrderNo = subOrderNo;
		this.picPath = picPath;
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodQuantity = prodQuantity;
		this.salePrice = salePrice;
		this.finalPrice = finalPrice;
		this.brand = brand;
		this.deliveryState = deliveryState;
	}

	// Property accessors
	
	public String getId() {
		return this.id;
	}

	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSubOrderNo() {
		return this.subOrderNo;
	}

	
	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}
	
	public String getPicPath() {
		return this.picPath;
	}

	
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public String getProdNo() {
		return this.prodNo;
	}

	
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	
	public String getProdName() {
		return this.prodName;
	}

	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public Integer getProdQuantity() {
		return this.prodQuantity;
	}

	
	public void setProdQuantity(Integer prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	
	public Double getSalePrice() {
		return this.salePrice;
	}

	
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	public Double getFinalPrice() {
		return this.finalPrice;
	}

	
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	public String getBrand() {
		return this.brand;
	}

	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getDeliveryState() {
		return this.deliveryState;
	}

	
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public String getIsVirtualStock() {
		return IsVirtualStock;
	}

	public void setIsVirtualStock(String isVirtualStock) {
		IsVirtualStock = isVirtualStock;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}

	public String getDefaultStockNo() {
		return defaultStockNo;
	}

	public void setDefaultStockNo(String defaultStockNo) {
		this.defaultStockNo = defaultStockNo;
	}

	public String getDefaultSuplierNo() {
		return defaultSuplierNo;
	}

	public void setDefaultSuplierNo(String defaultSuplierNo) {
		this.defaultSuplierNo = defaultSuplierNo;
	}

}
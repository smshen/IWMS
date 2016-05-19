package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;
import java.util.List;

import org.lazicats.ecos.erp.financial.service.model.ErpFinancialSaleByProxyActivityDo;



/**
 * 货品信息
 */
/**
 * @author Administrator
 *
 */
public class PreStackOutDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	private String number="";  //包裹明细编号
	private String preStackOutOrderNumber="";  //预出库单编号
	private String commodityNumber="";  //商品ID
	private String commodityName="";//商品名称
	private String skuNumber="";  //SKU ID
	private String batchNumber="";  //批次号
	private Integer quantity;  //数量
	private Double price;  //  单价
	private String unit="";  //单位
	private String waybillInfo="";  //运单信息
	private String description="";  //细单备注
	private Double orgPrice;//原价格
	private String suplierNo="";//供应商
	
	private String isVirtualStock="";//是否虚库
	private String buyType="";//销售模式
	private Double taxRate;  //税率
	private String defaultStockNo="";//默认仓库Id
	private String defaultSuplierNo="";//默认供应商
	private Double costPrice; //成交价
	private List<ErpFinancialSaleByProxyActivityDo> activeDos;
	private String brand;
	
	
	private Double unCostPrice;//不含税成本价 
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
	 * 获取预入库单编号
	 * @return
	 */
	public String getPreStackOutOrderNumber() {
		return preStackOutOrderNumber;
	}
	/**
	 * 设置预入库单编号
	 * @param preStackOutOrderNumber
	 */
	public void setPreStackOutOrderNumber(String preStackOutOrderNumber) {
		this.preStackOutOrderNumber = preStackOutOrderNumber;
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
	/**
	 * 获取单价
	 * @return
	 */
	
	/**
	 * 获取单位
	 * @return
	 */
	public String getUnit() {
		return unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 设置单位
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取运单信息
	 * @return
	 */
	public String getWaybillInfo() {
		return waybillInfo;
	}
	/**
	 * 设置运单信息
	 * @param waybillInfo
	 */
	public void setWaybillInfo(String waybillInfo) {
		this.waybillInfo = waybillInfo;
	}
	/**
	 * 获取描述信息
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置描述信息
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsVirtualStock() {
		return isVirtualStock;
	}
	public void setIsVirtualStock(String isVirtualStock) {
		this.isVirtualStock = isVirtualStock;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getSuplierNo() {
		return suplierNo;
	}
	public void setSuplierNo(String suplierNo) {
		this.suplierNo = suplierNo;
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
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Double getOrgPrice() {
		return orgPrice;
	}
	public void setOrgPrice(Double orgPrice) {
		this.orgPrice = orgPrice;
	}
	public List<ErpFinancialSaleByProxyActivityDo> getActiveDos() {
		return activeDos;
	}
	public void setActiveDos(List<ErpFinancialSaleByProxyActivityDo> activeDos) {
		this.activeDos = activeDos;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getUnCostPrice() {
		return unCostPrice;
	}
	public void setUnCostPrice(Double unCostPrice) {
		this.unCostPrice = unCostPrice;
	}
	
}

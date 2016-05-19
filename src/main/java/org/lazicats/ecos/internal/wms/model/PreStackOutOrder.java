package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 包裹信息
 * 
 */
public class PreStackOutOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	private String number = ""; // 包裹编号
	private int type; // 1.销售出库 2.销售换货 3.采购退货 4.调拨出库 5.盘点出库 6.其它出库
	private String sourceNumber = ""; // 客户ID 会员ID，供应商ID
	private String sourceName = ""; // 客户名称 会员名称，供应商名称
	private String deliveryAddressN; // 送货地址ID
	private String deliveryAddressInfo = ""; // 送货地址
	private Double packPrice; // 包裹金额
	private String waybillNumber = ""; // 承运商ID
	private String waybillName = ""; // 承运商名称
	private Date orderDate; // 订单日期
	private int deliveryType;// 发货方式
	private int transportMode;// 运输方式
	private int urgentFlag;// 加急标志
	private int noflyFlag;
	private int unairFlag;// 禁航标志
	private String description = "";// 备注
	private String createdByNumber = ""; // 制作人id
	private String createdByName = ""; // 制作人
	private String stockNumber = "";// 仓库id
	private String orderInfo = "";// 总单据信息
	private Date createdDate;
	private int codFlag;// Cod标志 取值 ：0、不是货到付款 1、货到付款
	private int soSource;// 来源 1：淘宝 2：商城
	private Double packWayPrice;  //包裹运费
	private Double packPreferPrice;  //包裹优惠金额
	// 货品信息
	private List<PreStackOutDetails> details;
	
	
	//订单号
	private String orderNumber;
	//包裹号
	private String parcelno;

	/**
	 * 获取编号
	 * 
	 * @return
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * 设置编号
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * 
	 * @return
	 */
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSourceNumber() {
		return sourceNumber;
	}

	public void setSourceNumber(String sourceNumber) {
		this.sourceNumber = sourceNumber;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getWaybillNumber() {
		return waybillNumber;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public String getWaybillName() {
		return waybillName;
	}

	public void setWaybillName(String waybillName) {
		this.waybillName = waybillName;
	}

	public String getDeliveryAddressInfo() {
		return deliveryAddressInfo;
	}

	public void setDeliveryAddressInfo(String deliveryAddressInfo) {
		this.deliveryAddressInfo = deliveryAddressInfo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(int transportMode) {
		this.transportMode = transportMode;
	}

	public int getUrgentFlag() {
		return urgentFlag;
	}

	public void setUrgentFlag(int urgentFlag) {
		this.urgentFlag = urgentFlag;
	}

	public int getNoflyFlag() {
		return noflyFlag;
	}

	public void setNoflyFlag(int noflyFlag) {
		this.noflyFlag = noflyFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedByNumber() {
		return createdByNumber;
	}

	public void setCreatedByNumber(String createdByNumber) {
		this.createdByNumber = createdByNumber;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public List<PreStackOutDetails> getDetails() {
		return details;
	}

	public void setDetails(List<PreStackOutDetails> details) {
		this.details = details;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getDeliveryAddressN() {
		return deliveryAddressN;
	}

	public void setDeliveryAddressN(String deliveryAddressN) {
		this.deliveryAddressN = deliveryAddressN;
	}

	public int getUnairFlag() {
		return unairFlag;
	}

	public void setUnairFlag(int unairFlag) {
		this.unairFlag = unairFlag;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public int getCodFlag() {
		return codFlag;
	}

	public void setCodFlag(int codFlag) {
		this.codFlag = codFlag;
	}

	public int getSoSource() {
		return soSource;
	}

	public void setSoSource(int soSource) {
		this.soSource = soSource;
	}

	public Double getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(Double packPrice) {
		this.packPrice = packPrice;
	}

	public Double getPackWayPrice() {
		return packWayPrice;
	}

	public void setPackWayPrice(Double packWayPrice) {
		this.packWayPrice = packWayPrice;
	}

	public Double getPackPreferPrice() {
		return packPreferPrice;
	}

	public void setPackPreferPrice(Double packPreferPrice) {
		this.packPreferPrice = packPreferPrice;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getParcelno() {
		return parcelno;
	}

	public void setParcelno(String parcelno) {
		this.parcelno = parcelno;
	}

}

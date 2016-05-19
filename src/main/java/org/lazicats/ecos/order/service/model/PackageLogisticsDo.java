package org.lazicats.ecos.order.service.model;

import java.util.Date;

/**
 * TblPackageLogistics entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PackageLogisticsDo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String subOrderNo;//包裹号
	private String consignor;//发货人
	private String logisticsCompany;//物流公司
	private String deliveryNo;//快递单号
	private String consignAddress;//发货地
	private String packageState;//包裹状态
	private Double deliveryFee;//运费
	private Date consignTime;//发货时间
	private String url;//
	
	private String logisticsCode;
	// Constructors

	/** default constructor */
	public PackageLogisticsDo() {
	}

	/** minimal constructor */
	public PackageLogisticsDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PackageLogisticsDo(String id, String subOrderNo, String consignor,
			String logisticsCompany, String deliveryNo, String consignAddress,
			String packageState, Double deliveryFee, Date consignTime) {
		this.id = id;
		this.subOrderNo = subOrderNo;
		this.consignor = consignor;
		this.logisticsCompany = logisticsCompany;
		this.deliveryNo = deliveryNo;
		this.consignAddress = consignAddress;
		this.packageState = packageState;
		this.deliveryFee = deliveryFee;
		this.consignTime = consignTime;
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
	
	public String getConsignor() {
		return this.consignor;
	}

	
	public void setConsignor(String consignor) {
		this.consignor = consignor;
	}
	
	public String getLogisticsCompany() {
		return this.logisticsCompany;
	}

	
	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}
	
	public String getDeliveryNo() {
		return this.deliveryNo;
	}

	
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	
	public String getConsignAddress() {
		return this.consignAddress;
	}

	
	public void setConsignAddress(String consignAddress) {
		this.consignAddress = consignAddress;
	}
	
	public String getPackageState() {
		return this.packageState;
	}

	
	public void setPackageState(String packageState) {
		this.packageState = packageState;
	}
	
	public Double getDeliveryFee() {
		return this.deliveryFee;
	}

	
	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	public Date getConsignTime() {
		return this.consignTime;
	}

	
	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}
}
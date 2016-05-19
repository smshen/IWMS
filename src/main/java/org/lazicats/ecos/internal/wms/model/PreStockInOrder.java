package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 预入库
 * @author 肖锋
 *
 */
public class PreStockInOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number="";
	private int type;
	private String sourceNumber="";
	private String sourceName="";
	private int dealModel;
	private String stockNumber="";
	private Date orderDate;
	private Date arrivalDate;
	private int transFlag;
	private String Description="";
	private List<PreStackInDetails> details;
	private String createdByNumber="";
	private String createdByName="";
	private Date CreatedDate;
	
	

	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	/**
	 * 
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
	 * 获取类型
	 * 1.采购入库
	 * 2.销售退货入库
	 * 3.销售换货入库
	 * 4.调拨入库
	 * @return
	 */
	public int getType() {
		return type;
	}
	/**
	 * 设置类型
	 * 1.采购入库
	 * 2.销售退货入库
	 * 3.销售换货入库
	 * 4.调拨入库
	 * @return
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * 获取来源编号（供应商或商城会员）
	 * @return
	 */
	public String getSourceNumber() {
		return sourceNumber;
	}
	/**
	 * 设置来源编号（供应商或商城会员）
	 * @param sourceNumber
	 */
	public void setSourceNumber(String sourceNumber) {
		this.sourceNumber = sourceNumber;
	}

	/**
	 * 获取来源名称（供应商或商城会员）
	 * @return
	 */
	public String getSourceName() {
		return sourceName;
	}
	/**
	 * 设置来源名称（供应商或商城会员）
	 * @param sourceName
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/**
	 * 获取经销模式
	 * 1.购销
	 * 2.代销
	 * @return
	 */
	public int getDealModel() {
		return dealModel;
	}
	/**
	 * 获取经销模式
	 * 1.购销
	 * 2.代销
	 * @return
	 */
	public void setDealModel(int dealModel) {
		this.dealModel = dealModel;
	}
	/**
	 * 获取仓库编号
	 * @return
	 */
	public String getStockNumber() {
		return stockNumber;
	}
	/**
	 * 设置仓库编号
	 * @param stockNumber
	 */
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
    /**
     * 获取单据创建时间
     * @return
     */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * 设置单据创建时间
	 * @param orderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * 获取单据创建人编号
	 * @return
	 */
	public String getCreatedByNumber() {
		return createdByNumber;
	}
	/**
	 * 设置单据创建人编号
	 * @param createdByNumber
	 */
	public void setCreatedByNumber(String createdByNumber) {
		this.createdByNumber = createdByNumber;
	}
	/**
	 * 获取单据创建人名称
	 * @return
	 */
	public String getCreatedByName() {
		return createdByName;
	}
	/**
	 * 设置单据创建人名称
	 * @param createdByName
	 */
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	/**
	 * 获取预计到货日期
	 * @return
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * 设置预计到货日期
	 * @param arrivalDate
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * 获取运输标志
	 * 0 送货
	 * @return
	 */
	public int getTransFlag() {
		return transFlag;
	}
	/**
	 * 设置运输标志
	 * 0 送货
	 * @return
	 */
	public void setTransFlag(int transFlag) {
		this.transFlag = transFlag;
	}
	/**
	 * 获取描述信息
	 * @return
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * 设置描述信息
	 * @param description
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * 获取详细记录列表
	 * @return
	 */
	public List<PreStackInDetails> getDetails() {
		return details;
	}
	/**
	 * 设置详细记录列表
	 * @param details
	 */
	public void setDetails(List<PreStackInDetails> details) {
		this.details = details;
	}
}

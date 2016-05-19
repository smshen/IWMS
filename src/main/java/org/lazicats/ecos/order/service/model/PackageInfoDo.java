package org.lazicats.ecos.order.service.model;

import java.util.List;

/**
 * 
 * @ClassName: PackageInfoDo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-17 上午9:43:07
 *
 */
public class PackageInfoDo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String orderNo;//订单编号
	private String packageNo;//包裹编号
	private Integer packageCount;//包裹数
	private String subPackageNo;//包裹号
	private String splitReason;//拆单原因

	private List<PackageDeliveryInfoDo> packageDeliveryInfoDos;
	// Constructors

	/** default constructor */
	public PackageInfoDo() {
	}

	/** minimal constructor */
	public PackageInfoDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PackageInfoDo(String id, String orderNo, String packageNo,
			Integer packageCount, String subPackageNo, String splitReason) {
		this.id = id;
		this.orderNo = orderNo;
		this.packageNo = packageNo;
		this.packageCount = packageCount;
		this.subPackageNo = subPackageNo;
		this.splitReason = splitReason;
	}

	// Property accessors
	
	public String getId() {
		return this.id;
	}

	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrderNo() {
		return this.orderNo;
	}

	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getPackageNo() {
		return this.packageNo;
	}

	
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	
	public Integer getPackageCount() {
		return this.packageCount;
	}

	
	public void setPackageCount(Integer packageCount) {
		this.packageCount = packageCount;
	}
	
	public String getSubPackageNo() {
		return this.subPackageNo;
	}

	
	public void setSubPackageNo(String subPackageNo) {
		this.subPackageNo = subPackageNo;
	}
	
	public String getSplitReason() {
		return this.splitReason;
	}

	
	public void setSplitReason(String splitReason) {
		this.splitReason = splitReason;
	}

	public List<PackageDeliveryInfoDo> getPackageDeliveryInfoDos() {
		return packageDeliveryInfoDos;
	}

	public void setPackageDeliveryInfoDos(
			List<PackageDeliveryInfoDo> packageDeliveryInfoDos) {
		this.packageDeliveryInfoDos = packageDeliveryInfoDos;
	}

}
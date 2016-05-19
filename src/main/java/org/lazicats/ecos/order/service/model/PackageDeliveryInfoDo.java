package org.lazicats.ecos.order.service.model;

import java.util.List;


/**
 * 
 * @ClassName: PackageDeliveryInfoDo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-4 下午6:40:47
 *
 */
public class PackageDeliveryInfoDo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String packageNo;//包裹号
	private String orderNo;//订单编号
	private String subOrderNo;//子单号
	private String logisticsCompany;//物流公司
	private String storehouse;//仓库
	private Double assessFee;//评估运费
	private Integer prodQuantity;//包裹商品数量
	/**
	 * 配送
	 */
	private PackageDeliveryDo packageDeliveryDo;
	private List<PackageDeliveryRecordDo> packageDeliveryRecordDos;
	/**包裹详情*/
	private List<PackageDetailDo> packageDetailDos;
	/**物流*/
	private PackageLogisticsDo packageLogisticsDos;
	// Constructors

	/** default constructor */
	public PackageDeliveryInfoDo() {
	}

	/** minimal constructor */
	public PackageDeliveryInfoDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PackageDeliveryInfoDo(String id, String packageNo,
			String subOrderNo, String logisticsCompany, String storehouse,
			Double assessFee, Integer prodQuantity) {
		this.id = id;
		this.packageNo = packageNo;
		this.subOrderNo = subOrderNo;
		this.logisticsCompany = logisticsCompany;
		this.storehouse = storehouse;
		this.assessFee = assessFee;
		this.prodQuantity = prodQuantity;
	}

	// Property accessors
    /* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getId()
	 */
   
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setId(java.lang.String)
	 */
	
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getPackageNo()
	 */
	
	public String getPackageNo() {
		return this.packageNo;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setPackageNo(java.lang.String)
	 */
	
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getSubOrderNo()
	 */
	
	public String getSubOrderNo() {
		return this.subOrderNo;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setSubOrderNo(java.lang.String)
	 */
	
	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getLogisticsCompany()
	 */
	
	public String getLogisticsCompany() {
		return this.logisticsCompany;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setLogisticsCompany(java.lang.String)
	 */
	
	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getStorehouse()
	 */
	
	public String getStorehouse() {
		return this.storehouse;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setStorehouse(java.lang.String)
	 */
	
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getAssessFee()
	 */
	
	public Double getAssessFee() {
		return this.assessFee;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setAssessFee(java.lang.Double)
	 */
	
	public void setAssessFee(Double assessFee) {
		this.assessFee = assessFee;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#getProdQuantity()
	 */
	
	public Integer getProdQuantity() {
		return this.prodQuantity;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDeliveryInfo#setProdQuantity(java.lang.Integer)
	 */
	
	public void setProdQuantity(Integer prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public PackageDeliveryDo getPackageDeliveryDo() {
		return packageDeliveryDo;
	}

	public void setPackageDeliveryDo(PackageDeliveryDo packageDeliveryDo) {
		this.packageDeliveryDo = packageDeliveryDo;
	}

	public List<PackageDeliveryRecordDo> getPackageDeliveryRecordDos() {
		return packageDeliveryRecordDos;
	}

	public void setPackageDeliveryRecordDos(
			List<PackageDeliveryRecordDo> packageDeliveryRecordDos) {
		this.packageDeliveryRecordDos = packageDeliveryRecordDos;
	}

	public List<PackageDetailDo> getPackageDetailDos() {
		return packageDetailDos;
	}

	public void setPackageDetailDos(List<PackageDetailDo> packageDetailDos) {
		this.packageDetailDos = packageDetailDos;
	}

	public PackageLogisticsDo getPackageLogisticsDos() {
		return packageLogisticsDos;
	}

	public void setPackageLogisticsDos(PackageLogisticsDo packageLogisticsDos) {
		this.packageLogisticsDos = packageLogisticsDos;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
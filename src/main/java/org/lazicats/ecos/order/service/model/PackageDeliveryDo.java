package org.lazicats.ecos.order.service.model;


public class PackageDeliveryDo implements java.io.Serializable {

	// Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String subOrderNo;//子单号
	private String appointExpress;//指定快递
	private String deliveryTime;//配送时间
	private String invoice;//发票
	private String invoiceType;//发票类型
	private String invoiceDetail;//发票内容
	private String invoiceTitle;//发票抬头
	private String consignee;//收货人
	private String cellPhone;//手机
	private String telephone;//电话
	private String zipCode;//邮编
	private String receiveAddress;//收货地址
	private String deliveryRemark;//配送备注

	// Constructors

	/** default constructor */
	public PackageDeliveryDo() {
	}

	/** minimal constructor */
	public PackageDeliveryDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public PackageDeliveryDo(String id, String subOrderNo,String appointExpress,
			String deliveryTime, String invoice, String consignee,
			String cellPhone, String telephone, String zipCode,
			String receiveAddress, String deliveryRemark) {
		this.id = id;
		this.subOrderNo = subOrderNo;
		this.appointExpress = appointExpress;
		this.deliveryTime = deliveryTime;
		this.invoice = invoice;
		this.consignee = consignee;
		this.cellPhone = cellPhone;
		this.telephone = telephone;
		this.zipCode = zipCode;
		this.receiveAddress = receiveAddress;
		this.deliveryRemark = deliveryRemark;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getId()
	 */
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getAppointExpress()
	 */
	
	public String getAppointExpress() {
		return this.appointExpress;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setAppointExpress(java.lang.String)
	 */
	
	public void setAppointExpress(String appointExpress) {
		this.appointExpress = appointExpress;
	}
	
	public String getSubOrderNo() {
		return this.subOrderNo;
	}

	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getDeliveryTime()
	 */
	public String getDeliveryTime() {
		return this.deliveryTime;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setDeliveryTime(java.util.Date)
	 */
	
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getInvoice()
	 */
	
	public String getInvoice() {
		return this.invoice;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setInvoice(java.lang.String)
	 */
	
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getConsignee()
	 */
	
	public String getConsignee() {
		return this.consignee;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setConsignee(java.lang.String)
	 */
	
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getCellPhone()
	 */
	
	public String getCellPhone() {
		return this.cellPhone;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setCellPhone(java.lang.String)
	 */
	
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getTelephone()
	 */
	
	public String getTelephone() {
		return this.telephone;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setTelephone(java.lang.String)
	 */
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getZipCode()
	 */
	
	public String getZipCode() {
		return this.zipCode;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setZipCode(java.lang.String)
	 */
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getReceiveAddress()
	 */
	
	public String getReceiveAddress() {
		return this.receiveAddress;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setReceiveAddress(java.lang.String)
	 */
	
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#getDeliveryRemark()
	 */
	
	public String getDeliveryRemark() {
		return this.deliveryRemark;
	}

	/* (non-Javadoc)
	 * @see org.lazicats.ecos.order.dal.model.entity.IPackageDelivery#setDeliveryRemark(java.lang.String)
	 */
	
	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceDetail() {
		return invoiceDetail;
	}

	public void setInvoiceDetail(String invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

}
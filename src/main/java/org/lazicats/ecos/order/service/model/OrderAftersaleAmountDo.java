package org.lazicats.ecos.order.service.model;

/**
 * 
 * @ClassName: OrderAftersaleAmount 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-12 下午8:53:22
 *
 */

public class OrderAftersaleAmountDo implements java.io.Serializable {

	// Fields

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * 退款订单编号
	 */
	private String aftersaleNo;
	/**
	 * 调整原因
	 */
	private String revisionReason;
	/**
	 * 调整金额
	 */
	private Double revisionAmount;
	/**
	 * 编号
	 */
	private String amountNo;


	// Constructors

	/** default constructor */
	public OrderAftersaleAmountDo() {
	}

	/** minimal constructor */
	public OrderAftersaleAmountDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public OrderAftersaleAmountDo(String id, String aftersaleNo,
			String revisionReason, Double revisionAmount,String amountNo) {
		this.id = id;
		this.aftersaleNo = aftersaleNo;
		this.revisionReason = revisionReason;
		this.revisionAmount = revisionAmount;
		this.amountNo = amountNo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAftersaleNo() {
		return this.aftersaleNo;
	}

	public void setAftersaleNo(String aftersaleNo) {
		this.aftersaleNo = aftersaleNo;
	}

	public String getRevisionReason() {
		return this.revisionReason;
	}

	public void setRevisionReason(String revisionReason) {
		this.revisionReason = revisionReason;
	}

	public Double getRevisionAmount() {
		return this.revisionAmount;
	}

	public void setRevisionAmount(Double revisionAmount) {
		this.revisionAmount = revisionAmount;
	}

	public String getAmountNo() {
		return amountNo;
	}

	public void setAmountNo(String amountNo) {
		this.amountNo = amountNo;
	}

}
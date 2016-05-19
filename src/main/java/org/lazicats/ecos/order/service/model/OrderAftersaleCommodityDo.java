package org.lazicats.ecos.order.service.model;

/**
 * 
 * @ClassName: OrderAftersaleCommodityDo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-7-12 下午8:52:22
 *
 */
public class OrderAftersaleCommodityDo implements java.io.Serializable {

	// Fields

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String id;
	/**退换货订单编号*/
	private String aftersaleNo;
	/**商品名*/
	private String prodName;
	/**价格*/
	private Double price;
	/**退货数量*/
	private Integer quantity;
	/**购买数量**/
	private Integer buyQuantity;
	/**优惠减扣金额*/
	private Double disccountAmount;
	/**退款小计*/
	private Double refundAmount;
	
	/**货品编号*/
	private String prodNo;
	// Constructors
	/***图片路径**/
	private String picPath;
	
	/**
	 * 是否为赠品与换购品
	 */
	private Integer itemType;      //0  赠品,1 条目 ,2 组合商品条目,3 换购 , 4组合包活动商品
	/** default constructor */
	public OrderAftersaleCommodityDo() {
	}

	/** minimal constructor */
	public OrderAftersaleCommodityDo(String id) {
		this.id = id;
	}

	/** full constructor */
	public OrderAftersaleCommodityDo(String id, String aftersaleNo,
			String prodName, Double price, Integer quantity,
			Double disccountAmount, Double refundAmount) {
		this.id = id;
		this.aftersaleNo = aftersaleNo;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
		this.disccountAmount = disccountAmount;
		this.refundAmount = refundAmount;
	}
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

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getDisccountAmount() {
		return this.disccountAmount;
	}

	public void setDisccountAmount(Double disccountAmount) {
		this.disccountAmount = disccountAmount;
	}

	public Double getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Integer getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(Integer buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
}
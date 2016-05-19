package org.lazicats.ecos.internal.jlscm.model;

import java.io.Serializable;

/**
 * @FileName SplistOrder.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午6:00:00
 * 
 */
public class SplistOrder  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//子订单号
	private String OrderItemId;
	//电商SKU_ID
	private String Sku_Id;
	//商品内码
	private String ProductID;
	//商品标题名称
	private String Sp_Title;
	//商品原价
	private String Price;
	//商品数量
	private String Num;
	//商品总金额
	private String Total_Fee;
	//手工调整金额
	private String Adjust_Fee_Item;
	//优惠金额
	private String Discount_Fee_Item;
	//商品实付金额
	private String Payment_Item;
	//仓库代码
	private String WhNo;
	
	private String DHAZ;
	private String HZFS;
	
	public String getOrderItemId() {
		return OrderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		OrderItemId = orderItemId;
	}
	public String getWhNo() {
		return WhNo;
	}
	public void setWhNo(String whNo) {
		WhNo = whNo;
	}
	public String getSku_Id() {
		return Sku_Id;
	}
	public void setSku_Id(String sku_Id) {
		Sku_Id = sku_Id;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getSp_Title() {
		return Sp_Title;
	}
	public void setSp_Title(String sp_Title) {
		Sp_Title = sp_Title;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getTotal_Fee() {
		return Total_Fee;
	}
	public void setTotal_Fee(String total_Fee) {
		Total_Fee = total_Fee;
	}
	public String getAdjust_Fee_Item() {
		return Adjust_Fee_Item;
	}
	public void setAdjust_Fee_Item(String adjust_Fee_Item) {
		Adjust_Fee_Item = adjust_Fee_Item;
	}
	public String getDiscount_Fee_Item() {
		return Discount_Fee_Item;
	}
	public void setDiscount_Fee_Item(String discount_Fee_Item) {
		Discount_Fee_Item = discount_Fee_Item;
	}
	public String getPayment_Item() {
		return Payment_Item;
	}
	public void setPayment_Item(String payment_Item) {
		Payment_Item = payment_Item;
	}
	public String getDHAZ() {
		return DHAZ;
	}
	public void setDHAZ(String dHAZ) {
		DHAZ = dHAZ;
	}
	public String getHZFS() {
		return HZFS;
	}
	public void setHZFS(String hZFS) {
		HZFS = hZFS;
	}
	
  }

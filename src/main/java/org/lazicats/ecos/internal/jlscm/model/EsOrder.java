package org.lazicats.ecos.internal.jlscm.model;

import java.io.Serializable;
import java.util.List;

/**
 * @FileName EsOrder.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午5:44:19
 * 
 */
public class EsOrder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//电商订单号
	private String OrderId;
	//订单创建时间
	private String Created;
	//订单修改时间
	private String Modified;
	//订单付款时间
	private String Pay_Time;
	//交易结束时间
	private String End_Time;
	//单据状态
	private String Status;
	//物流方式
	private String Shipping_Type;
	//店铺名称
	private String Title;
	//卖家昵称
	private String Seller_Nick;
	//买家昵称
	private String Buyer_Nick;
	//商品总金额（原价）
	private String Total_Fee;
	//实付金额（成交价）
	private String Payment;
	//手工调整金额
	private String Adjust_Fee;
	//优惠金额
	private String Discount_Fee;
	//使用积分
	private String Point_Fee;
	//获得积分
	private String Buyer_Obtain_Point_Fee;
	//邮费
	private String Post_Fee;
	//卖家备注
	private String Seller_Memo;
	//买家留言
	private String Buyer_Message;
	//收货人名字
	private String Receiver_Name;
	//收货人省份
	private String Receiver_State;
	//收货人城市
	private String Receiver_City;
	//收货人地区
	private String Receiver_District;
	//收货人地址
	private String Receiver_Address;
	//收货人邮编
	private String Receiver_Zip;
	//收货人移动电话
	private String Receiver_Mobile;
	//收货人固定电话
	private String Receiver_Phone;
	//是否需要发票
	private String invoice;
	//发票抬头   
	private String invoice_Name;
	//
	private String SysTemCon="1";
	//子订单
	private List<SplistOrder> SPLIST;
	
	private List<EsPaymentOrder> PAYLIST;

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}


	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public String getModified() {
		return Modified;
	}

	public void setModified(String modified) {
		Modified = modified;
	}

	public String getPay_Time() {
		return Pay_Time;
	}

	public void setPay_Time(String pay_Time) {
		Pay_Time = pay_Time;
	}

	public String getEnd_Time() {
		return End_Time;
	}

	public void setEnd_Time(String end_Time) {
		End_Time = end_Time;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getShipping_Type() {
		return Shipping_Type;
	}

	public void setShipping_Type(String shipping_Type) {
		Shipping_Type = shipping_Type;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSeller_Nick() {
		return Seller_Nick;
	}

	public void setSeller_Nick(String seller_Nick) {
		Seller_Nick = seller_Nick;
	}

	public String getBuyer_Nick() {
		return Buyer_Nick;
	}

	public void setBuyer_Nick(String buyer_Nick) {
		Buyer_Nick = buyer_Nick;
	}

	public String getTotal_Fee() {
		return Total_Fee;
	}

	public void setTotal_Fee(String total_Fee) {
		Total_Fee = total_Fee;
	}

	public String getPayment() {
		return Payment;
	}

	public void setPayment(String payment) {
		Payment = payment;
	}

	public String getAdjust_Fee() {
		return Adjust_Fee;
	}

	public void setAdjust_Fee(String adjust_Fee) {
		Adjust_Fee = adjust_Fee;
	}

	public String getDiscount_Fee() {
		return Discount_Fee;
	}

	public void setDiscount_Fee(String discount_Fee) {
		Discount_Fee = discount_Fee;
	}

	public String getPoint_Fee() {
		return Point_Fee;
	}

	public void setPoint_Fee(String point_Fee) {
		Point_Fee = point_Fee;
	}

	public String getBuyer_Obtain_Point_Fee() {
		return Buyer_Obtain_Point_Fee;
	}

	public void setBuyer_Obtain_Point_Fee(String buyer_Obtain_Point_Fee) {
		Buyer_Obtain_Point_Fee = buyer_Obtain_Point_Fee;
	}

	public String getPost_Fee() {
		return Post_Fee;
	}

	public void setPost_Fee(String post_Fee) {
		Post_Fee = post_Fee;
	}

	public String getSeller_Memo() {
		return Seller_Memo;
	}

	public void setSeller_Memo(String seller_Memo) {
		Seller_Memo = seller_Memo;
	}

	public String getBuyer_Message() {
		return Buyer_Message;
	}

	public void setBuyer_Message(String buyer_Message) {
		Buyer_Message = buyer_Message;
	}

	public String getReceiver_Name() {
		return Receiver_Name;
	}

	public void setReceiver_Name(String receiver_Name) {
		Receiver_Name = receiver_Name;
	}

	public String getReceiver_State() {
		return Receiver_State;
	}

	public void setReceiver_State(String receiver_State) {
		Receiver_State = receiver_State;
	}

	public String getReceiver_City() {
		return Receiver_City;
	}

	public void setReceiver_City(String receiver_City) {
		Receiver_City = receiver_City;
	}

	public String getReceiver_District() {
		return Receiver_District;
	}

	public void setReceiver_District(String receiver_District) {
		Receiver_District = receiver_District;
	}

	public String getReceiver_Address() {
		return Receiver_Address;
	}

	public void setReceiver_Address(String receiver_Address) {
		Receiver_Address = receiver_Address;
	}

	public String getReceiver_Zip() {
		return Receiver_Zip;
	}

	public void setReceiver_Zip(String receiver_Zip) {
		Receiver_Zip = receiver_Zip;
	}

	public String getReceiver_Mobile() {
		return Receiver_Mobile;
	}

	public void setReceiver_Mobile(String receiver_Mobile) {
		Receiver_Mobile = receiver_Mobile;
	}

	public String getReceiver_Phone() {
		return Receiver_Phone;
	}

	public void setReceiver_Phone(String receiver_Phone) {
		Receiver_Phone = receiver_Phone;
	}


	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getInvoice_Name() {
		return invoice_Name;
	}

	public void setInvoice_Name(String invoice_Name) {
		this.invoice_Name = invoice_Name;
	}

	public List<SplistOrder> getSPLIST() {
		return SPLIST;
	}

	public void setSPLIST(List<SplistOrder> sPLIST) {
		SPLIST = sPLIST;
	}

	public String getSysTemCon() {
		return SysTemCon;
	}

	public void setSysTemCon(String sysTemCon) {
		SysTemCon = sysTemCon;
	}

	public List<EsPaymentOrder> getPAYLIST() {
		return PAYLIST;
	}

	public void setPAYLIST(List<EsPaymentOrder> pAYLIST) {
		PAYLIST = pAYLIST;
	}

}

package org.lazicats.ecos.internal.jlscm.model;

import java.io.Serializable;

/**
 * @FileName RefundEsOrder.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午7:02:47
 * 
 */
public class RefundEsOrder  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//电商订单号
	private String OrderId;
	//电商退单号
	private String refund_id;
	//单据状态
	private String Status;
	//卖家昵称
	private String seller_nick;
	//买家昵称
	private String buyer_nick;
	//单据创建时间
	private String created;
	//单据修改时间
	private String modified;
	//订单状态
	private String order_status;
	//商品标题
	private String title;
	//总价
	private String total_fee;
	//退还给买家的金额
	private String refund_fee;
	//子订单号
	private String OrderItemId;
	//商品状态
	private String good_status;
	//是否需要退货
	private String has_good_return;
	//数量
	private String num;
	//支付给卖家的金额
	private String payment;
	//退货理由
	private String reason;
	//卖家收货地址
	private String address;
	//退款说明
	private String desc;
	//物流公司名称
	private String company_name;
	//退货运单号
	private String sid;
	//
	private String SysTemCon="1";
	
	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public String getSysTemCon() {
		return SysTemCon;
	}

	public void setSysTemCon(String sysTemCon) {
		SysTemCon = sysTemCon;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getSeller_nick() {
		return seller_nick;
	}

	public void setSeller_nick(String seller_nick) {
		this.seller_nick = seller_nick;
	}

	public String getBuyer_nick() {
		return buyer_nick;
	}

	public void setBuyer_nick(String buyer_nick) {
		this.buyer_nick = buyer_nick;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		OrderItemId = orderItemId;
	}

	public String getGood_status() {
		return good_status;
	}

	public void setGood_status(String good_status) {
		this.good_status = good_status;
	}

	public String getHas_good_return() {
		return has_good_return;
	}

	public void setHas_good_return(String has_good_return) {
		this.has_good_return = has_good_return;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
}
  
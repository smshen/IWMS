package org.lazicats.ecos.internal.payment.vo;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-23上午11:34:04
 * 
 * @类说明：订单查询返回对象
 */

public class QueryOrderMessage {

	private boolean success;// 是否成功，true：成功 false：失败
	private String order;// 订单号
	private String amount;// 金额
	private String message;// 详细信息
	private String orderPayNo; //订单支付流水号

	public boolean isSuccess() {
		return success;
	}

	public boolean getIsSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderPayNo() {
		return orderPayNo;
	}

	public void setOrderPayNo(String orderPayNo) {
		this.orderPayNo = orderPayNo;
	}

}

package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/**
 * 
 * @ClassName: OrderInvoiceVo 
 * @Description: TODO
 * @author: Stanley
 * @date 2013-3-25 下午4:24:18
 *
 */
public class OrderInvoiceDo implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String invoiceNo;         //发票编号
	private String orderNo;           //订单编号
	private String invoiceNum;        //发票-票号
	private String invoiceType;       //发票类型(1普通,2增值税)
	private String invoiceTitleType;  //抬头类型(1个人,2单位...)
	private String invoiceTitle;      //发票抬头(个人或单位名称 )
	private String taxpayerNo;        //纳税人识别号
	private String registAddress;     //注册地址
	private String registPhone;       //注册电活
	private String bankName;          //开户行
	private String bankAccount;        //银行账户
	private String detail;           //发票内容(1.明细,2办公用品(附件清单),3.电脑配件,4.耗材等)
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceTitleType() {
		return invoiceTitleType;
	}
	public void setInvoiceTitleType(String invoiceTitleType) {
		this.invoiceTitleType = invoiceTitleType;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getTaxpayerNo() {
		return taxpayerNo;
	}
	public void setTaxpayerNo(String taxpayerNo) {
		this.taxpayerNo = taxpayerNo;
	}
	public String getRegistAddress() {
		return registAddress;
	}
	public void setRegistAddress(String registAddress) {
		this.registAddress = registAddress;
	}
	public String getRegistPhone() {
		return registPhone;
	}
	public void setRegistPhone(String registPhone) {
		this.registPhone = registPhone;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}

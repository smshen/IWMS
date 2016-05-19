package org.lazicats.ecos.internal.payment.common.Upoppay.model;


/**
 * Param Class for UPOP payment,used to create a html form for the current payment.
 * @author Jay
 *	
 */
public class UPOPPaymentParam{
	private String orderNo; //订单号
	private String orderAmount; //订单金额（货款+运费+税费）
	private String reserved01="";
	private String reserved02="";
	
	private String merId; //商户编号
	private String pkey; //商户公匙
	private String currCode; //货币种类
	private String callBackUrl; //支付成功后的回调返回商城地址
	private String entryMode = ""; //入口模式
	private String bankCode; //支付银行代号
	private String orderType; //订单类型（e.g. BC,BBC）
	private String resultMode; //支付结果返回方式(0-成功和失败支付结果均返回；1-仅返回成功支付结果)
	private String buzType;
	private String LangType; 

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getPkey() {
		return pkey;
	}
	public void setPkey(String pkey) {
		this.pkey = pkey;
	}
	public String getCurrCode() {
		return currCode;
	}
	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}
	public String getCallBackUrl() {
		return callBackUrl;
	}
	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}
	public String getEntryMode() {
		return entryMode;
	}
	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getResultMode() {
		return resultMode;
	}
	public void setResultMode(String resultMode) {
		this.resultMode = resultMode;
	}
	public String getReserved01() {
		return reserved01;
	}
	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}
	public String getReserved02() {
		return reserved02;
	}
	public void setReserved02(String reserved02) {
		this.reserved02 = reserved02;
	}

	public String getLangType() {
		return LangType;
	}

	public void setLangType(String langType) {
		LangType = langType;
	}

	public String getBuzType() {
		return buzType;
	}

	public void setBuzType(BusinessType buzType) {
		this.buzType = buzType.getCode();
	}

	public boolean validate() {
		
		return true;
	}
	
	public String getSourceStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.merId);
		sb.append(this.orderNo);
		sb.append(this.orderAmount);
		sb.append(this.currCode);
		sb.append(this.orderType);
		sb.append(this.callBackUrl);
		sb.append(this.bankCode);
		sb.append(this.LangType);
		sb.append(this.buzType);
		//sb.append(this.resultMode);
		//sb.append(this.entryMode);
		sb.append(this.reserved01);
		sb.append(this.reserved02);
		return sb.toString();
	}
}

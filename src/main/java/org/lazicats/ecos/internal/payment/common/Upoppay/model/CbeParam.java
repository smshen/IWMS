package org.lazicats.ecos.internal.payment.common.Upoppay.model;

import org.apache.commons.lang.StringUtils;


public class CbeParam extends Param{
	private static final long serialVersionUID = 9203590023070152204L;

	public enum CredentialsType{
		ID("01");
		private String code;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}

		CredentialsType(String code){
			this.code = code;
		}
	}
	
	
	/*private String realName; //持卡人真实姓名
	private String credentialsType; //证件类型
	private String credentialsNo; //证件号码
	private String goodsAmount; //货款
	private String taxAmount; //税款
	private String freight; //运费
	private String mobile;
	private String email;*/
	
    
	public void setEcommerceCode(String eCommerceCode){
		put("eCommerceCode",eCommerceCode);
	}
	
	public void setMerCode(String merCode){
		put("MerCode",merCode);
	}
	
	public void setRealName(String realName) {
		put("RealName", realName);
	}

	public void setCredentialsType(CredentialsType credentialsType) {
		put("CredentialsType", credentialsType.getCode());
	}

	public void setCredentialsNo(String credentialsNo) {
		put("CredentialsNo",credentialsNo);
	}
	
	public void setGoodsAmount(String goodsAmount) {
		put("GoodsAmount",goodsAmount);
	}

	public void setTaxAmount(String taxAmount) {
		put("TaxAmount",taxAmount);
	}
	
	public void setFreight(String freight) {
		put("freight",freight);
	}
	
	public void setMobile(String mobile) {
		if(StringUtils.isNotBlank(mobile))
		put("Mobile",mobile);
	}

	public void setEmail(String email) {
		if(StringUtils.isNotBlank(email))
		put("Email",email);	
	}
	
	//1.2版本添加的字段
	/**
	 * 
	 * @param bizTypeCode 直购进口：1 网购保税进口：2
	 */
	public void setBizTypeCode(String bizTypeCode){
		if(StringUtils.isNotBlank(bizTypeCode))
		put("BizTypeCode",bizTypeCode);
	}
	
	/**
	 * 
	 * @param oriOrderNo 商户上传给海关系统的订单号
	 */
	public void setOriOrderNo(String oriOrderNo){
		if(StringUtils.isNotBlank(oriOrderNo))
		put("OriOrderNo",oriOrderNo);
	}
	
	/**
	 * 
	 * @param paymentType 0：全款 1：货款 2：运费
	 */
	public void setPaymentType(String paymentType){
		if(StringUtils.isNotBlank(paymentType))
		put("PaymentType",paymentType);
	}
	
	/**
	 * 
	 * @param ieType  I：进口 E：出口
	 */
	public void setIEType(String ieType){
		if(StringUtils.isNotBlank(ieType))
		put("IEType",ieType);
	}
	
	/**
	 * 
	 * @param customsCode 5100：广州海关 4612：郑州保税 8001：重庆海关 3101：宁波海关 4601：郑州机办
	 */
	public void setCustomsCode(String customsCode){
		if(StringUtils.isNotBlank(customsCode))
		put("CustomsCode",customsCode);
	}
	
	/**
	 * 
	 * @param creTime 订单创建时间（格式：YYYYMMDDHHmmss）
	 */
	public void setCreTime(String creTime){
		if(StringUtils.isNotBlank(creTime))
		put("CreTime",creTime);
	}

    public static void main(String[] args) {
		CbeParam cbeP = new CbeParam();
		cbeP.setCredentialsType(CredentialsType.ID);
		cbeP.setCredentialsNo("2545455f5d5fd54");
		System.out.println(cbeP.get());
	}
}

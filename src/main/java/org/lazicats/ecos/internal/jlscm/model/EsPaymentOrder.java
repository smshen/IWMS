package org.lazicats.ecos.internal.jlscm.model;

/**
 * @FileName EsPaymentOrder.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-5-12下午3:34:42
 * 
 */
public class EsPaymentOrder {
	
	/**
	 * 支付方式编码
	 */
    private String pay_type;
     /**
      * 支付金额
      */
    private String payment_type;
     
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
     
     

}

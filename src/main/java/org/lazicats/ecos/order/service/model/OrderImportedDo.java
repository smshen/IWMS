package org.lazicats.ecos.order.service.model;

import java.io.Serializable;

/**
 * @author jun
 * @time 2015-8-31下午04:01:20
 * @title:OrderImportedDo.java
 */
public class OrderImportedDo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String identifyType;
    private String identifyCode;
    private String totalTax;
    private String paidTax;
    private String deliveryFee;
    private String orderNo;
    private String businessFee;
    private String deliveryCompany;
    private String deliveryNo;
    private Double additionalTaxes; //跨境订单税费累计
    private String relateOrderNo;//税费关联订单号
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIdentifyType() {
        return identifyType;
    }
    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }
    public String getIdentifyCode() {
        return identifyCode;
    }
    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }
    public String getTotalTax() {
        return totalTax;
    }
    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }
    public String getPaidTax() {
        return paidTax;
    }
    public void setPaidTax(String paidTax) {
        this.paidTax = paidTax;
    }
    public String getDeliveryFee() {
        return deliveryFee;
    }
    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getBusinessFee() {
        return businessFee;
    }
    public void setBusinessFee(String businessFee) {
        this.businessFee = businessFee;
    }
    public String getDeliveryCompany() {
        return deliveryCompany;
    }
    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }
    public String getDeliveryNo() {
        return deliveryNo;
    }
    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }
    public Double getAdditionalTaxes() {
        return additionalTaxes;
    }
    public void setAdditionalTaxes(Double additionalTaxes) {
        this.additionalTaxes = additionalTaxes;
    }
    public String getRelateOrderNo() {
        return relateOrderNo;
    }
    public void setRelateOrderNo(String relateOrderNo) {
        this.relateOrderNo = relateOrderNo;
    }
    
    
}

package org.lazicats.ecos.erp.financial.service.model;

import java.io.Serializable;

/**
 * 代销结算活动明细表 jay
 * @author Steven
 *
 */
public class ErpFinancialSaleByProxyActivityDo implements Serializable {

	private static final long serialVersionUID = -159760805375932845L;

	/**
     * erp_financial_sale_by_proxy_activity.info_id (关联代销结算明细ID)
     * @ibatorgenerated 2013-08-30 17:01:17
     */
    private Integer infoId;

    /**
     * erp_financial_sale_by_proxy_activity.activity_code (活动编码)
     * @ibatorgenerated 2013-08-30 17:01:17
     */
    private String activityCode;

    /**
     * erp_financial_sale_by_proxy_activity.discount_amount (优惠金额)
     * @ibatorgenerated 2013-08-30 17:01:17
     */
    private Double discountAmount;

    /**
     * erp_financial_sale_by_proxy_activity.supplier_ratio (供应商承担比例)
     * @ibatorgenerated 2013-08-30 17:01:17
     */
    private Double supplierRatio;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getSupplierRatio() {
        return supplierRatio;
    }

    public void setSupplierRatio(Double supplierRatio) {
        this.supplierRatio = supplierRatio;
    }
}
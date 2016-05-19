package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: ProdPriceDo
 * @Description: 货品价格
 * @author: Hualong
 * @date 2013-2-28 下午02:25:55
 * 
 */
public class ProdPriceDo implements Serializable {

    /** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	private String commoNo;
    private String prodNo;
    private double marketPrice;
    private double sellPrice;
    private String channelNo;// 渠道编号
    private String operatorNo;
    private Date operatorTime;

    public String getCommoNo() {
        return this.commoNo;
    }

    public void setCommoNo(String commoNo) {
        this.commoNo = commoNo;
    }

    public String getProdNo() {
        return this.prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public double getMarketPrice() {
        return this.marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getSellPrice() {
        return this.sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getChannelNo() {
        return this.channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getOperatorNo() {
        return this.operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public Date getOperatorTime() {
        return this.operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

}

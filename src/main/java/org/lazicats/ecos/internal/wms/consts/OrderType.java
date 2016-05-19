package org.lazicats.ecos.internal.wms.consts;

/**
 * 订单类型
 * @author Jay 2
 */
public enum OrderType {
	SALE_EXWH("1"),
	PURCHASE_RETURN("2"),
	ALLOTRANSFER_EXWH("5"),
	SALE_EXCHANGE("10");
	
	private String code;
	
	private OrderType(String code) {
		this.code = code;
	}
	
	public String code(){
		return this.code;
	}

}

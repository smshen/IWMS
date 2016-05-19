/**  
 * @Project: ECW-Mall
 * @Title: PayResultVo.java
 * @Package org.lazicats.ecos.mall.view.pay.vo
 * @Description: TODO
 * @author: chengyuanhuan
 * @date 2013-8-30 下午9:16:05
 * @Copyright: BroadenGate Software Services Co.,Ltd. All rights reserved.
 * @version V1.0  
 */
package org.lazicats.ecos.internal.payment.vo;

public class PayResultVo {

	private boolean bool = false;
	private String orderNo = "";

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
	public boolean getBool(){
		return bool;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}

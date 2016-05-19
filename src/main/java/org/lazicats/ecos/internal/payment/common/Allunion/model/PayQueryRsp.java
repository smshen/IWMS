package org.lazicats.ecos.internal.payment.common.Allunion.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="VSPPEXRsp")
public class PayQueryRsp extends PayQuery{
	
	
	private String rspcode; //0000表示成功,9999已缴费,9995不在缴款时间范围内,9990非法订单号，
							//1999表示订单号合法但需要输入订单金额等信息
	private String rspmsg; //o
	private long amount; //单位为分

	
	public String getRspcode() {
		return rspcode;
	}

	public void setRspcode(String rspcode) {
		this.rspcode = rspcode;
	}
	public String getRspmsg() {
		return rspmsg;
	}
	public void setRspmsg(String rspmsg) {
		this.rspmsg = rspmsg;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	

	@Override
	public String toString() {
		return "QueryResl [rspcode=" + rspcode + ", rspmsg=" + rspmsg
				+ ", amount=" + amount + "]" + super.toString();
	}

}

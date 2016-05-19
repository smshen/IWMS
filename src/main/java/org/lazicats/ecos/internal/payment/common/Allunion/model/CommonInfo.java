package org.lazicats.ecos.internal.payment.common.Allunion.model;

import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * param for order inquiry
 * @author Jay
 *
 */
public class CommonInfo {
	/**
	 * 交易类型  (8)
	 */
	
	private String trxcod; 	
	
	/**
	 * 支付机构编号 
	 */
	private String payinst;
	
	/**
	 * 企业编号
	 */
	private String entinst;
	private String timestamp;	//交易时间 (yyyymmddhhmmss)
	private String mac; //32bit mac encrytion
	private String bizseq; //业务流水
	
	
	public String getTrxcod() {
		return trxcod;
	}
	public void setTrxcod(String trxcod) {
		this.trxcod = trxcod;
	}
	public String getPayinst() {
		return payinst;
	}
	public void setPayinst(String payinst) {
		this.payinst = payinst;
	}
	public String getEntinst() {
		return entinst;
	}
	public void setEntinst(String entinst) {
		this.entinst = entinst;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getBizseq() {
		return bizseq;
	}
	public void setBizseq(String bizseq) {
		this.bizseq = bizseq;
	}
	
	@Override
	public String toString() {
		return "QueryParam [trxcod=" + trxcod + ", payinst=" + payinst
				+ ", entinst=" + entinst + ", timestamp=" + timestamp
				+ ", mac=" + mac + ", bizseq=" + bizseq + "]";
	}
	

}

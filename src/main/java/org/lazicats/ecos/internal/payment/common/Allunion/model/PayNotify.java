package org.lazicats.ecos.internal.payment.common.Allunion.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="VSPPEXReq")
public class PayNotify extends CommonInfo{
	private String payresult;
	private long amount;
	private String payseq;
	private String trxid;
	private String termid;
	private String traceno;
	private String content;
	public String getPayresult() {
		return payresult;
	}
	public void setPayresult(String payresult) {
		this.payresult = payresult;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getPayseq() {
		return payseq;
	}
	public void setPayseq(String payseq) {
		this.payseq = payseq;
	}
	public String getTrxid() {
		return trxid;
	}
	public void setTrxid(String trxid) {
		this.trxid = trxid;
	}
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	public String getTraceno() {
		return traceno;
	}
	public void setTraceno(String traceno) {
		this.traceno = traceno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PayResl [payresult=" + payresult + ", amount=" + amount
				+ ", payseq=" + payseq + ", trxid=" + trxid + ", termid="
				+ termid + ", traceno=" + traceno + ", content=" + content
				+ "]";
	}
	
	
	

}

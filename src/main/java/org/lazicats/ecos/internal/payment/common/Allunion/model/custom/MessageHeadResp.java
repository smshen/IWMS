package org.lazicats.ecos.internal.payment.common.Allunion.model.custom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class MessageHeadResp extends HeadCommon{
	private String commCode;
	private String bizStatus;
	
	@XmlElement(name="CommCode")
	public String getCommCode() {
		return commCode;
	}
	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}
	
	@XmlElement(name="BizStatus")
	public String getBizStatus() {
		return bizStatus;
	}
	public void setBizStatus(String bizStatus) {
		this.bizStatus = bizStatus;
	}
	@Override
	public String toString() {
		return "MessageHeadResp [commCode=" + commCode + ", bizStatus="
				+ bizStatus + "]" + super.toString();
	}
	
	
	
}

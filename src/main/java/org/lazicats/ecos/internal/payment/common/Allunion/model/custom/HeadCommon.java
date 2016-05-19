package org.lazicats.ecos.internal.payment.common.Allunion.model.custom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


@XmlSeeAlso(MessageHead.class)
@XmlRootElement(name="MessageHead")
public class HeadCommon {
	
	private String messageId;
	private String senderId;
	private String sendTime;
	private String sign;
	
	
	@XmlElement(name="MessageID")
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	@XmlElement(name="SenderID")
	public String getSenderId() {
		return senderId;
	}
	
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	@XmlElement(name="SendTime")
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	@XmlElement(name="Sign")
	public String getSign() {
		return sign;
	}
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "HeadCommon [messageId=" + messageId + ", senderId=" + senderId
				+ ", sendTime=" + sendTime + ", sign=" + sign + "]";
	}

}

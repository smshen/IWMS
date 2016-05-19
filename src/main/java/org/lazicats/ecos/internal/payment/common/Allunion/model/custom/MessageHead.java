package org.lazicats.ecos.internal.payment.common.Allunion.model.custom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"messageCode","messageId","senderId","sendTime","sign"})
@XmlRootElement(name="MessageHead")
public class MessageHead{
	private String messageCode;
	@XmlElement(name="MessageCode")
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
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
		return "MessageHead [messageCode=" + messageCode + "]";
	}
	
	
}

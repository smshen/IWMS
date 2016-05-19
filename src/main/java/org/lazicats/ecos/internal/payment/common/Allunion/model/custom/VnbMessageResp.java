package org.lazicats.ecos.internal.payment.common.Allunion.model.custom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="VnbMessage")
@XmlType(propOrder= {"messageHead","messageBodies"})
public class VnbMessageResp {
	private MessageHeadResp messageHead;
	private List<MessageBody> messageBodies = new ArrayList<MessageBody>();
	@XmlElement(name="MessageHead")
	public MessageHeadResp getMessageHead() {
		return messageHead;
	}
	public void setMessageHead(MessageHeadResp messageHead) {
		this.messageHead = messageHead;
	}
	
	@XmlElementWrapper(name="MessageBodyList")
	@XmlElement(name="MessageBody")
	public List<MessageBody> getMessageBodies() {
		return messageBodies;
	}
	public void setMessageBodies(List<MessageBody> messageBodies) {
		this.messageBodies = messageBodies;
	}
	@Override
	public String toString() {
		return "VnbMessageResp [messageHead=" + messageHead
				+ ", messageBodies=" + messageBodies + "]";
	}
	
	
}

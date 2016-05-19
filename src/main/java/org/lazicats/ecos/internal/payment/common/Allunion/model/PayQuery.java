package org.lazicats.ecos.internal.payment.common.Allunion.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VSPPEXReq")
public class PayQuery extends CommonInfo{
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
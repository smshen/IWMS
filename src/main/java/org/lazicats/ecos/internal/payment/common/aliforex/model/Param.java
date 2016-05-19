package org.lazicats.ecos.internal.payment.common.aliforex.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="param")
public class Param {
	private String name;
	private String textContent;
	
	@XmlValue
	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Param [name=" + name + ", textContent=" + textContent + "]";
	}
	
	
}

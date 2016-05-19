package org.lazicats.ecos.internal.payment.common.aliforex.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class QResponse {
	private Trade trade;
	
	@XmlElement
	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	@Override
	public String toString() {
		return "QResponse [trade=" + trade + "]";
	}
	
	
	
	
}

package org.lazicats.ecos.internal.payment.common.aliforex.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="alipay")
public class QueryResp {
	
	private String is_success;
	private List<Param> request;
	private QResponse response;
	private String sign;
	private String sign_type;
	
	
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	@XmlElement
	public QResponse getResponse() {
		return response;
	}

	public void setResponse(QResponse response) {
		this.response = response;
	}

	public String getRequestParam(String key) {
		for (Param param : request) {
			if(param.getName().equals(key)) {
				return param.getTextContent();
			}
		}
		
		return null;
	}
	
	@XmlElementWrapper(name="request")
	@XmlElement(name="param")
	public List<Param> getRequest() {
		return request;
	}
	
	public void setRequest(List<Param> request) {
		this.request = request;
	}
	@XmlElement(name = "is_success")
	public String getIs_success() {
		return is_success;
	}
	public void setIs_success(String is_success) {
		this.is_success = is_success;
	}


	
	


	private String error;
	
	
	
	
	@XmlElement(name = "error")
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}



	



}

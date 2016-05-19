package org.lazicats.ecos.internal.jlscm.model;

/**
 * @FileName Message.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午5:13:02
 * 
 */
public class Message {
	
	private String jlstate;
	
	private String ordeId;
	
	private String error;

	public String getJlstate() {
		return jlstate;
	}

	public void setJlstate(String jlstate) {
		this.jlstate = jlstate;
	}

	public String getOrdeId() {
		return ordeId;
	}

	public void setOrdeId(String ordeId) {
		this.ordeId = ordeId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}

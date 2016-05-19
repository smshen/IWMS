package org.lazicats.ecos.internal.jlscm.model;

/**
 * @FileName JLMessage.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-2-25下午6:09:06
 * 
 */
public class JLMessage {
	
	private String JL_State;
	
	private String OrdeId;
	
	private String error;

	public String getJL_State() {
		return JL_State;
	}

	public void setJL_State(String jL_State) {
		JL_State = jL_State;
	}

	public String getOrdeId() {
		return OrdeId;
	}

	public void setOrdeId(String ordeId) {
		OrdeId = ordeId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	

}

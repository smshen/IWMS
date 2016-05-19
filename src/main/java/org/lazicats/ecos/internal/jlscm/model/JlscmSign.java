package org.lazicats.ecos.internal.jlscm.model;

/**
 * @FileName JlscmSign.java
 * @PackageName org.lazicats.ecos.internal.jlscm.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-9上午10:47:12
 * 
 */
public class JlscmSign {
	
	private String Parms;
	
	private String Sign;
	
	public  JlscmSign(){
		
	}
	
	public  JlscmSign(String parms,String sign){
		this.Parms=parms;
		this.Sign=sign;
	}

	public String getParms() {
		return Parms;
	}

	public void setParms(String parms) {
		Parms = parms;
	}

	public String getSign() {
		return Sign;
	}

	public void setSign(String sign) {
		Sign = sign;
	}
	
	

}

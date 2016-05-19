package org.lazicats.ecos.internal.phoneSms.model;

import java.io.Serializable;
/**
 * 
 * @author Administrator
 *	短信接口需要的信息
 */

public class PhoneInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mobileStr ;//电话号码
	private String content ;//短信内容，超过260个字符部分会被截断(必填)
	private long smId ;//短信ID，0到99999999中的某一整数。确保唯一后可以用来找到对应的回执、回复。缺省值0。（可为空）
	private int smType;//是否WAP Push短信的标识，1：表示是，0：表示否，默认为0
	private String url ;//WAP Push短信的URL，为“”或null时则发送常规短信。
	private String host ;//ip地址
	private String dbName ;//数据库名
	private String apiId ;//API编码
	private String name ;//用户名
	private String pwd ;//密码
	public String getMobileStr() {
		return mobileStr;
	}
	public void setMobileStr(String mobileStr) {
		this.mobileStr = mobileStr;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getSmId() {
		return smId;
	}
	public void setSmId(long smId) {
		this.smId = smId;
	}
	public int getSmType() {
		return smType;
	}
	public void setSmType(int smType) {
		this.smType = smType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getApiId() {
		return apiId;
	}
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}

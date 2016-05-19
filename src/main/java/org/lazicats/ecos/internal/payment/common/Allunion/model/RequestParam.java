package org.lazicats.ecos.internal.payment.common.Allunion.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="RequestParam")
public class RequestParam {
	private int age;

	private String gender;

	private int id;

	private String name;

	private String password;

	private String role;
	
	private RealNameInfo realNameInfo;
	
	@XmlElement(name="RealNameInfo")
	public RealNameInfo getRealNameInfo() {
		return realNameInfo;
	}

	public void setRealNameInfo(RealNameInfo realNameInfo) {
		this.realNameInfo = realNameInfo;
	}
	
	
	@XmlRootElement(name="RealNameInfo")
	static class RealNameInfo{
		private String id;
		private String name;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "RealNameInfo [id=" + id + ", name=" + name + "]";
		}
		
		
	}
	
	@XmlElement(name="Age")
	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RequestParam [age=" + age + ", gender=" + gender + ", id=" + id
				+ ", name=" + name + ", password=" + password + ", role="
				+ role + ", realNameInfo=" + realNameInfo + "]";
	}

	
}

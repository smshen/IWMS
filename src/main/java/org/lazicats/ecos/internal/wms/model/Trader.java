package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;

/*
 * 单位（供应商，物流商，仓库）
 */
public class Trader implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number="";
    private String alphabetical="";
    private String name="";
    private String shortName="";
    private int type;
    private String zone="";
	private String address="";
    private String postCode="";
    private String contract="";
    private String tel="";
    private String phone="";
    private String fax="";
    private int status;
    private String  monthlYaccount="";//月结账号
    private String  monthLyno="";//月结号
    
    /**
     * 获取单位编号
     * @return
     */
    public String getNumber() {
		return number;
	}
	/**
     * 设置单位编号
     * @param number
     */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取单位拼音
	 * @return
	 */
	public String getAlphabetical() {
		return alphabetical;
	}
	/**
	 * 设置单位拼音
	 * @param alphabetical
	 */
	public void setAlphabetical(String alphabetical) {
		this.alphabetical = alphabetical;
	}
	
	/**
	 * 获取单位名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置单位名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取单位简称
	 * @return
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * 设置单位简称
	 * @param shortName
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	/**
	 * 获取单位类型
	 * 1.供应商
	 * 2.物流商
	 * 3.仓库
	 * @return
	 */
	public int getType() {
		return type;
	}
	/**
	 * 设置单位类型
	 * 1.供应商
	 * 2.物流商
	 * 3.仓库
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * 获取单位所属的地区
	 * 格式：省市区（广东省深圳市南山区）
	 * @return
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * 设置单位所属的地区
	 * 格式：省市区（广东省深圳市南山区）
	 * @param zone
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * 获取单位的详细地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置单位的详细地址
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取单位所属地区的邮编
	 * @return
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 设置单位所属地区的邮编
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 获取联系人
	 * @return
	 */
	public String getContract() {
		return contract;
	}
	/**
	 * 设置联系人
	 * @param contract
	 */
	public void setContract(String contract) {
		this.contract = contract;
	}
    /**
     * 获取电话号码
     * @return
     */
    public String getTel() {
		return tel;
	}
    /**
     * 设置电话号码
     * @param tel
     */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取手机号码
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置手机号码
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取传真号码
	 * @return
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置传真号码
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMonthlYaccount() {
		return monthlYaccount;
	}
	public void setMonthlYaccount(String monthlYaccount) {
		this.monthlYaccount = monthlYaccount;
	}
	public String getMonthLyno() {
		return monthLyno;
	}
	public void setMonthLyno(String monthLyno) {
		this.monthLyno = monthLyno;
	}
	
	
	
}

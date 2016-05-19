
package org.lazicats.ecos.order.service.model;

import java.util.ArrayList;
import java.util.List;

/** 
 * 退款支付细项枚举类    
 * Copyright (c) BRORDENGATE SOFTWARE INFRASTRUCTURE ,LTD. 
 * @createDate: 2013-11-25 上午11:40:52
 * @author <a href="mailto:justin.t.wang@163.com">王耀军(justin.t.wang)</a>
 * @version 1.0
 */
public enum RefundPatternEnum {
	
	Alipay(101, "支付宝", 1, 2),
	UnionPay(102, "银联在线", 1, 2),
	_99Bill(103, "快钱", 1, 2),
	
	Boc(104, "中国银行", 1, 1),
	Ccb(105, "建设银行", 1, 1),
	Abc(106, "农业银行", 1, 1),
	Icbc(107, "工商银行", 1, 1),
	
	
	COD_TPPP(201, "第三方平台", 2, 3),
	COD_Bank(201, "银行账号", 2, 1),
	
	
	ShopPay(301, "门店退款", 3, 0),
	
	
	VirtualAccount(401, "电子钱包", 4, 0),

	
	Other(999, "其他", 0, 0);
	
	private Integer parentKey; 		// 支付大项Key 1.
	private Integer key;			// 支付细项key
	private Integer platformType;	// 平台类型 0.无平台 1.银行 2.第三方支付平台
	private String value;			// 支付细项名称
	private List<Properties> properties;	// 细项属性
	
	private RefundPatternEnum(Integer key, String value, Integer parentKey,Integer platformType){
		this.key = key;
		this.value = value;
		this.parentKey = parentKey;
		this.platformType = platformType;
		this.properties = getPropertiesByPlatformType(platformType);
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Integer getParentKey() {
		return parentKey;
	}

	public void setParentKey(Integer parentKey) {
		this.parentKey = parentKey;
	}

	public Integer getPlatformType() {
		return platformType;
	}

	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}

	public List<Properties> getProperties() {
		return properties;
	}

	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}

	public static String getValueByKey(Integer key) {
		for(RefundPatternEnum pattern : RefundPatternEnum.values()) {
			if(key.equals(pattern.getKey())) {
				return pattern.getValue();
			}
		}
		return Other.getValue();
	}
	
	
	public static Integer getKeyByValue(String value) {
		for(RefundPatternEnum pattern : RefundPatternEnum.values()) {
			if(value.equals(pattern.getValue())) {
				return pattern.getKey();
			}
		}
		return Other.getKey();
	}
	
	private static List<Properties> getPropertiesByPlatformType(Integer platformType) {
		List<Properties> propertiesList = new ArrayList<RefundPatternEnum.Properties>();
		if(platformType.intValue() == 1) {
			Properties receiveName = new Properties("receiveName","开户人姓名");
			Properties receiveBank = new Properties("receiveBank","开户行");
			Properties opeingBank = new Properties("opeingBank","支行名称");
			Properties receiveAccount = new Properties("receiveAccount","账号/卡号");
			propertiesList.add(receiveName);
			propertiesList.add(receiveBank);
			propertiesList.add(opeingBank);
			propertiesList.add(receiveAccount);
		}
		
		if(platformType.intValue() == 2) {
			Properties receiveAccount = new Properties("receiveAccount","账号");
			propertiesList.add(receiveAccount);
		}
		
		return propertiesList;
	}
	
	public static List<RefundPatternEnum> getListByParentKey(Integer parentKey) {
		List<RefundPatternEnum> list = new ArrayList<RefundPatternEnum>();
		
		for (RefundPatternEnum refundPatternEnum : RefundPatternEnum.values()) {
			if(parentKey.equals(refundPatternEnum.getParentKey())) {
				list.add(refundPatternEnum);
			}
		}
		return list;
	}
	
	public static List<RefundPatternEnum> getList() {
		List<RefundPatternEnum> list = new ArrayList<RefundPatternEnum>();
		for (RefundPatternEnum refundPatternEnum : RefundPatternEnum.values()) {
			list.add(refundPatternEnum);
		}
		return list;
	}
	
	
	
	// 支付细项属性，比如银行账号，开户姓名
	static class Properties{
		private String propertiesName;
		private String propertiesDisplay;
		public Properties(String propertiesName, String propertiesDisplay) {
			super();
			this.propertiesName = propertiesName;
			this.propertiesDisplay = propertiesDisplay;
		}
		public String getPropertiesName() {
			return propertiesName;
		}
		public void setPropertiesName(String propertiesName) {
			this.propertiesName = propertiesName;
		}
		public String getPropertiesDisplay() {
			return propertiesDisplay;
		}
		public void setPropertiesDisplay(String propertiesDisplay) {
			this.propertiesDisplay = propertiesDisplay;
		}
	}
}

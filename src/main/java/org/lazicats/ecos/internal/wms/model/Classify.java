package org.lazicats.ecos.internal.wms.model;

import java.io.Serializable;

/**
 * 分类
 * @author Administrator
 *
 */
public class Classify implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number="";
    private String name="";
    private String parentNumber="";
    
    /**
     * 获取分类编号
     * @return
     */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置分类编号
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取分类名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置分类名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取父级分类名称
	 * @return
	 */
	public String getParentNumber() {
		return parentNumber;
	}
	/**
	 * 设置父级分类名称
	 * @param parentNumber
	 */
	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}
}

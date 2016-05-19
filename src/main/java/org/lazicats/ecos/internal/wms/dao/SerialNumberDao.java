package org.lazicats.ecos.internal.wms.dao;

public interface SerialNumberDao {
	/**
	 * 
	 * @param serialNumberName
	 * 通过流水号的name查找流水号
	 * 并且跟新流水号
	 */
	public int findSerialNumberByName(String serialNumberName);
}

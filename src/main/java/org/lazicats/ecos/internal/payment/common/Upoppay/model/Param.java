package org.lazicats.ecos.internal.payment.common.Upoppay.model;

import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.commons.lang.StringUtils;



public abstract class Param extends LinkedHashMap<String, String>{
	public static final String FIELD_SEPERATOR = "|";
	public static final String KEY_VAL_SEPERATOR = ":";
	
	public String get(){
		StringBuffer sb = new StringBuffer();
		Set<String> keys = keySet();
		for (String key : keys) {
			String val = get(key);
			sb.append(key).append(KEY_VAL_SEPERATOR).append(val);
			sb.append(FIELD_SEPERATOR);
		}
		
		return StringUtils.removeEnd(sb.toString(), FIELD_SEPERATOR);
	}
}

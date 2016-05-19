package org.lazicats.internal.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Before;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.utils.StringUtils;

public class BankTestBasePro {

	public BankTestBasePro() {
		super();
	}

	@Before
	public void init() {
		Properties prop = new Properties();
		InputStream ips = null;
		ClassLoader loader = this.getClass().getClassLoader();
		ips = loader.getResourceAsStream("prod/bank.prod.properties");
		
		try {
			prop.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<?> enumeration = prop.propertyNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			String value = "";
			try {
				value = new String(prop.getProperty(key).getBytes("ISO-8859-1"),"UTF-8").toString();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
			CommonPayInfo.BankPayInfo.put(StringUtils.removeSpace(key), StringUtils.removeSpace(value));
		}
	}

}
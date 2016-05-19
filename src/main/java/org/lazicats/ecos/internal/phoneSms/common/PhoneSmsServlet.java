package org.lazicats.ecos.internal.phoneSms.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.BankInfoLoadServlet;
import org.lazicats.ecos.internal.utils.StringUtils;


public class PhoneSmsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(BankInfoLoadServlet.class);
	private static String phoneSwsProperties= "";
	
	/**
	 * 银行参数初始化
	 */
	public void init() {
		log.info("开始短信接口参数......");
		ServletConfig config = getServletConfig();
		if (config.getInitParameter("phoneSwsProperties") != null) {
			phoneSwsProperties = config.getInitParameter("phoneSwsProperties");
		}

		Properties prop = new Properties();
		InputStream ips = null;
		ClassLoader loader = BankInfoLoadServlet.class.getClassLoader();
		ips = loader.getResourceAsStream(phoneSwsProperties);
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
				log.error("初始化短信参数，转换字符集错误......");
				e.printStackTrace();
			}
			
			PhoneCommon.phoneCommonInfo.put(StringUtils.removeSpace(key), StringUtils.removeSpace(value));
		}
		log.info("初始化短信参数结束......");
	}
}

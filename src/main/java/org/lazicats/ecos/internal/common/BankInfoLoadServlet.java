package org.lazicats.ecos.internal.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.utils.StringUtils;


/**
 * 初始化加载银行信息
 * 
 * @author Mingjun_GUO
 * @since 2013年8月9日 09:44:19
 * 
 */
public class BankInfoLoadServlet extends HttpServlet {

	private static final long serialVersionUID = -2748208487861878993L;
	private static Logger log = Logger.getLogger(BankInfoLoadServlet.class);
	private static String bankProperties = "bank.properties";
	
	/**
	 * 银行参数初始化
	 */
	public void init() {
		log.debug("开始初始化加载银行参数......");
		ServletConfig config = getServletConfig();
		if (config.getInitParameter("bankProperties") != null) {
			bankProperties = config.getInitParameter("bankProperties");
		}

		Properties prop = new Properties();
		InputStream ips = null;
		ClassLoader loader = BankInfoLoadServlet.class.getClassLoader();
		ips = loader.getResourceAsStream(bankProperties);
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
				log.error("初始化加载银行参数，转换字符集错误......");
				e.printStackTrace();
			}
			/*
			 * 删除 key、value 中所有空格
			 */
			CommonPayInfo.BankPayInfo.put(StringUtils.removeSpace(key), StringUtils.removeSpace(value));
		}
		log.debug("初始化加载银行参数结束......");
	}

}

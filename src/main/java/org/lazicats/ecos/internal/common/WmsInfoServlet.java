package org.lazicats.ecos.internal.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.jlscm.common.CommonJlscmConstant;
import org.lazicats.ecos.internal.wms.common.CommonWmsInfo;
//import org.lazicats.ecos.internal.jinli.common.CommonJinliConstant;

/**
 * WMS WebService 信息加载
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-12 下午02:45:55
 * 
 */
public class WmsInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(WmsInfoServlet.class);
	private static String infoProperties = "info.properties";
	
	private static String jinliProperties = "jinli-interfaceConfig.properties";

	public void init() {
		
		log.debug("开始加载WebService参数......");
		ServletConfig config = getServletConfig();
		if (config.getInitParameter("infoProperties") != null) {
			infoProperties = config.getInitParameter("infoProperties");
		}

		Properties prop = new Properties();
		InputStream ips = null;
		ClassLoader loader = BankInfoLoadServlet.class.getClassLoader();
		ips = loader.getResourceAsStream(infoProperties);
		try {
			prop.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Enumeration<?> enumeration = prop.propertyNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			String value = prop.getProperty(key).trim();
			if ("clientUrl".equals(key)) {
				CommonWmsInfo.clientUrl = value;
			} else if ("userName".equals(key)) {
				CommonWmsInfo.userName = value;
			} else if ("password".equals(key)) {
				CommonWmsInfo.password = value;
			} else if ("serviceName".equals(key)) {
				CommonWmsInfo.serviceName = value;
			} else if ("checkMemberUrl".equals(key)){
				CommonWmsInfo.checkMemberUrl=value;
			}else if("queryMemberInfoUrl".equals(key)){
				CommonWmsInfo.queryMemberInfoUrl = value;
			}
		}
		log.debug("加载WebService参数结束......");
		
		this.jinliUrlInit();
	}
	
	//金力http路径初始化
	private void jinliUrlInit(){
		log.debug("开始加载金力url参数......");
		ServletConfig config = getServletConfig();
		if (config.getInitParameter("jinliProperties") != null) {
			jinliProperties = config.getInitParameter("jinliProperties");
		}

		Properties prop = new Properties();
		InputStream ips = null;
		ClassLoader loader = WmsInfoServlet.class.getClassLoader();
		ips = loader.getResourceAsStream(jinliProperties);
		try {
			prop.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Enumeration<?> enumeration = prop.propertyNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			System.out.println("key:" + key);
			String value = prop.getProperty(key).trim();
			if("clientUrl".equals(key)){
				CommonJlscmConstant.clientUrl=value;
			}else if("UserName".equals(key)){
				CommonJlscmConstant.userName=value;
			}else if("PassWord".equals(key)){
				CommonJlscmConstant.passWord=value;
		    }else if("Parms".equals(key)){
		    	CommonJlscmConstant.parms=value;
			}else if("Sign".equals(key)){
				CommonJlscmConstant.sign=value;
			}else if ("orderTradeType".equals(key)) {
				CommonJlscmConstant.orderTradeType = value;
			} else if ("cancelOrderType".equals(key)) {
				CommonJlscmConstant.cancelOrderType = value;
			} else if ("refundOrderType".equals(key)) {
				CommonJlscmConstant.refundOrderType= value;
			}
		}
		
		log.debug("加载金力url参数结束......");
		
	}
}

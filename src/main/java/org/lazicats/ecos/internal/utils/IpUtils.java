package org.lazicats.ecos.internal.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-30下午2:02:15
 * 
 * @说明：
 */

public class IpUtils {

	/**
	 * 获取ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static final String getClientAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}

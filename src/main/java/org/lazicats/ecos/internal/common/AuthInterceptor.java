package org.lazicats.ecos.internal.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：
 */
public class AuthInterceptor implements HandlerInterceptor {

	private final Logger log = Logger.getLogger(AuthInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		log.info("prehandling ... ");
//		String url = request.getRequestURI();
//		log.info("url="+url);
//		String checkValue = url.substring(url.indexOf(request.getContextPath()), 45);
//		if (checkValue.indexOf("payNotify") > 0) {
			return true;
//		} else {
//			log.error("非支付回调请求，" + request.getRequestURI());
//			return false;
//		}
	}

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
}

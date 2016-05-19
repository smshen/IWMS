package org.lazicats.ecos.internal.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * CustomHandlerExceptionResolver.java
 * 
 * @author MingJun_Guo
 * @创建日期：2013-11-5上午10:01:08
 * 
 */
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception e) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("e", e);
		System.out.println(e);
		return new ModelAndView("redirect:"+CommonPayInfo.BankPayInfo.get("exceptionUrl"), model);
	}

}

package org.lazicats.ecos.internal.payment.controllor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.service.PayNotifyService;
import org.lazicats.ecos.internal.payment.vo.PayResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * OrderPayCompleteController.java
 * 
 * @author MingJun_Guo
 * @创建日期：2013-9-24下午5:00:48
 * 
 */
@Controller
@RequestMapping("/payNotify/pay")
public class OrderPayCompleteController {
	
	private final Logger log = Logger.getLogger(OrderPayCompleteController.class);

	@Resource
	private PayNotifyService payNotifyService;

	/**
	 * 支付宝 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_alipay", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_alipay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();

		try {
			vo = payNotifyService.returnAlipay(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("支付宝支付回调错误 toPayComplete_alipay："+e.getMessage());
			e.printStackTrace();
		}

		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}

	/**
	 * 财付通 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_tenpay", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_tenpay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// PayResultVo vo = payNotifyService.returnTenpay(request, response);
		// PayResultVo vo = new PayResultVo();
		ModelAndView model = new ModelAndView();
		// vo.setBool(false);
		// String page = "/pay/paySuccess";
		// try {
		// if (vo.getBool() == false) {// 假设失败
		// page = "/pay/payFail";
		// }
		// model.addObject("resultVo", vo.getOrderNo());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		model.setViewName("redirect:http://www.baidu.com");
		return model;
	}

	/**
	 * 快钱 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_paypal", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_paypal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();
		try {
			vo = payNotifyService.returnRmbport(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("快钱支付回调错误 toPayComplete_paypal："+e.getMessage());
			e.printStackTrace();
		}

		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}

	/**
	 * 银联 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_unionpay", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_unionpay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();
		
		try {
			vo = payNotifyService.returnUnionpay(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("银联支付回调错误 toPayComplete_unionpay："+e.getMessage());
			e.printStackTrace();
		}

		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}

	/**
	 * 中行 支付通知、用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_boc", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_boc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();	
		
		try {
			vo = payNotifyService.notifyBocpay(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("中行支付回调错误 toPayComplete_boc："+e.getMessage());
			e.printStackTrace();
		}
		
		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}

	/**
	 * 工行 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_icbc", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_icbc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();
		
		try {
			vo = payNotifyService.returnIcbcpay(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("工行支付回调错误 toPayComplete_icbc："+e.getMessage());
			e.printStackTrace();
		}
		
		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}

	/**
	 * 农行 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_abc", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_abc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();
		
		try {
			vo = payNotifyService.returnAbchina(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("农行支付回调错误 toPayComplete_abc："+e.getMessage());
			e.printStackTrace();
		}
		
		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}

	/**
	 * 建行 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_ccb", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_ccb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();
		
		try {
			vo = payNotifyService.returnCcbpay(request);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("建行支付回调错误 toPayComplete_ccb："+e.getMessage());
			e.printStackTrace();
		}
		
		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}
	
	/**
	 * 建行 用户反馈回调、重定向
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toPayComplete_upop", produces = "text/html;charset=UTF-8")
	public ModelAndView toPayComplete_upop(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PayResultVo vo = new PayResultVo();
		log.info("about to redirect customer to payment result page ...");
		try {
			vo = payNotifyService.determinePayResult(request,false);
		} catch (Exception e) {   
			vo.setBool(false);
			log.info("支付回调错误 toPayComplete_upop："+e.getMessage());
			e.printStackTrace();
		}
		
		ModelMap model = new ModelMap();
		model.put("bool", vo.getBool());
		model.put("orderNo", vo.getOrderNo());

		return new ModelAndView("redirect:"
				+ CommonPayInfo.BankPayInfo.get("redirectUrl"), model);
	}
}

package org.lazicats.ecos.internal.payment.controllor;

import java.lang.reflect.Method;
import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.payment.service.PayNotifyService;
import org.lazicats.ecos.internal.payment.vo.PayResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：支付回调
 */

@Controller
public class PayNotifyController {

	private static Logger log = Logger.getLogger(PayNotifyController.class);

	@Resource
	private PayNotifyService payNotifyService;

	/**
	 * 财付通支付通知（后台通知）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/payNotify/notify_tenpay")
	public void notify_tenpay(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			payNotifyService.notifyTenpay(request, response);
		} catch (Exception e) {
			log.error("财付通支付回调异常，" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 财付通支付 回调处理
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/payNotify/TenReturn")
	public void returnTenpay(HttpServletRequest request,
			HttpServletResponse response) {
		payNotifyService.returnTenpay(request, response);
	}

	/**
	 * 支付宝异步通知
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/payNotify/notify_alipay")
	public void notify_alipay(HttpServletRequest request,
			HttpServletResponse response) {
		payNotifyService.notifyAlipay(request, response);
	}

	/**
	 * 银联支付回调后台通知
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/payNotify/notify_unionpay")
	public void notify_unionpay(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("银联后台通知......");
		payNotifyService.notifyUnionpay(request);
	}
	
	
	
	/**
	 * 建行支付回调(服务端交互)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/payNotify/notify_ccbpay")
	public void notify_ccbpay(HttpServletRequest request,
			HttpServletResponse response) {
		payNotifyService.notifyCcbpay(request);
	}

	/**
	 * 工行支付回调
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/payNotify/notify_icbcpay")
	public void notify_icbcpay(HttpServletRequest request,
			HttpServletResponse response) {
		payNotifyService.notifyIcbcpay(request,response);
	}

	/**
	 * 中行 银行主动通知
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/payNotify/notify_bocpay")
	public void notify_bocpay(HttpServletRequest request,
			HttpServletResponse response) {
		payNotifyService.notifyBocpay(request);
	}

	/**
	 * 快钱支付回调(主动通知)
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(value = "/payNotify/notify_rmbport")
	public void notify_rmbport(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		payNotifyService.notifyRmbport(request, response);
	}
	
	/**
	 * 农行支付回调后台通知
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/payNotify/notify_abchina")
	public void notify_abchina(HttpServletRequest request,
			HttpServletResponse response) {
		payNotifyService.notifyAbchina(request, response);
	}
	
	
	@RequestMapping(value = "/payNotify/notify_upoppay",method=RequestMethod.POST)
	@ResponseBody
	public String notify_upoppay(HttpServletRequest request,
			HttpServletResponse response) {
	  String characterEncoding = request.getCharacterEncoding();
      log.info("will use CharacterEncoding<" + 
          (characterEncoding==null?"ISO-8859-1":characterEncoding) + "> to decode post entity body!");
      
      
		PayResultVo vo = new PayResultVo();
		log.info("about to proccess payment notification ...");
		try {
			vo = payNotifyService.determinePayResult(request,true);
		} catch (Exception e) {
			vo.setBool(false);
			log.info("银联跨境支付回调错误 - detail:"+e.getMessage());
			e.printStackTrace();
		}
		
		String string = vo.getBool()?"OK":"failure";
		log.info("银联跨境支付后台回调返回结果:"+string);
		return string;
		
	}
}

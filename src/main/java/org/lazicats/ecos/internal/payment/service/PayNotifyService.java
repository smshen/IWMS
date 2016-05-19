package org.lazicats.ecos.internal.payment.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.ecos.internal.payment.vo.PayResultVo;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：
 */

public interface PayNotifyService {

	/**
	 * 财付通 后台通知 处理
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void notifyTenpay(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 财付通 回调 处理
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public PayResultVo returnTenpay(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 支付宝 支付请求回调处理
	 * 
	 * @param request
	 * @throws Exception
	 */
	public PayResultVo returnAlipay(HttpServletRequest request);

	/**
	 * 支付宝异步通知
	 * 
	 * @param request
	 * @param response
	 */
	public void notifyAlipay(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 银联支付回调
	 * 
	 * @param request
	 * @throws Exception
	 */
	public void notifyUnionpay(HttpServletRequest request);

	/**
	 * 银联支付前端页面返回
	 * 
	 * @param request
	 * @throws Exception
	 */
	public PayResultVo returnUnionpay(HttpServletRequest request);

	/**
	 * 建行后台支付回调
	 * 
	 * @param request
	 */
	public void notifyCcbpay(HttpServletRequest request);
	
	/**
	 * 建行支付回调，前端页面
	 * @param request
	 * @return
	 */
	public PayResultVo returnCcbpay(HttpServletRequest request);

	/**
	 * 工行支付回调
	 * 
	 * @param request
	 */
	public void notifyIcbcpay(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 工行前端页面跳转
	 * 
	 * @param request
	 */
	public PayResultVo returnIcbcpay(HttpServletRequest request);

	/**
	 * 中行 银行主动通知
	 * 
	 * @param request
	 */
	public PayResultVo notifyBocpay(HttpServletRequest request);

	/**
	 * 快钱后台通知接收处理
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void notifyRmbport(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/**
	 * 快钱 前端页面 展示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public PayResultVo returnRmbport(HttpServletRequest request);

	/**
	 * 农行支付后台通知
	 * 
	 * @param request
	 * @param response
	 */
	public void notifyAbchina(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 农行支付前端页面展示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public PayResultVo returnAbchina(HttpServletRequest request);
    
	/**
	 * cross-border payment
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public PayResultVo determinePayResult(HttpServletRequest request,boolean needProccessOrderPayment) throws UnsupportedEncodingException;
	
}

package org.lazicats.ecos.internal.payment.component.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.AlipaySendGoods.AlipayNotify;
import org.lazicats.ecos.internal.payment.common.AlipaySendGoods.AlipaySubmit;
import org.lazicats.ecos.internal.payment.common.AlipaySendGoods.XMLUtils;
import org.lazicats.ecos.internal.payment.component.ISendGoodsment;
import org.lazicats.ecos.internal.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 * SendGoodsmentImpl.java
 * 
 * @author MingJun_Guo
 * @创建日期：2013-10-22下午4:56:42
 * 
 */
@Service
public class SendGoodsmentImpl implements ISendGoodsment {

	private final static Logger log = Logger.getLogger(SendGoodsmentImpl.class);
	
	/**
	 * 发货请求
	 * 
	 * @param payPlatform
	 * @param paramMap
	 * @return
	 */
	public boolean sendGoods(String payPlatform, Map<String, String> paramMap) {

		//支付宝发货确认
		if (payPlatform.equals(CommonPayInfo.PAYMENT_ALIPAY)) {
			return SendGoodsmentImpl.alipaySendGoods(paramMap);
		}
		return false;
	}

	/**
	 * 支付宝确认收货
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static boolean alipaySendGoods(Map<String, String> paramMap) {
		boolean bool = false;
		Map<String, String> sendGoods = new HashMap<String, String>();
		sendGoods.put("service", "send_goods_confirm_by_platform");
		sendGoods.put("partner", CommonPayInfo.BankPayInfo.get("alipay_partner"));
		sendGoods.put("_input_charset", CommonPayInfo.BankPayInfo.get("alipay_input_charset"));
		sendGoods.put("trade_no", paramMap.get("trade_no"));// 支付宝交易号	A
		sendGoods.put("logistics_name", paramMap.get("logistics_name"));// 物流公司名称	A
		sendGoods.put("invoice_no", paramMap.get("invoice_no"));// 物流发货单号	A
		sendGoods.put("transport_type", paramMap.get("transport_type"));// 发货时的运输类型	A
		sendGoods.put("create_transport_type", paramMap.get(""));// 创建交易时的运输类型
		sendGoods.put("seller_ip", paramMap.get(""));// 卖家IP（可为空）

		String resultXml = "";
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		try {
			resultXml = AlipaySubmit.buildRequest("", "", sendGoods);
			if (StringUtils.isEmpty(resultXml)) {
				resultMap = XMLUtils.xmlToMapByAlipaySendGoods(resultXml);
				Map<String, String> mapTradeBase = (Map<String, String>) resultMap
						.get("mapTradeBase");
				// mapTradeBase.put("sign", resultMap.get("sign").toString());
				// mapTradeBase.remove("partner_id");
				// bool = AlipayNotify.verify(mapTradeBase);
				if ("T".equals(resultMap.get("is_success"))) {
					log.info("支付宝确认收货发送成功，返回成功。订单号："
							+ mapTradeBase.get("out_trade_no"));
					bool = true;
				}
			}
		} catch (Exception e) {
			log.error("商城发货通知支付宝异常......");
			e.printStackTrace();
		}
		return bool;
	}
}

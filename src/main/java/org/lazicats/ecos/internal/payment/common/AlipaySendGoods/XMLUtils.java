package org.lazicats.ecos.internal.payment.common.AlipaySendGoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * XMLUtils.java
 * 
 * @author MingJun_Guo
 * @创建日期：2013-10-22下午7:07:11
 * 
 */
public class XMLUtils {

	private final static Logger log = Logger.getLogger(XMLUtils.class);

	/**
	 * 支付宝收货地址确认XML解析
	 * 
	 * @param xmlValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Object, Object> xmlToMapByAlipaySendGoods(
			String xmlValue) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Document doc = null;
		/*
		 * 获取 header 节点，请求结果
		 */
		try {
			doc = DocumentHelper.parseText(xmlValue);
		} catch (DocumentException e) {
			log.error("支付宝确认收货结果XML解析异常，" + e.getMessage());
			e.printStackTrace();
		}

		Element root = doc.getRootElement();
		// 是否成功
		Element is_success = root.element("is_success");
		map.put("is_success", is_success.getTextTrim());
		// 校验码
		Element sign = root.element("sign");
		map.put("sign", sign.getTextTrim());
		// 加密方式
		Element sign_type = root.element("sign_type");
		map.put("sign_type", sign_type.getTextTrim());

		Map<String, String> mapTradeBase = new HashMap<String, String>();
		List<Element> elementOrderTrans = doc
				.selectNodes("/alipay/response/tradeBase/*");
		for (Element element : elementOrderTrans) {
			mapTradeBase.put(element.getName(), element.getTextTrim());
		}
		map.put("mapTradeBase", mapTradeBase);

		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><alipay><is_success>T</is_success>"
				+ "<request><param name=\"trade_no\">2013102226991504</param><param name=\"_input_charset\">UTF-8</param><param name=\"transport_type\">EXPRESS</param><param name=\"service\">send_goods_confirm_by_platform</param><param name=\"partner\">2088701809260784</param><param name=\"invoice_no\">TS00000001212</param><param name=\"logistics_name\">申通快递</param></request><response><tradeBase><buyer_account>20884024088340430156</buyer_account><buyer_actions>[REFUND, CONFIRM_GOODS]</buyer_actions><buyer_login_email>guomingjun1990@126.com</buyer_login_email><buyer_type>PRIVATE_ACCOUNT</buyer_type><buyer_user_id>2088402408834043</buyer_user_id><channel>interface/escrow</channel><create_time>2013-10-22 18:43:17</create_time><currency>156</currency><gathering_type>1</gathering_type><last_modified_time>2013-10-22 18:52:56</last_modified_time><operator_role>B</operator_role><out_trade_no>61433c7e-145d-4332-bfb4-220ce29de2c3</out_trade_no><partner_id>2088701809260784</partner_id><seller_account>20887018092607840156</seller_account><seller_actions>[EXTEND_TIMEOUT]</seller_actions><seller_login_email>igrandbuy@igrandbuy.net</seller_login_email><seller_type>CORPORATE_ACCOUNT</seller_type><seller_user_id>2088701809260784</seller_user_id><service_fee>0.00</service_fee><service_fee_ratio>0.0</service_fee_ratio><stop_timeout>F</stop_timeout><total_fee>0.01</total_fee><trade_from>INST_PARTNER</trade_from><trade_no>2013102226991504</trade_no><trade_status>WAIT_BUYER_CONFIRM_GOODS</trade_status><trade_type>S</trade_type></tradeBase></response><sign>c06f8d2916d62b9bf794b6c6061a24c5</sign><sign_type>MD5</sign_type></alipay>";

		Map<Object, Object> map = XMLUtils.xmlToMapByAlipaySendGoods(xml);

		System.out.println(map.get("is_success"));

		@SuppressWarnings("unchecked")
		Map<Object, Object> mapTradeBase = (Map<Object, Object>) map
				.get("mapTradeBase");
		System.out.println(mapTradeBase.get("out_trade_no"));
	}
}

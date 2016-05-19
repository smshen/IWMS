package org.lazicats.ecos.internal.payment.common.AlipayOrderQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * @FileName XMLUtils.java
 * @PackageName org.lazicats.ecos.internal.payment.common.AlipayOrderQuery
 * @功能 支付宝订单查询xml解析
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-17下午2:42:07
 *
 */
public class XMLUtils {

	private final static Logger log = Logger.getLogger(XMLUtils.class);

	/**
	 * 支付宝订单查询接口，xml文件解析指定参数
	 * @param xmlValue
	 * @param resultMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static Map<String, Object> xmlToMapByAlipay(String xmlValue) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlValue);
		} catch (DocumentException e) {
			log.error("支付宝订单查询，解析xml异常，" + e.getMessage());
			e.printStackTrace();
		}
		
		List<Element> listAlipay = doc.selectNodes("/alipay/*");
		
		Element e = listAlipay.get(0);
		
		resultMap.put(e.getName(), e.getTextTrim());
		
		if("T".equals(e.getTextTrim())){
			List<Element> listTrade = doc.selectNodes("/alipay/response/trade/*");
			Map<String, String> trandeMap = new HashMap<String, String>();
			
			for (Element element : listTrade) {
				trandeMap.put(element.getName(), element.getTextTrim());
			}
			resultMap.put("trade", trandeMap);
			
			Element eRe = listAlipay.get(3);
			resultMap.put(eRe.getName(), eRe.getTextTrim());
		} else {
			Element error = listAlipay.get(1);
			resultMap.put("error", error.getTextTrim());
		}

		return resultMap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><alipay><is_success>T</is_success><request><param name=\"_input_charset\">UTF-8</param><param name=\"service\">single_trade_query</param><param name=\"partner\">2088701809260784</param><param name=\"out_trade_no\">1387181806012885809</param></request><response><trade><buyer_email>13916527936</buyer_email><buyer_id>2088902118310254</buyer_id><discount>0.00</discount><flag_trade_locked>0</flag_trade_locked><gmt_create>2013-12-16 16:03:11</gmt_create><gmt_last_modified_time>2013-12-17 09:42:10</gmt_last_modified_time><gmt_logistics_modify>2013-12-17 09:42:10</gmt_logistics_modify><gmt_payment>2013-12-16 16:04:35</gmt_payment><gmt_send_goods>2013-12-17 09:42:10</gmt_send_goods><is_total_fee_adjust>F</is_total_fee_adjust><logistics_fee>0.00</logistics_fee><logistics_status>WAIT_RECEIVER_CONFIRM_GOODS</logistics_status><operator_role>B</operator_role><out_trade_no>1387181806012885809</out_trade_no><payment_type>1</payment_type><price>313.00</price><quantity>1</quantity><seller_email>igrandbuy@igrandbuy.net</seller_email><seller_id>2088701809260784</seller_id><subject>1387181806012885809</subject><time_out>2013-12-27 09:42:10</time_out><time_out_type>autoFinishTradeAction</time_out_type><to_buyer_fee>0.00</to_buyer_fee><to_seller_fee>0.00</to_seller_fee><total_fee>313.00</total_fee><trade_no>2013121669724625</trade_no><trade_status>WAIT_BUYER_CONFIRM_GOODS</trade_status><use_coupon>F</use_coupon></trade></response><sign>f80536f72ec0d2db06a9e81da4207fc7</sign><sign_type>MD5</sign_type></alipay>";
		XMLUtils.xmlToMapByAlipay(xml);

	}
}

package org.lazicats.ecos.internal.payment.common.Boc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-23上午9:51:10
 * 
 * @类说明：中行XML解析
 */

public class XMLUtils {

	private final static Logger log = Logger.getLogger(XMLUtils.class);

	/**
	 * 固定解析BOC 查询接口返回对象
	 * 
	 * @param xmlValue
	 * @return Map<Object, Object>
	 */
	@SuppressWarnings("unchecked")
	protected static Map<Object, Object> xmlToMapByBoc(String xmlValue) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Document doc = null;
		/*
		 * 获取 header 节点，请求结果
		 */
		try {
			doc = DocumentHelper.parseText(xmlValue);
		} catch (DocumentException e) {
			log.error("中行支付查询结果XML解析异常，" + e.getMessage());
			e.printStackTrace();
		}

		List<Element> listHeader = doc.selectNodes("/res/header/*");
		for (Element element : listHeader) {
			map.put(element.getName(), element.getTextTrim());
		}

		/*
		 * 获取 body orderTrans 节点，详细内容
		 */
		// 多级子对象封装list
		List<Map<String, String>> listTrans = new ArrayList<Map<String, String>>();

		List<Element> listBody = doc.selectNodes("/res/body/*");
		for (int i = 0; i < listBody.size(); i++) {
			List<Element> listOrderTrans = listBody.get(i).elements();
			Map<String, String> mapTrans = new HashMap<String, String>();
			for (Element element : listOrderTrans) {
				mapTrans.put(element.getName(), element.getTextTrim());
			}
			listTrans.add(mapTrans);
		}
		map.put("listTrans", listTrans);
		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><res><header><msgId>0000204</msgId><hdlSts>A</hdlSts><bdFlg>0</bdFlg><rtnCd /></header>"
				+ "<body><orderTrans><merchantNo>3335551</merchantNo><orderNo>12251</orderNo><orderSeq>128511</orderSeq><orderStatus>01</orderStatus><cardTyp>11</cardTyp><acctNo>55555101001234567891</acctNo><holderName>张三1</holderName><ibknum>074281</ibknum><payTime>201106241713131</payTime><payAmount>141.00</payAmount><visitorIp>127.0.0.11</visitorIp><visitorRefer /></orderTrans>"
				+ "<orderTrans><merchantNo>3335552</merchantNo><orderNo>12262</orderNo><orderSeq>121122</orderSeq><orderStatus>02</orderStatus><cardTyp>12</cardTyp><acctNo>55555101001234567892</acctNo><holderName>张三2</holderName><ibknum>074282</ibknum><payTime>201106241713132</payTime><payAmount>1002.00</payAmount>	<visitorIp>127.0.0.12</visitorIp><visitorRefer /></orderTrans></body></res>";
		XMLUtils.xmlToMapByBoc(xml);

	}

}

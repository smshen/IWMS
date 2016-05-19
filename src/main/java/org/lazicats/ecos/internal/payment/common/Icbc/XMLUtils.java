package org.lazicats.ecos.internal.payment.common.Icbc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * @FileName：XMLUtils.java
 * @PackageName：org.lazicats.ecos.internal.payment.common.Icbc
 * @功能：工商银行支付订单状态查询,xml文件解析
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-16上午10:45:25
 * 
 */
public class XMLUtils {

	private final static Logger log = Logger.getLogger(XMLUtils.class);

	/**
	 * 工行订单查询接口，xml文件解析指定参数
	 * @param xmlValue
	 * @param resultMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static Map<String, String> xmlToMapByIcbc(String xmlValue,Map<String, String> resultMap) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlValue);
		} catch (DocumentException e) {
			log.error("工行订单查询，解析xml异常，" + e.getMessage());
			e.printStackTrace();
		}

		List<Element> listHeader = doc.selectNodes("/ICBCAPI/out/*");
		for (Element element : listHeader) {
			if("tranStat".equals(element.getName())){
				resultMap.put(element.getName(), element.getTextTrim());
			}
			if("amount".equals(element.getName())){
				resultMap.put(element.getName(), element.getTextTrim());
			}
		}

		return resultMap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String xml = "<?xml  version=\"1.0\" encoding=\"GB2312\" standalone=\"no\" ?><ICBCAPI><pub><APIName>EAPI</APIName><APIVersion>001.001.002.001</APIVersion></pub><in><orderNum>1386598703921694123</orderNum><tranDate>20131209</tranDate><ShopCode>3602EC23784725</ShopCode><ShopAccount>3602000919200379707</ShopAccount></in><out><tranSerialNum>HFG000004560594117</tranSerialNum><tranStat>1</tranStat><bankRem></bankRem><amount>20000</amount><currType>001</currType><tranTime>221800</tranTime><ShopAccount>3602000919200379707</ShopAccount><PayeeName>�����й�ٹɷ����޹�˾��������ֹ�˾</PayeeName><JoinFlag>0</JoinFlag><MerJoinFlag></MerJoinFlag><CustJoinFlag>0</CustJoinFlag><CustJoinNum></CustJoinNum><CertID>GBDZ01.e.3602</CertID></out></ICBCAPI>";
		XMLUtils.xmlToMapByIcbc(xml,null);

	}
}

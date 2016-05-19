package org.lazicats.ecos.internal.payment.common.Tenpay;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.utils.StringUtils;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：
 */

public class TenPayUtils {
	
	private static Logger log = Logger.getLogger(TenPayUtils.class);
			
	/**
	 * 创建支付提交HTML
	 * @param valueVo
	 * @return
	 */
	public static String crateTenPayHtml(String valueVo[]){
		SortedMap<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < TenPayConf.payVo.length; i++) {
			log.info(" ---DEBUG:"+valueVo[i].toString().indexOf("http"));
			if(valueVo[i].toString().indexOf("http")>-1){
				map.put(TenPayConf.payVo[i], valueVo[i]);
			}else{
				map.put(TenPayConf.payVo[i], StringUtils.encode(valueVo[i], "GBK"));
			}
		}
		map.put(TenPayConf.sign, TenPayUtils.createSign(map));
		
		String fromUrl = TenPayUtils.generateAutoSubmitForm(map);
		
		return fromUrl;
	}
	

	/**
	 * 封装支付提交文本
	 * 
	 * @param actionUrl
	 * @param paramMap
	 * @return
	 */
	private static String generateAutoSubmitForm(Map<String, String> paramMap) {
		StringBuilder html = new StringBuilder();
		html.append("<form id=\"tenpay\" name=\"tenpay\" action=\"").append(CommonPayInfo.BankPayInfo.get("tenpay_url")).append("\" method=\"post\">\n");

		for (String key : paramMap.keySet()) {
			html.append("<input type=\"hidden\" id=\"" + key + "\" name=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
		}
		html.append("</form>");
		html.append("<script>document.forms['tenpay'].submit();</script>");
		
		return html.toString();
		
//		StringBuilder html = new StringBuilder(CommonPayInfo.BankPayInfo.get("tenpay_url")+"?");
//		for (String key : paramMap.keySet()) {
//			try {
//				html.append(key+"="+java.net.URLEncoder.encode(paramMap.get(key),"UTF-8")+"&");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return html.toString().substring(0, html.toString().lastIndexOf("&"));
	}
	
	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String createSign(SortedMap<String, String> map) {

		StringBuffer sb = new StringBuffer();
		
		Set es = map.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"null".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		
		sb.append("key=" + CommonPayInfo.BankPayInfo.get("tenpay_key"));

		log.info(sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toLowerCase();
		return sign;
	}

}

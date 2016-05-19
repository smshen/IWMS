package org.lazicats.ecos.internal.payment.common.Ccb;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;

import sun.nio.cs.UnicodeEncoder;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：建行支付、验证等
 */
public class CcbPayUtils {
	
	private static final Logger log = Logger.getLogger(CcbPayUtils.class);

	/**
	 * 封装支付请求对象
	 * 
	 * @param valueVo
	 * @return
	 */
	public static String crateCcbPayHtml(String valueVo[]) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < CcbPayConf.ccbPay.length; i++) {
			map.put(CcbPayConf.ccbPay[i], valueVo[i]);
		}
		map.put(CcbPayConf.mac, CcbPayUtils.getMAC(map));// 加密字符串
		String fromUrl = CcbPayUtils.generateAutoSubmitForm(map);
		
		return fromUrl;
	}
	
	/**
	 * 封装支付签名域
	 * 
	 * @param map
	 * @return
	 */
	private static String getMAC(Map<String, String> map) {
		StringBuilder stringBuilder = new StringBuilder("MERCHANTID="+CommonPayInfo.BankPayInfo.get("ccbPay_merCode")+"&");
		stringBuilder.append("POSID="+CommonPayInfo.BankPayInfo.get("ccbPay_posid")+"&");
		stringBuilder.append("BRANCHID="+CommonPayInfo.BankPayInfo.get("ccbPay_branchId")+"&");
		stringBuilder.append("ORDERID="+map.get("ORDERID")+"&");
		stringBuilder.append("PAYMENT="+map.get("PAYMENT")+"&");
		stringBuilder.append("CURCODE="+map.get("CURCODE")+"&");
		stringBuilder.append("TXCODE="+map.get("TXCODE")+"&");
		stringBuilder.append("REMARK1="+map.get("REMARK1")+"&");
		stringBuilder.append("REMARK2="+map.get("REMARK2")+"&");
		stringBuilder.append("TYPE="+map.get("TYPE")+"&");
		stringBuilder.append("PUB="+map.get("PUB")+"&");
		stringBuilder.append("GATEWAY="+map.get("GATEWAY")+"&");
		stringBuilder.append("CLIENTIP="+map.get("CLIENTIP")+"&");
		stringBuilder.append("REGINFO="+map.get("REGINFO")+"&");
		stringBuilder.append("PROINFO="+map.get("PROINFO")+"&");
		stringBuilder.append("REFERER="+map.get("REFERER"));
//		if(StringUtils.isNotEmpty(CommonPayInfo.BankPayInfo.get("ccbPay_pubkey"))){
//			log.debug("建行支付执行接口2或者3");
//			stringBuilder.append("&PUB32="+ CommonPayInfo.BankPayInfo.get("ccbPay_pubkey"));
//		}
		
		
		System.out.println(stringBuilder.toString());
		
		return MD5.md5Str(stringBuilder.toString());
	}
	
	
	/**
	 * 校验回调
	 * 
	 * @param sign
	 * @param map
	 * @return true：成功	false：失败
	 */
	public static boolean getSign(Map<String, String> map){
		boolean bool = false;
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("POSID="+map.get("POSID")+"&");
		stringBuilder.append("BRANCHID="+map.get("BRANCHID")+"&");
		stringBuilder.append("ORDERID="+map.get("ORDERID")+"&");
		stringBuilder.append("PAYMENT="+map.get("PAYMENT")+"&");
		stringBuilder.append("CURCODE="+map.get("CURCODE")+"&");
		stringBuilder.append("REMARK1="+map.get("REMARK1")+"&");
		stringBuilder.append("REMARK2="+map.get("REMARK2")+"&");
		if(org.lazicats.ecos.internal.utils.StringUtils.isEmpty(map.get("ACC_TYPE"))){
			stringBuilder.append("ACC_TYPE="+map.get("ACC_TYPE")+"&");
		}
		stringBuilder.append("SUCCESS="+ map.get("SUCCESS"));
		if(StringUtils.isNotEmpty(map.get("ACCDATE"))){
			log.debug("建行支付回调执行接口2或者3");
			stringBuilder.append("&ACCDATE="+ map.get("ACCDATE"));
		}
		
		RSASig rsa=new RSASig();
		String strSign=map.get("SIGN");
		
		if( strSign==null ){
			strSign="";
		}
		rsa.setPublicKey(CommonPayInfo.BankPayInfo.get("ccbPay_pubkey"));
		bool=rsa.verifySigature(strSign,stringBuilder.toString());
		
		return bool;
	}
	
	/**
	 * 订单查询
	 * @param paramMap
	 * @return
	 */
	public static String queryOrder(String queryVo[]) {
		//转换对象
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < CcbPayConf.ccbQueryOrder.length; i++) {
			map.put(CcbPayConf.ccbQueryOrder[i], queryVo[i]);
		}
		//封装HTTP请求对象Map
		Map<String, String> httpMap = new HashMap<String, String>();
		httpMap = CcbPayUtils.getOrderQueryMap(map);
		String queryResult = HttpClientUtil.httpPost(CommonPayInfo.BankPayInfo.get("ccbPay_url"), httpMap);
		
		log.info(queryResult);
		return "";
	}

	/**
	 * 封装支付form对象
	 * 
	 * @param paramMap
	 * @return
	 */
	private static String generateAutoSubmitForm(Map<String, String> paramMap){
		StringBuilder html = new StringBuilder();
		html.append("<form id=\"ccbForm\" name=\"icbcForm\" action=\"").append(CommonPayInfo.BankPayInfo.get("ccbPay_url")).append("\" method=\"post\">\n");

		for (String key : paramMap.keySet()) {
			if("PUB".equals(key))continue;
			html.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
		}
		
		html.append("</form>\n");
		html.append("<script>document.forms['ccbForm'].submit();</script>");
		return html.toString();
	}
	
	/**
	 * 订单查询HTTP请求Map封装
	 * 
	 * @param paramMap
	 * @return
	 */
	private static Map<String, String> getOrderQueryMap(Map<String, String> paramMap){
		/*
		 * 传递参数： ORDERDATE：查询日期	 BEGORDERID：开始订单号	 ENDORDERID：结束订单号
		 */
//		String queryWay = "";
		Map<String, String> map = new HashMap<String, String>();

		StringBuilder queryMacStr = new StringBuilder("MERCHANTID=" + CommonPayInfo.BankPayInfo.get("ccbPay_merCode"));
		queryMacStr.append("&BRANCHID=" + CommonPayInfo.BankPayInfo.get("ccbPay_branchId"));
		queryMacStr.append("&POSID=" + CommonPayInfo.BankPayInfo.get("ccbPay_posid"));
		queryMacStr.append("&ORDERDATE=" + paramMap.get("ORDERDATE"));
		queryMacStr.append("&BEGORDERTIME=00:00:00&ENDORDERTIME=23:59:59");

		map.put("MERCHANTID", CommonPayInfo.BankPayInfo.get("ccbPay_merCode"));
		map.put("BRANCHID", CommonPayInfo.BankPayInfo.get("ccbPay_branchId"));
		map.put("POSID", CommonPayInfo.BankPayInfo.get("ccbPay_posid"));
		map.put("ORDERDATE", paramMap.get("ORDERDATE"));
		map.put("BEGORDERTIME", "00:00:00");
		map.put("ENDORDERTIME", "23:59:59");

		if (StringUtils.isNotBlank(paramMap.get("BEGORDERID")) && StringUtils.isNotBlank(paramMap.get("ENDORDERID"))) {
			queryMacStr.append("&BEGORDERID=" + paramMap.get("BEGORDERID") + "&ENDORDERID=" + paramMap.get("ENDORDERID"));

			map.put("BEGORDERID", paramMap.get("BEGORDERID"));
			map.put("ENDORDERID", paramMap.get("ENDORDERID"));
//			queryWay = "all";
		} else {
			if (StringUtils.isNotBlank(paramMap.get("BEGORDERID"))) {
				queryMacStr.append("&ORDERID=" + paramMap.get("BEGORDERID"));

				map.put("ORDERID", paramMap.get("BEGORDERID"));
			} else if (StringUtils.isNotBlank(paramMap.get("ENDORDERID"))) {
				queryMacStr.append("&ORDERID=" + paramMap.get("ENDORDERID"));

				map.put("ORDERID", paramMap.get("ENDORDERID"));
			}
//			queryWay = "one";
		}

		queryMacStr.append("&QUPWD=" + CommonPayInfo.BankPayInfo.get("ccbPay_queryPass"));
		queryMacStr.append("&TXCODE=410405");
		queryMacStr.append("&SEL_TYPE=2&OPERATOR=");

		map.put("QUPWD", CommonPayInfo.BankPayInfo.get("ccbPay_queryPass"));
		map.put("TXCODE", "410405");
		map.put("SEL_TYPE", "2");// 查询方式SEL_TYPE 1页面形式 2文件返回形式
									// (提供TXT和XML格式文件的下载) 3 XML页面形式
		map.put("OPERATOR", "");
		map.put("MAC", MD5.md5Str(queryMacStr.toString()));
		return map;
	}
}

/*package org.lazicats.ecos.internal.payment.common.aliforex.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.utils.UnicodeChange;

public class Payment {
	public static final String SERVICE = "service";
	public static final String NOTIFY_URL = CommonPayInfo.get("aliforex_notify_url");
	public static final String RETURN_URL = CommonPayInfo.get("aliforex_return_url");
	public static final String CURRENCY = CommonPayInfo.get("aliforex_currency");
	public static final String PARNER_ID = CommonPayInfo.get("aliforex_partnerid");
	public static final String GATEWAY = CommonPayInfo.get("aliforex_paygateway");
	public static final String CHARTSET = CommonPayInfo.get("aliforex_input_charset");
	public static final String KEY = CommonPayInfo.get("aliforex_key");
	public static final String SERVICE_CREATE_FOREX_TRADE = "create_forex_trade";
	public static final String SERVICE_GET_LIQUIDATION_FILE = "forex_liquidation_file";
	public static final String SERVICE_GET_RATE_FILE = "forex_rate_file";
	public static final String SERVICE_QUERY_SINGLE_TRADE = "single_trade_query";
	public static final String SERVICE_PUSH_REFUND_FILE = "forex_refund_file";
	
	public static final String SIGN = "sign";
	public static final String SIGN_TYPE = "MD5";
	public static final String OUT_TRADE_NO = "out_trade_no";
	
	
		
	public static String Create(Map<String,String> inputParam,String service) {

        Map params = new HashMap();
        params.put("partner", PARNER_ID);
        params.put(SERVICE, service);
        if(inputParam != null && inputParam.size()>0)
        params.putAll(inputParam);
        String prestr = "";

        prestr = prestr + KEY;
        //System.out.println("prestr=" + prestr);

        String sign = Md5Encrypt.md5(getContent(params, KEY));

        String parameter = "";
        parameter = parameter + GATEWAY;

        List keys = new ArrayList(params.keySet());
        for (int i = 0; i < keys.size(); i++) {
            try {
                parameter = parameter + keys.get(i) + "="
                            + URLEncoder.encode((String) params.get(keys.get(i)), CHARTSET) + "&";
            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();
            }
        }

        parameter = parameter + "sign=" + sign + "&sign_type=" + SIGN_TYPE;

        return parameter;

    }
	
	 public static String CreateUrl(String start_date,String end_date) {

	        Map params = new HashMap();
	        params.put(SERVICE, SERVICE_GET_LIQUIDATION_FILE);
	        params.put("partner", PARNER_ID);
	        params.put("start_date", start_date);
	        params.put("end_date", end_date);
	        params.put("_input_charset", CHARTSET);
	        String prestr = "";

	        prestr = prestr + KEY;
	        //System.out.println("prestr=" + prestr);

	        String sign = Md5Encrypt.md5(getContent(params, KEY));

	        String parameter = "";
	        parameter = parameter + GATEWAY;

	        List keys = new ArrayList(params.keySet());
	        for (int i = 0; i < keys.size(); i++) {
	            try {
	                parameter = parameter + keys.get(i) + "="
	                            + URLEncoder.encode((String) params.get(keys.get(i)), CHARTSET) + "&";
	            } catch (UnsupportedEncodingException e) {

	                e.printStackTrace();
	            }
	        }

	        parameter = parameter + "sign=" + sign + "&sign_type=" + SIGN_TYPE;

	        return parameter;

	    }
	
	public static String CreateUrl(Map<String,String> inputParam,String service) {

		Map<String,String> params = new HashMap<String,String>();
		params.put(SERVICE, service);
		params.put("partner", PARNER_ID);
		params.put("currency", CURRENCY);
		params.put("return_url", RETURN_URL);
		params.put("notify_url", NOTIFY_URL);
		params.put("_input_charset",CHARTSET);
		
		requiredPut(params, inputParam,"out_trade_no");
		requiredPut(params,inputParam,"total_fee");
		requiredPut(params,inputParam,"subject");
		optionalPut(params, inputParam,"body");

		Map<String,String> formHiddenInputs = new HashMap<String,String>();
		for (String key : params.keySet()) {
			String val = params.get(key);
			formHiddenInputs.put(key, val);
		}
		
		formHiddenInputs.put("sign",signWithMD5(params));
		formHiddenInputs.put("sign_type",SIGN_TYPE);
		
		return genFormHtml(formHiddenInputs);

	}

	private static String signWithMD5(Map<String, String> params) {
		String gb2312Str = UnicodeChange.utf8Togb2312(getContent(params, KEY));
		System.out.println(gb2312Str);
		String md5 = Md5Encrypt.md5(gb2312Str);
		return md5;
	}

	private static String genFormHtml(Map<String,String> formHiddenInputs) {
		StringBuffer sb = new StringBuffer("<form name='aliforex_pay_form' method='GET' action='"+ GATEWAY + "'>");
		for (Entry<String, String> entry: formHiddenInputs.entrySet()) {
			fillInputField(sb, entry);
		}
		sb.append("</form><script>document.charset='"+CHARTSET + "';document.forms.aliforex_pay_form.submit();</script>");
		return sb.toString();
	}

	private static void optionalPut(Map<String, String> params,Map<String, String> inputparams, String key) {
		String val = inputparams.get(key);
		if(val != null) {
			params.put(key,val);
		}
	}
	
	private static void requiredPut(Map<String, String> params,Map<String, String> inputparams, String key) {
		String val = inputparams.get(key);
		if(val == null) {
			throw new IllegalArgumentException(" field: " +key+" is manditory!");
		}else {
			
			params.put(key,val);
		}
	}

	private static void fillInputField(StringBuffer sb,
			Entry<String, String> entry) {
		sb.append("<input type='hidden' ")
		  .append("name='").append(entry.getKey()).append("' value='").append(entry.getValue())
		  .append("' />");
	}
	
	private static String convert2utf8(String src) {
		try {
			return new String(src.getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return src;
		
	}
	private static String getContent(Map params, String privateKey) {
		List keys = new ArrayList(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = (String) params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr + privateKey;
	}
}
*/
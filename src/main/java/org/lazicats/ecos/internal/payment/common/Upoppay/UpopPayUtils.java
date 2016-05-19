package org.lazicats.ecos.internal.payment.common.Upoppay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.lazicats.ecos.basecomponent.utils.DateUtils;
import org.lazicats.ecos.basecomponent.utils.StringUtils;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Upoppay.model.UPOPPaymentParam;
import org.lazicats.ecos.internal.utils.HttpClientUtils;
import org.lazicats.ecos.internal.utils.HttpsUtils;
import org.lazicats.ecos.internal.utils.HttpsUtils.KeystoreInfo;

public class UpopPayUtils {

	private String md5(String str) {

		if (str == null) {
			return null;
		}
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(PayConf.signType);
			messageDigest.reset();
			messageDigest.update(str.getBytes(CommonPayInfo.BankPayInfo
					.get("upop_charset")));
		} catch (NoSuchAlgorithmException e) {
			return str;
		} catch (UnsupportedEncodingException e) {
			return str;
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}

	private String joinMapValue(Map<String, String> map, char connector) {
		StringBuffer b = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (StringUtils.isNotBlank(entry.getValue())) {
				b.append(entry.getValue());
				b.append(connector);
			}

		}

		return b.toString();
	}

	/**
	 * verify return msg using MD5 signing.
	 * 
	 * @param valueVo
	 * @param signature
	 * @return
	 */
	public boolean checkMD5Signature(String[] valueVo, String signature) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i < PayConf.notifyVo.length; i++) {
			map.put(PayConf.notifyVo[i], valueVo[i]);
		}

		if (signature == null)
			return false;

		String encodeSource = joinMapValue(map, '+')
				+ md5(CommonPayInfo.BankPayInfo.get("upop_pkey"));
		System.out.println("md5 encoding source - [" + encodeSource + "]");
		return signature.equals(md5(encodeSource));
	}

	/**
	 * generate the html payment form for the upop payment.
	 * 
	 * @param name
	 * @param action
	 * @param upoppaymentParam
	 * @return
	 */
	public static String createHtmlPaymentForm(String name, String action,
			UPOPPaymentParam upoppaymentParam) {
		StringBuffer result = new StringBuffer();
		if (upoppaymentParam.validate()) {// make sure the param pass the
											// valiation

			String[][] param = {
					{ "MerId", upoppaymentParam.getMerId() },
					{ "OrderNo", upoppaymentParam.getOrderNo() },
					{ "OrderAmount", upoppaymentParam.getOrderAmount() },
					{ "CurrCode", upoppaymentParam.getCurrCode() },
					{ "OrderType", upoppaymentParam.getOrderType() },
					{ "CallBackUrl", upoppaymentParam.getCallBackUrl() },
					// {"ResultMode",upoppaymentParam.getResultMode()},
					{ "BankCode", upoppaymentParam.getBankCode() },
					{ "LangType", upoppaymentParam.getLangType() },
					// {"EntryMode",upoppaymentParam.getEntryMode()},
					{ "BuzType", upoppaymentParam.getBuzType() },
					// {"Reserved01",UPOPPaymentParam.utf82gbk(upoppaymentParam.getReserved01())},
					{ "Reserved01", upoppaymentParam.getReserved01() },
					{ "Reserved02", upoppaymentParam.getReserved02() },
					{ "SignMsg", sign(upoppaymentParam) } };

			result.append("<form method='post' accept-charset='GB2312' ")
					.append("name='").append(name).append("' ")
					.append("action='").append(action).append("' ")
					.append(" >");
			for (String[] pairs : param) {
				String nameStr = pairs[0];
				String valStr = pairs[1];
				result.append("<input type=\"hidden\" name=\"").append(nameStr)
						.append("\"").append(" value=\"").append(valStr)
						.append("\"/>");

			}

			result.append("</form>");
			result.append("<script>");
			result.append("document.charset='GB2312';");
			result.append("document.all.").append(name).append(".submit();");
			result.append("</script>");

		} else {
			// TODO THROW A EXCEPTION WHEN THE REQUIREMENT FOR PARAM IS NOT
			// PASSED.
		}

		return result.toString();
	}

	public static String sign(UPOPPaymentParam upoppaymentParam) {
		PayUtils payUtils = new PayUtils();
		String sourceText = upoppaymentParam.getSourceStr();// utf8
		System.out.println("SourceMsg:" + sourceText);
		return payUtils.md5(CharacterEncodeConverter.utf82gbk(sourceText)
				+ payUtils.md5(upoppaymentParam.getPkey()));

	}

	public static boolean verify(String orderNo) 
			throws Exception {
		String url = CommonPayInfo.BankPayInfo.get("upop_queryUrl");
		System.out.println(CommonPayInfo.BankPayInfo.get("upop_queryRange"));
		String data = constructRequestData(orderNo);
		
		String respText = null; 	
		if (url.startsWith("https")) {
		    KeystoreInfo ksInfo = new KeystoreInfo();
		    ksInfo.setKeyStoreType("JKS");
		    ksInfo.setKeyStoreFilePath(CommonPayInfo.BankPayInfo.get("upop_keystore"));
		    ksInfo.setKeyStorePass(CommonPayInfo.BankPayInfo.get("upop_ksPwd"));
		    ksInfo.setKeyPass(CommonPayInfo.BankPayInfo.get("upop_ksPwd"));
			respText = HttpsUtils.httpsPost(url, data,ksInfo);

		} else if (url.startsWith("http")) {
			String urlWithParm = url + "?" + data;
			System.out.println(urlWithParm);
			respText = HttpClientUtils.httpGet(urlWithParm);
		}

		System.out.println(respText);
		if (respText.startsWith("Code=")) {
			System.out.println(respText);
			return false;
		} else {
			if (respText.contains(orderNo))
				return true;
			else
				return false;
		}

	}

	private static String constructRequestData(String orderNo) {
		String data = "Version=V60"
					+ "&TranType=100"
					+ "&JavaCharset=UTF-8"
					+ "&MerId=" + CommonPayInfo.BankPayInfo.get("upop_merId")
					+ "&UserId=" + CommonPayInfo.BankPayInfo.get("upop_userId")
					+ "&Pwd=" + CommonPayInfo.BankPayInfo.get("upop_userPwd")
					+ "&PayStatus=1"
					+ "&ShoppingTime="+getShoppingtime()
					+ (orderNo == null ? "" : "&OrderNo=" + orderNo);
		return data;
	}
	
	public static String getQueryOrderResl(String orderNo) 
			throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, FileNotFoundException, IOException {
		String url = CommonPayInfo.BankPayInfo.get("upop_queryUrl");
		System.out.println(CommonPayInfo.BankPayInfo.get("upop_queryRange"));
		String data = constructRequestData(orderNo);
		String respText = null;
		if (url.startsWith("https")) {
		  KeystoreInfo ksInfo = new KeystoreInfo();
          ksInfo.setKeyStoreType("JKS");
          ksInfo.setKeyStoreFilePath(CommonPayInfo.BankPayInfo.get("upop_keystore"));
          ksInfo.setKeyStorePass(CommonPayInfo.BankPayInfo.get("upop_ksPwd"));
          ksInfo.setKeyPass(CommonPayInfo.BankPayInfo.get("upop_ksPwd"));
			respText = HttpsUtils.httpsPost(url, data,ksInfo);

		} else if (url.startsWith("http")) {
			String urlWithParm = url + "?" + data;
			System.out.println(urlWithParm);
			respText = HttpClientUtils.httpGet(urlWithParm);
		}

		System.out.println(respText);
		return respText;
	}


	private static String getRangeBaseOnCurrent(int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long l = System.currentTimeMillis() - i * 60 * 1000;
		String format = sdf.format(getDate(l));
		System.out.println(format);
		String format2 = sdf.format(getDate(System.currentTimeMillis()));
		System.out.println(format2);
		return "BeginTime=" + URLEncoder.encode(format) + "&EndTime="
				+ URLEncoder.encode(format2);
	}
	
	private static String getShoppingtime() {
		String currentDateTime = DateUtils.getCurrentDateTime("yyyy-MM-dd 00:00:00");
		//String currentDateTime = "2015-12-11 00:00:00";
		return currentDateTime;
	}

	public static Date getDate(long miliSec) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(miliSec);
		return instance.getTime();
	}

}

package org.lazicats.ecos.internal.payment.common.Unionpay;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.utils.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 名称：支付工具类 功能：工具类，可以生成付款表单等 类属性：公共类 版本：1.0 日期：2011-03-11 作者：中国银联UPOP团队 版权：中国银联
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。该代码仅供参考。
 * */
public class UnionPayUtils {

	Logger log = Logger.getLogger(UnionPayUtils.class);
	
	/**
	 * 生成发送银联报文页面
	 * 
	 * @param map
	 * @param signature
	 * @return
	 */
	public String createPayHtml(String[] valueVo, String signType) {
		Map<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < UnionPayConf.reqVo.length; i++) {
			map.put(UnionPayConf.reqVo[i], StringUtils.StringCharSet(valueVo[i], "UTF-8", CommonPayInfo.BankPayInfo.get("unionPay_charset")));
		}
		
		map.put("signature", signMap(map, signType));
		map.put("signMethod", signType);
		String payForm = generateAutoSubmitForm(CommonPayInfo.BankPayInfo.get("unionPay_url"), map);
		
		return payForm;
	}

	public String createBackStr(String[] valueVo, String[] keyVo) {
		Map<String, String> map = new TreeMap<String, String>();
		
		for (int i = 0; i < keyVo.length; i++) {
			map.put(keyVo[i], valueVo[i]);
		}
		
		map.put("signature", signMap(map, UnionPayConf.signType));
		map.put("signMethod", UnionPayConf.signType);
		
		return joinMapValue(map, '&');
	}

	public String createBackStrForBackTrans(String[] valueVo, String[] keyVo) {

		Map<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < keyVo.length; i++) {
			map.put(keyVo[i], valueVo[i]);
		}
		map.put("signature", signMap(map, UnionPayConf.signType));
		map.put("signMethod", UnionPayConf.signType);
		return joinMapValueBySpecial(map, '&');
	}

	/**
	 * 查询验证签名
	 * 
	 * @param valueVo
	 * @return 0:验证失败 1验证成功 2没有签名信息（报文格式不对）
	 */
	public int checkSecurity(String[] valueVo) {
		Map<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < valueVo.length; i++) {
			String[] keyValue = valueVo[i].split("=");
			map.put(keyValue[0], keyValue.length >= 2 ? valueVo[i].substring(keyValue[0].length() + 1) : "");
		}
		if ("".equals(map.get("signature"))) {
			return 2;
		}
		String signature = map.get("signature");
		boolean isValid = false;
		if (UnionPayConf.signType.equalsIgnoreCase(map.get("signMethod"))) {
			map.remove("signature");
			map.remove("signMethod");
			isValid = signature.equals(md5(joinMapValue(map, '&') + md5(CommonPayInfo.BankPayInfo.get("unionPay_securitKey"))));
		} else {
			isValid = verifyWithRSA(map.get("signMethod"), md5(joinMapValue(map, '&') + md5(CommonPayInfo.BankPayInfo.get("unionPay_securitKey"))), signature);
		}

		return (isValid ? 1 : 0);
	}

	/**
	 * 生成加密钥
	 * 
	 * @param map
	 * @param secretKey
	 *            商城密钥
	 * @return
	 */
	private String signMap(Map<String, String> map, String signMethod) {
		if (UnionPayConf.signType.equalsIgnoreCase(signMethod)) {
			String strBeforeMd5 = joinMapValue(map, '&') + md5(CommonPayInfo.BankPayInfo.get("unionPay_securitKey"));
			return md5(strBeforeMd5);
		} else {
			return signWithRSA(md5(joinMapValue(map, '&') + md5(CommonPayInfo.BankPayInfo.get("unionPay_securitKey"))));
		}
	}

	private String signWithRSA(String signData) {
		ObjectInputStream priObjectIs = null;
		try {
			priObjectIs = new ObjectInputStream(new FileInputStream(CommonPayInfo.BankPayInfo.get("unionPay_keyPath")));
			PrivateKey privateKey = PrivateKey.class.cast(priObjectIs.readObject());
			Signature dsa = Signature.getInstance(CommonPayInfo.BankPayInfo.get("unionPay_keyPass"));
			dsa.initSign(privateKey);
			dsa.update(signData.getBytes(CommonPayInfo.BankPayInfo.get("unionPay_charset")));
			byte[] signature = dsa.sign();
			BASE64Encoder base64Encoder = new BASE64Encoder();
			return base64Encoder.encode(signature);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (priObjectIs != null) {
				try {
					priObjectIs.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private boolean verifyWithRSA(String algorithm, String signData,
			String signature) {
		ObjectInputStream pubObjectIs = null;
		try {
			CertificateFactory factory = CertificateFactory.getInstance("X.509");
			InputStream in = new FileInputStream(CommonPayInfo.BankPayInfo.get("unionPay_certPath"));
			Certificate cert = factory.generateCertificate(in);
			PublicKey publicKey = cert.getPublicKey();
			Signature signCheck = Signature.getInstance(CommonPayInfo.BankPayInfo.get("unionPay_keyPass"));
			signCheck.initVerify(publicKey);
			signCheck.update(signData.getBytes(CommonPayInfo.BankPayInfo.get("unionPay_charset")));
			BASE64Decoder base64Decoder = new BASE64Decoder();
			return signCheck.verify(base64Decoder.decodeBuffer(signature));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (pubObjectIs != null) {
				try {
					pubObjectIs.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 验证签名
	 * 
	 * @param map
	 * @param secretKey
	 *            商城密钥
	 * @return
	 */
	public boolean checkSign(String[] valueVo, String signMethod, String signature) {

		Map<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < UnionPayConf.notifyVo.length; i++) {
			map.put(UnionPayConf.notifyVo[i], valueVo[i]);
		}

		if (signature == null)
			return false;
		if (UnionPayConf.signType.equalsIgnoreCase(signMethod)) {
			return signature.equals(md5(joinMapValue(map, '&') + md5(CommonPayInfo.BankPayInfo.get("unionPay_securitKey"))));
		} else {
			return verifyWithRSA(signMethod, md5(joinMapValue(map, '&') + md5(CommonPayInfo.BankPayInfo.get("unionPay_securitKey"))), signature);
		}

	}

	public static String[] getResArr(String str) {
		String regex = "(.*?cupReserved\\=)(\\{[^}]+\\})(.*)";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);

		String reserved = "";
		if (matcher.find()) {
			reserved = matcher.group(2);
		}

		String result = str.replaceFirst(regex, "$1$3");
		String[] resArr = result.split("&");
		for (int i = 0; i < resArr.length; i++) {
			if ("cupReserved=".equals(resArr[i])) {
				resArr[i] += reserved;
			}
		}
		return resArr;
	}

	private String joinMapValue(Map<String, String> map, char connector) {
		StringBuffer b = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			b.append(entry.getKey());
			b.append('=');
			if (entry.getValue() != null) {
				b.append(entry.getValue());
			}
			b.append(connector);
		}
		return b.toString();
	}

	private String joinMapValueBySpecial(Map<String, String> map, char connector) {
		StringBuffer b = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {

			b.append(entry.getKey());
			b.append('=');
			if (entry.getValue() != null) {
				try {
					b.append(java.net.URLEncoder.encode(entry.getValue(), CommonPayInfo.BankPayInfo.get("unionPay_charset")));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			b.append(connector);
		}
		return b.toString();
	}

	/**
	 * get the md5 hash of a string
	 * 
	 * @param str
	 * @return
	 */
	private String md5(String str) {

		if (str == null) {
			return null;
		}

		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance(UnionPayConf.signType);
			messageDigest.reset();
			messageDigest.update(str.getBytes(CommonPayInfo.BankPayInfo.get("unionPay_charset")));
		} catch (NoSuchAlgorithmException e) {
			return str;
		} catch (UnsupportedEncodingException e) {
			return str;
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	public void destroy() {
	}

	/**
	 * 查询方法
	 * 
	 * @param strURL
	 * @param req
	 * @return
	 */
	public String doPostQueryCmd(String strURL, String req) {
		String result = null;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			URL url = new URL(strURL);
			URLConnection con = url.openConnection();
			// if (con instanceof HttpsURLConnection) {
			// ((HttpsURLConnection) con).setHostnameVerifier(new
			// HostnameVerifier() {
			// @Override
			// public boolean verify(String hostname, SSLSession session) {
			// return true;
			// }
			// });
			// }
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			out = new BufferedOutputStream(con.getOutputStream());
			byte outBuf[] = req.getBytes(CommonPayInfo.BankPayInfo.get("unionPay_charset"));
			out.write(outBuf);
			out.close();
			in = new BufferedInputStream(con.getInputStream());
			result = ReadByteStream(in);
		} catch (Exception ex) {
			System.out.print(ex);
			return "";
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		if (result == null)
			return "";
		else
			return result;
	}

	private static String ReadByteStream(BufferedInputStream in)
			throws IOException {
		LinkedList<Mybuf> bufList = new LinkedList<Mybuf>();
		int size = 0;
		byte buf[];
		do {
			buf = new byte[128];
			int num = in.read(buf);
			if (num == -1)
				break;
			size += num;
			bufList.add(new Mybuf(buf, num));
		} while (true);
		buf = new byte[size];
		int pos = 0;
		for (ListIterator<Mybuf> p = bufList.listIterator(); p.hasNext();) {
			Mybuf b = p.next();
			for (int i = 0; i < b.size;) {
				buf[pos] = b.buf[i];
				i++;
				pos++;
			}

		}

		return new String(buf,CommonPayInfo.BankPayInfo.get("unionPay_charset"));
	}

	/**
	 * 生成支付提交表单
	 * 
	 * @param actionUrl
	 * @param paramMap
	 * @return
	 */
	private static String generateAutoSubmitForm(String actionUrl,
			Map<String, String> paramMap) {
		StringBuilder html = new StringBuilder();
		html.append("<form id=\"unionpay\" name=\"unionpay\" action=\"").append(actionUrl).append("\" method=\"post\">\n");

		for (String key : paramMap.keySet()) {
			String value = paramMap.get(key);
			html.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + value + "\">\n");
		}
		html.append("</form>\n");
		html.append("<script>document.forms['unionpay'].submit();</script>");
		return html.toString();
	}

	public static void main(String[] aaa) {
		String a = "charset=UTF-8&cupReserved=&exchangeDate=&exchangeRate=&merAbbr=联动优势&merId=100000000000025&orderAmount=1&orderCurrency=156&orderNumber=9002111465&qid=201106030000005928402&respCode=00&respMsg=Success!&respTime=20110603214534&settleAmount=1&settleCurrency=156&settleDate=0419&traceNumber=592840&traceTime=0603000000&transType=01&version=1.0.0&8ddcff3a80f4189ca1c9d4d902c3c909";
		System.out.print(new UnionPayUtils().md5(a));
	}

}

class Mybuf {

	public byte buf[];
	public int size;

	public Mybuf(byte b[], int s) {
		buf = b;
		size = s;
	}
}

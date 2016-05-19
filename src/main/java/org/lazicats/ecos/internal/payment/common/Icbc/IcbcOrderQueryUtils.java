package org.lazicats.ecos.internal.payment.common.Icbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.lazicats.ecos.internal.common.CommonPayInfo;

/**
 * 
 * @FileName IcbcOrderQueryUtils.java
 * @PackageName org.lazicats.ecos.internal.payment.common.Icbc
 * @功能 工行订单支付状态查询接口
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-16上午11:07:21
 *
 */
public class IcbcOrderQueryUtils {
	
	public static void main(String[] args) {
		System.out.println("===============================================================");
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderId", "1386598703921694123");
		map.put("tranDate", "20131209");
		
		String result = queryAPIHelper(map);
		System.out.println("查询结果：" + result);
	}

	/**
	 * 
	 * #############################################################
	 * 
	 * *********************查询接口********************************
	 * 
	 * #############################################################
	 */
	private static HostnameVerifier hnv = new HostnameVerifier() {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};

	/**
	 * 信任所有证书
	 */
	private static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkServerTrusted(X509Certificate[] certs, String authType) {
			return;
		}

		public void checkClientTrusted(X509Certificate[] certs, String authType) {
			return;
		}
	} };

	/**
	 * 工行订单查询，请求封装、请求执行
	 * 
	 * @param queryMap
	 * @return
	 */
	@SuppressWarnings("unused")
	protected static String queryAPIHelper(Map<String, String> queryMap) {
		SSLSocketFactory ssf = null;
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";

		try {
			// init context
			SSLContext ctx = SSLContext.getInstance("TLS");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			KeyStore ks = KeyStore.getInstance("PKCS12");

			ks.load(new FileInputStream(CommonPayInfo.BankPayInfo.get("icbcquery_pfx")), CommonPayInfo.BankPayInfo.get("icbcquery_pfxpass").toCharArray());
			kmf.init(ks, CommonPayInfo.BankPayInfo.get("icbcquery_pfxpass").toCharArray());
			ctx.init(kmf.getKeyManagers(), trustAllCerts, null);
			ssf = ctx.getSocketFactory();
			HttpsURLConnection.setDefaultSSLSocketFactory(ssf);
			HttpsURLConnection.setDefaultHostnameVerifier(hnv);
			URL realUrl = new URL(CommonPayInfo.BankPayInfo.get("icbcquery_Url"));
			// 打开连接
			HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream());
			// 发送请求参数
			String data = "APIName=EAPI&APIVersion=001.001.002.001&MerReqData=";
			String xml = "<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?>"
					+ "<ICBCAPI>"
					+ "<in>"
					+ "<orderNum>"
					+ queryMap.get("orderId")
					+ "</orderNum>"
					+ "<tranDate>"
					+ queryMap.get("tranDate")
					+ "</tranDate>"
					+ "<ShopCode>"
					+ CommonPayInfo.BankPayInfo.get("icbcPay_merCode")
					+ "</ShopCode>"
					+ "<ShopAccount>"
					+ CommonPayInfo.BankPayInfo.get("icbcPay_merAcct") + "</ShopAccount>" + "</in>" + "</ICBCAPI>";
			data = data + xml;// java.net.URLEncoder.encode(xml);
			out.write(data);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			
			result = java.net.URLDecoder.decode(result,"GB2312").trim();
			result = new String(result.getBytes("GB2312"), "UTF-8");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}

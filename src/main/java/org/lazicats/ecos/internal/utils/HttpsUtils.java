package org.lazicats.ecos.internal.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;

/**
 *jay 3
 */
public class HttpsUtils {
  private static final String DEFAULT_KEYSTORE_TYPE = "PKCS12";

  private static final String DEFAULT_KEY_MANAGER_FACTORY = "SunX509";

  private static final String SSL_CONTEXT_INSTANCE_TYPE = "TLS";

  private static  Logger log = Logger.getLogger(HttpsUtils.class);
	
	private static HostnameVerifier hnv = new HostnameVerifier() {
		public boolean verify(String hostname, SSLSession session) {
		    System.out.println(hostname);
			return false;
		}
	};

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
	
	public static class KeystoreInfo{
	  private  String keyStoreFilePath;
	  private  String keyStorePass;
	  private  String keyStoreType;
	  private  String keyPass;
	  
	  public KeystoreInfo(){
	    
	  }
	  
	  public KeystoreInfo(String keyStoreFilePath, String keyStorePass, String keyStoreType,
	      String keyPass) {
	    super();
	    this.keyStoreFilePath = keyStoreFilePath;
	    this.keyStorePass = keyStorePass;
	    this.keyStoreType = keyStoreType;
	    this.keyPass = keyPass;
	  }

	  public String getKeyStoreFilePath() {
	    return keyStoreFilePath;
	  }

	  public void setKeyStoreFilePath(String keyStoreFilePath) {
	    this.keyStoreFilePath = keyStoreFilePath;
	  }

	  public String getKeyStorePass() {
	    return keyStorePass;
	  }

	  public void setKeyStorePass(String keyStorePass) {
	    this.keyStorePass = keyStorePass;
	  }

	  public String getKeyStoreType() {
	    return keyStoreType;
	  }

	  public void setKeyStoreType(String keyStoreType) {
	    this.keyStoreType = keyStoreType;
	  }

	  public String getKeyPass() {
	    return keyPass;
	  }

	  public void setKeyPass(String keyPass) {
	    this.keyPass = keyPass;
	  }
	
	}
	
	public static void setupSSL(KeystoreInfo keystore) 
			throws NoSuchAlgorithmException, KeyStoreException, 
				CertificateException, FileNotFoundException, 
					IOException, UnrecoverableKeyException, KeyManagementException {
	  KeyManager[] km = null;
	  if(keystore != null){
	    KeyManagerFactory kmf = KeyManagerFactory.getInstance(DEFAULT_KEY_MANAGER_FACTORY);
	    KeyStore ks = KeyStore.getInstance(keystore.getKeyStoreType()==null
	                      ?DEFAULT_KEYSTORE_TYPE:keystore.getKeyStoreType());
	    ks.load(new FileInputStream(keystore.getKeyStoreFilePath()),
	                      keystore.getKeyStorePass().toCharArray());
	    kmf.init(ks,keystore.getKeyPass().toCharArray());
	    
	    km = kmf.getKeyManagers();
	  }
	  
	  SSLContext ctx = SSLContext.getInstance(SSL_CONTEXT_INSTANCE_TYPE);
	  ctx.init(km, trustAllCerts, null);
	  SSLSocketFactory ssf = ctx.getSocketFactory();
	  HttpsURLConnection.setDefaultSSLSocketFactory(ssf);
	  HttpsURLConnection.setDefaultHostnameVerifier(hnv);
	}

	public static String httpsPost(String url,String paramStr,KeystoreInfo keystore) 
			throws UnrecoverableKeyException, KeyManagementException, 
			            NoSuchAlgorithmException, KeyStoreException, 
			                CertificateException, FileNotFoundException, IOException {
		setupSSL(keystore);
		log.info("going to make request[" + url + "] with parameter["+ paramStr +"]" );
		log.info("url:" + url + "?" + paramStr);
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";

		try {
			URL realUrl = new URL(url);
			// 打开连接
			HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setConnectTimeout(100*1000);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 8.0; "
					+ "Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727;"
					+ " .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream());
			// 发送请求参数
			out.write(paramStr);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			
			/*result = java.net.URLDecoder.decode(result, "GB2312").trim();
			result = new String(result.getBytes("GB2312"), "UTF-8");*/
			log.info("get respond["+ result +"] from[" + url + "]");
			return result;
		} catch (MalformedURLException e) {
			log.error("malformed url[" + url + "]");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("sth wrong with io!");
			e.printStackTrace();
		} finally {
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

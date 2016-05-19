package org.lazicats.ecos.internal.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import com.google.common.io.Files;
import com.google.common.io.InputSupplier;


/**
 * 
 * @author Jay review4
 *
 */
public class PostHttp {
	
	public static void post(String url,String data){
		doHttpPost(url,
				getNameValuePairs(data),"&");
		
	}
	
	public static class  UTF8PostMethod  extends  PostMethod {   
        public  UTF8PostMethod ( String url ){   
            super ( url ) ;   
        }   
        @Override   
        public  String getRequestCharSet () {   
            //return super.getRequestCharSet();   
        	System.out.println("getting...");
            return  "utf-8" ;   
        }   
    }   
	
	private static NameValuePair[] getNameValuePairs(String data) {
		
		String[] nameValuePairs = data.split("&");
		
		
		NameValuePair[] nameValuePairsArr =
								new NameValuePair[nameValuePairs.length];
		for (int i = 0; i < nameValuePairs.length; i++) {
			String[] nameValuePair = nameValuePairs[i].split("=");
			System.out.println(nameValuePairs[i]);
			
			String name = "";
			String value = "";
			for (int j = 0; j < nameValuePair.length; j++) {
				if(0==j){
					 name = nameValuePair[0];
				}else{
					 value = nameValuePair[1];
				}
			}
			
			
			nameValuePairsArr[i] = new NameValuePair(name,value);
		}
	
		return nameValuePairsArr;
	}
	
	private static Logger logger = Logger.getLogger(PostHttp.class);
	
	/**
	 * 以http方式发起post请求
	 * 
	 * @param url 请求路径
	 * @param data 请求参数
	 * @param seperator 参数拼接的分割符
	 */
	public static void doHttpPost(String url,NameValuePair[] data,String seperator) {
	
		
	
		PostMethod postMethod = new UTF8PostMethod(url);
		
		/*StringBuilder sb = new StringBuilder();
		for (NameValuePair nameValuePair : data) {
			if(!nameValuePair.getValue().isEmpty())
			sb.append(nameValuePair.getValue()).append(seperator);
		}*/
		//postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
		//postMethod.addRequestHeader("Content-Type","application;charset=UTF-8");
		//postMethod.addRequestHeader("Content-Type","charset=UTF-8");
		postMethod.setRequestBody(data);
		int statusCode = 0;
		try {
			HttpClient httpClient = new HttpClient();
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// redirect if needed
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			Header locationHeader = postMethod.getResponseHeader("location");
			String location = null;
			if (locationHeader != null) {
				location = locationHeader.getValue();
				logger.info("The page was redirected to:" + location);
			} else {
				System.err.println("Location field value is null.");
			}
			return;
		} else {
			logger.info(postMethod.getStatusLine());
			String str = "";
			try {
				str = HttpClientUtils.strFrom(
							postMethod.getResponseBodyAsStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info(str);
		}
		
		postMethod.releaseConnection();
		return;
	}
	
	/**
	 * 以http get的方式下载文件来本地
	 * @param localFileName 保存文件的本地路径
	 * @param url 下载文件的url
	 */
	public static void downLoad(String localFileName, String url) {
        HttpClient client = new HttpClient();
        GetMethod get = null;
    
        
        try {
            get = new GetMethod(url);
            //可以设置一些头文件属性值
          
            int i = client.executeMethod(get);
            if (HttpStatus.SC_OK == i) {
                File storeFile = new File(localFileName);
                final InputStream is = get.getResponseBodyAsStream();
                Files.copy(new InputSupplier<InputStream>() {

					@Override
					public InputStream getInput() throws IOException {
						return is;
					}
                	
				}, storeFile);
            } else {
            	if(logger.isInfoEnabled())
            	logger.info("DownLoad file occurs exception, the error code is :" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            get.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
    }
	
	/**
	 * 以http get的方式请求资源
	 * @param url
	 * @param data
	 * @return
	 */
	public static String doHttpGet(String url,String data) {
		String str = "";
		HttpClient httpClient = new HttpClient();
		
		GetMethod postMethod = new GetMethod(url);
		
		postMethod.setQueryString(data);
		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.info(statusCode);
		// HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发
		// 301或者302
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			// 从头中取出转向的地址
			Header locationHeader = postMethod.getResponseHeader("location");
			String location = null;
			if (locationHeader != null) {
				location = locationHeader.getValue();
				logger.info("The page was redirected to:" + location);
			} else {
				System.err.println("Location field value is null.");
			}
			return str;
		} else {
			logger.info(postMethod.getStatusLine());
			
			try {
				str = HttpClientUtils.strFrom(postMethod.getResponseBodyAsStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info(str);
		}
		postMethod.releaseConnection();
		return str;
	}
	
	public static String doHttpPost(String url,String data) {
		String str = "";
		HttpClient httpClient = new HttpClient();
		
		PostMethod postMethod = new PostMethod(url);
		postMethod.addRequestHeader("Content-Type","text/xml;charset=UTF-8");
		logger.info(data);
		postMethod.setRequestBody(data);
		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//logger.info(statusCode);
		// HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发
		// 301或者302
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			// 从头中取出转向的地址
			Header locationHeader = postMethod.getResponseHeader("location");
			String location = null;
			if (locationHeader != null) {
				location = locationHeader.getValue();
				logger.info("The page was redirected to:" + location);
			} else {
				System.err.println("Location field value is null.");
			}
			return str;
		} else {
			logger.info(postMethod.getStatusLine());
			
			try {
				str = HttpClientUtils.strFrom(postMethod.getResponseBodyAsStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//logger.info(str);
		}
		postMethod.releaseConnection();
		return str;
	}

}
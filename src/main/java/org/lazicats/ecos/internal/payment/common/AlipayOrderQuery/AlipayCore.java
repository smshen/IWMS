package org.lazicats.ecos.internal.payment.common.AlipayOrderQuery;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;

/**
 * 
 * @FileName AlipayCore.java
 * @PackageName org.lazicats.ecos.internal.payment.common.AlipayOrderQuery
 * @功能 请求、通知返回两个文件所调用的公用函数核心处理文件 
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-17下午2:19:33
 *
 */
public class AlipayCore {

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	protected static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("")
					|| key.equalsIgnoreCase("sign")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	protected static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	 * 生成文件摘要
	 * 
	 * @param strFilePath
	 *            文件路径
	 * @param file_digest_type
	 *            摘要算法
	 * @return 文件摘要结果
	 */
	protected static String getAbstract(String strFilePath, String file_digest_type)
			throws IOException {
		PartSource file = new FilePartSource(new File(strFilePath));
		if (file_digest_type.equals("MD5")) {
			return DigestUtils.md5Hex(file.createInputStream());
		} else if (file_digest_type.equals("SHA")) {
			return DigestUtils.sha256Hex(file.createInputStream());
		} else {
			return "";
		}
	}
}

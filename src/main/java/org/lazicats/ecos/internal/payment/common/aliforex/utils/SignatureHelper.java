/*package org.lazicats.ecos.internal.payment.common.aliforex.utils;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SignatureHelper {
	public static String sign(Map params, String privateKey) {
		Properties properties = new Properties();

		for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			Object value = params.get(name);

			if (name == null || name.equalsIgnoreCase("sign")
					|| name.equalsIgnoreCase("sign_type")) {
				continue;
			}

			properties.setProperty(name, value.toString());

		}

		String content = getSignatureContent(properties);
		return sign(content, privateKey);
	}

	public static String getSignatureContent(Properties properties) {
		StringBuffer content = new StringBuffer();
		List keys = new ArrayList(properties.keySet());
		Collections.sort(keys);

		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = properties.getProperty(key);
			content.append((i == 0 ? "" : "&") + key + "=" + value);
		}

		return content.toString();
	}

	public static String sign(String content, String privateKey) {
		if (privateKey == null) {
			return null;
		}
		String signBefore = content + privateKey;
		// System.out.print("signBefore=" + signBefore);

		// *****************************************************************
		// ��alipay�յ���Ϣ����ѽ��ܵ���Ϣд����־
		// ���ļ������ں�Ӧ�÷����� �����ļ�ͬһĿ¼�£��ļ�����alipay log�ӷ�����ʱ��
		try {
			FileWriter writer = new FileWriter("alipay_log"
					+ System.currentTimeMillis() + ".txt");
			writer.write(signBefore);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// *********************************************************************

		// String utf8Togb2312 = CharacterEncodeConverter.utf82gbk(signBefore);
		return Md5Encrypt.md5(signBefore);

	}
}
*/
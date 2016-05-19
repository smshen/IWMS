package org.lazicats.ecos.internal.payment.common.Ccb;

import java.io.*;
import java.security.*;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * @类说明：MD5加密字符串-建行
 */

public class MD5 {

	protected static String md5Str(String str) {
		if (str == null)
			return "";
		return md5Str(str, 0);
	}

	/**
	 * 计算消息摘要。
	 * 
	 * @param data
	 *            计算摘要的数据。
	 * @param offset
	 *            数据偏移地址。
	 * @param length
	 *            数据长度。
	 * @return 摘要结果。(16字节)
	 */
	protected static String md5Str(String str, int offset) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] b = str.getBytes("UTF8");
			md5.update(b, offset, b.length);
			return byteArrayToHexString(md5.digest());
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param b
	 *            byte[]
	 * @return String
	 */
	protected static String byteArrayToHexString(byte[] b) {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += byteToHexString(b[i]);
		}
		return result;
	}

	private static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 将字节转换为对应的16进制明文
	 * 
	 * @param b
	 *            byte
	 * @return String
	 */
	protected static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}

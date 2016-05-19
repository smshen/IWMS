package org.lazicats.ecos.internal.payment.common.Rmbport;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @FileName MD5Util.java
 * @PackageName org.lazicats.ecos.internal.payment.common.Rmbport
 * @功能
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-17上午9:58:07
 * 
 */
public class MD5Util {

	private MD5Util() {
	}

	/**
	 * Returns a MessageDigest for the given <code>algorithm</code>.
	 * 
	 * @param algorithm
	 *            The MessageDigest algorithm name.
	 * @return An MD5 digest instance.
	 * @throws RuntimeException
	 *             when a {@link java.security.NoSuchAlgorithmException} is
	 *             caught
	 */
	static MessageDigest getDigest() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 16 element
	 * <code>byte[]</code>.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest
	 */
	public static byte[] md5(byte[] data) {
		return getDigest().digest(data);
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 16 element
	 * <code>byte[]</code>.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest
	 */
	public static byte[] md5(String data) {
		return md5(data.getBytes());
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex
	 * string.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest as a hex string
	 */
	public static String md5Hex(byte[] data) {
		return HexUtil.toHexString(md5(data));
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex
	 * string.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest as a hex string
	 */
	public static String md5Hex(String data) {
		return HexUtil.toHexString(md5(data));
	}
}

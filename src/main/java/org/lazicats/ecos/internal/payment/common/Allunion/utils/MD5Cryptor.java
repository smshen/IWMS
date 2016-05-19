// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MD5Cryptor.java

package org.lazicats.ecos.internal.payment.common.Allunion.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MD5Cryptor
{

	public static final Log log = LogFactory.getLog(MD5Cryptor.class);
	public static final String ALGORITHM = "MD5";

	public MD5Cryptor()
	{
	}

	public static String getMD5ofStr(String origString)
	{
		String origMD5 = null;
		try
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte result[] = md5.digest(origString.getBytes());
			origMD5 = byteArray2HexStr(result);
		}
		catch (Exception e)
		{
			log.error("获得MD5加密密码的方法异常!");
			e.printStackTrace();
		}
		return origMD5;
	}

	public static String getMD5ofByte(byte data[])
	{
		String origMD5 = null;
		try
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte result[] = md5.digest(data);
			origMD5 = byteArray2HexStr(result);
		}
		catch (Exception e)
		{
			log.error("获得MD5加密密码的方法异常!");
			e.printStackTrace();
		}
		return origMD5;
	}

	public static String getMD5ofFile(File file) throws NoSuchAlgorithmException 
	{
		FileInputStream in;
		byte buffer[];
		in = null;
		buffer = new byte[1024];
		String s1 = null;
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		try {
			in = new FileInputStream(file);
			int len;
			while ((len = in.read(buffer, 0, 1024)) != -1) 
				digest.update(buffer, 0, len);
			byte b[] = digest.digest();
			s1 = byteArray2HexStr(b);
			return s1;
		} catch (Exception e) {
			
		}finally {
			if (null != in) {
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		   }
		}
		return s1;
		
		
	}

	public static String getMD5ofStr(String origString, int times)
	{
		String md5 = getMD5ofStr(origString);
		for (int i = 0; i < times - 1; i++)
			md5 = getMD5ofStr(md5);

		return md5;
	}

	public static boolean verifyPassword(String inputStr, String MD5Code)
	{
		return getMD5ofStr(inputStr).equals(MD5Code);
	}

	public static boolean verifyPassword(String inputStr, String MD5Code, int times)
	{
		return getMD5ofStr(inputStr, times).equals(MD5Code);
	}

	private static String byteArray2HexStr(byte bs[])
	{
		StringBuffer sb = new StringBuffer();
		byte arr$[] = bs;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++)
		{
			byte b = arr$[i$];
			sb.append(byte2HexStr(b));
		}

		return sb.toString();
	}

	private static String byte2HexStr(byte b)
	{
		String hexStr = null;
		int n = b;
		if (n < 0)
			n = b & 0xff;
		hexStr = (new StringBuilder()).append(Integer.toHexString(n / 16)).append(Integer.toHexString(n % 16)).toString();
		return hexStr.toUpperCase();
	}

	public static void main(String args[])
	{
		System.out.println("32位加密算法测试......");
		System.out.println((new StringBuilder()).append("JesseyHu: ").append(getMD5ofStr("JesseyHu")).toString());
		System.out.println((new StringBuilder()).append("111111: ").append(verifyPassword("111111", "96E79218965EB72C92A549DD5A330112")).toString());
	}

}

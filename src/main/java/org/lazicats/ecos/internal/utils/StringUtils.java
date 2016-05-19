package org.lazicats.ecos.internal.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 字符串 工具类
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-9 下午02:20:44
 * 
 */
public class StringUtils {

	private static Logger log = Logger.getLogger(StringUtils.class);

	/**
	 * 判断string对象是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		boolean bool = true;
		if (str == null || "null".equals(str) || str == "" || "".equals(str)) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除字符串所有空格
	 * 
	 * @param str
	 * @return
	 */
	public static String removeSpace(String str) {
		return str.replaceAll(" ", "");
	}

	/**
	 * 字符串左边补零
	 * 
	 * @param str
	 *            原始字符串
	 * @param strLength
	 *            字符串总长度
	 * @return
	 */
	public static String leftAddZero(String str, int strLength) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strLength - str.length(); i++) {
			stringBuilder.append("0");
		}
		stringBuilder.append(str);
		return stringBuilder.toString();
	}

	/**
	 * 字符串右边补零
	 * 
	 * @param str
	 *            原始字符串
	 * @param strLength
	 *            字符串总长度
	 * @return
	 */
	public static String rightAddZero(String str, int strLength) {
		StringBuilder stringBuilder = new StringBuilder(str);
		for (int i = 0; i < strLength - str.length(); i++) {
			stringBuilder.append("0");
		}
		return stringBuilder.toString();
	}

	/**
	 * 字符串转为Ascii码
	 * 
	 * @param value
	 * @return
	 */
	public static String stringToAscii(String value) {
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i != chars.length - 1) {
				sbu.append((int) chars[i]).append(",");
			} else {
				sbu.append((int) chars[i]);
			}

			sbu.append((int) chars[i]);
		}
		return sbu.toString();
	}

	/**
	 * Ascii转为字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String asciiToString(String value) {
		StringBuffer sbu = new StringBuffer();
		String[] chars = value.split(",");
		for (int i = 0; i < chars.length; i++) {
			sbu.append((char) Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}

	/**
	 * 字符串URL编码
	 * 
	 * @param value
	 * @param charSet
	 * @return
	 */
	public static String encode(String value, String charSet) {
		try {
			return URLEncoder.encode(value, charSet);
		} catch (UnsupportedEncodingException e) {
			log.error("字符串URL编码异常！");
		}
		return value;
	}

	/**
	 * 符串URL解码
	 * 
	 * @param value
	 * @param charSet
	 * @return
	 */
	public static String decode(String value, String charSet) {
		try {
			return URLDecoder.decode(value, charSet);
		} catch (UnsupportedEncodingException e) {
			log.error("字符串URL解码异常！");
		}
		return value;
	}

	/**
	 * 字符串字符集转换
	 * 
	 * @param value
	 * @param oldCharSet
	 * @param newCharSet
	 * @return
	 */
	public static String StringCharSet(String value, String oldCharSet,
			String newCharSet) {
		String returnValue = "";
		try {
			if (!StringUtils.isEmpty(oldCharSet)) {
				returnValue = new String(value.getBytes(), newCharSet);
			} else {
				returnValue = new String(value.getBytes(oldCharSet), newCharSet);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 判断字符串是否包含中文字符
	 * 
	 * @param value
	 * @return true：包含 false：不包含
	 */
	public static final boolean isContainsChinese(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (value.substring(i, i + 1).matches("[\\u4e00-\\u9fbb]+")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串是否以HTTP:// 开头
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isUrl(String url) {
		boolean bool = false;
		if (url.indexOf("http://") > 0) {
			bool = true;
		}
		return bool;
	}

	/**
	 * 判断字符串是否为ip地址
	 * @param checkStr
	 * @return
	 */
	public static boolean checkIP(String checkStr) {
		try {
			String number = checkStr.substring(0, checkStr.indexOf('.'));
			if (Integer.parseInt(number) > 255)
				return false;
			checkStr = checkStr.substring(checkStr.indexOf('.') + 1);
			number = checkStr.substring(0, checkStr.indexOf('.'));
			if (Integer.parseInt(number) > 255)
				return false;
			checkStr = checkStr.substring(checkStr.indexOf('.') + 1);
			number = checkStr.substring(0, checkStr.indexOf('.'));
			if (Integer.parseInt(number) > 255)
				return false;
			number = checkStr.substring(checkStr.indexOf('.') + 1);
			if (Integer.parseInt(number) > 255)
				return false;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 计算除数和被除数，按照指定小数位数保留
	 * 
	 * @param divisor	除数
	 * @param dividend	被除数
	 * @param decimal	保留小数位数
	 * @return
	 */
	public static BigDecimal calculateDataRetainDecimal(String divisor, String dividend,
			int decimal) {
		// 除数
		BigDecimal bd = new BigDecimal(Long.parseLong(divisor));
		// 被除数
		BigDecimal bd2 = new BigDecimal(Long.parseLong(dividend));
		BigDecimal result = bd.divide(bd2, decimal, BigDecimal.ROUND_HALF_UP);
		return result;
	}
	
	/**
	 * 将日期字符串格式化为指定格式字符串
	 * 
	 * @param date
	 * @param formatOld
	 * @param formatNew
	 * @return
	 * @throws ParseException 
	 */
	public static String formatDate(String date, String formatOld,
			String formatNew) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat(formatOld);
		SimpleDateFormat format2 = new SimpleDateFormat(formatNew);
		Date datef =null;
		try{
			datef=format1.parse(date);
		}catch(ParseException e){
			e.printStackTrace();
		}
		if(datef!=null){
			return  format2.format(datef);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取系统当前时间并格式化为指定格式
	 * 
	 * @param format
	 * @return
	 */
	public static String getSystemCurrentTime(String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(calendar.getTime());
	}
	
	/**
	 * 将时间HHmmss 格式化成HH:mm:ss
	 * @param time
	 * @return
	 */
	public static String getSplitTime(String time){
		String str=null;
		if(time==null || time.length()!=6){
			return null;
		}
		str=time.substring(0, 2)+":"+time.substring(2, 4)+":"+time.substring(4, 6);
		return str;
	}
}

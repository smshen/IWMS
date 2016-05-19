package org.lazicats.ecos.internal.payment.common.AlipayOrderQuery;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * 
 * @FileName UtilDate.java
 * @PackageName org.lazicats.ecos.internal.payment.common.AlipayOrderQuery
 * @功能 工具类，可以用作获取系统日期、订单编号等
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-17下午2:17:43
 * 
 */
public class UtilDate {

	/** 年月日时分秒(无下划线) yyyyMMddHHmmss */
	private static final String dtLong = "yyyyMMddHHmmss";

	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	private static final String simple = "yyyy-MM-dd HH:mm:ss";

	/** 年月日(无下划线) yyyyMMdd */
	private static final String dtShort = "yyyyMMdd";

	/**
	 * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
	 * 
	 * @return 以yyyyMMddHHmmss为格式的当前系统时间
	 */
	protected static String getOrderNum() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dtLong);
		return df.format(date);
	}

	/**
	 * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	protected static String getDateFormatter() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(simple);
		return df.format(date);
	}

	/**
	 * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
	 * 
	 * @return
	 */
	protected static String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dtShort);
		return df.format(date);
	}

	/**
	 * 产生随机的三位数
	 * 
	 * @return
	 */
	protected static String getThree() {
		Random rad = new Random();
		return rad.nextInt(1000) + "";
	}

}

package org.lazicats.ecos.internal.payment.common.Upoppay;

/**
 * configuration class for upop payment.
 * @author Jay
 *
 */
public class PayConf {
	
	public final static String charset="GBK";
	public final static String signType="MD5";
	public static final String signature = "SignMsg";
	
	public final static String[] notifyVo = new String[]{
        "OrderNo",   //0 
        "PayNo",     //1 
        "PayAmount", //2 
        "CurrCode",  //3
        "SystemSSN", //4
        "RespCode",  //5
        "SettDate",  //6
        "Reserved01",//7
        "Reserved02",//8
	};
}

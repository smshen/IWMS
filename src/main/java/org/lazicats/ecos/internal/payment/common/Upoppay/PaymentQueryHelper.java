package org.lazicats.ecos.internal.payment.common.Upoppay;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单查询结果辅助类
 * @author Jay
 *
 */
public class PaymentQueryHelper {
	
	/**
	 * @param querySuccessRespText 订单查询成功结果字串
	 * @return 商城原订单号
	 */
	public static String getOriOrderNo(String querySuccessRespText) {
		Map<String, String> cbtInfoMap = getCbtInfoMap(querySuccessRespText);
		return cbtInfoMap.get("OriOrderNo");
	}
	
	/**
	 * 
	 * @param querySuccessRespText
	 * @return 跨境相关信息
	 */
	private static Map<String, String> getCbtInfoMap(String querySuccessRespText) {
		final int CBTINFO_POS = 7;
		String cbtInfo = getRespArr(querySuccessRespText)[CBTINFO_POS];
		String[] cbtInfoArr = cbtInfo.split("\\|");
		
		Map<String,String> cbtInfoMap = new HashMap<String,String>();
		for (String string : cbtInfoArr) {
			String[] split = string.split(":");
			cbtInfoMap.put(split[0], split[1]);
		}
		return cbtInfoMap;
	}
	
	private static String[] getRespArr(String querySuccessRespText){
		String[] respArray = querySuccessRespText.split("\\\\n");
		return respArray;
	}

}

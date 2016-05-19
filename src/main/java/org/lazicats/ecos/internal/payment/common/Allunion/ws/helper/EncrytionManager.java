package org.lazicats.ecos.internal.payment.common.Allunion.ws.helper;

import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotifyRsp;
import org.lazicats.ecos.internal.payment.common.Allunion.utils.MD5Cryptor;

public class EncrytionManager {
	public static String getMD5Mac(String[] srcElements) {
		StringBuilder sb = new StringBuilder();
		
		for (String srcElement : srcElements) {
			sb.append(srcElement).append("|");
		}
		
		sb.append(CommonPayInfo.BankPayInfo.get("allinpay_ws_mackey"));
		
		return sign(sb);
	}

	private static String sign(StringBuilder sb) {
		return MD5Cryptor.getMD5ofStr(sb.toString()).toUpperCase();
	}
	
	public static String getMD5Mac(PayNotifyRsp qr) {
		StringBuilder sb = new StringBuilder();
		sb.append(qr.getTrxcod()).append("|");
		sb.append(qr.getBizseq()).append("|");
		sb.append(qr.getTimestamp()).append("|");
		sb.append("|");
		sb.append(qr.getRspcode()).append("|");
		sb.append(CommonPayInfo.BankPayInfo.get("allinpay_ws_mackey"));
		
		return sign(sb);
	}
	
}

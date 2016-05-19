package org.lazicats.ecos.internal.phoneSms.compent;

import org.lazicats.ecos.internal.phoneSms.model.PhoneInfo;
import org.lazicats.ecos.internal.wms.model.Message;
 
public interface PhoneSmsCompent {
	/**
	 * 短信接口
	 * @param phoneInfo 发送短信所需要的参数
	 * @return code 001 表示成功  002表示失败
	 */
	public Message sendPhoneSmsCompent(PhoneInfo phoneInfo);
	
	/**
	 * 短信接口
	 */
	public int sendMsg(String mobile, String content);
}

package org.lazicats.ecos.internal.phoneSms.util;

import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.phoneSms.model.PhoneInfo;
import org.lazicats.ecos.internal.wms.model.Message;
import org.springframework.stereotype.Component;
import com.jasson.im.api.APIClient;

@Component
public class PhoneUtil {
	private Logger logger = Logger.getLogger(PhoneInfo.class);
	private APIClient handler = new APIClient();

	public Message init(PhoneInfo phoneInfo) {
		Message message = new Message();
		int connectRe = handler
				.init(phoneInfo.getHost(), phoneInfo.getName(), phoneInfo
						.getPwd(), phoneInfo.getApiId(), phoneInfo.getDbName());
		logger.info(phoneInfo.getHost() + "  " + phoneInfo.getName() + "  "
				+ phoneInfo.getPwd() + "  " + phoneInfo.getApiId() + "  "
				+ phoneInfo.getDbName());
		if (connectRe == APIClient.IMAPI_SUCC) {
			message.setCode("001");
			message.setMessage("初始化成功");
		} else if (connectRe == APIClient.IMAPI_CONN_ERR) {
			message.setCode("002");
			message.setMessage("初始化连接失败");
		} else if (connectRe == APIClient.IMAPI_API_ERR) {
			message.setCode("002");
			message.setMessage("apiID不存在");
		}
		if (connectRe != APIClient.IMAPI_SUCC) {
			message.setCode("002");
			message.setMessage("初始化不成功");
		 
		}
		return message;
	}

//	public void release() {
//		handler.release();
//		Thread.currentThread().interrupt();
//	}
//
//	public void testSend(PhoneInfo phoneInfo) {
//		SendTask task = new SendTask(handler, phoneInfo);
//		task.start();
//	}

	public Message sendSM(PhoneInfo phoneInfo) {
		Message message = new Message();
		String tmpMobile = phoneInfo.getMobileStr();
		String tmpContent = phoneInfo.getContent();
		String tmpSrcID = "" + phoneInfo.getSmId();
		int tmpType = phoneInfo.getSmType();
		String tmpUrl = phoneInfo.getUrl();
		if (tmpType == 1) {
			tmpUrl = phoneInfo.getUrl();

		} else {
			tmpType = phoneInfo.getSmType();
		}
		Vector<String> mobileList = new Vector<String>();
		StringTokenizer st = new StringTokenizer(tmpMobile, ",");
		while (st.hasMoreElements()) {
			String tmp = (String) st.nextElement();
			if (tmp.indexOf("-") != -1) {
				long min = Long.parseLong(tmp.substring(0, tmp.indexOf("-")));
				long max = Long.parseLong(tmp.substring(tmp.indexOf("-") + 1));

				long i = min;
				while (i <= max) {
					mobileList.addElement(Long.toString(i));
					i++;
				}
			} else {
				mobileList.addElement(tmp);
			}
		}
		int len = mobileList.size();
		String[] mobiles = new String[len];
		for (int i = 0; i < len; i++) {
			mobiles[i] = (String) mobileList.elementAt(i);
		}
		int result = 0;
		if (tmpType == 1) {
			if (tmpUrl == null || tmpUrl.length() == 0) {
				message.setCode("002");
				message.setMessage("请输入Wap Push的链接地址！");
				return message;
			}
			result = handler.sendSM(mobiles, tmpContent, phoneInfo.getSmId(),
					Long.parseLong(tmpSrcID), tmpUrl);
		} else {
			result = handler.sendSM(mobiles, tmpContent, phoneInfo.getSmId(),
					Long.parseLong(tmpSrcID));
		}
		if (result == APIClient.IMAPI_SUCC) {
			message.setCode("001");
			message.setMessage("发送成功\n");
			return message;
		} else if (result == APIClient.IMAPI_INIT_ERR) {

			message.setCode("002");
			message.setMessage("未初始化");
			return message;
		} else if (result == APIClient.IMAPI_CONN_ERR) {
			message.setCode("002");
			message.setMessage("数据库连接失败");
			return message;
		} else if (result == APIClient.IMAPI_DATA_ERR) {
			message.setCode("002");
			message.setMessage("参数错误");
			return message;
		} else if (result == APIClient.IMAPI_DATA_TOOLONG) {
			message.setCode("002");
			message.setMessage("消息内容太长");
			return message;
		} else if (result == APIClient.IMAPI_INS_ERR) {
			message.setCode("002");
			message.setMessage("数据库插入错误");
			return message;
		} else {
			message.setCode("002");
			message.setMessage("出现其他错误");
			return message;
		}
	}
}

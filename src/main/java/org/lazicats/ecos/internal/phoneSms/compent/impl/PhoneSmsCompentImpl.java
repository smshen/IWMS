package org.lazicats.ecos.internal.phoneSms.compent.impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.phoneSms.common.PhoneCommon;
import org.lazicats.ecos.internal.phoneSms.compent.PhoneSmsCompent;
import org.lazicats.ecos.internal.phoneSms.model.PhoneInfo;
import org.lazicats.ecos.internal.phoneSms.tempuri.MobileListGroup;
import org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiLocator;
import org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoap;
import org.lazicats.ecos.internal.phoneSms.tempuri.SmsIDGroup;
import org.lazicats.ecos.internal.phoneSms.tempuri.holders.ArrayOfSmsIDListHolder;
import org.lazicats.ecos.internal.phoneSms.util.MD5;
import org.lazicats.ecos.internal.phoneSms.util.PhoneUtil;
import org.lazicats.ecos.internal.wms.model.Message;
import org.springframework.stereotype.Service;

import com.jasson.im.api.APIClient;

@Service
public class PhoneSmsCompentImpl implements PhoneSmsCompent {
	
	private static final Logger log = Logger.getLogger(PhoneSmsCompentImpl.class);

	@Resource
	private PhoneUtil phoneUtil;

	public Message sendPhoneSmsCompent(PhoneInfo phoneInfo) {
		/*if("01".equals(PhoneCommon.phoneCommonInfo.get("smsGateway"))){
			return sendSmsAtOld(phoneInfo);
		}else if("03".equals(PhoneCommon.phoneCommonInfo.get("smsGateway"))){
			return sendSmsAtMobset(phoneInfo);
		}*/
		int result = this.sendMsg(phoneInfo.getMobileStr(), phoneInfo.getContent());
		Message message = new Message();
		if(result == 0) {
			message.setCode("001");
		}else {
			message.setCode(String.valueOf(result));
			if(result == -1) {
				message.setMessage("连接数据库出错");
			}else if(result == -2) {
				message.setMessage("数据库关闭失败");
			}else if(result == -3) {
				message.setMessage("数据库插入错误");
			}else if(result == -4) {
				message.setMessage("数据库删除错误");
			}else if(result == -5) {
				message.setMessage("数据库查询错误");
			}else if(result == -6) {
				message.setMessage("参数错误");
			}else if(result == -7) {
				message.setMessage("API编码非法");
			}else if(result == -8) {
				message.setMessage("参数超长");
			}else if(result == -9) {
				message.setMessage("没有初始化或初始化失败");
			}else if(result == -10) {
				message.setMessage("API接口处于暂停（失效）状态");
			}else if(result == -11) {
				message.setMessage("短信网关未连接");
			}
		}
		
		return message;
	}
	
	/**
	 * 原有短信网关
	 * 
	 * @param phoneInfo
	 * @return
	 */
	private Message sendSmsAtOld(PhoneInfo phoneInfo){
		Message message = null;
		phoneInfo.setDbName(PhoneCommon.phoneCommonInfo.get("dbName"));
		phoneInfo.setPwd(PhoneCommon.phoneCommonInfo.get("pwd"));
		phoneInfo.setHost(PhoneCommon.phoneCommonInfo.get("host"));
		phoneInfo.setApiId(PhoneCommon.phoneCommonInfo.get("apiId"));
		phoneInfo.setName(PhoneCommon.phoneCommonInfo.get("name"));
		message = phoneUtil.init(phoneInfo);
		// 初始化化系统参数
		if (message.getCode() != "001") {
			return message;
		} else {
			// 发送短信
			message = phoneUtil.sendSM(phoneInfo);
			return message;
		}
	}

	/**
	 * 广州首易短信网关
	 * 
	 * @param phoneInfo
	 * @return
	 */
	public Message sendSmsAtMobset(PhoneInfo phoneInfo) {
		Message message = new Message();
		String apiSoap_address = PhoneCommon.phoneCommonInfo.get("sy-host");
		MobsetApiLocator locator = new MobsetApiLocator();
		locator.setMobsetApiSoapEndpointAddress(apiSoap_address);
		MobsetApiSoap apiSoap = null;

		try {
			apiSoap = locator.getMobsetApiSoap();
		} catch (ServiceException e) {
			log.error("locator创建异常……");
			message.setCode("013");
			message.setMessage("locator创建异常");
			e.printStackTrace();
		}

		//企业id
		long corpID = Long.parseLong(PhoneCommon.phoneCommonInfo.get("sy-GroupId"));
		//用户名
		String loginName = PhoneCommon.phoneCommonInfo.get("sy-userName");
		//时间戳
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
		String timeStamp = formatter.format(new Date());
		//密码
		String password = PhoneCommon.phoneCommonInfo.get("sy-pass");
		MD5 md5 = new MD5();
		password = md5.getMD5ofStr(corpID + password + timeStamp);
		//发送内容
		String content = phoneInfo.getContent();
		//是否长短信发送
		long LongSms = Long.parseLong(PhoneCommon.phoneCommonInfo.get("sy-LongSms"));

		StringHolder errMsg = new StringHolder();
		LongHolder count = new LongHolder();
		
		//接收手机号码
//		String mobiles[] = phoneInfo.getMobileStr().replaceAll(" ", "").split("#");
		String[] mobileArray = {phoneInfo.getMobileStr().replaceAll(" ", "")};
//		for (int i = 0; i < mobiles.length; i++) {
//			mobileArray[i] = mobiles[i];
//		}
		
		MobileListGroup[] mobileList = new MobileListGroup[mobileArray.length];

	    for (int i = 0; i < mobileList.length; ++i) {
	      mobileList[i] = new MobileListGroup();
	      mobileList[i].setMobile(mobileArray[i]);
	    }
	    
	    ArrayOfSmsIDListHolder smsIDList = new ArrayOfSmsIDListHolder();
	    
		try {
			apiSoap.sms_Send(corpID, loginName, password, timeStamp,
					"", "", LongSms, mobileList, content, count, errMsg,
					smsIDList);
			
			SmsIDGroup[] smsIDGroup = smsIDList.value;
			
			for (SmsIDGroup smsGroup : smsIDGroup) {
				if (smsGroup.getSmsID() > 0) {
					message.setCode("001");
					message.setMessage("短信发送成功，发送序号为	" + smsGroup.getSmsID());
				}
			}
		} catch (RemoteException e) {
			message.setCode("010");
			log.error("发送短信异常……");
			message.setMessage("发送短信异常");
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public int sendMsg(String mobile, String content) {
		APIClient smsClient = new APIClient();
		smsClient.init("192.9.9.210", "igb", "igb", "igb", "mas");
		return smsClient.sendSM(mobile, content, 1);
	}
	
	public static void main(String args[]) { 
		APIClient smsClient = new APIClient();
		smsClient.init("192.9.9.210", "igb", "igb", "igb", "mas");
		smsClient.sendSM("15975640039", "中文测试", 1); 
    } 
}

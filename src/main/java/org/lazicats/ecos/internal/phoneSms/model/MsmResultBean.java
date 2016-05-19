package org.lazicats.ecos.internal.phoneSms.model;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import org.lazicats.ecos.internal.phoneSms.tempuri.MobileListGroup;
import org.lazicats.ecos.internal.phoneSms.tempuri.holders.ArrayOfSmsIDListHolder;
import org.lazicats.ecos.internal.phoneSms.tempuri.holders.ArrayOfSmsRecvListHolder;
import org.lazicats.ecos.internal.phoneSms.tempuri.holders.ArrayOfSmsReportListHolder;

/**
 * 
 * @FileName MsmResultBean.java
 * @PackageName org.lazicats.ecos.internal.phoneSms.model
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-26上午9:23:57
 *
 */
public class MsmResultBean {
	private StringHolder errMsg;
	private ArrayOfSmsIDListHolder smsIDList;
	private MobileListGroup[] mobileList;
	private ArrayOfSmsReportListHolder smsReportList;
	private ArrayOfSmsRecvListHolder smsRecvList;
	private LongHolder balance;
	private StringHolder sign;
	private LongHolder errCode;
	
	public LongHolder getErrCode() {
		return errCode;
	}
	public void setErrCode(LongHolder errCode) {
		this.errCode = errCode;
	}
	public StringHolder getSign() {
		return sign;
	}
	public void setSign(StringHolder sign) {
		this.sign = sign;
	}
	public LongHolder getBalance() {
		return balance;
	}
	public void setBalance(LongHolder balance) {
		this.balance = balance;
	}
	public ArrayOfSmsRecvListHolder getSmsRecvList() {
		return smsRecvList;
	}
	public void setSmsRecvList(ArrayOfSmsRecvListHolder smsRecvList) {
		this.smsRecvList = smsRecvList;
	}
	public ArrayOfSmsReportListHolder getSmsReportList() {
		return smsReportList;
	}
	public void setSmsReportList(ArrayOfSmsReportListHolder smsReportList) {
		this.smsReportList = smsReportList;
	}
	public StringHolder getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(StringHolder errMsg) {
		this.errMsg = errMsg;
	}
	public ArrayOfSmsIDListHolder getSmsIDList() {
		return smsIDList;
	}
	public void setSmsIDList(ArrayOfSmsIDListHolder smsIDList) {
		this.smsIDList = smsIDList;
	}
	public MobileListGroup[] getMobileList() {
		return mobileList;
	}
	public void setMobileList(MobileListGroup[] mobileList) {
		this.mobileList = mobileList;
	}
	public MsmResultBean() {
		super();
	}

	public MsmResultBean(StringHolder errMsg, ArrayOfSmsIDListHolder smsIDList, MobileListGroup[] mobileList) {
		super();
		this.errMsg = errMsg;
		this.smsIDList = smsIDList;
		this.mobileList = mobileList;
	}
}

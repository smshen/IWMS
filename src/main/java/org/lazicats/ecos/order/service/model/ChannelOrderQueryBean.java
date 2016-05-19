package org.lazicats.ecos.order.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询订单的条件Bean
 * @author: chenyeen
 * @date 2013-7-30 下午11:30:24
 */
public class ChannelOrderQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date startTime;			//下单时间(开始)
    private Date endTime;			//下单时间(结束)
    private String orderNo; 		//订单编号
    private String receiverName;	//收货人的姓名
    private String commNo; 			//商品编号
    private String commName; 		//商品名称
    private Integer orderState;		//订单状态
    private String account;			//买家账号
    private String receiverMobile;	//收货人的手机号码
	private Integer isRemark;		//是否备注(1:有<是>;2:无<否>)
	private String channelCode;		//渠道编码

    private int pageNo;
    private int pageSize;

    public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getCommNo() {
		return commNo;
	}

	public void setCommNo(String commNo) {
		this.commNo = commNo;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public Integer getIsRemark() {
		return isRemark;
	}

	public void setIsRemark(Integer isRemark) {
		this.isRemark = isRemark;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}

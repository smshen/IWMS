
package org.lazicats.ecos.order.service.model;

/**     
 * Copyright (c) BRORDENGATE SOFTWARE INFRASTRUCTURE ,LTD. 
 * @createDate: 2014-3-31 下午04:31:27
 * @author <a href="mailto:justin.t.wang@163.com">王耀军(justin.t.wang)</a>
 * @version 1.0
 */
public enum ChannelEnum {
	
	gwsc("1","gwsc"),
	tmall("2","taobao"),
	ccb("3","ccb");
	
	private String channelId;
	private String channelCode;
	
	private ChannelEnum(String channelId, String channelCode) {
		this.channelId = channelId;
		this.channelCode = channelCode;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	
	public static ChannelEnum getChannel(String channelId) {
		ChannelEnum result = null;
		for(ChannelEnum channel : ChannelEnum.values()) {
			if(channelId.equals(channel.getChannelId())) {
				result = channel;
				break;
			}
		}
		return result;
	}
	
}

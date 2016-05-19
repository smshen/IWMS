package org.lazicats.ecos.internal.wms.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MWS WebService 基本信息
 * 
 * @author
 * @创建日期：2013-8-12 下午02:58:59
 * 
 */
public class CommonWmsInfo {

	// WebServer服务端地址
	@Value(value="clientUrl")
	public static String clientUrl;
	// 用户名
	@Value(value="userName")
	public static String userName;
	// 密码
	@Value(value="password")
	public static String password;
	// 服务名
	@Value(value="serviceName")
	public static String serviceName;
	//验证会员信息url
	@Value(value="checkMemberUrl")
	public static String checkMemberUrl;
	//查询会员url
	@Value(value="queryMemberInfoUrl")
	public static String queryMemberInfoUrl;
}

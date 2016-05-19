package org.lazicats.ecos.internal.promotion.component;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public interface IGzWxmpComponent {
	
	/**
	 * 通过目标号码查找是否已经在广州移动微信运营管理平台进行微信openid与目标号绑定
	 * @param mobile 目标号码
	 * @return
	 * @throws RemoteException 
	 * @throws ServiceException 
	 */
	String getBindFlag(String mobile) throws RemoteException, ServiceException;
}

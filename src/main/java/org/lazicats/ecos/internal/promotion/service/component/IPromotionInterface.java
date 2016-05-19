package org.lazicats.ecos.internal.promotion.service.component;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public interface IPromotionInterface {
	
	String getGzWxmpBoundFlag(String mobile) throws RemoteException, ServiceException;

}

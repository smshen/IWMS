package org.lazicats.ecos.internal.promotion.service.component.impl;

import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import org.lazicats.ecos.internal.promotion.component.IGzWxmpComponent;
import org.lazicats.ecos.internal.promotion.service.component.IPromotionInterface;
import org.springframework.stereotype.Service;

@Service
public class PromotionInterfaceImpl implements IPromotionInterface{
	
	@Resource
	IGzWxmpComponent gzWxmpComponent;
	
	@Override
	public String getGzWxmpBoundFlag(String mobile) throws RemoteException, ServiceException {
		// TODO Auto-generated method stub
		
		
		return gzWxmpComponent.getBindFlag(mobile);
	}
	
	
}

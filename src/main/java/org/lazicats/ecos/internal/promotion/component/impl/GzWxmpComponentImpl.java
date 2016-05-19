package org.lazicats.ecos.internal.promotion.component.impl;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.lazicats.ecos.internal.promotion.common.Constants;
import org.lazicats.ecos.internal.promotion.component.IGzWxmpComponent;
import org.springframework.stereotype.Component;

@Component
public class GzWxmpComponentImpl implements IGzWxmpComponent{
	
	@Override
	public String getBindFlag(String mobile) throws RemoteException, ServiceException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		//call.setTimeout(1000*30);
		call.setTargetEndpointAddress(Constants.GZWXMP_ENDPOINT);
		
		//call.setOperationName("GetBindFlag");
		call.setOperationName(new QName("http://tempuri.org/","GetBindFlag"));
		
		/*call.addParameter("channel",
				org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN) ;  
		call.addParameter("passport",
				org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN) ;
		call.addParameter("mobile",
				org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN) ;*/
	

		call.addParameter(new QName("http://tempuri.org/","channel"),
				XMLType.XSD_STRING,ParameterMode.IN) ;  
		call.addParameter(new QName("http://tempuri.org/","passport") ,
				XMLType.XSD_STRING,ParameterMode.IN) ;
		call.addParameter(new QName("http://tempuri.org/","mobile") ,
				XMLType.XSD_STRING,ParameterMode.IN) ;
		
		 
		//call.setEncodingStyle("UTF-8");
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING); 
		//call.setUseSOAPAction(true) ; 
		call.setSOAPActionURI("http://tempuri.org/GetBindFlag");
		String resl = (String) call.invoke(new Object[] {
				"ch3","jfjfjdsifidsjfdfds_-fds_w23fdksjfewkksiknfajwonfds",mobile});
		return resl;
	}

}

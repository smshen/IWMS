package org.lazicats.ecos.internal.wms.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.soap.Addressing;

/**
 * wms相关操作webservice
 * @author Jay
 */
@WebService
@SOAPBinding(style=Style.RPC)
@Addressing(enabled=true,required=false)
public interface WMSService {
	
	/**
	 * 确认订单自提
	 * @param orderNo 订单号
	 * @param consigner 收货人
	 * @return 成功标志，0表示不成功，1表示成功  i.e {code:1,msg:"msg"}
	 */
	@WebMethod(operationName="confirmSelfDelivery",action="confirmSelfDelivery")
	public String confirmSelfDelivery(
			@WebParam(name="orderNo") String orderNo,
			 	@WebParam(name="consigner") String consigner);

}

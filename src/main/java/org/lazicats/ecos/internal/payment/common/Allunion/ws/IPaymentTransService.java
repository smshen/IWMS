package org.lazicats.ecos.internal.payment.common.Allunion.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

@WebService
@SOAPBinding(style=Style.RPC)
@Addressing(enabled=true, required=false) 
public interface IPaymentTransService {
	/**
	 * check the validity of the order from pos
	 * @param orderInfo
	 * @return
	 */
	@WebMethod(operationName = "queryOrder",action="queryOrder")
	public String queryOrder(@WebParam(name="requestxml") String requestxml);
	
	/**
	 * receive payment result on payment completion
	 * @param paymentResl
	 * @return
	 */
	@WebMethod(operationName = "resultPay",action="resultPay")
	public String resultPay(@WebParam(name="payxml") String payxml);
} 
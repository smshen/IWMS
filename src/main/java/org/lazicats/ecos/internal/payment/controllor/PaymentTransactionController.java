package org.lazicats.ecos.internal.payment.controllor;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.payment.common.Allunion.db.Dao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * url: localhost:8080/IWMS/custom/notifyClearance
 * @author Jay
 *
 */
@Controller
@RequestMapping("/custom")
public class PaymentTransactionController {
	private static Logger log = Logger.getLogger(PaymentTransactionController.class);
	
	private static final String DECLAREINFO_SPLITOR = "&";
	private static final String RECEIVED_SUCCESS = "HTTPSQS_PUT_OK";
	@Resource
	private Dao dao;
	
	@RequestMapping(value = "/notifyClearance")
	@ResponseBody
	public String notifyClearance(String name,String opt,String data) {
		
			String dataSplited = data.replace("|",DECLAREINFO_SPLITOR);
			String[] clearanceResl = dataSplited.split(DECLAREINFO_SPLITOR);
			String payTransactionNo = clearanceResl[0];
			String returnCode  = clearanceResl[1];
			String returnInfo  = clearanceResl[2];
			
			log.info("receive from " +name +"["+data+"]");
			try {
				String returnInfo2 = new String(returnInfo.getBytes("iso-8859-1"),"utf-8");
				dao.insertCustomReturnLog(payTransactionNo, returnCode,returnInfo2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if("C01".equals(returnCode)) {//custom examination passed!0
				//TODO add order to declared order list
			}else if(returnCode.startsWith("A")) {// invalid configuration
				//TODO sth wrong with the configuration
			}else if("B11".equals(returnCode) || "B10".equals(returnCode)) {//realName info not valid
				//TODO send notify to customer to correct the info and do resent
			}else {
				//ignore
			}
			
		return RECEIVED_SUCCESS;
	}
}

package org.lazicats.ecos.internal.payment.common.Allunion.ws.impl;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.lazicats.ecos.basecomponent.utils.BeanUtils;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Allunion.http.HttpOperator;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotify;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotifyRsp;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayQuery;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayQueryRsp;
import org.lazicats.ecos.internal.payment.common.Allunion.utils.JAXB;
import org.lazicats.ecos.internal.payment.common.Allunion.ws.IPaymentTransService;
import org.lazicats.ecos.internal.payment.common.Allunion.ws.component.PayTransComponent;
import org.lazicats.ecos.internal.payment.common.Allunion.ws.helper.EncrytionManager;

/**
 * webservice implementation for allinpay interactions.
 * @author Jay
 *
 */
@WebService(endpointInterface = 
	"org.lazicats.ecos.internal.payment.common.Allunion.ws.IPaymentTransService",
	serviceName = "paymentTransService")
public class PaymentTransService implements IPaymentTransService {
	private static Logger logger = Logger.getLogger(PaymentTransService.class);
	@Resource
	private PayTransComponent payTransComponent;
    
	private boolean checkIdentity(final String fromPayinst,final String fromEninst) {
		String mypayinst = CommonPayInfo.BankPayInfo.get("allinpay_payinst");
		String myeninst =  CommonPayInfo.BankPayInfo.get("allinpay_eninst");
		return mypayinst.equals(fromPayinst) && myeninst.equals(fromEninst);
	}
	
	@Override
	public String queryOrder(String queryXml) {
		
		PayQuery payQuery = null;
		try {
			payQuery = JAXB.xo(PayQuery.class, queryXml);
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.info("failed to parse queryxml [" + queryXml + "]",e);
			return null;
		}
		
		String[] srcElements = new String[]{payQuery.getTrxcod(),payQuery.getBizseq(),
				payQuery.getTimestamp(),"",""};
		String queryXmlSign = EncrytionManager.getMD5Mac(srcElements);
		
		
		if(!checkIdentity(payQuery.getPayinst(),payQuery.getEntinst())) {
			logger.info("unknow identity [" +payQuery.getPayinst() + "," + payQuery.getEntinst() + "],rejected!");
			return null;
		}
		
		// check the integrity of the source message
		if(!queryXmlSign.equals(payQuery.getMac())) {
			logger.info("invalid queryXml,check mac! [" + queryXml + "]");
			return null;
		}
		
		logger.info("starting to check order -" + payQuery);
		PayQueryRsp qr = payTransComponent.checkOrder(payQuery);
		
		prepareOrderQueryResp(payQuery, srcElements, qr);
		String reslXml = "";
		try {
			reslXml = JAXB.ox(qr);
			logger.info("respond message:" + reslXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return reslXml;
	}

	private void prepareOrderQueryResp(PayQuery payQuery, String[] srcElements,
			PayQueryRsp qr) {
		srcElements[3] = String.valueOf(qr.getAmount());
		srcElements[4] = qr.getRspcode();
		BeanUtils.deepCopy(payQuery, qr);
		
		String crytedMsg = EncrytionManager.getMD5Mac(srcElements);
		logger.info("respond message signture:" + crytedMsg);
		qr.setMac(crytedMsg);
	}

	@Override
	public String resultPay(String payXml) {
		PayNotify payNotify = null;
		try {
			payNotify = JAXB.xo(PayNotify.class, payXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		logger.info("checking in order on payment completion -" + payNotify);
		String[] srcElements = new String[]{payNotify.getTrxcod(),payNotify.getBizseq(),
				payNotify.getTimestamp(),String.valueOf(payNotify.getAmount()),payNotify.getPayresult()};
		String crytedMsg = EncrytionManager.getMD5Mac(srcElements);
		
		PayNotifyRsp payNotifyRsp = null;
		if(!payNotify.getMac().equals(crytedMsg)) {
			logger.info("mac verification failed! [originMac:" + payNotify.getMac() + " vs reconstructedMac:" + crytedMsg + "]");
			return null;
		}else {
			payNotifyRsp = payTransComponent.checkIn(payNotify);
		}
		
		preparePayNotifyResp(payNotify, srcElements, payNotifyRsp);
		
		String reslXml = "";
		try {
			reslXml = JAXB.ox(payNotifyRsp);
			logger.info("respond message:" + reslXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return reslXml;
	}

	private void preparePayNotifyResp(PayNotify payNotify, String[] srcElements,PayNotifyRsp payNotifyRsp) {
		payNotifyRsp.setTimestamp(HttpOperator.getFormattedCurrentTimeStr(HttpOperator.MSGID_DATE_FORMAT));
		BeanUtils.deepCopy(payNotify, payNotifyRsp);
		
		srcElements[4] = payNotifyRsp.getRspcode();
		String crytedMsgResp = EncrytionManager.getMD5Mac(srcElements);
		logger.info("respond message signture:" + crytedMsgResp);
		payNotifyRsp.setMac(crytedMsgResp);
	}

}

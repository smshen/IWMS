package org.lazicats.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.lazicats.ecos.basecomponent.utils.BeanUtils;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotify;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayNotifyRsp;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayQuery;
import org.lazicats.ecos.internal.payment.common.Allunion.model.PayQueryRsp;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.MessageBody;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.MessageHead;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.MessageHeadResp;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.VnbMessage;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.VnbMessageResp;
import org.lazicats.ecos.internal.payment.common.Allunion.utils.JAXB;
import org.lazicats.ecos.internal.payment.common.Allunion.utils.MD5Cryptor;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;


public class JAXBTest {
	


	@Test
	public void testOXQueryParam() throws JAXBException {
		PayQuery qp = null;
		qp = new PayQuery();
		
		qp.setEntinst("entinst");
		qp.setBizseq("bizseq");
		qp.setMac("mac");
		qp.setPayinst("payInst");
		qp.setTrxcod("trxcod");
		qp.setTimestamp("tstp");
		qp.setContent("");
		// test ox
		JAXB.enableFormatOutput();
		JAXB.enableFragment();
		JAXB.enableXmlDeclaration();
		String payQueryXml = JAXB.ox(qp);
		System.out.println(payQueryXml);
		
		// test xo
		PayQuery payQuery = JAXB.xo(PayQuery.class,payQueryXml);
		System.out.println(payQuery);
		
		//####################################
		PayQueryRsp qr = new PayQueryRsp();
		qr.setRspcode("respcode");
		qr.setRspmsg("respmsg");
		qr.setAmount(100l);
		
	    BeanUtils.deepCopy(qp,qr);
		
		System.out.println();
		// test ox
		JAXB.enableFormatOutput();
		JAXB.disableXmlDeclaration();
		String queryRspXml = JAXB.ox(qr);
		System.out.println(queryRspXml);
		
		// test xo
		System.out.println(JAXB.xo(PayQueryRsp.class,queryRspXml));
		
		
			
	
	}
	
	@Test
	public void testGetSourceXml() throws JAXBException {
		MessageHead msgHead = new MessageHead();
		msgHead.setMessageCode("testMsgCode");
		msgHead.setMessageId("testMsgId");
		msgHead.setSendTime("testSendTime");
		msgHead.setSign("testSign");
		
		MessageBody msgBody = new MessageBody();
		msgBody.setCustomICP("test");
		
		JAXB.disableFormatOutput();
		JAXB.disableXmlDeclaration();
		String msgHeadXml = JAXB.ox(msgHead);
		String msgBodyXml = JAXB.ox(msgBody);
	
		String xmlDecl = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		String string = StringUtils.remove(msgHeadXml, xmlDecl) + StringUtils.remove(msgBodyXml, xmlDecl);
		System.out.println( string);
		
	}
	@Test
	public void testGen2SignXml() throws JAXBException, UnsupportedEncodingException {
		String signSrcXml = getSignSrcXml();
		String md5Str = MD5Cryptor.getMD5ofStr(signSrcXml).toUpperCase();
		String string = new String(signSrcXml.getBytes(),"utf-8");
		System.out.println(md5Str);
	}

	private String getSignSrcXml() throws JAXBException {
		VnbMessage vnbMsg = new VnbMessage();
		MessageHead msgHead = new MessageHead();
		msgHead.setMessageCode("我是谁");
		msgHead.setMessageId("testMsgId");
		msgHead.setSendTime("testSendTime");
		vnbMsg.setMessageHead(msgHead);
		
		MessageBody msgBody = new MessageBody();
		msgBody.setCustomICP("test");
		vnbMsg.getMessageBodies().add(msgBody);
	
		JAXB.disableFormatOutput();
		JAXB.disableXmlDeclaration();
		String vnbMsgXml = JAXB.ox(vnbMsg);
		String key = "2CB6A4BD056242078EE28B540CD48297";
		String signSrcXml = vnbMsgXml+key;
		return signSrcXml;
	}
	
	@Test
	public void testVnbMessageOX() throws JAXBException {
		//########################################
		
		MessageHead msgHead = new MessageHead();
		msgHead.setMessageCode("testMsgCode");
		msgHead.setMessageId("testMsgId");
		msgHead.setSendTime("testSendTime");
		msgHead.setSign("testSign");
		MessageBody msgBody = new MessageBody();
		msgBody.setCustomICP("test");
		
		VnbMessage vnbMsg = new VnbMessage();
		vnbMsg.setMessageHead(msgHead);
		vnbMsg.getMessageBodies().add(msgBody);
	
		// test ox
		JAXB.enableFormatOutput();
		JAXB.disableXmlDeclaration();
		String vnbMsgXml = JAXB.ox(vnbMsg);
		System.out.println(vnbMsgXml);
		
		// test xo
		System.out.println(JAXB.xo(VnbMessage.class,vnbMsgXml));
		
		
				MessageHeadResp msgHeadResp = new MessageHeadResp();
				msgHeadResp.setMessageId("testMsgId");
				msgHeadResp.setSenderId("testSendId");
				msgHeadResp.setSendTime("testSendTime");
				msgHeadResp.setSign("testSign");
				
				msgHeadResp.setBizStatus("testBizStatus");
				msgHeadResp.setCommCode("0000000");
				VnbMessageResp vnbMsgRsp = new VnbMessageResp();
				vnbMsgRsp.setMessageHead(msgHeadResp);
			
				// test ox
				JAXB.enableFormatOutput();
				String vnbMsgRspXml = JAXB.ox(vnbMsgRsp);
				System.out.println(vnbMsgRspXml);
				
				// test xo
				System.out.println(JAXB.xo(VnbMessageResp.class,vnbMsgRspXml));
	}
	
	@Test
	public void test2() throws Exception {
		PayNotify qp = new PayNotify();
		qp.setEntinst("entinst");
		qp.setBizseq("bizseq");
		qp.setMac("mac");
		qp.setPayinst("payInst");
		qp.setTrxcod("trxcod");
		qp.setTimestamp("tstp");
		qp.setContent("");
		qp.setPayresult("0000");
		qp.setAmount(33600l);
		qp.setPayseq("payseq");
		qp.setTermid("termidid");
		qp.setTraceno("traceno");
		qp.setContent("");
		qp.setTrxid("trxid");
		// test ox
		JAXB.enableFormatOutput();
		String payNotifyXml = JAXB.ox(qp);
		System.out.println(payNotifyXml);
		
		// test xo
		PayNotify payNotify = JAXB.xo(PayNotify.class,payNotifyXml);
		System.out.println(payNotify);

		PayNotifyRsp qr = new PayNotifyRsp();
		qr.setRspcode("respcode");
		qr.setRspmsg("respmsg");
	
		
	    BeanUtils.deepCopy(qp,qr);
		
		System.out.println();
		// test ox
		JAXB.enableFormatOutput();
		String queryRspXml = JAXB.ox(qr);
		System.out.println(queryRspXml);
		
		// test xo
		System.out.println(JAXB.xo(PayNotifyRsp.class,queryRspXml));
	}
	

}
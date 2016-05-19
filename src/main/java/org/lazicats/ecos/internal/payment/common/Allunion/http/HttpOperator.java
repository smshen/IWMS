package org.lazicats.ecos.internal.payment.common.Allunion.http;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.lazicats.ecos.basecomponent.utils.RandomUtils;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.MessageBody;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.MessageHead;
import org.lazicats.ecos.internal.payment.common.Allunion.model.custom.VnbMessage;
import org.lazicats.ecos.internal.payment.common.Allunion.utils.JAXB;
import org.lazicats.ecos.internal.payment.common.Allunion.utils.MD5Cryptor;
import org.lazicats.ecos.internal.payment.common.Upoppay.CharacterEncodeConverter;
import org.lazicats.ecos.internal.utils.PostHttp;
import org.lazicats.ecos.order.service.model.OrderAddressDo;
import org.lazicats.ecos.order.service.model.OrderDo;
import org.lazicats.ecos.order.service.model.OrderImportedDo;

/**
 * 
 * @author Jay
 *
 */
public class HttpOperator {
	private static Logger logger = Logger.getLogger(HttpOperator.class);
	
	private static final String XML_DECLERATION = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
	private static final String PAYCHANNEL_OFFLINE_POS = "03";
	private static final String DOCUMENTTYPE_IDCARD = "01";
	private static final String CURRENCY_CNY = "142";
	
	public static final String CURRENT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	public static final String MSGID_DATE_FORMAT = "yyyyMMddHHmmss";

	
	public static void sendDeclaration(OrderDo orderDo, String trxId, String payTime, double bankPaidAmountYuan) throws JAXBException {
		sanityCheck(orderDo,  trxId,  payTime);
		
		logger.info("posting request[send the payment credence] to allinpay ...");
		String xml = getXml(orderDo,  trxId,  payTime,bankPaidAmountYuan);
		System.out.println(xml);
		String respXml = PostHttp.doHttpPost(CommonPayInfo.BankPayInfo.get("allinpay_send_decleration_url"),xml);
		//String respXml = PostHttp.doHttpPost("http://121.8.157.114:17090/vnbcustoms/CustomsServlet",xml);
		System.out.println(respXml);
		
		

	}
	
	private static void sanityCheck(OrderDo orderDo, String trxId,
			String payTime) {
		// TODO Auto-generated method stub
		
	}

	public static String getFormattedCurrentTimeStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	private static String getXml(OrderDo orderDo, String trxId, String payTime, double bankPaidAmountYuan) throws JAXBException {
		OrderImportedDo orderImported = orderDo.getOrderImported();
		OrderAddressDo orderAddress = orderDo.getOrderAddress();
		
		String msgId = getFormattedCurrentTimeStr(MSGID_DATE_FORMAT)+ RandomUtils.getRandomNumberStr(4);
		MessageHead msgHead = new MessageHead();
		msgHead.setMessageCode(CommonPayInfo.BankPayInfo.get("allinpay_interface_code"));
		msgHead.setMessageId(msgId);
		msgHead.setSenderId(CommonPayInfo.BankPayInfo.get("allinpay_sender_id"));
		msgHead.setSendTime(getFormattedCurrentTimeStr(CURRENT_DATE_FORMAT));
		msgHead.setSign("");
		
		MessageBody msgBody = new MessageBody();
		msgBody.setCustomICP(CommonPayInfo.BankPayInfo.get("allinpay_custom_icp"));
		msgBody.setOrderNo(orderDo.getOrderNo());
		msgBody.setPayGoodsAmount(get2DigitDouble(bankPaidAmountYuan));
		msgBody.setFreight(get2DigitDouble(orderDo.getDeliveryFeeTotal()));
		msgBody.setPayTaxAmount(get2DigitDouble(orderImported.getPaidTax()));
		
		msgBody.setPayerName(orderAddress.getRealName());
		msgBody.setPayerDocumentType(DOCUMENTTYPE_IDCARD);
		msgBody.setPayerDocumentNumber(orderImported.getIdentifyCode());
		
		msgBody.setPayChnlID(PAYCHANNEL_OFFLINE_POS);
		msgBody.setPayTransactionNo(trxId);
		msgBody.setPayTime(payTime);
		
		msgBody.setPayCurrency(CURRENCY_CNY);
		
		VnbMessage vnp = new VnbMessage();
		vnp.setMessageHead(msgHead);
		vnp.getMessageBodies().add(msgBody);
	
		String vnpMsgXml = "";
		try {
		    vnpMsgXml = JAXB.ox(vnp);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		msgHead.setSign(signMD5(vnpMsgXml));
		return JAXB.ox(vnp);
	}
	
	public static String get2DigitDouble(String doubleStr) {
		double digit2Double = new BigDecimal(doubleStr).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.format("%.2f",digit2Double);
	}
	
	public static String get2DigitDouble(Double orderDo) {
		double digit2Double = BigDecimal.valueOf(orderDo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.format("%.2f",digit2Double);
	}

	private static String signMD5(String msgHeadXml) {
		StringBuilder sb = new StringBuilder();
		sb.append(StringUtils.remove(msgHeadXml, XML_DECLERATION))
		  .append(CommonPayInfo.BankPayInfo.get("allinpay_declaration_mac_key"));
		String source = sb.toString();
		logger.info("signing with source: " + source);
		
		String upperCase = null;
		try {
			String origString = new String(source.getBytes(),"utf-8");
			System.out.println("plain text before md5:" + origString);
            upperCase = MD5Cryptor.getMD5ofStr(origString).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger.info("signture: " + upperCase);
		return upperCase;
	}
	
}

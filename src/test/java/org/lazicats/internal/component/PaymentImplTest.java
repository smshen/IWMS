package org.lazicats.internal.component;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.lazicats.ecos.basecomponent.utils.RandomUtils;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.component.impl.PaymentImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PaymentImplTest {
	
	@Resource
	private static PaymentImpl paymentImpl;
	
	@BeforeClass
	public static void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		paymentImpl = ac.getBean(PaymentImpl.class);
	}
	
	@Test
	public void test() throws UnsupportedEncodingException {
		
		Map<String, String> payentMent = new HashMap<String, String>();
		
		
		payentMent.put("orderNo", RandomUtils.getRandomNumberStr(20));
		payentMent.put("orderAmount","30.66");
		
		payentMent.put("RealName","人" );
		payentMent.put("goodsAmount","15.33");
		payentMent.put("taxAmount","0.00");
		payentMent.put("freight","15.33");
		payentMent.put("credentialsNo","441224198906096813");
		
		
	    try {
			System.out.println("Hello: " + paymentImpl.pay(CommonPayInfo.PAYMENT_UPOP, payentMent));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	

}

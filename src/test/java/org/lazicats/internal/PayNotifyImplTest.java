package org.lazicats.internal;

import java.net.URLDecoder;

import org.junit.Test;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.service.impl.PayNotifyImpl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class PayNotifyImplTest {
	PayNotifyImpl pay = new PayNotifyImpl();
	@Test
	public void test_99Bill_payment_notify_proccessed_fail() throws Exception {
		CommonPayInfo.BankPayInfo.put("rmbport_cerPath", "L:\\bak\\bank_key\\rmbport\\99bill.cert.rsa.20140728.cer");
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();
		req.setParameter("dealTime","20150613215402");
		req.setParameter("payAmount","399900");
		req.setParameter("signType","4");
		req.setParameter("errCode","");
		req.setParameter("merchantAcctId","1002163801001");
		req.setParameter("orderTime","20150613215230");
		req.setParameter("dealId","1920957615");
		req.setParameter("version","v2.0");
		req.setParameter("bankId","CIB");
		req.setParameter("fee","2399");
		req.setParameter("bankDealId","150613135941");
		req.setParameter("payResult","10");
		req.setParameter("ext1","");
		req.setParameter("ext2","");
		req.setParameter("orderAmount","399900");
		req.setParameter("signMsg",URLDecoder.decode("n6dHYgm50gvDdLui0ANwJU3ySoY8shCCADEi80XBu1xMLcVMKoawqfOXKZ3Hi4P%2FnxP1Q2NMvFgFpbMpsxKUEGhyaACySJw48rPlD3xFtjrPHU0ypwdaUIGXBlKF4obkX24lR8gl77YC9f4qKibqMhMOBYMh%2BFk5KMrdpahQWMtocXcixRO4rPamNM%2F4FEuAnbKP9FJIwmcrPpfuSQY%2Bsw9ozIMJZhcKjzuO9JKdLDDG0iD3%2FfLCg4Im3A%2Fe9KVWII%2FsCPJyDh72kmFEPMAyWgfyqtMRqsV8N8HvkhD4LJm8elsHIU6xnKLB5yiUtscRwA5xAQDglRJL1XTfb0j9sQ%3D%3D"));
		req.setParameter("payType","10");
		req.setParameter("language","1");
		req.setParameter("orderId","1434202166633085813");

		
		
		pay.notifyRmbport(req, resp);
	}
	
	@Test
	public void test_99Bill_payment_notify_proccessed_success() throws Exception {
		CommonPayInfo.BankPayInfo.put("rmbport_cerPath", "C:\\Users\\Jay\\Desktop\\todo\\20150709\\99bill.cert.rsa.20340630.cer");
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();
	
		
		req.setParameter("dealTime","20150603091736");
		req.setParameter("payAmount","12900");
		req.setParameter("signType","4");
		req.setParameter("errCode","");
		req.setParameter("merchantAcctId","1002163801001");
		req.setParameter("orderTime","20150603091501");
		req.setParameter("dealId","1910862692");
		req.setParameter("version","v2.0");
		req.setParameter("bankId","CCB");
		req.setParameter("fee","77");
		req.setParameter("bankDealId","150603078225");
		req.setParameter("payResult","10");
		req.setParameter("ext1","");
		req.setParameter("ext2","");
		req.setParameter("orderAmount","12900");
		String base64URLEncodeStr = "iVnM1U0siPQ%2BKG1bvOix4m%2Bdiirb8xAzvn%2FtAKzT%2B8uX%2FwkNo4rhD8%2BipCKnrBOMtLw%2FB7GxYw0XDpp38EcIIUIJvYfKNW9n1fzpC85EBvphDC%2BsfwI3JDr9Ltq42GYazdDNZL0K8qHCIb1V%2Brn%2FshdbxZjl7m2geoC0Ey4OaW7owrXf1Lct8ZIdR%2FX20YrxBozDeD43y4T6E4VMqJzQ9s3wt3GR0vCNJJGY1JAjFb100jw70Rioc6lpJRLi7tqv5v9tbVuH%2FCncxTdkqnLPTpoxSeoByfgxmJbG7slMb46B5losRU4qOmDiCfAE%2FQJllEwRKQK2ID3W2NO9kgbGXw%3D%3D";
		req.setParameter("signMsg",URLDecoder.decode(base64URLEncodeStr));
		req.setParameter("payType","10");
		req.setParameter("language","1");
		req.setParameter("orderId","1433293824229600240000");
		
		
		pay.notifyRmbport(req, resp);
	}

}

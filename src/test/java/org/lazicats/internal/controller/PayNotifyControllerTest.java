package org.lazicats.internal.controller;

import org.junit.Test;
import org.lazicats.ecos.internal.payment.controllor.PayNotifyController;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.unitils.easymock.EasyMockModule;

public class PayNotifyControllerTest{
	
	@Test
	public void testPayNotify() {
		MockHttpServletRequest mreq = new MockHttpServletRequest();
		MockHttpServletResponse mresp = new MockHttpServletResponse();
		
		PayNotifyController payNotifyCtrl = new PayNotifyController();
	}

}

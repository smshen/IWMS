package org.lazicats.ecos.internal.wms.compent;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.lazicats.ecos.internal.wms.common.CommonWmsInfo;
import org.lazicats.ecos.internal.wms.consts.OrderType;
import org.lazicats.ecos.internal.wms.model.Message;
import org.lazicats.internal.base.SpringBeanTestBase;

public class IWMSServComponentTest extends SpringBeanTestBase{
	private static IWMSServComponent wmsServComponent;
	
	@BeforeClass
	public static void initSelf(){
		try {
			wmsServComponent = get(IWMSServComponent.class);
			
			CommonWmsInfo.clientUrl= "http://192.9.9.97:8076/gbdswms/services/WSProcessor?wsdl";
			CommonWmsInfo.userName="YSB";
			CommonWmsInfo.password="jiekou";
			CommonWmsInfo.serviceName="NormalService";
			assert wmsServComponent != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试收货确认
	 * @throws Exception
	 */
	@Test
	public void testConfirmReceiveOK() throws Exception {
		Message msg = wmsServComponent.confirmReceive("1445241493537246109",OrderType.SALE_EXWH,"888888");
		Assert.assertEquals("0",msg.getCode());
		
	}
}

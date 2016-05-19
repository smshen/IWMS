package org.lazicats.ecos.internal.wms.ws.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.lazicats.ecos.internal.wms.compent.IWMSServComponent;
import org.lazicats.ecos.internal.wms.ws.WMSService;


@WebService(endpointInterface="org.lazicats.ecos.internal.wms.ws.WMSService"
				,serviceName="WMSService")
public class WMSServiceImpl implements WMSService{
	
	@Resource
	private IWMSServComponent wmsServComponent;
	
	@Override
	public String confirmSelfDelivery(String orderNo, String consigner) {
		
		/*Message result = wmsServComponent.confirmReceive(
								orderNo,OrderType.SALE_EXWH, consigner);
		
		return translateMsg(result.getCode(),result.getMessage());*/
		return "{code:0,errmsg:\"you have a error\"}";
		
	}
	
	private String translateMsg(String success,String errmsg){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("code:").append("0".equals(success)?"1":"0");
		//有错误时才会添加到返回对象中
		if(StringUtils.isNotBlank(errmsg)){
			sb.append(",").append("errmsg:\"").append(errmsg).append("\"");
		}
		sb.append("}");
		
		return sb.toString();
	}
	
}

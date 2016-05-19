package org.lazicats.ecos.internal.wms.common;

import java.io.StringReader;
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.lazicats.ecos.internal.wms.model.Message;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
@Component
public class Client {
	/**
	 * 建立连接
	 * 
	 * @param invokeXml
	 * @return
	 */
	private Logger logger = Logger.getLogger(Client.class);

	public String getResultXml(String invokeXml) throws Exception {
		logger.info("EPR推送WMS开始-------------------------------------------");
		String retXml = null;
		Service service = new Service();
		Call call = (Call) service.createCall();
		//call.setTimeout(5000);
		call.setTargetEndpointAddress(CommonWmsInfo.clientUrl);
		call.setOperationName(new QName("", CommonWmsInfo.serviceName.toString()));
		retXml = (String) call.invoke(new Object[] { CommonWmsInfo.userName,CommonWmsInfo.password, invokeXml });
		return retXml;
	}

	/**
	 * 获得返回的message
	 * 
	 * @param invokeXml
	 * @return
	 */
	public Message getMessqge(String invokeXml) throws Exception {
			Message message = new Message();
			String retXml = this.getResultXml(invokeXml);
			logger.info("wms返回结果：" + retXml);
			SAXBuilder builder = new SAXBuilder();
			StringReader sr = new StringReader(retXml);
			InputSource is = new InputSource(sr);
			Document document = builder.build(is);
			Element rootElement = (Element) document.getRootElement();
			message.setCode(rootElement.getAttributeValue("errcode"));
			message.setMessage(rootElement.getAttributeValue("errmsg"));
		return message;
	}
}

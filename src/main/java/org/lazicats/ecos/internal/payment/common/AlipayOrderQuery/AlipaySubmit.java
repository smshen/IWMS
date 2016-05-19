package org.lazicats.ecos.internal.payment.common.AlipayOrderQuery;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;

/**
 * 
 * @FileName AlipaySubmit.java
 * @PackageName org.lazicats.ecos.internal.payment.common.AlipayOrderQuery
 * @功能 构造支付宝各接口表单HTML文本，获取远程HTTP数据
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-17下午2:20:49
 * 
 */
public class AlipaySubmit {

	private static final Logger log = Logger.getLogger(AlipaySubmit.class);
	/**
	 * 支付宝提供给商户的服务接入网关URL(新)
	 */
	private static final String ALIPAY_GATEWAY_NEW = CommonPayInfo.BankPayInfo.get("alipay_sendGoodsUrl");

	/**
	 * 生成签名结果
	 * 
	 * @param sPara
	 *            要签名的数组
	 * @return 签名结果字符串
	 */
	protected static String buildRequestMysign(Map<String, String> sPara) {
		String prestr = AlipayCore.createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
		String mysign = "";
		if (AlipayConfig.sign_type.equals("MD5")) {
			mysign = MD5.sign(prestr,
					CommonPayInfo.BankPayInfo.get("alipay_key"),
					CommonPayInfo.BankPayInfo.get("alipay_input_charset"));
		}
		return mysign;
	}

	/**
	 * 生成要请求给支付宝的参数数组
	 * 
	 * @param sParaTemp
	 *            请求前的参数数组
	 * @return 要请求的参数数组
	 */
	private static Map<String, String> buildRequestPara(
			Map<String, String> sParaTemp) {
		// 除去数组中的空值和签名参数
		Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
		// 生成签名结果
		String mysign = buildRequestMysign(sPara);

		// 签名结果与签名方式加入请求提交参数组中
		sPara.put("sign", mysign);
		sPara.put("sign_type", AlipayConfig.sign_type);

		return sPara;
	}
	
	/**
	 * 支付宝订单结果查询
	 * 
	 * @param orderId 订单号
	 * @param trandeNo 交易流水号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static QueryOrderMessage orderQuery(String orderId,String trandeNo){
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		
		Map<String, String> sParaTemp = AlipaySubmit.orderQueryGetMap(orderId, trandeNo);
		String resultXml = "";
		try {
			resultXml = AlipaySubmit.buildRequest("", "", sParaTemp);
		} catch (Exception e) {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("程序执行异常，" + e.getMessage());
			log.error("支付宝订单查询程序异常，" + e.getMessage());
			e.printStackTrace();
		}
		
		Map<String, Object> resultMap = XMLUtils.xmlToMapByAlipay(resultXml);
		
		if("T".equals(resultMap.get("is_success"))){
			Map<String, String> trandeMap = (Map<String, String>) resultMap.get("trade");
			trandeMap.put("sign", resultMap.get("sign").toString());
			boolean bool = AlipayNotify.verify(trandeMap);
			if (bool == true) {
				queryOrderMessage.setSuccess(true);
				queryOrderMessage.setOrder(trandeMap.get("out_trade_no"));
				queryOrderMessage.setAmount(trandeMap.get("total_fee"));
			} else {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("校验签名失败");
			}
		} else {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("查询无结果,反馈信息："+resultMap.get("error"));
		}
		
		return queryOrderMessage;
	}

	/**
	 * 建立请求，以表单HTML形式构造（默认）
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @return 提交表单HTML文本
	 */
	public static String buildRequest(Map<String, String> sParaTemp,
			String strMethod, String strButtonName) {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		List<String> keys = new ArrayList<String>(sPara.keySet());

		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\""
				+ ALIPAY_GATEWAY_NEW
				+ "_input_charset="
				+ CommonPayInfo.BankPayInfo.get("alipay_input_charset")
				+ "\" method=\"" + strMethod + "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name
					+ "\" value=\"" + value + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName
				+ "\" style=\"display:none;\"></form>");
		sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

		return sbHtml.toString();
	}

	/**
	 * 建立请求，以表单HTML形式构造，带文件上传功能
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @param strParaFileName
	 *            文件上传的参数名
	 * @return 提交表单HTML文本
	 */
	public static String buildRequest(Map<String, String> sParaTemp,
			String strMethod, String strButtonName, String strParaFileName) {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		List<String> keys = new ArrayList<String>(sPara.keySet());

		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\"  enctype=\"multipart/form-data\" action=\""
				+ ALIPAY_GATEWAY_NEW
				+ "_input_charset="
				+ CommonPayInfo.BankPayInfo.get("alipay_input_charset")
				+ "\" method=\"" + strMethod + "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name
					+ "\" value=\"" + value + "\"/>");
		}

		sbHtml.append("<input type=\"file\" name=\"" + strParaFileName
				+ "\" />");

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName
				+ "\" style=\"display:none;\"></form>");

		return sbHtml.toString();
	}

	/**
	 * 建立请求，以模拟远程HTTP的POST请求方式构造并获取支付宝的处理结果
	 * 如果接口中没有上传文件参数，那么strParaFileName与strFilePath设置为空值 如：buildRequest("",
	 * "",sParaTemp)
	 * 
	 * @param strParaFileName
	 *            文件类型的参数名
	 * @param strFilePath
	 *            文件路径
	 * @param sParaTemp
	 *            请求参数数组
	 * @return 支付宝处理结果
	 * @throws Exception
	 */
	public static String buildRequest(String strParaFileName,
			String strFilePath, Map<String, String> sParaTemp) throws Exception {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);

		HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler
				.getInstance();

		HttpRequest request = new HttpRequest(HttpResultType.BYTES);
		// 设置编码集
		request.setCharset(CommonPayInfo.BankPayInfo
				.get("alipay_input_charset"));

		request.setParameters(generatNameValuePair(sPara));
		request.setUrl(ALIPAY_GATEWAY_NEW + "_input_charset="
				+ CommonPayInfo.BankPayInfo.get("alipay_input_charset"));

		HttpResponse response = httpProtocolHandler.execute(request,
				strParaFileName, strFilePath);
		if (response == null) {
			return null;
		}

		String strResult = response.getStringResult();

		return strResult;
	}

	/**
	 * MAP类型数组转换成NameValuePair类型
	 * 
	 * @param properties
	 *            MAP类型数组
	 * @return NameValuePair类型数组
	 */
	private static NameValuePair[] generatNameValuePair(
			Map<String, String> properties) {
		NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
		int i = 0;
		for (Map.Entry<String, String> entry : properties.entrySet()) {
			nameValuePair[i++] = new NameValuePair(entry.getKey(),
					entry.getValue());
		}

		return nameValuePair;
	}

	/**
	 * 订单查询请求Map
	 * 
	 * @param orderId
	 * @param tradeNo
	 * @return
	 */
	private static Map<String, String> orderQueryGetMap(String orderId, String trandeNo) {
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "single_trade_query");
		sParaTemp.put("partner", CommonPayInfo.BankPayInfo.get("alipay_partner"));
		sParaTemp.put("_input_charset", CommonPayInfo.BankPayInfo.get("alipay_input_charset"));
		sParaTemp.put("trade_no", trandeNo);
		sParaTemp.put("out_trade_no", orderId);
		
		return sParaTemp;
	}
	
	/**
	 * 用于防钓鱼，调用接口query_timestamp来获取时间戳的处理函数 注意：远程解析XML出错，与服务器是否支持SSL等配置有关
	 * 
	 * @return 时间戳字符串
	 * @throws IOException
	 * @throws DocumentException
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("unchecked")
	protected static String query_timestamp() throws MalformedURLException,
			DocumentException, IOException {

		// 构造访问query_timestamp接口的URL串
		String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner="
				+ CommonPayInfo.BankPayInfo.get("alipay_partner");
		StringBuffer result = new StringBuffer();

		SAXReader reader = new SAXReader();
		Document doc = reader.read(new URL(strUrl).openStream());

		List<Node> nodeList = doc.selectNodes("//alipay/*");

		for (Node node : nodeList) {
			// 截取部分不需要解析的信息
			if (node.getName().equals("is_success")
					&& node.getText().equals("T")) {
				// 判断是否有成功标示
				List<Node> nodeList1 = doc
						.selectNodes("//response/timestamp/*");
				for (Node node1 : nodeList1) {
					result.append(node1.getText());
				}
			}
		}

		return result.toString();
	}
}

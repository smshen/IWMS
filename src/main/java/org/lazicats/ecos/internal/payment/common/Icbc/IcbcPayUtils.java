package org.lazicats.ecos.internal.payment.common.Icbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;

import cn.com.infosec.icbc.ReturnValue;


/**
 * 工行支付工具类
 * 
 * @author MingJun_Guo
 * @创建日期：2013-8-12 上午11:12:46
 * 
 */
public class IcbcPayUtils {
	
	private static Logger log = Logger.getLogger(IcbcPayUtils.class);

	/**
	 * 创建支付提交HTML
	 * @param valueVo
	 * @return
	 */
	public static String crateIcbcPayHtml(String valueVo[]){
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < IcbcPayConf.payVo.length; i++) {
			map.put(IcbcPayConf.payVo[i], valueVo[i]);
		}
		map.put(IcbcPayConf.merSignMsg, new String(IcbcPayUtils.signKey(IcbcPayUtils.signContent(map))));
		map.put(IcbcPayConf.merCert, new String(IcbcPayUtils.signCrt()));
		
		return IcbcPayUtils.generateAutoSubmitForm(CommonPayInfo.BankPayInfo.get("icbcPay_url"), map);
	}
	
	/**
	 * 订单支付状态查询
	 * 
	 * @param valueVo
	 * @return
	 */
	public static QueryOrderMessage orderPayQuery(String queryVo[]){
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < IcbcPayConf.queryVo.length; i++) {
			map.put(IcbcPayConf.queryVo[i], queryVo[i]);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("orderId", map.get("orderId"));
		
		try {
			String result = IcbcOrderQueryUtils.queryAPIHelper(map);
			if(result.length()>30){
				resultMap = XMLUtils.xmlToMapByIcbc(result, resultMap);
			}
			queryOrderMessage = IcbcPayUtils.getQueryOrderMessage(resultMap);
		} catch (Exception e) {
			log.error("工行支付订单查询异常，" + e.getMessage());
			queryOrderMessage.setMessage("工行订单查询失败，程序异常！");
			e.printStackTrace();
		}
		return queryOrderMessage;
	}
	
	/**
	 * 加密明文封装
	 * 
	 * @param map
	 * @return
	 */
	private static String signContent(Map<String, String> map){
		StringBuffer plainCode = new StringBuffer(CommonPayInfo.BankPayInfo.get("icbcPay_portName"));//接口名称的值
		plainCode.append(CommonPayInfo.BankPayInfo.get("icbcPay_version"));//接口版本号的值
		plainCode.append(map.get("merID"));//商城代码的值
		plainCode.append(map.get("merAcct"));//商城账号的值
		plainCode.append(map.get("merURL"));//通知地址的值
		plainCode.append(map.get("notifyType"));//结果发送类型的值
		plainCode.append(map.get("orderid"));//订单号的值
		plainCode.append(map.get("amount"));//订单金额的值
		plainCode.append(map.get("curType"));//支付币种的值
		plainCode.append(map.get("resultType"));//通知类型的值
		plainCode.append(map.get("orderDate"));//交易日期时间的值
		plainCode.append(map.get("verifyJoinFlag"));//校验联名标志的值
		
		return plainCode.toString();
	}
	
	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param map
	 * @return
	 */
	public static boolean checkSign(Map<String, String> map) {
		boolean bool = false;
		// 证书公钥解码
		byte[] DecCert = ReturnValue.base64dec(IcbcPayUtils.signCrt());
		// 私钥解码
		byte[] DecSign = ReturnValue.base64dec(IcbcPayUtils.signKey(IcbcPayUtils.checkSignContent(map)));

		// 明文字符串 字节
		byte[] byteSrcContent = IcbcPayUtils.checkSignContent(map).getBytes();

		try {
			int a = ReturnValue.verifySign(byteSrcContent, byteSrcContent.length, DecCert, DecSign);
			if (a == 0) {
				bool = true;
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * 工行返回参数验证明文
	 * 
	 * @param map
	 * @return
	 */
	private static String checkSignContent(Map<String, String> map) {
		StringBuilder signContent = new StringBuilder("interfaceVersion");
		signContent.append("=" + map.get("interfaceName" + "&"));
		signContent.append("interfaceVersion");
		signContent.append("=" + map.get("interfaceVersion" + "&"));
		signContent.append("orderid");
		signContent.append("=" + map.get("orderid" + "&"));
		signContent.append("TranSerialNo");
		signContent.append("=" + map.get("TranSerialNo" + "&"));
		signContent.append("amount");
		signContent.append("=" + map.get("amount" + "&"));
		signContent.append("curType");
		signContent.append("=" + map.get("curType" + "&"));
		signContent.append("merID");
		signContent.append("=" + map.get("merID" + "&"));
		signContent.append("merAcct");
		signContent.append("=" + map.get("merAcct" + "&"));
		signContent.append("verifyJoinFlag");
		signContent.append("=" + map.get("verifyJoinFlag" + "&"));
		signContent.append("JoinFlag");
		signContent.append("=" + map.get("JoinFlag" + "&"));
		signContent.append("UserNum");
		signContent.append("=" + map.get("UserNum" + "&"));
		signContent.append("resultType");
		signContent.append("=" + map.get("resultType" + "&"));
		signContent.append("orderDate");
		signContent.append("=" + map.get("orderDate" + "&"));
		signContent.append("notifyDate");
		signContent.append("=" + map.get("notifyDate" + "&"));
		signContent.append("tranStat");
		signContent.append("=" + map.get("tranStat" + "&"));
		signContent.append("comment");
		signContent.append("=" + map.get("comment" + "&"));
		signContent.append("remark1");
		signContent.append("=" + map.get("remark1" + "&"));
		signContent.append("remark2");
		signContent.append("=" + map.get("remark2"));
		return signContent.toString();
	}
	
	/**
	 * 私钥 明文加密，64base加密生成
	 * 
	 * @param content
	 * @return
	 */
	private static byte[] signKey(String content){
		//String SignMsgBase64 = "";
		byte[] byteSrc = content.getBytes();//明文字节
		char[] keyPass = CommonPayInfo.BankPayInfo.get("icbcPay_keyPass").toCharArray();//私钥密码字节
		byte[] bkey = "".getBytes();
		
		try {
			FileInputStream inputStream = new FileInputStream(CommonPayInfo.BankPayInfo.get("icbcPay_key"));
			bkey = new byte[inputStream.available()];
			inputStream.read(bkey);
			inputStream.close();
		} catch (FileNotFoundException e) {
			log.error("工行私钥文件不能找到错误，请检查配置文件！");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("读取工行私钥文件错误，请检查配置文件！");
			e.printStackTrace();
		}
		
		byte[] EncSign = null;
		
		try {
			byte[] sign =ReturnValue.sign(byteSrc,byteSrc.length,bkey,keyPass);
			EncSign = ReturnValue.base64enc(sign);
			//SignMsgBase64=new String(EncSign).toString();
		} catch (Exception e) {
			log.error("私钥生成加密字符串错误，请检查配置文件！");
			e.printStackTrace();
		}
		
		return EncSign;
	}
	
	/**
	 * 公钥证书文件读取，64Base加密
	 * 
	 * @return
	 */
	private static byte[] signCrt() {
		//String certBase64 = "";
		byte[] EncCert = null;

		try {
			FileInputStream inputStream = new FileInputStream(CommonPayInfo.BankPayInfo.get("icbcPay_crt"));
			byte[] bcert = new byte[inputStream.available()];
			inputStream.read(bcert);
			inputStream.close();
			EncCert = ReturnValue.base64enc(bcert);
			//certBase64 = new String(EncCert).toString();
		} catch (FileNotFoundException e) {
			log.error("工行证书公钥文件不能找到错误，请检查配置文件！");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("读取工行公钥文件错误，请检查配置文件！");
			e.printStackTrace();
		}

		return EncCert;
	}
	
	/**
	 * 封装支付提交文本
	 * 
	 * @param actionUrl
	 * @param paramMap
	 * @return
	 */
	private static String generateAutoSubmitForm(String actionUrl,
			Map<String, String> paramMap) {
		StringBuilder html = new StringBuilder();
		html.append("<form id=\"icbcForm\" name=\"icbcForm\" action=\"").append(actionUrl).append("\" method=\"post\">\n");

		for (String key : paramMap.keySet()) {
			html.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
		}
		html.append("</form>\n");
		html.append("<script>document.forms['icbcForm'].submit();</script>");
		return html.toString();
	}
	
	/**
	 * 工行订单状态查询，将map转为QueryOrderMessage 对象
	 * @param orderQueryMap
	 * @return
	 */
	private static QueryOrderMessage getQueryOrderMessage(Map<String, String> orderQueryMap){
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		queryOrderMessage.setOrder(orderQueryMap.get("orderId"));
		if(orderQueryMap.containsKey("tranStat")){
			String orderStat = orderQueryMap.get("tranStat");
			if("0".equals(orderStat) || "1".equals(orderStat)){
				queryOrderMessage.setSuccess(true);
			}
			if(orderQueryMap.containsKey("amount")){
				double amount = Double.parseDouble(orderQueryMap.get("amount"));
				DecimalFormat df=new DecimalFormat("#.00");
				queryOrderMessage.setAmount(df.format(amount/100));
			}
		}else{
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("工行订单查询失败，未支付或支付未清算");
		}
		
		return queryOrderMessage;
	}
}

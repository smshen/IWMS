package org.lazicats.ecos.internal.payment.common.Boc;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;

import com.bocnet.common.security.PKCS7Tool;

/**
 * @author MingJun_Guo
 * @创建日期：2013-8-13 上午09:28:48
 * 
 * 类说明：中行网银支付接口工具
 */

public class BocPayUtils {

	private static Logger log = Logger.getLogger(BocPayUtils.class);
	
	/**
	 * 创建支付提交HTML
	 * @param valueVo
	 * @return
	 */
	public static String crateIcbcPayHtml(String valueVo[]){
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < BocPayConf.payVo.length; i++) {
			map.put(BocPayConf.payVo[i], valueVo[i]);
		}
		map.put(BocPayConf.signData, BocPayUtils.sginData(map));
		
		String fromUrl = BocPayUtils.generateAutoSubmitForm(CommonPayInfo.BankPayInfo.get("bocPay_url"), map);
		return fromUrl;
	}
	
	/**
	 * 中行 商户签名字符串生成，极其加密处理
	 * 
	 * @param map
	 * @return
	 */
	private static String sginData(Map<String, String> map) {

		StringBuilder content = new StringBuilder(map.get("orderNo"));// 商户订单号
		content.append("|" + map.get("orderTime"));// 订单时间
		content.append("|" + "001");// 订单币种
		content.append("|" + map.get("orderAmount"));// 订单金额
		content.append("|" + CommonPayInfo.BankPayInfo.get("bocPay_merCode"));// 商户号
		return BocPayUtils.signPKCS7(content.toString().replaceAll(" ", ""));
	}
	
	/**
	 * 验证银行签名
	 * 
	 * @param map
	 * @return
	 */
	public static boolean checkSign(Map<String, String> map){
		boolean bool = false;
		
		/*
		 * 银行回调 签名明文
		 */
		StringBuilder stringBuilder = new StringBuilder(map.get("merchantNo")+"|");//商户号
		stringBuilder.append(map.get("orderNo")+"|");//商户订单号
		stringBuilder.append(map.get("orderSeq")+"|");//银行订单流水号
		stringBuilder.append(map.get("cardTyp")+"|");//银行卡类别
		stringBuilder.append(map.get("payTime")+"|");//支付时间
		stringBuilder.append(map.get("orderStatus")+"|");//订单状态
		stringBuilder.append(map.get("payAmount"));//支付金额
		
		PKCS7Tool tool;
		try {
			/**
			 * signature：签名，data：明文数据，dn：银行签名证书DN，如果为空则不验证DN。验签名，如果失败抛出异常
			 */
			tool = PKCS7Tool.getVerifier(CommonPayInfo.BankPayInfo.get("bocPay_publicKeyPath"));//根证书路径(公钥证书)
			tool.verify(map.get("signData"), stringBuilder.toString().getBytes(),null); //CommonPayInfo.BankPayInfo.get("bocPay_dnPath")
			bool = true;
		} catch (GeneralSecurityException e) {
			bool = false;
			e.printStackTrace();
		} catch (IOException e) {
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 订单查询
	 * @param valueVo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static QueryOrderMessage queryOrder(String[] valueVo){
		
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		Map<String, String> mapQuery = new HashMap<String, String>();
		
		for (int i = 0; i < BocPayConf.queryVo.length; i++) {
			mapQuery.put(BocPayConf.queryVo[i], valueVo[i]);
		}
		/*
		 * 封装签名信息
		 * 格式:商户号:商户订单号字符串merchantNo:orderNos
		 */
		StringBuilder signData =  new StringBuilder(mapQuery.get("merchantNo"));
		signData.append(":").append(mapQuery.get("orderNos"));
		
		mapQuery.put(BocPayConf.signData, BocPayUtils.signPKCS7(signData.toString()));
		
		/*
		 * 发送查询请求获得请求结果XML
		 */
		String queryXmlStr = "";
		try {
			queryXmlStr = BocHttpClient.sendPost(CommonPayInfo.BankPayInfo.get("bocpay_queryUrl"), mapQuery);
		} catch (Exception e) {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("订单查询失败");
			log.error("中行执行请求查询异常，" + e.getMessage());
			e.printStackTrace();
		}
		
		if(!"".equals(queryXmlStr)){
			Map<Object, Object> queryMap = XMLUtils.xmlToMapByBoc(queryXmlStr);
			if("A".equals(queryMap.get("HandleStatus"))){
				List<Map<String, String>> listTrans = (List<Map<String, String>>) queryMap.get("listTrans");
				
				/*
				 * BOC存在多订单同时查询，当前只处理一条订单
				 */
				if(listTrans.size()>0){
					Map<String, String> transMap = listTrans.get(0);
					/*
					 * 订单状态：0-未处理,1-支付,4-未明5-失败
					 */
					if("1".equals(transMap.get("orderStatus"))){
						queryOrderMessage.setOrder(transMap.get("orderNo"));
						queryOrderMessage.setAmount(transMap.get("payAmount"));
						queryOrderMessage.setSuccess(true);
						queryOrderMessage.setMessage("支付成功");
					}else{
						queryOrderMessage.setSuccess(false);
						queryOrderMessage.setMessage("未支付成功");
					}
				}
			}else{
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("订单查询失败");
			}
		}
		return queryOrderMessage;
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
		html.append("<form name=\"bocPay\" action=\"").append(actionUrl).append("\" method=\"post\">\n");

		for (String key : paramMap.keySet()) {
			html.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
		}
		html.append("</form>\n");
		html.append("<script>document.forms['bocPay'].submit();</script>");
		return html.toString();
	}
	
	/**
	 * 加密字符串
	 * 
	 * @param content
	 * @return
	 */
	private static String signPKCS7(String content) {
		// String keyStorePath: 证书库路径
		// String keyStorePassword: 证书库口令
		// String keyPassword: 签名私钥口令，一般与证书库口令相同
		String signature = "";
		try {
			PKCS7Tool tool = PKCS7Tool.getSigner(
					CommonPayInfo.BankPayInfo.get("bocPay_keyStorePath"),
					CommonPayInfo.BankPayInfo.get("bocPay_keyStorePassword"),
					CommonPayInfo.BankPayInfo.get("bocPay_keyPassword"));
			// 签名，返回signature：base64格式的签名结果
			// byte[] data: 明文字符串
			byte[] data = content.toString().getBytes();
			signature = tool.sign(data);
		} catch (GeneralSecurityException e) {
			log.error("中行商户签名执行异常！");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("中行商户签名读取key文件异常！");
			e.printStackTrace();
		} catch (Exception e) {
			log.error("中行商户签名加密内容执行异常！");
			e.printStackTrace();
		}
		return signature;
	}
}

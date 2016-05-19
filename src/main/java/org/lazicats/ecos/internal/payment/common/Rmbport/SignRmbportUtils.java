package org.lazicats.ecos.internal.payment.common.Rmbport;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;

import sun.misc.BASE64Encoder;

/**
 * 
 * @author MingJun_Guo
 * @创建日期：2013-9-3 上午9:12:30
 * 
 * @说明：快钱支付SSL加密极其验证
 */
public class SignRmbportUtils {

	private static final Logger log = Logger.getLogger(SignRmbportUtils.class);

	/**
	 * 加密字符串
	 * 
	 * @param signMsg
	 * @return
	 */
	protected static String signMsg(String signMsg) {
	    System.out.println("quick pay sign msg:/n"+signMsg);
		String base64 = "";
		try {
			// 密钥仓库
			KeyStore ks = KeyStore.getInstance("PKCS12");

			// 读取密钥仓库
			FileInputStream ksfis = new FileInputStream(
					CommonPayInfo.BankPayInfo.get("rmbport_keyPath"));

			BufferedInputStream ksbufin = new BufferedInputStream(ksfis);

			char[] keyPwd = CommonPayInfo.BankPayInfo.get("rmbport_keyPass")
					.toCharArray();
			ks.load(ksbufin, keyPwd);
			// 从密钥仓库得到私钥
			PrivateKey priK = (PrivateKey) ks.getKey(
					CommonPayInfo.BankPayInfo.get("rmbport_keyName"), keyPwd);
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initSign(priK);
			signature.update(signMsg.getBytes("UTF-8"));
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			base64 = encoder.encode(signature.sign());
		} catch (FileNotFoundException e) {
			log.error("快钱支付加密字符串无法找到证书文件......");
		} catch (Exception ex) {
			log.error("快钱支付加密字符串异常......");
			ex.printStackTrace();
		}
		return base64;
	}

	/**
	 * 校验回调数据
	 * 
	 * @param val
	 * @param msg
	 * @return
	 */
	protected static boolean enCodeByCer(String val, String msg) {
		boolean flag = false;
		try {
			// 获得公钥文件(绝对路径)
			FileInputStream inStream = new FileInputStream(CommonPayInfo.BankPayInfo.get("rmbport_cerPath"));

			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
			
			PublicKey pk = cert.getPublicKey();
			
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initVerify(pk);
			signature.update(val.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			String encodeStr = encoder.encode(val.getBytes());
			System.out.println(encodeStr);
			// 解码
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			flag = signature.verify(decoder.decodeBuffer(msg));
		} catch (Exception e) {
			log.error("快钱支付回调验证签名异常......", e.fillInStackTrace());
			e.printStackTrace();
		}
		return flag;
	}
}

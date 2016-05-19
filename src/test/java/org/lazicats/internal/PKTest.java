package org.lazicats.internal;
import java.io.FileInputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.lazicats.ecos.internal.common.CommonPayInfo;

import sun.misc.BASE64Encoder;
import sun.security.tools.KeyStoreUtil;

public class PKTest {
  public static void main(String args[]) throws Exception {
    /*Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    KeyPair keyPair = generateKeyPair(999);

    byte[] data = "hello".getBytes();
    byte[] digitalSignature = signData(data, keyPair.getPrivate());

    boolean verified;

    verified = verifySig(data, keyPair.getPublic(), digitalSignature);
    System.out.println(verified) ;

    keyPair = generateKeyPair(888);
    verified = verifySig(data, keyPair.getPublic(), digitalSignature);
    System.out.println(verified);
    */
    
    /**
     * 
     */
   
    String test = "merchantAcctId=1002163801001&version=v2.0&language=1&signType=4&payType=10&bankId=CIB&orderId=1434202166633085813&orderTime=20150613215230&orderAmount=399900&dealId=1920957615&bankDealId=150613135941&dealTime=20150613215402&payAmount=399900&fee=2399&payResult=10";
	// 获得公钥文件(绝对路径)
	FileInputStream inStream = new FileInputStream("D:\\test\\secu\\keystore.jks");

	 KeyStore ks = KeyStore.getInstance("JKS", "SUN");
	 ks.load(inStream,"password".toCharArray());
	    
	 PrivateKey prk = (PrivateKey) ks.getKey("server","password".toCharArray());
	 Signature signer = Signature.getInstance("SHA1withRSA");
	 signer.initSign(prk);
	 signer.update(test.getBytes());
	 byte[] sgb = signer.sign(); 
	
	 FileInputStream cer = new FileInputStream("D:\\test\\secu\\server.cer");
	CertificateFactory cf = CertificateFactory.getInstance("X.509");
	X509Certificate cert = (X509Certificate) cf.generateCertificate(cer);
	
	
	PublicKey pk = cert.getPublicKey();
	
	Signature signature = Signature.getInstance("SHA1withRSA");
	signature.initVerify(pk);
	signature.update(test.getBytes());
	
	BASE64Encoder encoder = new BASE64Encoder();
	String encodeStr = encoder.encode(sgb);
	System.out.println(encodeStr);
	// 解码
	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	boolean flag = signature.verify(decoder.decodeBuffer(encodeStr));
	System.out.println(flag);

  }

  public static byte[] signData(byte[] data, PrivateKey key) throws Exception {
    Signature signer = Signature.getInstance("SHA1withDSA");
    signer.initSign(key);
    signer.update(data);
    return (signer.sign());
  }

  public static boolean verifySig(byte[] data, PublicKey key, byte[] sig) throws Exception {
    Signature signer = Signature.getInstance("SHA1withDSA");
    signer.initVerify(key);
    signer.update(data);
    return (signer.verify(sig));

  }

  public static KeyPair generateKeyPair(long seed) throws Exception {
    //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("DSA");
    SecureRandom rng = SecureRandom.getInstance("SHA1PRNG", "SUN");
    rng.setSeed(seed);
    keyGenerator.initialize(1024, rng);

    return (keyGenerator.generateKeyPair());
  }
}
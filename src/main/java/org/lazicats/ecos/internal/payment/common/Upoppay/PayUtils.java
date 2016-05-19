package org.lazicats.ecos.internal.payment.common.Upoppay;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.ListIterator;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

/**
 * 名称：支付工具类 功能：工具类，可以生成付款表单等 类属性：公共类 版本：1.0 日期：2012-10-23 作者：银联网络互联网团队 版权：银联网络
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。该代码仅供参考。
 * */
public class PayUtils {

  public static final String GBK = "GBK";
  public static final String GB2312 = "GB2312";
  public static final String UTF_8 = "UTF-8";
  public static final String ISO_8859_1 = "ISO-8859-1";

  private static final Logger LOGGER = Logger.getLogger(PayUtils.class);

  public static String convertUTF2GBK(String content, String encoding) {

    byte[] srcByte = null;
    try {
      srcByte = content.getBytes(UTF_8);
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    StringBuffer str = new StringBuffer();
    int len = srcByte.length;
    int char1, char2, char3;
    int count = 0;
    while (count < len) {
      char1 = (int) srcByte[count] & 0xff;
      switch (char1 >> 4) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
          count++;
          str.append((char) char1);
          break;
        case 12:
        case 13:
          count += 2;
          if (count > len) {
            break;
          }
          char2 = (int) srcByte[count - 1];
          if ((char2 & 0xC0) != 0x80) {
            break;
          }
          str.append((char) (((char1 & 0x1F) << 6) | (char2 & 0x3F)));
          break;
        case 14:

          count += 3;
          if (count > len) {
            LOGGER.info("wrong");
          }
          char2 = (int) srcByte[count - 2];
          char3 = (int) srcByte[count - 1];
          if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80)) {
            break;
          }
          str.append((char) (((char1 & 0x0F) << 12) | ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0)));
          break;
        default:
          break;
      }
    }

    String temps = null;
    try {
      temps = new String(str.toString().getBytes(GBK), GBK);
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return temps;
  }

  
  public static boolean verifyMsg(String msg, String key, String signature) throws UnsupportedEncodingException {
    if (msg == null || signature == null || key == null)return false;
    
    String signatureRecalcuated = sign(msg, key);
    
    if(LOGGER.isDebugEnabled()){
      LOGGER.debug("sourceMsg=" + msg);
      LOGGER.debug("strSigned=" + signatureRecalcuated);
      LOGGER.debug("signature=" + signature);
    }
    
    if (signature.equals(signatureRecalcuated)) {
      return true;
    } else {
      return false;
    }

  }
  
  private static String sign(String msg, String key) throws UnsupportedEncodingException {
    String keyMd5HexStr = getMd5HexStrOfByteArray(key.getBytes(GBK));
    String str2Sign = msg + keyMd5HexStr;
    String strSigned = getMd5HexStrOfByteArray(str2Sign.getBytes(GBK));
    return strSigned;
  }

  public static String getMd5HexStrOfByteArray(byte[] arr) {
    if (arr == null) {
      return null;
    }

    MessageDigest messageDigest = null;

    try {
      messageDigest = MessageDigest.getInstance(PayConf.signType);
      messageDigest.reset();
      messageDigest.update(arr);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    byte[] byteArray = messageDigest.digest();

    StringBuffer md5StrBuff = new StringBuffer();

    for (int i = 0; i < byteArray.length; i++) {
      if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
        md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
      else
        md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
    }

    return md5StrBuff.toString();
  }

  /**
   * get the md5 hash of a string
   * 
   * @param str
   * @return
   */
  public static String md5(String str) {
    return getMd5HexStrOfByteArray(str.getBytes());
  }

  // Clean up resources
  public void destroy() {}

  /**
   * 查询方法
   * 
   * @param strURL
   * @param req
   * @return
   */
  public String doPostQueryCmd(String strURL, String req) {
    String result = null;
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    try {
      URL url = new URL(strURL);
      URLConnection con = url.openConnection();
      con.setUseCaches(false);
      con.setDoInput(true);
      con.setDoOutput(true);
      out = new BufferedOutputStream(con.getOutputStream());
      LOGGER.info("Request:==" + req);
      byte outBuf[] = req.getBytes(PayConf.charset);
      out.write(outBuf);
      out.close();
      in = new BufferedInputStream(con.getInputStream());
      result = ReadByteStream(in);
    } catch (Exception ex) {
      System.out.print(ex);
      return "";
    } finally {
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
        }
      }
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
        }
      }
    }
    if (result == null)
      return "";
    else
      return result;
  }

  private static String ReadByteStream(BufferedInputStream in) throws IOException {
    LinkedList<Mybuf> bufList = new LinkedList<Mybuf>();
    int size = 0;
    byte buf[];
    do {
      buf = new byte[128];
      int num = in.read(buf);
      if (num == -1)
        break;
      size += num;
      bufList.add(new Mybuf(buf, num));
    } while (true);
    buf = new byte[size];
    int pos = 0;
    for (ListIterator<Mybuf> p = bufList.listIterator(); p.hasNext();) {
      Mybuf b = p.next();
      for (int i = 0; i < b.size;) {
        buf[pos] = b.buf[i];
        i++;
        pos++;
      }

    }

    return new String(buf, PayConf.charset);
  }

  public static void main(String[] aaa) throws UnsupportedEncodingException {
    String a =
        "acqCode=27630276&backEndUrl=http://127.0.0.1:8080/easypay2/cupSecureUpopBackEndStatus.do&charset=UTF-8&commodityDiscount=&commodityName=&commodityQuantity=&commodityUnitPrice=&commodityUrl=&customerIp=192.168.0.116&customerName=&defaultBankNumber=&defaultPayType=&frontEndUrl=http://127.0.0.1:8080/easypay2/cupSecureUpopFrontEndStatus.do&merAbbr=SAW&merCode=7399&merId=763027645119001&merReserved=&orderAmount=100&orderCurrency=156&orderNumber=kim20110523010&orderTime=20110523113458&origQid=&transTimeout=120000&transType=01&transferFee=&version=1.0.0&8ddcff3a80f4189ca1c9d4d902c3c909";
    String str = new String("韦明剑".getBytes("ISO-8859-1"), "GBK");

    try {
      byte[] bs = str.getBytes("gbk");
      for (int i = 0; i < bs.length; i++) {
        LOGGER.info(bs[i]);
      }

    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.print(new PayUtils().md5(a));
  }

}


class UTF8PostMethod extends PostMethod {
  public UTF8PostMethod(String url) {
    super(url);
  }

  @Override
  public String getRequestCharSet() {
    return "UTF-8";
  }
}


class GBKPostMethod extends PostMethod {
  public GBKPostMethod(String url) {
    super(url);
  }

  @Override
  public String getRequestCharSet() {
    return "GBK";
  }
}


class Mybuf {

  public byte buf[];
  public int size;

  public Mybuf(byte b[], int s) {
    buf = b;
    size = s;
  }
}

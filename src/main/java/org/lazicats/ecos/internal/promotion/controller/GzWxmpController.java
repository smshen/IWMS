package org.lazicats.ecos.internal.promotion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.commons.httpclient.util.URIUtil;
import org.lazicats.ecos.basecomponent.utils.RandomUtils;
import org.lazicats.ecos.internal.promotion.component.IGzWxmpComponent;
import org.lazicats.ecos.internal.promotion.db.CouponDao;
import org.lazicats.ecos.internal.utils.PostHttp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 广州移动微信运营管理平台调用入口类 - 通过目标号码查找是否已经在广州移动微信运营管理平台进行微信openid与目标号绑定
 * 
 * api.gbhui.com/GzWxmp/isbound
 * 
 * @author Jay
 *
 */
@Controller
@RequestMapping("/GzWxmp")
public class GzWxmpController {
  @Resource
  IGzWxmpComponent gzWxmpServComponent;

  @Resource
  CouponDao couponDao;

  @RequestMapping("/isbound")
  public void getBindFlag(String mobile, HttpServletResponse resp, HttpServletRequest req) {

    try {
      resp.addHeader("Access-Control-Allow-Origin", "*");
      PrintWriter writer = resp.getWriter();

      if (couponDao.exist(mobile)) {
        writer.write(couponDao.getExistCoupon(mobile));
      } else {

        long start = System.currentTimeMillis();
        String resl = "" + gzWxmpServComponent.getBindFlag(mobile).charAt(0);
        System.out.println("time taken: " + (System.currentTimeMillis() - start));
        String couponNo = "";

        if ("1".equals(resl)) {// 如果该号码为移动微信会员，则生成卷码
          couponNo = RandomUtils.getRandomNumberStr(16);
          couponDao.saveCoupon(mobile, couponNo);
        }

        writer.write(couponNo);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ServiceException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @RequestMapping("/suggestions")
  public void suggestions(String query,HttpServletResponse resp, HttpServletRequest req) {
    try {
      resp.addHeader("Access-Control-Allow-Origin", "*");
      resp.setContentType("application/json;charset=utf-8");
      PrintWriter writer = resp.getWriter();
      String result = httpGet(URIUtil.encodeAll(query));
      writer.write(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String httpGet(String query) {
    String url = "http://192.168.168.7:8080/ecos_solr/suggest";
    String queryJsonFormat = "q="+query+"&wt=json";
    String result = PostHttp.doHttpGet(url, queryJsonFormat);
    return result;
  }

  @RequestMapping("/timeoutCoupon")
  public void getSession(String mobile, String coupon, HttpServletResponse resp,
      HttpServletRequest req) {
    try {


      
      resp.setHeader("Access-Control-Allow-Origin", "*");
      
      PrintWriter writer = resp.getWriter();
      String resl = "false";
      if (couponDao.exist(mobile)) {
        resl = couponDao.getExistCoupon(mobile);
      } else {
        couponDao.saveCoupon(mobile, coupon);   
        resl = "true";
      }
      writer.write(resl);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @RequestMapping("/couponCount")
  public void getCouponCount(HttpServletResponse resp, HttpServletRequest req) {
    try {
      resp.addHeader("Access-Control-Allow-Origin", "*");
      PrintWriter writer = resp.getWriter();
      int couponCount = couponDao.getCouponCount();
      writer.write(String.valueOf(couponCount));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

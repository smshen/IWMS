package org.lazicats.ecos.internal.promotion.controller;

import javax.servlet.http.HttpServletRequest;

import org.lazicats.ecos.internal.promotion.common.Sign;
import org.lazicats.ecos.internal.promotion.common.WxConfigure;
import org.lazicats.ecos.internal.promotion.common.WxJsApiClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Jay
 *
 */
@Controller
@RequestMapping("WxApi")
public class WxApiController {
 
  @RequestMapping("test")
  public String testPropUsedInJs(String serverId,ModelMap map,HttpServletRequest req)
  
      throws Exception {
    map.put("serverId",serverId);
    map.put("appId", WxConfigure.appid);
    
    String queryString = req.getQueryString();
    String requestURI = req.getRequestURL().toString()+(queryString==null?"":"?"+queryString);
    
    map.putAll(Sign.sign(WxJsApiClient.getJsApiTicket(), requestURI));
    return "test";
  }

  

}

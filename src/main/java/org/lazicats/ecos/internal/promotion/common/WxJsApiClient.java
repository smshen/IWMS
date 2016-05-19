package org.lazicats.ecos.internal.promotion.common;

public class WxJsApiClient {
  
  public static String getJsApiTicket() throws Exception {
    String urll =
        "https://api.weixin.qq.com/cgi-bin/ticket/getticket?" + "type=jsapi&" + "access_token="
            + WxBaseApiClient.getAccessToken();
    String inputLine = HttpUtils.httpGetLine(urll);

    return MyJsonUtils.getFromJson(inputLine, "ticket");
  }

}

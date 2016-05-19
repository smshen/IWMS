package org.lazicats.ecos.internal.promotion.common;

public class WxBaseApiClient {

  
  public static String getAccessToken() {
    String url =
        "https://api.weixin.qq.com/cgi-bin/token?" + "grant_type=client_credential&" + "appid="
            + WxConfigure.appid + "&" + "secret=" + WxConfigure.appSecret;

    return MyJsonUtils.getFromJson(HttpUtils.httpGetLine(url), "access_token");
  }

}

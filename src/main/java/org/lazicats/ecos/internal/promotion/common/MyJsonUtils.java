package org.lazicats.ecos.internal.promotion.common;

import java.util.Map;

import org.lazicats.ecos.basecomponent.utils.JsonUtils;

public class MyJsonUtils {
  

  public static String getFromJson(String inputLine, String key) {
    Map<String, String> mp = JsonUtils.fromJson(inputLine, Map.class);
    return mp.get(key);
  }

}

package org.lazicats.ecos.internal.promotion.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
  
  public static String httpGetLine(String urll) {
    String inputLine = null;
    try {
      URL url = new URL(urll);
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      inputLine = in.readLine().toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return inputLine;
  }
}

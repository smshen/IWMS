package org.lazicats.ecos.internal.promotion.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.io.Files;

/**
 *京东到家令牌管理
 */
@Controller
@RequestMapping("/jdtoken")
public class JdTokenController {
  private final String tokenFilePath = "/usr/local/token/token";
  
  /**
   * 接收令牌,保存到本地文件。
   * @param token
   * @throws IOException
   */
  @RequestMapping("/token")
  public void receiveToken(String token) throws IOException {
     
     File tokenfilePath = new File(tokenFilePath + System.currentTimeMillis() + ".json");
     Files.write(token.getBytes(), tokenfilePath);
  }

}

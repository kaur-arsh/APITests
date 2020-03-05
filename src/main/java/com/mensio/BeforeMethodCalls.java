// This class is being used to generate cookie
package com.mensio;

import org.testng.annotations.Test;
import com.mensio.Login.LoginTest;
import com.model.LoginInfo;

public class BeforeMethodCalls {

  @Test
  public static String getCookie() {
    String cookie = LoginInfo.getCookie();
    if (cookie == null) {
      LoginTest.login();
    }
    return LoginInfo.getCookie();
  }

}

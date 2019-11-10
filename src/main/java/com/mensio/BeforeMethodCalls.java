// This class is being used to generate cookie
package com.mensio;

import org.testng.annotations.Test;
import com.model.LoginInfo;

public class BeforeMethodCalls {

  @Test
  public static String getCookie() {
    return LoginInfo.getCookie();
  }

}

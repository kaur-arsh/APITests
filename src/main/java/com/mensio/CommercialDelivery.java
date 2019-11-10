package com.mensio;

import com.constants.Constants;
import io.restassured.RestAssured;

public class CommercialDelivery {


  public void overallDeliveryTrends() {
    System.out.println("### Running Commercial Delivery Test ###");
    RestAssured.baseURI = Constants.devBase;
    String cookie = BeforeMethodCalls.getCookie();
    System.out.println("Commercial Delivery Login Cookie is = " + cookie);

  }

}

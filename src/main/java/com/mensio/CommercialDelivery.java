package com.mensio;

import com.constants.Constants;

import io.restassured.RestAssured;

public class CommercialDelivery {


  public void overallDeliveryTrends() {
    System.out.println("### Running Commercial Delivery Test ###");
    RestAssured.baseURI = Constants.devBase;
    String cookie = BeforeMethodCalls.getCookie();
    System.out.println("Commercial Delivery Login Cookie is = " + cookie);

    RestAssured.given()
        .when()
        .body({
            "brands": [
    "google_all",
        "apple_all"
    ],
    "start": "2020-01-01",
        "end": "2020-01-05",
        "audiences": [
    "national_population"
    ],
    "metrics": [
    "airings"
    ],
    "creative_groups": [],
    "segmentations": [
    "brands",
        "dates"
    ],
    "obj_type": "commercials"
})

  }

}

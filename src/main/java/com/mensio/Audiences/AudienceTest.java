package com.mensio.Audiences;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.mensio.BeforeMethodCalls;
import com.mensio.Audiences.response.AudienceResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AudienceTest {

  @Test
  public static void fetchAudiences() {
    String cookie = BeforeMethodCalls.getCookie();
    RestAssured.baseURI = Constants.devBase;

    Response res;
    res = given().header("content-type", "application/json").header("Cookie", "nomnom=" + cookie)
        .log().all().when().get(Constants.devBase + Constants.getAudiences).then().assertThat()
        .statusCode(HttpStatus.SC_OK).extract().response();

    AudienceResponse audienceResponse = res.as(AudienceResponse.class);
    Assert.assertNotNull(audienceResponse);

    //List<AudienceData> audienceDataList = audienceResponse.getAudiences();
    //while(audienceDataList =  )
        
    }
}


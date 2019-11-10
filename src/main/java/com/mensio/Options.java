package com.mensio;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Options {

  @Test
  public void getSegmentations() {
    RestAssured.baseURI = Constants.STAGING_BASE;
    String cookie = BeforeMethodCalls.getCookie();
    Response res;
    res = given().header("content-type", "application/json").header("Cookie", "nomnom=" + cookie)
        .log().all().when().get(Constants.STAGING_BASE + Constants.segmentations).then()
        .assertThat().statusCode(200).and().body("options[0].id", equalTo("brands")).extract()
        .response();
    ResponseBody body = res.getBody();
  }

  @Test
  public void getSegmentationsUnauthorized() {
    RestAssured.baseURI = Constants.STAGING_BASE;
    Response res = given().header("content-type", "application/json").header("Cookie", "nomnom=")
        .log().all().when().get(Constants.STAGING_BASE + Constants.segmentations).thenReturn();

    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, res.getStatusCode());

    ResponseBody resBody = res.getBody();
    Assert.assertNotNull(resBody);
    // Assert.assertEquals(Segmentation.BRANDS.value(), resBody);
    // .then().assertThat()
    // .statusCode(HttpStatus.SC_UNAUTHORIZED).and().body("options[0].id", equalTo("brands"))
    // .extract().response();
  }

  @Test
  public void getVerticals() {
    RestAssured.baseURI = Constants.STAGING_BASE;
    String cookie = BeforeMethodCalls.getCookie();
    Response res;
    res = given().header("content-type", "application/json").header("Cookie", "nomnom=" + cookie)
        .log().all().when().get(Constants.STAGING_BASE + Constants.verticals).then().assertThat()
        .statusCode(200).and().body("options[1].id", equalTo("retail")).extract().response();

  }

  @Test
  public void getMetrics() {
    RestAssured.baseURI = Constants.STAGING_BASE;
    String cookie = BeforeMethodCalls.getCookie();
    Response res;
    res = given().header("content-type", "application/json").header("Cookie", "nomnom=" + cookie)
        .log().all().when().get(Constants.STAGING_BASE + Constants.metrics).then().assertThat()
        .statusCode(200).and().body("options[22].id", equalTo("lift")).extract().response();



  }
}

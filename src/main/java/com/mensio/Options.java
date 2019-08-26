package com.mensio;

import com.model.LoginInfo;
import com.utils.Constants;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Options {

    @BeforeTest

    public String getCookie() {
        LoginInfo userLoginInfo = new LoginInfo();
        String cookie = userLoginInfo.getCookie();
        return cookie;
    }

    @Test
    public void getSegmentations() {
        RestAssured.baseURI = Constants.stagingBase;
        String cookie = getCookie();
        Response res;
        res = given().header("content-type", "application/json")
                .header("Cookie", "nomnom=" + cookie).log().all()
                .when()
                .get(Constants.stagingBase + Constants.segmentations)
                .then()
                .assertThat().statusCode(200).and().body("options[0].id", equalTo("brands")).extract().response();

    }

    @Test
    public void getVerticals() {
        RestAssured.baseURI = Constants.stagingBase;
        String cookie = getCookie();
        Response res;
        res = given().header("content-type", "application/json")
                .header("Cookie", "nomnom=" + cookie).log().all()
                .when()
                .get(Constants.stagingBase + Constants.verticals)
                .then()
                .assertThat().statusCode(200).and().body("options[1].id", equalTo("retail")).extract().response();

    }

    @Test
    public void getMetrics() {
        RestAssured.baseURI = Constants.stagingBase;
        String cookie = getCookie();
        Response res;
        res = given().header("content-type", "application/json")
                .header("Cookie", "nomnom=" + cookie).log().all()
                .when()
                .get(Constants.stagingBase + Constants.metrics)
                .then()
                .assertThat().statusCode(200).and().body("options[21].id", equalTo("lift")).extract().response();


    }
}
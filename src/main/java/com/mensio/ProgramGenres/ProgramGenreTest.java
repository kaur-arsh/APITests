package com.mensio.ProgramGenres;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.mensio.BeforeMethodCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ProgramGenreTest extends Constants {

    @Test
    public static void fetchProgramGenres(){

        String cookie = BeforeMethodCalls.getCookie();
        RestAssured.baseURI = Constants.devBase;

        Response res;
        res = given().header("content-type", "application/json").header("Cookie", "nomnom=" + cookie)
            .log().all().when().get(Constants.devBase + Constants.programGenres).then().assertThat()
            .statusCode(HttpStatus.SC_OK).extract().response();
        res.prettyPrint();

    }
}

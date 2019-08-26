package com.mensio;
import com.model.LoginInfo;
import com.utils.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//import jdk.jfr.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Login extends Constants {

    public static void main (String args[])
    {
//        System.out.println("Login Cookie is = " + login());
    }

    public static String loginData;

    @Test
    public  static void login() {
        System.out.println("### Running Login ###");

        RestAssured.baseURI = Constants.stagingBase;

        JSONObject loginBody = new JSONObject();
        loginBody.put("email", "arshdeep+q1@thehive.ai");
        loginBody.put("password", "Hive1234");
        loginBody.put("remember_me", true);

        String loginRequestBody = loginBody.toString();
        System.out.println(loginRequestBody);

        Response res=given().
                header("content-type", "application/json").
                body(loginRequestBody).log().all().
                when().post(Constants.loginURL).
                then().assertThat().statusCode(202).extract().response();
        loginData=res.asString();
        String cookie= res.getCookie("NomNom");
        System.out.println("Login Cookie is = " + cookie);
        LoginInfo userLoginInfo = new LoginInfo();
        userLoginInfo.setCookie(cookie);
        return;
    }

}

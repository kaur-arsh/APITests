package com.mensio.Login;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.constants.Constants;
import com.enums.LoginType;
import com.mensio.Login.request.LoginRequest;
import com.mensio.Login.response.LoginFailure;
import com.mensio.Login.response.LoginResponse;
import com.model.LoginInfo;
import com.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

// import jdk.jfr.ContentType;


// Import Request class here
public class LoginTest extends Constants {

  public static String loginData;

  public static void main(String[] args) {
    // System.out.println("Login Cookie is = " + login());
  }

  @Test
  public static void login() {
    System.out.println("### Running Login ###");

    RestAssured.baseURI = Constants.devBase;

    LoginRequest loginRequest = new LoginRequest().setEmail(USER_LOGIN_CREDENTIALS.EMAIL)
        .setPassword(USER_LOGIN_CREDENTIALS.PASSWORD).setRememberMe(true);

    String loginRequestBody = Utils.toJsonString(loginRequest);
    System.out.println(loginRequestBody);

    Response res = given().header("content-type", "application/json").body(loginRequestBody).log()
        .all().when().post(Constants.LOGIN_URL).then().assertThat()
        .statusCode(HttpStatus.SC_ACCEPTED).extract().response();

    LoginResponse loginResponse = res.as(LoginResponse.class);
    String cookie = res.getCookie("NomNom");

    Assert.assertNotNull(cookie);
    Assert.assertNotNull(loginResponse);
    Assert.assertNotNull(loginResponse.getUserRecord());
    Assert.assertEquals(LoginType.basic, loginResponse.getUserRecord().getLoginType());

    LoginInfo.setCookie(cookie);
  }

  @Test
  public static void incorrectPassword() {

    RestAssured.baseURI = Constants.devBase;

    // For explanation
    // List<Segmentation> segmentationList = new ArrayList<Segmentation>();
    //
    // segmentationList.add(Segmentation.BRANDS);
    // segmentationList.add(Segmentation.NETWORKS);

    LoginRequest loginRequest = new LoginRequest().setEmail(USER_LOGIN_CREDENTIALS.EMAIL)
        .setPassword("12134324").setRememberMe(true);

    String loginRequestBody = Utils.toJsonString(loginRequest);
    System.out.println(loginRequestBody);

    Response res = given().header("content-type", "application/json").body(loginRequestBody).log()
        .all().when().post(Constants.LOGIN_URL).then().assertThat()
        .statusCode(HttpStatus.SC_UNAUTHORIZED).extract().response();
    LoginFailure loginFailure = res.as(LoginFailure.class);
    // LoginResponse loginResponse = res.as(LoginResponse.class);
    String cookie = res.getCookie("NomNom");

    Assert.assertNull(cookie);
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, loginFailure.getStatus());
  }
}

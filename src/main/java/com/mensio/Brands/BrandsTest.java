package com.mensio.Brands;

import static io.restassured.RestAssured.given;
import java.util.List;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.constants.Constants;
import com.mensio.BeforeMethodCalls;
import com.mensio.Brands.response.BrandData;
import com.mensio.Brands.response.BrandResponse;
import com.mensio.Login.response.LoginFailure;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrandsTest extends Constants {

  // public static void main(String args[]) {}
  // TODO Make every test case run on separate basis without calling login api every time
  // TODO Remove displayBrands once all basics are clear and other test cases are running fine for
  // Brands API
  @Test
  public static void fetchBrands() {
    System.out.println("### Running Brands ###");

    String cookie = BeforeMethodCalls.getCookie();
    RestAssured.baseURI = Constants.devBase;

    Response res;
    res = given().header("content-type", "application/json").header("Cookie", "nomnom=" + cookie)
        .log().all().when().get(Constants.devBase + Constants.brands).then().assertThat()
        .statusCode(HttpStatus.SC_OK).extract().response();

    BrandResponse brandResponse = res.as(BrandResponse.class);
    Assert.assertNotNull(brandResponse);

    List<BrandData> brandDataList = brandResponse.getBrands();
    for (BrandData brand : brandDataList) {
      // System.out.println(brand.getBrandName());
    }
  }

  @Test
  public static void fetchBrandsFailed() {
    RestAssured.baseURI = Constants.devBase;
    String cookie = BeforeMethodCalls.getCookie();
    Response res;
    res = given().header("content-type", "application/json").log().all().when()
        .get(Constants.devBase + Constants.brands).then().assertThat()
        .statusCode(HttpStatus.SC_UNAUTHORIZED).extract().response();
    System.out.println(res.asString());
    LoginFailure loginFailure = res.as(LoginFailure.class);
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, loginFailure.getStatus());
  }


}


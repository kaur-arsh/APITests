package com.mensio;

import com.model.LoginInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.utils.Constants;

public class CommercialDelivery {

    @Test
    public void overallDeliveryTrends() {
        System.out.println("### Running Commercial Delivery Test ###");
        RestAssured.baseURI = Constants.stagingBase;

        LoginInfo userLoginInfo = new LoginInfo();
        String cookie = userLoginInfo.getCookie();
        System.out.println("Commercial Delivery Login Cookie is = " + cookie);
        Response res;
        res = given().header("content-type", "application/json")
                .header("Cookie", "nomnom=" + cookie).queryParam("brands[]", "walmart")
                .queryParam("start", "2019-03-21").queryParam("end", "2019-04-04")
                .queryParam("audiences[]", "national_population")//.queryParam("segmentations[]", "programs")
                .queryParam("segmentations[]", "dates")//.queryParam("segmentations[]", "dayparts")
                .queryParam("segmentations[]", "brands")//.queryParam("metrics[]", "airings")
//				.queryParam("metrics[]", "impressions").queryParam("metrics[]", "avg_impressions")
                .queryParam("metrics[]", "spend").log().all().
                        when().
                        get(Constants.stagingBase + Constants.marketShare).
                        then().
                        assertThat().statusCode(200).and().extract().response();

//        String response= res.asString();
//        JsonPath js= new JsonPath(response);
//        String processedValue= js.getString("processed");
//        System.out.print(processedValue);
//        if(processedValue.equals(false))
//        {
//            assert true;
//        }

        System.out.println("This is overalldeliveryTrend " + res.asString());
    }

}

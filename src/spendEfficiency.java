import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

public class spendEfficiency 
{
	@Test
	public void spendReach()
	{
		System.out.println("### Running Spend Reach Test ###");
		RestAssured.baseURI = Constants.stagingBase;
		Response res =given().
				header("content-type", "application/json").
				header("Cookie","nomnom="+LoginMensio.login()).
				queryParam("audiences[]", "national_population").
				queryParam("brands[]", "Pier 1 Imports").
				queryParam("start", "2019-04-01").
				queryParam("end", "2019-04-07").
				queryParam("segmentations[]", "networks").
				queryParam("metrics[]", "unique_impressions").
				queryParam("metrics[]", "segmentation_unique_impressions").
				queryParam("metrics[]", "spend").log().all().
				when().get(Constants.spendEfficiency).
				then().and().extract().response();
		 JsonPath js =new JsonPath(res.asString());
	 boolean isTrue = js.get("processed"); 
	assertEquals(isTrue, true);
		//.and().
				//extract().response();
		//System.out.println("This is Spend Reach Data" +res.asString());
	}
	
	
	@Test(priority=1)
	public void spendCPMbyNetwork()
	{
		System.out.println("### Running spendCPMbyNetwork Test ###");
		RestAssured.baseURI = Constants.stagingBase;
		Response res = given().
				header("content-type", "application/json").
				header("Cookie","nomnom="+LoginMensio.login()).
				queryParam("audiences[]", "national_population").
				queryParam("brands[]", "pier_1_imports").
				queryParam("start", "2019-04-01").
				queryParam("end", "2019-04-30").
				queryParam("segmentations[]", "networks").
				queryParam("networks[]", "cbs").
				queryParam("metrics[]", "cpm").
				queryParam("metrics[]", "impressions").
				queryParam("metrics[]", "spend").log().all().
				when().get(Constants.marketShare).
				then().extract().response();
		System.out.println("This is Spend CPM Networks Data" +res.asString());
	}
	
	@Test
	public void spendCPMbyAudience()
	{
		System.out.println("### Running spendCPMbyAudience Test ###");
		RestAssured.baseURI = Constants.stagingBase;
		Response res = given().
				header("content-type", "application/json").
				header("Cookie","nomnom="+LoginMensio.login()).
				queryParam("audiences[]", "national_population").
				queryParam("audiences[]", "married_with_children").
				queryParam("audiences[]", "adult_18_29").
				queryParam("audiences[]", "adult_18_49").
				queryParam("brands[]", "Pier 1 Imports").
				//queryParam("networks[]", "[]").
				queryParam("start", "2019-04-05").
				queryParam("end", "2019-04-17").
				queryParam("metrics[]", "cpm").
				queryParam("metrics[]", "impressions").
				queryParam("metrics[]", "spend").log().all().
				when().get(Constants.marketShare).
				then().extract().response();
		System.out.println("This is Spend CPM Audience Data" +res.asString());
	}
}

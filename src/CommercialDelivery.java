import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class CommercialDelivery {

	@Test
	public void overallDeliveryTrends() {
		System.out.println("### Running Commercial Delivery Test ###");
		RestAssured.baseURI = Constants.stagingBase;
		// String payload =
		// "{\"graph_key\":\"marketShare\",\"custom_color_map\":{},\"visualization_type\":\"stacked_bar_chart\",\"metrics\":[\"impressions\"],\"start\":\"2019-04-01\",\"end\":\"2019-04-30\",\"segmentations\":[\"program_genres\",\"brands\"],\"audiences\":[\"national_population\"],\"show_secondary\":false,\"niches\":[],\"verticals\":[],\"brands\":[],\"networks\":[],\"network_types\":[],\"network_owners\":[],\"program_genres\":[],\"display_name\":\"Market
		// Share by Networks\"}";
		String cookie = LoginMensio.login();
		Response res = given().header("content-type", "application/json")
				.header("Cookie", "nomnom=" + cookie).queryParam("brands[]", "walmart")
				.queryParam("start", "2019-03-21").queryParam("end", "2019-04-04")
				.queryParam("audiences[]", "national_population")//.queryParam("segmentations[]", "programs")
				.queryParam("segmentations[]", "dates")//.queryParam("segmentations[]", "dayparts")
				.queryParam("segmentations[]", "brands")//.queryParam("metrics[]", "airings")
//				.queryParam("metrics[]", "impressions").queryParam("metrics[]", "avg_impressions")
				.queryParam("metrics[]", "spend").log().all().when().get(Constants.stagingBase + Constants.marketShare)
				.then().extract().response();

		System.out.println("This is overalldeliveryTrend " + res.asString());
	}

}

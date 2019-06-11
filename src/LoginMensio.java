import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class LoginMensio {
	
	
	public static String loginData;
	
	public static String login() {
		RestAssured.baseURI = Constants.stagingBase;
		String loginRequestBody = "{\"email\":\"arshdeep@thehive.ai\",\"password\":\"Hive1510\",\"remember_me\":true}";
		System.out.println(loginRequestBody);
		Response res=given().
			header("content-type", "application/json").
			body(loginRequestBody).log().all().
			when().post(Constants.loginURL).
			then().assertThat().statusCode(202).extract().response();
		loginData=res.asString();
		String cookie= res.getCookie("NomNom");
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setCookie(cookie);
		return cookie;
	}
}

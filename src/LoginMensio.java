import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;

public class LoginMensio {
	
	
	public static String loginData;
	
	public static String login() {
		System.out.println("### Running Login ###");
		RestAssured.baseURI = Constants.stagingBase;

		JSONObject loginBody = new JSONObject();
		loginBody.put("email", "arshdeep@thehive.ai");
		loginBody.put("password", "Hive1510");
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
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setCookie(cookie);
		return cookie;
	}
}

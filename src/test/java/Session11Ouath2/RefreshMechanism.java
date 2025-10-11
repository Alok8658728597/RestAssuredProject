package Session11Ouath2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RefreshMechanism{
	private static String bodyContent="{\"username\":\"emilys\",\"password\":\"emilyspass\"}";
	String accessToken;
	String refreshToken;
	@Test(priority=1)
	public void loginAndGetBothTokens() {
		Response response=RestAssured.given()
		.baseUri("https://dummyjson.com")
		.contentType(ContentType.JSON)
		.body(bodyContent)
		.when()
		.post("/auth/login");
		
		accessToken=response.jsonPath().getString("accessToken");
		System.out.println("Old access Token :"+accessToken);
		refreshToken=response.jsonPath().getString("refreshToken");
		//response.then().log().body();
		
	}
	@Test(priority=2,dependsOnMethods="loginAndGetBothTokens")
	public void getAuthUserUsingAboveAccessToken() {
		Response resp=RestAssured.given()
		.baseUri("https://dummyjson.com")
		.accept(ContentType.JSON)
		.header("Authorization","Bearer " +accessToken)
		.when().get("/auth/me");
		resp.then().log().all();
	}
	@Test(priority=3,dependsOnMethods="loginAndGetBothTokens")
	public void getNewAccessTokenUsingRefreshToken() {
		String refreshTokenBody="{\"refreshToken\":\""+refreshToken+"\"}";
		Response response=RestAssured.given()
		.baseUri("https://dummyjson.com")
		.contentType(ContentType.JSON)
		.body(refreshTokenBody)
		.post("/auth/refresh");
		String NewAccessToken=response.jsonPath().getString("accessToken");
		System.out.println("New access token:"+NewAccessToken);
		
	}
	
}
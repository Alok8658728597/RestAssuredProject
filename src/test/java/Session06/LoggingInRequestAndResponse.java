package Session06;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LoggingInRequestAndResponse{
	
	@Test
	public void loggingRequest() {
		RestAssured.baseURI="https://api.restful-api.dev";
		RestAssured
		.given().log().all()
		.contentType("application/json")
		.pathParam("id", 7)
		.get("/objects/{id}");
		
	}
	@Test
	public void loggingSpecificRequest() {
		RestAssured.baseURI="https://api.restful-api.dev";
		RestAssured
		.given().log().headers()
		.contentType("application/json")
		.pathParam("id", 7)
		.get("/objects/{id}");
		
	}
}
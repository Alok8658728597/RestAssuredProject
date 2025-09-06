package Session08Authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class validateBasicAuth {
	@Test
	public void basicAuth() {
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://postman-echo.com");
		reqspec.basePath("/basic-auth");
		
		Response response=reqspec.auth().preemptive().basic("postman", "password").get();
		System.out.println(response.statusCode());
		
	}

}

package Session05;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class validateResponseHeader {
	// https://reqres.in/api/users/2

	@Test
	public void get_ResponseHeader() {
		// Create request specification
		RequestSpecification reqspec = RestAssured.given().baseUri("https://reqres.in").basePath("/api/users/2");

		// Send GET request
		Response response = reqspec.get();

		// ✅ 1. Get single header value
		String contentType = response.getHeader("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8", "Content-Type should match");

		// ✅ 2. Get all headers and print
		Headers allHeaders = response.getHeaders();
		for (Header header : allHeaders) {
			System.out.println(header.getName() + ": " + header.getValue());
		}

		// ✅ 3. Validate headers using Hamcrest matchers
		response.then().statusCode(200).header("Content-Type", equalTo("application/json; charset=utf-8"))
				.header("Server", containsString("cloudflare")).header("Connection", equalTo("keep-alive"));

		// ✅ 4. Validate headers using ValidatableResponse
		ValidatableResponse vres = response.then();
		vres.header("Content-Type", containsString("application/json")).header("Connection", equalTo("keep-alive"))
				.header("Server", notNullValue());

		// ✅ 5. Manual assertion using TestNG
		Assert.assertTrue(response.getHeaders().hasHeaderWithName("Server"), "Server header should be present");
	}

}

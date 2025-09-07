/*I use RequestSpecification when I need to reuse request setup across multiple tests or centralize configuration like headers, base URI, or authentication.
But for simple one-off requests, .given() is sufficient.*/
package Session04;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class validateResponse {
	RequestSpecification requestspec;

	@BeforeClass
	public void setup() {
		requestspec = new RequestSpecBuilder().setBaseUri("https://api.restful-api.dev")
				.setContentType(ContentType.JSON).build();
	}

	@Test()
	public void GetSingleUser() {
		Response response = RestAssured.given().spec(requestspec).when().get("/objects/7");
		int responsecode = response.getStatusCode();
		String responseline = response.getStatusLine();
		String getBody = response.getBody().asString();
		String getYear = response.jsonPath().getString("data.year");
		Assert.assertEquals(getYear, "2019");
		Assert.assertTrue(getBody.contains("Apple MacBook Pro 16"));
		Assert.assertEquals(responsecode, 200, "Valid response code");
		Assert.assertEquals(responseline, "HTTP/1.1 200 OK", "Invalid response line");

	}

	@Test
	public void GetListUsers() {
		Response response = RestAssured.given().spec(requestspec).when().get("/objects");
		int responsecode = response.getStatusCode();
		String responseline = response.getStatusLine();
		Assert.assertEquals(responsecode, 200);
	}

	public void GetSingleUserValidatableResponse() {

		RequestSpecification requestspec = RestAssured.given();
		requestspec.baseUri("https://reqres.in/api/users/2");
		Response response = requestspec.get();
		ValidatableResponse vres = response.then();
		vres.statusCode(200);
		vres.statusLine("HTTP/1.1 200 OK");

	}

}

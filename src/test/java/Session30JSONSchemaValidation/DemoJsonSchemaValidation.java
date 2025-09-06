package Session30JSONSchemaValidation;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class DemoJsonSchemaValidation {
	@Test
	public void test() {
		//https://www.jsonschemavalidator.net/
		//https://restful-booker.herokuapp.com/auth
		String payload="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		RestAssured.given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.relaxedHTTPSValidation()
			.contentType(ContentType.JSON)
			.body(payload)
			.when().post()
			.then()
			.assertThat().statusCode(200)
			.body("token", Matchers.notNullValue())
			.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\ALSWAIN\\Downloads\\Schema.json")));
		
		
	}

}

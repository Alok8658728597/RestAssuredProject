/*
A path parameter is a variable part of the URL used to identify a specific resource.
→ It is embedded directly in the URL path, not after a `?` like query parameters.

🔹 Format:
→ /users/{id}
→ /products/{productId}

🔹 Example URL:
→ https://api.example.com/users/101
*/
package Session07QueryParameter;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidatePathParameter {
	@Test
	public void validatePathParam() {
		RestAssured.baseURI = "https://api.restful-api.dev";
		Response response = RestAssured.given().pathParam("id", 7).when().get("/objects/{id}");

		// Validation below
		response.then().statusCode(200);
		response.then().statusLine("HTTP/1.1 200 OK");
		response.then().time(lessThan(2000L));
		response.then().header("Content-Type", containsString("application/json"));
		String actual = response.jsonPath().getString("data.year");
		Assert.assertEquals(actual, "2019");

	}
}

/*
 * 🔹 4. Content-Type Header Validation → Confirms the response is in JSON
 * format. → Use containsString() instead of direct match to handle extra info
 * like charset. → Example: "application/json; charset=utf-8" → Import: import
 * static org.hamcrest.Matchers.containsString;
 * response.then().header("Content-Type", containsString("application/json"));
 * 
 * 🔹 Why use containsString() instead of direct match? → Direct match like
 * "application/json" may fail if the actual header includes charset. →
 * containsString() allows partial match and avoids false failures.
 */

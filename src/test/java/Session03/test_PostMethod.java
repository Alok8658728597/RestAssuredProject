package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class test_PostMethod {

	@Test
	public void createUser() {

		// ✅ Creating nested JSON using org.json.simple.JSONObject
		// This is useful for building request payloads dynamically

		JSONObject nestedJson = new JSONObject(); 
		nestedJson.put("year", 2019);
		nestedJson.put("price", 1849.99);
		nestedJson.put("CPU model", "Intel Core i9");
		nestedJson.put("Hard disk size", "1 TB");
		
		// ✅ Creating outer JSON and embedding nested JSON
		JSONObject outerJson = new JSONObject();
		outerJson.put("name", "Apple MacBook Pro 16");
		outerJson.put("data", nestedJson);

		// Send POST request
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
		// Converting JSONObject to JSON string
		RestAssured.given().contentType(ContentType.JSON).body(outerJson.toJSONString()).when().post().then()
				.statusCode(200).log().all(); // Logs full response
	}
}

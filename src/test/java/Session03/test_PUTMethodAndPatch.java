package Session03;
/*{
   "name": "Apple MacBook Pro 16",
   "data": {
      "year": 2019,
      "price": 1849.99,
      "CPU model": "Intel Core i9",
      "Hard disk size": "1 TB"
   }
}*/

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/* PUT***
 * Used to update an entire resource.
Replaces the existing data with the new one.
Requires sending the full updated object.
***Patch***
Used to partially update a resource.
Only the fields you send will be updated.
More efficient when you want to change just one or two fields*/
public class test_PUTMethodAndPatch {
	@Test(enabled = false)
	public void test_Put() {
		JSONObject nestedJson = new JSONObject();
		nestedJson.put("year", 2019);
		nestedJson.put("price", 1849.99);
		nestedJson.put("CPU model", "Intel Core i9");
		nestedJson.put("Hard disk size", "1 TB");
		nestedJson.put("color", "silver");

		JSONObject outerJson = new JSONObject();
		outerJson.put("name", "Apple MacBook Pro 16");
		outerJson.put("data", nestedJson);

		RestAssured.baseURI = "https://api.restful-api.dev/objects/ff8081819782e69e0199237e50d96684";
		RestAssured.given().contentType(ContentType.JSON).body(outerJson.toJSONString()).when().put().then()
				.statusCode(200).log().all();
	}

	@Test
	public void test_Patch() {
		JSONObject json = new JSONObject();

		json.put("name", "Alok Proisupdated name");
		// json.put("price", 1990.99);

		RestAssured.baseURI = "https://api.restful-api.dev";
		Response resp = RestAssured.given().contentType(ContentType.JSON).body(json.toJSONString()).when()
				.patch("/objects/ff8081819782e69e01994232c46d73ec");
		int statusCode = resp.getStatusCode();
		String headerName = resp.getHeader("Content-Type");
		String body = resp.body().asString();

		System.out.println("Status Code: " + statusCode);
		System.out.println("Content-Type Header: " + headerName);
		System.out.println("Response Body: " + body);

	}
	/*
	 * Note: This RESTful API development site only allows PATCH requests to modify
	 * the name field. Other fields are restricted and cannot be updated via PATCH.
	 * Please take the id from post request response and userd here
	 */
}

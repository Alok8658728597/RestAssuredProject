package Session06;


import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ValidateQueryParam {
	@Test
	public void validate_QueryParameter() {
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
		Response response = RestAssured.given()
				.queryParam("id", 3)
				.queryParam("id", 5)
				.queryParam("id", 10)
				.when().get();
		// Validations
		response.then().statusCode(200);
		List<String> colors=response.jsonPath().get("data.color");
		//response.then().log().all(); //for debugging purpose we use this
		System.out.println("Get color value from GetJson response:"+colors);
				
	}
}
/*Query parameters are key-value pairs that are appended to the end of a URL to filter,
search, or customize the data returned by the server./
/*To filter data (e.g., by category, date, status)
To paginate results (e.g., page=1, page=2)
To sort or search (e.g., sort=asc, search=Alok)*/

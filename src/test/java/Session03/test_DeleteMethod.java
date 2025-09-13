package Session03;
/*Key Characteristics:

Idempotent: Sending the same DELETE request multiple times should result in the same outcome — the resource is deleted (or already deleted).
Targeted: Usually operates on a specific resource, e.g., DELETE /users/123 deletes the user with ID 123.
No Request Body: Most DELETE requests do not require a body; the resource is identified in the URL.
Response Codes:

200 OK: Resource deleted successfully, with a response body.
204 No Content: Resource deleted successfully, no response body.
404 Not Found: Resource does not exist.
401 Unauthorized or 403 Forbidden: Access denied.*/

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class test_DeleteMethod { 
				@Test
	public void test05() {
		RestAssured.baseURI="https://api.restful-api.dev";
		Response response=RestAssured.given().
		when().delete("/objects/ff8081819782e69e0199237e50d96684");
		response.getStatusCode();
		System.out.println("Post delete message:"+response.body().asPrettyString());
		
	}

}

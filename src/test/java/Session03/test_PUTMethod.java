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

public class test_PUTMethod {
				@Test
	public void test04() {
					JSONObject nestedJson=new JSONObject();
					nestedJson.put("year", 2019);
					nestedJson.put("price", 1849.99);
					nestedJson.put("CPU model", "Intel Core i9");
					nestedJson.put("Hard disk size", "1 TB");
					nestedJson.put("color", "silver");
					
					JSONObject outerJson=new JSONObject();
					outerJson.put("name", "Apple MacBook Pro 16");
					outerJson.put("data", nestedJson);
					
					
					
					
					RestAssured.baseURI="https://api.restful-api.dev/objects/ff8081819782e69e0199237e50d96684";
					RestAssured.given()
					.contentType(ContentType.JSON).body(outerJson.toJSONString()).
					when().put().then().statusCode(200).log().all();			
				}

}

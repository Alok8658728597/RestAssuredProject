package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class test_PUTMethod {
				@Test
	public void test04() {
					JSONObject boystr=new JSONObject();
					boystr.put("name", "Alok");
					boystr.put("job", "Engineer");
					
					
					
					RestAssured.baseURI="https://reqres.in/api/users/853";
					RestAssured.given().header("Content-Type","Application/json").
					contentType(ContentType.JSON).body(boystr.toJSONString()).
					when().put().then().statusCode(200).log().all();			
				}

}

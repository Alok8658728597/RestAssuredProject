package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class test_PostMethod {
				@Test
	public void test03() {
					
					JSONObject boystr=new JSONObject();
					boystr.put("name", "morpheus");
					boystr.put("job", "QA");
					
					
					
					RestAssured.baseURI="https://reqres.in/api/users";
					RestAssured.given().header("Content-Type","Application/json").
					contentType(ContentType.JSON).body(boystr.toJSONString()).
					when().post().then().statusCode(201).log().all();
			
					
				}

}

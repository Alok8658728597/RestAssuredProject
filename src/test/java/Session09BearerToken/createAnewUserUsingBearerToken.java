package Session09BearerToken;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createAnewUserUsingBearerToken {
	@Test
	public void validateBearerToken() {
		//https://gorest.co.in/public/v2/users
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://gorest.co.in");
		reqspec.basePath("/public/v2/users");
		
		//Create an new user in this gorest site
		JSONObject payload=new JSONObject();
		payload.put("name", "AlokSwain");
		payload.put("email", "alokswain716@gmail.com");
		payload.put("gender", "male");
		payload.put("status", "Active");
		
		//pass header and content type with payload
		String authbearertoken="Bearer bb341bce6c78c9ba297b9f5e20137de7a0c09ced47ab1e4e01c91cb091b6acb2";
		reqspec.header("Authorization", authbearertoken).contentType(ContentType.JSON).body(payload.toJSONString());
		
		//Perform post operation after providing above details
		Response result=reqspec.post();
//		Print and validate the response
		System.out.println("Print REsponse body "+result.getBody().toString());
		System.out.println("Print status code "+result.getStatusLine());
		
		Assert.assertEquals(result.getStatusCode(), 201);
		
		
	}

}

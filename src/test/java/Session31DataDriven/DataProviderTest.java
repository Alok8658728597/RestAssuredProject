package Session31DataDriven;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class DataProviderTest{
	@Test(dataProvider="userData",dataProviderClass=DataProviderClass.class)
	public void validate_LoginUsingDataProvider(String username,String password) {
		JSONObject json=new JSONObject();
		json.put("username",username);
		json.put("password", password);
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		.baseUri("https://dummyjson.com")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(json.toString())
		.when()
		.post("/auth/login").then().statusCode(200);
	}
}
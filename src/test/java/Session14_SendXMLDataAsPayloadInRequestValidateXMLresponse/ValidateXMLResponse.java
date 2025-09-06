package Session14_SendXMLDataAsPayloadInRequestValidateXMLresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ValidateXMLResponse {
	@Test
	public void addPet() {
	//https://petstore.swagger.io/v2/pet
	String jsondata="{\r\n"
			+ "  \"id\": 0,\r\n"
			+ "  \"category\": {\r\n"
			+ "    \"id\": 0,\r\n"
			+ "    \"name\": \"string\"\r\n"
			+ "  },\r\n"
			+ "  \"name\": \"doggie\",\r\n"
			+ "  \"photoUrls\": [\r\n"
			+ "    \"string\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \"string\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"available\"\r\n"
			+ "}";
	RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://petstore.swagger.io").basePath("/v2/pet");
		
		//Specify header
		reqspec.header("Content-Type", "application/json");
		reqspec.header("Accept","application/json");
		reqspec.body(jsondata);
		
		//Perform post request
	     Response resp=reqspec.post();
	     
	     resp.prettyPrint();
	     
	    //Assert data 
	     Assert.assertEquals(resp.statusCode(),/*actual status code*/ 200, "check stastus code");
	     
		
	}   
}

package Session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class validateResponse {
	            @Test()
	public void GetSingleUser() {
	        
	         RequestSpecification requestspec=RestAssured.given();
	         requestspec.baseUri("https://reqres.in/api/users/2");
	         Response response=requestspec.get();
	         int responsecode=response.getStatusCode();
	         String responeline=response.getStatusLine();
	         Assert.assertEquals(responsecode, 200,"invalid response code");
	         Assert.assertEquals(responeline, "HTTP/1.1 200 OK","Invalid response line");
	         
	            }
	   public void GetSingleUserValidatableResponse() {
	    	        
	   	     RequestSpecification requestspec=RestAssured.given();
	   	     requestspec.baseUri("https://reqres.in/api/users/2");
	   	     Response response=requestspec.get();
	   	      ValidatableResponse vres=response.then();
	   	          vres.statusCode(200);
	   	          vres.statusLine("HTTP/1.1 200 OK");
	   	      
	   	         
	   	            }            
	            
}


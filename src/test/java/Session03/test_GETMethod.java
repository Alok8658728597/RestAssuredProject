package Session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class test_GETMethod {
		        @Test
	public void test() {
		 Response res=RestAssured.get("https://reqres.in/api/users?page=2");	
		System.out.println("Get Status code"+res.getStatusCode()); 
		System.out.println("Get header"+res.getHeader("Content-Type"));
		System.out.println("Get response body"+res.getBody().asString());
		System.out.println("Get response time"+res.getTime());
		//Validate the status code
		int expected_statuscode=200;
		int Actual_Statuscode=res.getStatusCode();
		Assert.assertEquals(expected_statuscode, Actual_Statuscode);
		        }
		   @Test     
    public void test02() {
    	//given when then
	    RestAssured.baseURI="https://reqres.in/api/users";
	    RestAssured.given().queryParam("page", "2").
	    when().get().
	    then().statusCode(200);
	    
    }

	
		        
}

package Session05;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class validateResponseHeader {
	//https://reqres.in/api/users/2
	             @Test
	public void get_ResponseHeader() {
	       //Make request Specification
	        RequestSpecification reqspec=RestAssured.given();
	        reqspec.baseUri("https://reqres.in");
	        reqspec.basePath("/api/users/2");
	        //Method we want to run
	        Response response=reqspec.get();
//	        Get the single header value
	        String header=response.getHeader("Content-Type");
	       // System.out.println(header);
	        //It will give all the headers 
	        Headers headerlist=response.getHeaders();
//	        for(Header headervalue:headerlist) {
//	        	System.out.println(headervalue.getName()+":"+headervalue.getValue());
//	        }
	        	
	        //Validate the expected response value application/json; charset=utf-8
	        Assert.assertEquals(header, "application/json; charset=utf-8");
	        
	             }
}

package Session29ResponseSpecificationResponseSpecBuilder;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class FindAllBookingIDs {
	ResponseSpecification responseSepc=null;
	@BeforeClass
	public void createResponseSpec() {
		ResponseSpecBuilder responsebuilder=new ResponseSpecBuilder();
		responsebuilder.expectStatusCode(200);
		responsebuilder.expectStatusLine("HTTP/1.1 200 OK");
		responsebuilder.expectContentType(ContentType.JSON);
		responsebuilder.expectResponseTime(Matchers.lessThan(4000L));
		
		responseSepc=responsebuilder.build();
		
	}
	@Test
	public void getAllBookingIds() {
		//Url: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking
		//Specify url:https://restful-booker.herokuapp.com/booking
		//Need to validate statuscode:200 statusline:"HTTP/1.1 200 ok" ContentType=ContentType.JSON Responsetime=5000ms
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking").
				when().get().then().spec(responseSepc).body("size()",Matchers.greaterThan(0));
				 /*statusCode(200).
				 statusLine("HTTP/1.1 200 OK").
				 contentType(ContentType.JSON).
				 time(Matchers.lessThan(3000L));*/
	}
	@Test
	public void getBookingByFirstName() {
		//Url: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking
		//Specify url:https://restful-booker.herokuapp.com/booking
		//Need to validate statuscode:200 statusline:"HTTP/1.1 200 ok" ContentType=ContentType.JSON Responsetime=5000ms
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally").
				when().get().then().spec(responseSepc);
				 /*statusCode(200).
				 statusLine("HTTP/1.1 200 OK").
				 contentType(ContentType.JSON).
				 time(Matchers.lessThan(3000L));*/
	}

}

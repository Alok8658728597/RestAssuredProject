package Session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class test_DeleteMethod { 
				@Test
	public void test05() {
		RestAssured.baseURI="https://reqres.in/api/users/853";
		RestAssured.given().header("Content-Type","Application/json").contentType(ContentType.JSON).
		when().delete().
		then().
		statusCode(204).log().all();
		//add test cases 
	}

}

package Session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class validateREsponseBody {
	@Test
    public void listJsonResponebody() {
		//https://reqres.in/api/users/2
		RequestSpecification reqspec=RestAssured.given();
		//Get Base URI and Path
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("api/users/2");
		//USe get method
		Response response=reqspec.get();
		
		//Get response body
		ResponseBody respbody=response.getBody();
		
		//convert response body into string format
//		String star=respbody.asString();
//		System.out.println(star);
		JsonPath jsonview=respbody.jsonPath();
		String firstname=jsonview.get("data.first_name");
		System.out.println(firstname);
		Assert.assertEquals(firstname, "Janet");
	}
}

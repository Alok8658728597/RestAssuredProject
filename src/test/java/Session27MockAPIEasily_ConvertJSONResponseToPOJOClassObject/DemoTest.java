package Session27MockAPIEasily_ConvertJSONResponseToPOJOClassObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoTest {
	@Test
	public void test2() {
		//https://run.mocky.io/v3/f3af4cba-aa15-475a-841e-38d4e71eeeab
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://run.mocky.io/v3/f3af4cba-aa15-475a-841e-38d4e71eeeab");
		Response response=reqspec.get();
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200,"check the status code");
	}
	//Convert JSON ObjectREsoponse into pojo class object
	@Test
	public void test3() {
		//https://run.mocky.io/v3/f3af4cba-aa15-475a-841e-38d4e71eeeab
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://run.mocky.io/v3/f3af4cba-aa15-475a-841e-38d4e71eeeab");
		EmpPojo empobj=reqspec.get().as(EmpPojo.class);
		System.out.println("--------Print after convert of Json object into emp object");
		System.out.println("Name:"+empobj.getName());
		System.out.println("Age:"+empobj.getAge());
		System.out.println("Salay"+empobj.getSalary());
	}
}

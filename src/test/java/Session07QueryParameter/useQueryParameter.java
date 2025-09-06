package Session07QueryParameter;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class useQueryParameter {
	@Test
	public void validate_UsingQueryParam() {

		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users");
		reqspec.queryParam("page", 2);
		reqspec.queryParam("id", 10);
		Response response=reqspec.get();


		String getbodyinstring=response.getBody().asString();
		System.out.println(getbodyinstring);

		JsonPath jsonbody=response.jsonPath();
		String firstname=jsonbody.get("data.first_name");

		Assert.assertEquals(firstname, "Byron","Mistmatch in actual and expected");
		

	}

}

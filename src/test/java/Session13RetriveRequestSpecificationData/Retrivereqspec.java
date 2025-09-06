package Session13RetriveRequestSpecificationData;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class Retrivereqspec {
	@Test()
	public void validate_Retrivereqspec() {
		//create json data object
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Alok");
		jsondata.put("job", "QA");
		//https://reqres.in/api/users
		RequestSpecification reqspec=RestAssured.given();
		//Provide the base UI and path
		reqspec.baseUri("https://reqres.in").
		basePath("/api/users").
		contentType(ContentType.JSON).body(jsondata.toJSONString());

		//Retrieve request specification details
		QueryableRequestSpecification retrivejson=SpecificationQuerier.query(reqspec);
		String baseuri=retrivejson.getBaseUri();
		String basepath=retrivejson.getBasePath();
		System.out.println(baseuri +",/t"+basepath);

		//Retrieve request body
		String requestbody=retrivejson.getBody();
		System.out.println("Body"+requestbody);

		//Get request Headers
		Headers headers=retrivejson.getHeaders();
		System.out.println("------------REQuest Header_______________");
		for(Header h:headers) {
			System.out.println(h.getName()+":"+h.getValue());
		}





	}
}

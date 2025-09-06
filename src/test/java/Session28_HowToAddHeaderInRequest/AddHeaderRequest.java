package Session28_HowToAddHeaderInRequest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class AddHeaderRequest {
	@Test
	public void addHeaderswithrequest() {
		//using map 
		Map<String,String> requestheader=new HashMap<String,String>();
		requestheader.put("Header1", "Value1");
		requestheader.put("Header2", "Value2");
		
		//Using header class
		Header requestobj=new Header("Header1","Value1");
		RequestSpecification reqspec=RestAssured.given();
		//reqspec.header("Header1","Value1");
		//reqspec.headers(requestheader);
		reqspec.header(requestobj);
		reqspec.log().headers();
		reqspec.baseUri("https://reqres.in/api/users?page=2");
		reqspec.get();
	}

}

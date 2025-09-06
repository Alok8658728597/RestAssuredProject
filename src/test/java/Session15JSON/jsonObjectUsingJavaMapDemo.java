package Session15JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class jsonObjectUsingJavaMapDemo {
	@Test(enabled=false)
	public void createAuthToken() {
		//https://restful-booker.herokuapp.com/apidoc/index.html
		//Create json object using java map
		/*{
    "username" : "admin",
    "password" : "password123"
}*/
		Map<String,String> authToken=new HashMap<String,String>();
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		Response token=RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").
		contentType(ContentType.JSON).body(authToken).post();
		
		token.prettyPrint();
		Assert.assertEquals(token.getStatusCode(),200, "check the status code");
	
	}
	@Test
	public void createUser() {
		/*{
	"Name":"Rohan",
	"Job":"Student",
	"age":12,
	"Salary":10000.00,
	"IsMarried":False,
	"Hobbies":["Music","Game","Dance"],
	"Address":[
	{
	            "Address":"Home",
				"city":"Paradeep"
	},
	{
		"Address":"Office",
				"city":"Bengluru"
	}      
	  
	],
	"TechSkill":{
		"Programming Language":"Java",
		"UI Automation":"Selenium",
		"API Testing":"RestAssured"P
	}
}*/
		HashMap<String,Object> jsonbody=new HashMap<String,Object> ();
		jsonbody.put("Name", "Rohan");
		jsonbody.put("Job", "Student");
		jsonbody.put("age", 12);
		jsonbody.put("Salary", 10000.00);
		jsonbody.put("IsMarried", false);
		ArrayList<String> hobies=new ArrayList<String>();
		hobies.add("Music");
		hobies.add("Dance");
		hobies.add("Game");
		jsonbody.put("Hobbies", hobies);
		HashMap<String,String> techskill=new HashMap<String,String> ();
		techskill.put("Programming Language","Java");
		techskill.put("UI Automation","Selenium");
		techskill.put("API Testing","RestAssured");
		jsonbody.put("TechSkill",techskill );
		
		
		
		
		Response token=RestAssured.given().baseUri("https://reqres.in/api/users").
				contentType(ContentType.JSON).body(jsonbody).post();
				
				token.prettyPrint();
				Assert.assertEquals(token.getStatusCode(),201, "check the status code");
		
	}

}

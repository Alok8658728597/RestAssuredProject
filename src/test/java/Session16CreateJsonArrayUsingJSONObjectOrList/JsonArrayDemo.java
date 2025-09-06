package Session16CreateJsonArrayUsingJSONObjectOrList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonArrayDemo {
	@Test(enabled=false)
	public void createUserusingJsonArray() {
		/*[
{
	"Name":"Rohan",
	"Job":"Student",
	"age":12
},
{
	"Name":"Alok",
	"Job":"Student",
	"age":12
},
{
	"Name":"Nibas",
	"Job":"Student",
	"age":12
}
]*/
		//create JSON object for users
		JSONObject user1=new JSONObject();
		user1.put("Name", "ALok");
		user1.put("Job", "QA");
		user1.put("age", 15);
		
		JSONObject user2=new JSONObject();
		user2.put("Name", "Rohan");
		user2.put("Job", "Student");
		user2.put("age", 20);
		
		JSONObject user3=new JSONObject();
		user3.put("Name", "Asw");
		user3.put("Job", "DA");
		user3.put("age", 20);
		
		//Add json object to json array
		JSONArray userpayload=new JSONArray();
		userpayload.add(user1);
		userpayload.add(user2);
		userpayload.add(user3);
		
		
		Response response=RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).
		body(userpayload).post();
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 201,"Check the status code");
		
	}
	@Test
	public void createJsonArrayUSingList() {
		/*[
{
	"Name":"Rohan",
	"Job":"Student",
	"age":12
},
{
	"Name":"Alok",
	"Job":"Student",
	"age":12
},
{
	"Name":"Nibas",
	"Job":"Student",
	"age":12
}
]*/
		//create JSON object for users
		Map<String,Object> user1=new HashMap<String,Object>();
		user1.put("Name", "ALok");
		user1.put("Job", "QA");
		user1.put("age", 15);
		
		Map<String,Object> user2=new HashMap<String,Object>();
		user2.put("Name", "Rohan");
		user2.put("Job", "Student");
		user2.put("age", 20);
		
		Map<String,Object> user3=new HashMap<String,Object>();
		user3.put("Name", "Asw");
		user3.put("Job", "DA");
		user3.put("age", 20);
		
		//Add json object to json array
		//JSONArray userpayload=new JSONArray();
		//create json array using list
		List jsonPayload=new ArrayList();
		jsonPayload.add(user1);
		jsonPayload.add(user2);
		jsonPayload.add(user3);
		
		
		Response response=RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).
		body(jsonPayload).post();
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 201,"Check the status code");
		
	}

}

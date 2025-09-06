package Session17CreateJsonObjectUsingJacksonAPI;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import groovyjarjarantlr4.v4.runtime.misc.FlexibleHashMap.Entry;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjectUSingJacksonapi {
	@Test
	public void createUser() {
		/*{
	"Name":"Rohan",
	"Job":"Student",
	"age":12,
	"Salary":10000.00,
	"IsMarried":False,
	"TechSkill":{
		"Programming Language":"Java",
		"UI Automation":"Selenium",
		"API Testing":"RestAssured"P
	}
}*/

		ObjectMapper objectmapper=new ObjectMapper();
		//Create JSON object node
		ObjectNode userdetails=objectmapper.createObjectNode();
		userdetails.put("Name", "Rohan");
		userdetails.put("lastName", "Das");
		userdetails.put("Job", "QA");
		userdetails.put("Salary", 10000.00);
		userdetails.put("IsMarried", false);
		//Add an array for Hobbies
		userdetails.putArray("Hobbies").add("Cooking").add("Sleep").add("singing");

		//Create another node for techskill(Nested Object)
		ObjectNode techskill=objectmapper.createObjectNode();
		techskill.put("Programming Language", "Java");
		techskill.put("UIAutomation", "Selenium");
		techskill.put("API Testing", "RestAssured");
		//Add the tech skill node into usernode
		userdetails.set("TechSkills", techskill);

		//Convert userdetails to String
		String userdetialsiwthstring;
		try {
			userdetialsiwthstring = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);
			System.out.println("Created Json Node IS:"+userdetialsiwthstring);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//Retrieve a field value from Json Object	
		double salary=userdetails.get("Salary").asDouble();
		System.out.println(salary);
		Boolean marriestatus=userdetails.get("IsMarried").asBoolean(); 
		System.out.println(marriestatus);

		//Retrieve filed value for nested object(webautomation)
		String uiautomationvalue=userdetails.get("TechSkills").get("UIAutomation").asText();
		System.out.println("Value of UI Automation: "  +uiautomationvalue);

		//Retrieve all files and values from Json node
		System.out.println("\n.............Print all fields name.............\n");
		java.util.Iterator<String> fieldnameIterator=userdetails.fieldNames();
		while(fieldnameIterator.hasNext()){
			System.out.println(fieldnameIterator.next());

		}
		System.out.println("\n.............Print all Values name.............\n");
		java.util.Iterator<JsonNode> fieldvaluesIterator=userdetails.elements();
		while(fieldvaluesIterator.hasNext()){
			System.out.println(fieldvaluesIterator.next());

		}
		System.out.println("\n.............Print Field and Values both.............\n");
		java.util.Iterator<java.util.Map.Entry<String, JsonNode>> fieldvalues=userdetails.fields();
		while(fieldvalues.hasNext()){
			java.util.Map.Entry<String, JsonNode> entry=fieldvalues.next();
			System.out.println("Get Key"+entry.getKey()+"GetValues"+entry.getValue());
			//System.out.println(fieldvalues.);

		}
		//Remove field from Json Object Node(Name)
		String removedvalue=userdetails.remove("Name").asText();
		System.out.println(removedvalue);

		//Update a field from Json Object
		//Lastname
		userdetails.put("lastName", "Swain");
		techskill.put("Programming Language", "Python");
		userdetails.set("TechSkills", techskill);
		

		try {
			userdetialsiwthstring = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);
			System.out.println("After remove Name and update lastname from Json Node IS:"+userdetialsiwthstring);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		Response response=RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).
				body(userdetails).post();
		System.out.println("n/------Printing Response--------------/n");
				response.prettyPrint();
				
				Assert.assertEquals(response.getStatusCode(), 201,"Check the status code");
	}
	
	}











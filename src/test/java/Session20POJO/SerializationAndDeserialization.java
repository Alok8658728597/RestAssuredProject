package Session20POJO;
import Session20POJO.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationAndDeserialization {
	@Test
	public void createJsonObjectFromEmployeeObject() throws JsonProcessingException {
		Employee emp1=new Employee();
		emp1.setName("ALok");
		emp1.setAge(11);
		emp1.setJob("QA");
		emp1.setSalary(10000);
		
		//Convert Employee class objet to json object payload
		ObjectMapper objmap=new ObjectMapper();
		String jsonpayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(jsonpayload);
		Response response=RestAssured.given().baseUri("https://httpbin.org/post").
		contentType(ContentType.JSON).body(jsonpayload).post();
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("/n-------------------Print after conversion-----------------/n");
		//Covnert json string(jsonpayload) to class object(Employee) deserilization
		Employee emp2=objmap.readValue(jsonpayload, Employee.class);
		System.out.println(emp2.getAge()+emp2.getJob()+emp2.getSalary());
		
	}
	
	
	
}

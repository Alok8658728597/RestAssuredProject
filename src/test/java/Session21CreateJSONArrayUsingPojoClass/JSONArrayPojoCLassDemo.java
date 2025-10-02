package Session21CreateJSONArrayUsingPojoClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session20IntroToPOJO.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONArrayPojoCLassDemo {
	@Test
	public void createJsonArrayPayloadFromPojoClass() throws JsonProcessingException {
		Employee emp1=new Employee();
		emp1.setName("Priti");
		emp1.setJob("Student");
		emp1.setAge(34);
		emp1.setSalary(200);
		
		Employee emp2=new Employee();
		emp2.setName("Rubi");
		emp2.setJob("Engineer");
		emp2.setAge(44);
		emp2.setSalary(2000);
		
		Employee emp3=new Employee();
		emp3.setName("Kabi");
		emp3.setJob("Singer");
		emp3.setAge(64);
		emp3.setSalary(20000);
		
		List<Employee> listofemp=new ArrayList<Employee>();
		listofemp.add(emp1);
		listofemp.add(emp2);
		listofemp.add(emp3);
		
		//Convert employee class object to json payload array
		ObjectMapper objmap=new ObjectMapper();
		String jsonpayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(listofemp);
		
		System.out.println("After adding all employee object "+jsonpayload);
		
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://httpbin.org/post");
		reqspec.contentType(ContentType.JSON);
		Response response=reqspec.body(jsonpayload).post();
		System.out.println("---------Response body--------------");
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200,"check the status code");
		
		//Convert json array payload into employee object 
		ResponseBody res=response.getBody();
		JsonPath jsonPathview=res.jsonPath();
		
		List<Employee> allemp=jsonPathview.getList("json",Employee.class);
		for(Employee emp:allemp) {
			System.out.println("Get Name of all emp object "+emp.getName());
		}
		
	}
}

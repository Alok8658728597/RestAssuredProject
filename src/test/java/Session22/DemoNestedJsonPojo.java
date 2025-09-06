package Session22;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DemoNestedJsonPojo {
	@Test
	public void createUser() throws JsonProcessingException {
		createPOJO emp1=new createPOJO();
		emp1.setName("Alok");
		emp1.setAge(22);
		emp1.setJob("QA");
		emp1.setSalary(2000);
		EmployeeTechSkill emptechskill=new EmployeeTechSkill();
		emptechskill.setProgramming_Language("Java");
		emptechskill.setUI_Automation("Selenium");
		emptechskill.setAPI_Testing("POstman");
		emp1.setTechSkills(emptechskill);
		
		//convert class object into json object payload
		ObjectMapper objmap=new ObjectMapper();
		String jsonpayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println("jsonpayload" +jsonpayload);
		
		Response response=RestAssured.given().baseUri("https://httpbin.org/post").
		contentType(ContentType.JSON).body(jsonpayload).post();
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}

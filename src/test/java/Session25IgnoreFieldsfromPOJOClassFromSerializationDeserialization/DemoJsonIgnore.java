package Session25IgnoreFieldsfromPOJOClassFromSerializationDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;





public class DemoJsonIgnore {
	@Test
	public void test() throws JsonProcessingException {
		EmployeePOJO emp1=new EmployeePOJO();
		emp1.setName("ALok");
		emp1.setAge(11);
		emp1.setJob("QA");
		emp1.setSalary(10000);
		emp1.setIsMarried(true);

		//Serialization: Convert Employee class objet to json object payload
		ObjectMapper objmap=new ObjectMapper();
		String jsonpayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(jsonpayload);
		
		//Deserialization : convert from json string to employee object
		String payload="{\r\n"
				+ "  \"name\" : \"ALok\",\r\n"
				+ "  \"job\" : \"QA\",\r\n"
				+ "  \"age\" : 11,\r\n"
				+ "  \"salary\" : 10000.0,\r\n"
				+ "  \"isMarried\" : true\r\n"
				+ "}";
		EmployeePOJO emp2=objmap.readValue(payload, EmployeePOJO.class);
		System.out.println(emp2.getName()+emp2.getAge()+emp2.getJob()+emp2.getSalary()+emp2.isIsMarried());
	}}

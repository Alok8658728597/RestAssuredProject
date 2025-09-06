package Session26IgnoreUnknownPropertiesDuringDeserializationProcess;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Session25IgnoreFieldsfromPOJOClassFromSerializationDeserialization.EmployeePOJO;




public class IgnoreUnknownField {
	@Test
	public void test1() throws JsonMappingException, JsonProcessingException {
		String payload="{\r\n"
				+ "  \"name\" : \"ALok\",\r\n"
				+ "  \"job\" : \"QA\",\r\n"
				+ "  \"age\" : 11,\r\n"
				+ "  \"salary\" : 10000.0,\r\n"
				+ "  \"isMarried\" : true,\r\n"
				+ "  \"lastname\" : \"Swain\"\r\n"
				+ "}";
		ObjectMapper objmap=new ObjectMapper();
		objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		EmployeePOJO convertobj=objmap.readValue(payload, EmployeePOJO.class);
		System.out.println(convertobj.getName()+convertobj.getAge()+convertobj.getJob()+convertobj.getSalary()+convertobj.isIsMarried());
	}

}

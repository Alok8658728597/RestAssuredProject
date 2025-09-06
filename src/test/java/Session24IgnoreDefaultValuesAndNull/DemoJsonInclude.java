package Session24IgnoreDefaultValuesAndNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJsonInclude {
	@Test
	public void test() throws JsonProcessingException {
		EmployeePOJOClass emp1=new EmployeePOJOClass();
		//emp1.setName("ALok");
		emp1.setAge(11);
		emp1.setJob("QA");
		emp1.setSalary(10000);
		emp1.setIsMarried(true);
		
		String[] hobbies = {}; // Empty array
		emp1.setHobbies(hobbies);
		List<String> degrees = new ArrayList<String>(); // Empty list
		emp1.setDegrees(degrees);
		Map<String, String> familyMembers = new HashMap<String, String>(); // Empty map
		emp1.setFamilymambers(familyMembers);

		//Convert Employee class objet to json object payload
		ObjectMapper objmap=new ObjectMapper();
		String jsonpayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(jsonpayload);
		
		
	}

}

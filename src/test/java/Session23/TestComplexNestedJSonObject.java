package Session23;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestComplexNestedJSonObject {
	/*{
  "ComapnyName":"Capgemini",
  "Bank":["HDFC","PNB","AXIX"],
  "Street":"NilachalBazzar",
        "City":"Paradeep",
        "Pincode":754141,
"Employees":[
{
	"Name":"Rohan",
	"Job":"Student",
	"age":12,
      "Address":{
        "Street":"NilachalBazzar",
        "City":"Paradeep",
        "Pincode":754141

      }
},
{
	"Name":"Alok",
	"Job":"Student",
	"age":12,
      "Address":{
        "Street":"Bhutumundai",
        "City":"Kujang",
        "Pincode":754241

      }
},
{
	"Name":"Nibas",
	"Job":"Student",
	"age":12,
      "Address":{
        "Street":"Rahama",
        "City":"Hental",
        "Pincode":734141

      }
}
]
}*/
	@Test
	public void createUser() throws JsonProcessingException {
		//create request payload
		NestedJSONPojoClass reqpayload=new NestedJSONPojoClass();
		reqpayload.setCompanyName("Capgemini");
		reqpayload.setCity("Paradeep");
		reqpayload.setStreet("NilachalBazzar");
		reqpayload.setPincode(7541414);
		List<String> banks=new ArrayList<String>();
		banks.add("HDFC");
		banks.add("PNB");
		banks.add("AXIX");
		reqpayload.setBank(banks);
		
		
		EmployeePOJO emp1=new EmployeePOJO();
		emp1.setName("ALok");
		emp1.setAge(23);
		emp1.setJob("QA");
		AddressPOJO adp=new AddressPOJO();
		adp.setCity("Kednrapada");
		adp.setStreet("Marshagai");
		adp.setPincode(890076);
		emp1.setAddress(adp);
		
		EmployeePOJO emp2 = new EmployeePOJO();
		emp2.setName("Rajesh");
		emp2.setAge(30);
		emp2.setJob("Developer");

		AddressPOJO adp2 = new AddressPOJO();
		adp2.setCity("Bhubaneswar");
		adp2.setStreet("Jaydev Vihar");
		adp2.setPincode(751013);
		emp2.setAddress(adp2);
		
		EmployeePOJO emp3 = new EmployeePOJO();
		emp3.setName("Sourav");
		emp3.setAge(28);
		emp3.setJob("Software Engineer");
		AddressPOJO adp3 = new AddressPOJO();
		adp3.setCity("Cuttack");
		adp3.setStreet("Badambadi");
		adp3.setPincode(753009);
		emp3.setAddress(adp3);
		List<EmployeePOJO> emplist=new ArrayList<EmployeePOJO>();
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);
		
		reqpayload.setEmployeelist(emplist);
		
		ObjectMapper objmap=new ObjectMapper();
		String jsonpayload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(reqpayload);
		System.out.println("jsonpayload response:" +jsonpayload);
		
		Response response=RestAssured.given().baseUri("https://httpbin.org/post").
				contentType(ContentType.JSON).body(jsonpayload).post();
				response.prettyPrint();
				Assert.assertEquals(response.statusCode(), 200);
		
	}

}

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestAndResponse {
	@Test
	void testcase01(){
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println("Alok Swains");
		
	}

}
/**
 *✅ What is a Request?
A request is what you send to the server to ask for data or perform an action.
It includes:

HTTP Method: GET, POST, PUT, DELETE
URL: The endpoint you're calling
Headers: Metadata like Content-Type, Authorization
Body: Data you send (only for POST/PUT)

🧠 Think of it like placing an order in a restaurant:

You tell the waiter (server) what you want (method + data).


✅ What is a Response?
A response is what the server sends back after processing your request.
It includes:

Status Code: Tells if the request was successful (e.g., 200 OK, 404 Not Found)
Headers: Info about the response (e.g., Content-Type)
Body: The actual data returned (JSON, XML, etc.)

🧠 Think of it like the waiter bringing your food:

You get the dish (data), receipt (status), and packaging info (headers).


✅ How Do We Validate in RestAssured?
Validation means checking if the response is correct.
You can validate:

Status Code: Is it 200 OK?
Body Content: Does it contain expected data?
Headers: Is the content type correct?**/

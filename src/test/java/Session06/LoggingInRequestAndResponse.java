// ✅ Logging in RestAssured — Interview Revision Notes

// 1️⃣ Purpose of Logging:
// - Helps debug request and response details
// - Useful during development and troubleshooting
// - Shows headers, body, URI, parameters, cookies, etc.

// 2️⃣ Logging Request Details:
// - .log().all()         → Logs everything in the request
// - .log().headers()     → Logs only request headers
// - .log().body()        → Logs only request body
// - .log().uri()         → Logs only request URI
// - .log().params()      → Logs only request parameters

// 3️⃣ Logging Response Details:
// - .then().log().all()      → Logs full response
// - .then().log().status()   → Logs only status code
// - .then().log().headers()  → Logs only response headers
// - .then().log().body()     → Logs only response body

// 4️⃣ When to Use Logging:
// - During test development to verify request/response structure
// - When debugging failed tests
// - To inspect dynamic values like tokens, IDs, etc.

// 5️⃣ Best Practices:
// - Avoid logging sensitive data (e.g., passwords, tokens) in production
// - Use conditional logging if needed (e.g., only on failure)
// - Combine logging with assertions for better traceability

// 🧠 Memory Tip:
// - "Use .log().all() for full visibility — split into .headers(), .body(), .uri() when needed"

package Session06;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LoggingInRequestAndResponse{
	
	@Test
	public void loggingRequest() {
		RestAssured.baseURI="https://api.restful-api.dev";
		RestAssured
		.given().log().params()
		.contentType("application/json")
		.pathParam("id", 7)
		.get("/objects/{id}");
		
	}
	@Test
	public void loggingSpecificRequest() {
		RestAssured.baseURI="https://api.restful-api.dev";
		RestAssured
		.given().log().headers()
		.contentType("application/json")
		.pathParam("id", 7)
		.get("/objects/{id}");
		
	}
}
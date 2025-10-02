package Session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBodyUsingJSONPath {

    @Test
    public void listJsonResponseBody() {
        // Step 1: Create RequestSpecification
        RequestSpecification reqspec = RestAssured.given();

        // Step 2: Set Base URI and Path
        reqspec.baseUri("https://reqres.in");
        reqspec.basePath("api/users/2");

        // Step 3: Send GET request
        Response response = reqspec.get();

        // Step 4: Get response body
        ResponseBody respbody = response.getBody();

        // Step 5: Convert response body to JSONPath
        JsonPath jsonview = respbody.jsonPath();

        // Step 6: Extract specific field using JSONPath
        String firstname = jsonview.get("data.first_name");
        System.out.println("First Name: " + firstname);

        // Step 7: Validate using TestNG Assert
        Assert.assertEquals(firstname, "Janet", "First name should be Janet");
    }

    // ✅ Interview & Revision Tips for JSONPath and ResponseBody:

    // ✅ Why use JsonPath?
    // - To extract specific fields from JSON response
    // - Supports dot notation like "data.first_name"
    // - Useful for nested JSON structures

    // ✅ Common JsonPath methods:
    // - jsonPath().get("key") → Get value by key
    // - jsonPath().getList("key") → Get list of values
    // - jsonPath().getMap("key") → Get map of key-value pairs

    // ✅ When to use ResponseBody?
    // - When you want to convert response to string or JsonPath
    // - response.getBody().asString() → raw string
    // - response.getBody().jsonPath() → parsed JSON

    // ✅ Best Practices:
    // - Always validate extracted values using assertions
    // - Use System.out.println() only for debugging
    // - Keep URI and path separate for clarity
    // - Use JsonPath for clean and readable field extraction

    // 🧠 Memory Tip:
    // - "Use JsonPath when you need to extract nested fields from JSON response."
}

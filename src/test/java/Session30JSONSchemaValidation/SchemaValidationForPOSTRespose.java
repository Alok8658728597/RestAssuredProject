/*{
  "name": "Alok Itself",
  "data": {
    "year": 2014,
    "price": 1204
  }
}
*/
package Session30JSONSchemaValidation;

// Importing required libraries for JSON, TestNG, and RestAssured
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidationForPOSTRespose {
    // Declare a reusable RequestSpecification object for all requests in this class
    RequestSpecification reqspec;

    // This method runs once before any test method in this class
    @BeforeClass
    public void verify_setup() {
        // Build a reusable request specification with base URI and Content-Type as JSON
        reqspec = new RequestSpecBuilder()
                .setBaseUri("https://api.restful-api.dev") // Base URL for the API
                .setContentType(ContentType.JSON)          // Set Content-Type header to application/json
                .build();
    }

    @Test
    public void schemaValidtionForPostResponse() {
        // --- PAYLOAD CREATION ---
        // Instead of using JSONObject or Map, here we use a raw JSON string as the request body.
        // This is valid as long as the string is a properly formatted JSON and Content-Type is set to JSON.
        String payload = "{ \"name\": \"Alok Itself\", \"data\": { \"year\": 2014, \"price\": 1204 } }";

        // --- API REQUEST EXECUTION ---
        // Use RestAssured to send a POST request with the payload to the /objects endpoint.
        // .spec(reqspec) applies the base URI and Content-Type from the reusable spec.
        // .body(payload) attaches the JSON string as the request body.
        Response response = RestAssured.given()
                .spec(reqspec)
                .body(payload)
                .when()
                .post("/objects");

        // --- RESPONSE VALIDATION ---
        // 1. Assert that the response status code is 200 (OK).
        // 2. Validate that the response body matches the expected JSON schema.
        //    The schema file should be placed under src/test/resources/schemas/schemaforPostResponse.json.
        response.then().statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/schemaforPostResponse.json"));

        // --- NOTES FOR REVISION ---
        // - If you pass a String payload to .body() in RestAssured, it is sent as-is in the request body.
        // - The server will treat it as JSON if the Content-Type header is set to application/json.
        // - Using a raw JSON string is quick for simple payloads, but for complex or dynamic payloads,
        //   consider using Map or POJO for better maintainability and readability.
        // - matchesJsonSchemaInClasspath() validates the response against a JSON schema file present in the classpath.
        // - Always check for correct endpoint and schema file path to avoid 404 or schema validation errors.
    }
}

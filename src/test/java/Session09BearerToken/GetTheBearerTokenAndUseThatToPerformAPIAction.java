package Session09BearerToken;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * 🔐 Bearer Token API Testing Notes:
 * ----------------------------------
 * 1. Always fetch the token dynamically using a login API.
 * 2. Use JsonPath to extract specific fields like "token" from the response.
 * 3. Pass the token in the Authorization header using "Bearer <token>" format.
 * 4. Avoid hardcoding tokens — use utility methods or @BeforeClass setup.
 * 5. Validate protected endpoints using both valid and invalid tokens.
 * 6. JsonPath is used after `.when()` to extract data, not after `.then()`.
 * 7. Use `getString()`, `getInt()`, `getList()` based on the data type.
 * 8. Interview Tip: Explain how you handle token expiration and reuse.
 */

public class GetTheBearerTokenAndUseThatToPerformAPIAction {

    // JSON body for login request
    String jsonBody = "{\"username\":\"emilys\",\"password\":\"emilyspass\"}";

    /**
     * 🔧 Helper method to get Bearer Token from login API
     * - Sends POST request to /auth/login
     * - Extracts "accessToken" from the response using JsonPath
     * - Returns the token as a String
     */
    public String getAccessToken() {
        Response response = RestAssured.given()
            .baseUri("https://dummyjson.com")
            .contentType(ContentType.JSON)
            .body(jsonBody)
            .when().post("/auth/login");

        // Extract token from response
        String accessToken = response.getBody().jsonPath().getString("accessToken");
        System.out.println("Print Token: " + accessToken);
        return accessToken;
    }

    /**
     * ✅ Test method to perform GET request using Bearer Token
     * - Calls getAccessToken() to fetch token
     * - Sends GET request to /auth/me with Authorization header
     * - Extracts "gender" field from response using JsonPath
     * - Validates status code is 200
     */
    @Test(enabled = true)
    public void performGetRequestUsingAboveGeneratedBearerToken() {
        // Get token from login API
        String token = getAccessToken();

        // Send GET request with Bearer token
        Response response = RestAssured.given()
            .baseUri("https://dummyjson.com")
            .accept(ContentType.JSON)
            .header("Authorization", "Bearer " + token)
            .when()
            .get("/auth/me");

        // Extract specific field from response
        String gender = response.jsonPath().getString("gender");
        System.out.println("The value of gender: " + gender);

        // Validate response status
        response.then().statusCode(200);
    }
}

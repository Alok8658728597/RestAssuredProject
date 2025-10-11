package Session11Ouath2;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RefreshMechanism {

    // Step 1: Define login credentials in JSON format
    private static String bodyContent = "{\"username\":\"emilys\",\"password\":\"emilyspass\"}";

    // Variables to store tokens
    String accessToken;
    String refreshToken;

    /**
     * Step 2: Login to the application using username and password
     * - Send a POST request to /auth/login
     * - Extract accessToken and refreshToken from the response
     * - These tokens will be used in subsequent requests
     */
    @Test(priority = 1)
    public void loginAndGetBothTokens() {
        Response response = RestAssured.given()
            .baseUri("https://dummyjson.com")
            .contentType(ContentType.JSON)
            .body(bodyContent)
            .when()
            .post("/auth/login");

        // Extract tokens from JSON response
        accessToken = response.jsonPath().getString("token"); // Correct key is "token" not "accessToken"
        System.out.println("Old access Token: " + accessToken);

        refreshToken = response.jsonPath().getString("refreshToken");
        System.out.println("Refresh Token: " + refreshToken);

        // Optional: Log full response for debugging
        response.then().log().body();
    }

    /**
     * Step 3: Use the access token to access a protected resource
     * - Send a GET request to /auth/me
     * - Pass the access token in the Authorization header
     * - This simulates accessing a secure endpoint
     */
    @Test(priority = 2, dependsOnMethods = "loginAndGetBothTokens")
    public void getAuthUserUsingAboveAccessToken() {
        Response resp = RestAssured.given()
            .baseUri("https://dummyjson.com")
            .accept(ContentType.JSON)
            .header("Authorization", "Bearer " + accessToken)
            .when()
            .get("/auth/me");

        // Log the response to verify access
        resp.then().log().all();

        // Optional: Check if token is expired (status code 401)
        if (resp.statusCode() == 401) {
            System.out.println("Access token expired. Consider refreshing the token.");
        }
    }

    /**
     * Step 4: Handle refresh token mechanism
     * - If access token expires, use refresh token to get a new access token
     * - Send a POST request to /auth/refresh with refreshToken in body
     * - Extract new access token from the response
     * - This simulates renewing session without logging in again
     */
    @Test(priority = 3, dependsOnMethods = "loginAndGetBothTokens")
    public void getNewAccessTokenUsingRefreshToken() {
        // Prepare body with actual refresh token value
        String refreshTokenBody = "{\"refreshToken\":\"" + refreshToken + "\"}";

        Response response = RestAssured.given()
            .baseUri("https://dummyjson.com")
            .contentType(ContentType.JSON)
            .body(refreshTokenBody)
            .post("/auth/refresh");

        // Extract new access token
        String newAccessToken = response.jsonPath().getString("token"); // Correct key is "token"
        System.out.println("New access token: " + newAccessToken);

        // Optional: Use new token to access protected resource again
        Response retryResp = RestAssured.given()
            .baseUri("https://dummyjson.com")
            .accept(ContentType.JSON)
            .header("Authorization", "Bearer " + newAccessToken)
            .get("/auth/me");

        retryResp.then().log().all();
    }
}
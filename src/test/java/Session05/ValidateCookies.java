package Session05;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.containsString;

public class ValidateCookies {

    @Test
    public void loginToGetCookies() {

        /*
         * Step 1: Send a POST request to the login endpoint using Basic Authentication.
         * This simulates a user login and returns a response containing cookies.
         */
        Response response = RestAssured.given()
            .baseUri("https://the-internet.herokuapp.com")
            .contentType(ContentType.JSON)
            .auth().basic("tomsmith", "SuperSecretPassword!") // Basic Auth credentials
            .when()
            .post("/login"); // Login endpoint

        /*
         * Step 2: Extract the 'rack.session' cookie from the login response.
         * This cookie is used to maintain the session for the logged-in user.
         */
        String cookies = response.getCookie("rack.session");
        System.out.println("Print the value of rack.session cookie: " + cookies);

        /*
         * Step 3: Use the extracted cookie to access the secure area.
         * This simulates accessing a protected resource using session-based authentication.
         */
        Response secureAppUsingCookie = RestAssured.given()
            .baseUri("https://the-internet.herokuapp.com")
            .cookie("rack.session", cookies) // Reusing the session cookie
            .get("/secure"); // Secure endpoint

        /*
         * Step 4: Validate that the secure page contains expected success message.
         * This confirms that the cookie-based login was successful.
         */
        secureAppUsingCookie.then().body(containsString("You logged into a secure area!"));

        /*
         * Step 5: Print status code and response body for debugging and verification.
         */
        System.out.println("Check the status code after login with cookie: " + secureAppUsingCookie.getStatusCode());
        System.out.println("Get the body of page: " + secureAppUsingCookie.getBody().asString());
    }
}
/*1. Cookies are small pieces of data stored on the client side to maintain session state.
2. They are commonly used for authentication, personalization, and tracking user activity.
3. In API testing, cookies help simulate real user sessions and test secure endpoints.
4. Types of cookies include:
   - Session Cookies: Temporary, deleted when browser closes.
   - Persistent Cookies: Stored for a defined duration.
   - Secure Cookies: Sent only over HTTPS.
   - HttpOnly Cookies: Not accessible via JavaScript (for security).
5. In RestAssured:
   - Use getCookie("name") to extract a specific cookie.
   - Use getCookies() to get all cookies as a Map.
   - Use .cookie("name", "value") to send cookies in a request.
6. Cookie-based authentication is different from token-based authentication (like JWT).
7. Always validate session expiry, cookie presence, and secure access during testing.
8. Interview Tip: Be ready to explain how you extract, reuse, and validate cookies in API flows.*/
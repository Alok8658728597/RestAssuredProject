package Session08Authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
//Always remeber incase of request use contentType and in response use accept() method.
import org.testng.annotations.Test;

public class LoginWithBasicAuthValidateResponse {

    @Test
    public void validate_UsingBasicAuth() {
        // Interview Point: useRelaxedHTTPSValidation() is useful when testing against self-signed SSL certificates
        RestAssured.useRelaxedHTTPSValidation();

        // Interview Point: .auth().basic() is used to apply Basic Authentication in RestAssured
        // Basic Auth sends credentials encoded in Base64 in the Authorization header
        Response response = RestAssured.given()
            .baseUri("https://the-internet.herokuapp.com") // Base URI of the test server
            .accept("application/json") // Setting content type
            .auth().basic("admin", "admin") // Providing Basic Auth credentials
            .when()
            .get("/basic_auth"); // Endpoint that requires Basic Auth

        // Interview Point: Validate both status code and response body to ensure authentication success
        response.then().statusCode(200)
            .body(containsString("Congratulations! You must have the proper credentials."));
    }
}

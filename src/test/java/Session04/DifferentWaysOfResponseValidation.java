package Session04;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class DifferentWaysOfResponseValidation {

    RequestSpecification requestspec;

    @BeforeClass
    public void setup() {
        // Reusable request specification for base URI and content type
        requestspec = new RequestSpecBuilder()
                .setBaseUri("https://api.restful-api.dev")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void GetSingleUser() {
        Response response = RestAssured.given()
                .spec(requestspec)
                .when()
                .get("/objects/7");

        // ✅ Using TestNG Assert for manual validation
        int responsecode = response.getStatusCode();
        String responseline = response.getStatusLine();
        String getBody = response.getBody().asString();
        String getYear = response.jsonPath().getString("data.year");

        Assert.assertEquals(getYear, "2019", "Year should be 2019");
        Assert.assertTrue(getBody.contains("Apple MacBook Pro 16"), "Body should contain product name");
        Assert.assertEquals(responsecode, 200, "Valid response code");
        Assert.assertEquals(responseline, "HTTP/1.1 200 OK", "Valid response line");

        // ✅ Using Hamcrest Matchers for readable assertions
        response.then()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("data.year", equalTo("2019"))
                .header("Content-Type", containsString("application/json"));
    }

    @Test
    public void GetListUsers() {
        Response response = RestAssured.given()
                .spec(requestspec)
                .when()
                .get("/objects");

        // ✅ Using ValidatableResponse chaining
        ValidatableResponse vres = response.then();
        vres.statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .header("Content-Type", containsString("application/json"));
    }

    @Test
    public void GetSingleUserValidatableResponse() {
        // ✅ One-off request using .given() directly
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in/api/users/2")
                .when()
                .get();

        // ✅ Using ValidatableResponse with Hamcrest
        response.then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("data.first_name", equalTo("Janet"))
                .body("data.email", containsString("@reqres.in"));
    }
}

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

import org.json.simple.JSONObject;

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
    //Using TestNG Assert for Response Validation
    @Test
    public void validateUsingTestNGAssert() {
        Response response = RestAssured.given()
                .spec(requestspec)
                .when()
                .get("/objects/7");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
        Assert.assertTrue(response.getBody().asString().contains("Apple MacBook Pro 16"));
        Assert.assertEquals(response.jsonPath().getString("data.year"), "2019");
    }
    //Using Hamcrest Matchers with .then()
    @Test
    public void validateUsingHamcrestMatchers() {
        RestAssured.given()
                .spec(requestspec)
                .when()
                .get("/objects/7")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("name", equalTo("Apple MacBook Pro 16"))
                .body("data.year", equalTo("2019"))
                .body("data.price", lessThan(3000))
                .body("name", containsString("MacBook"))
                .body("name", notNullValue())
                .header("Content-Type", containsString("application/json"));
    }
    //Using ValidatableResponse (Clean & Separate)
    @Test
    public void validateUsingValidatableResponse() {
        ValidatableResponse vres = RestAssured.given()
                .spec(requestspec)
                .when()
                .get("/objects")
                .then(); // Start chaining validations

        vres.statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .contentType(ContentType.JSON)
            .body("[0].name", equalTo("Apple MacBook Pro 16"))
            .body("[0].data.year", greaterThanOrEqualTo(2015))
            .body("[0].data.price", lessThan(3000))
            .body("name", hasItem("Apple MacBook Pro 16"))
            .body("[0].data.year", notNullValue())
            .header("Content-Type", containsString("application/json"))
            .header("Server", notNullValue());

        vres.log().headers().log().body(); // Optional logging
    }


    
    }
//🔹 Hamcrest = after .then() → Think: “Then comes the matchers.”
//🔹 Response = raw data → Think: “Get and assert manually.”
//🔹 ValidatableResponse = chain validations → Think: “Validate everything in one flow.”
//In RestAssured, when the response is a JSON array, you use [index] to access specific elements.

//Use [0].name → when validating a specific object in an array.
//Use hasItem(...) → when validating a value inside a list.  


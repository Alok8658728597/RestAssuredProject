package Session10APIKey;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 🔑 API Key Authentication Example using OpenWeatherMap API
 * ----------------------------------------------------------
 * ✅ This test sends a GET request to OpenWeatherMap's `/weather` endpoint.
 * ✅ It uses an API key passed as a query parameter to authenticate the request.
 * ✅ The response contains weather data for the specified city (Delhi).
 * ✅ The test validates that the response status code is 200 (OK).
 * 
 * 🔁 Other ways to pass API keys (for revision):
 * ---------------------------------------------
 * 1️⃣ Query Parameter (used below): ?appid=your_api_key
 * 2️⃣ Header (more secure): reqspec.header("x-api-key", apiKey);
 * 3️⃣ Request Body (for POST APIs): reqspec.body("{ \"apikey\": \"your_api_key\" }");
 * 
 * 🔐 Best Practices:
 * ------------------
 * ❌ Never hardcode API keys in production code.
 * ✅ Use config.properties or environment variables to store keys securely.
 * ✅ Rotate keys periodically and restrict usage by IP/domain if supported.
 */

public class APIKeyvalueuse {

    // ✅ Your API Key from OpenWeatherMap
    // Note: Never hardcode API keys in production. Use config files or environment variables.
    String apiKey = "b1a97a3e12fab50af7910aec4cddf67a";

    @Test
    public void getWeatherDatabyCity() {
        // Create a request specification
        RequestSpecification reqspec = RestAssured.given();

        // Set base URI and endpoint path
        reqspec.baseUri("https://api.openweathermap.org");
        reqspec.basePath("/data/2.5/weather");

        // ✅ Method 1: Pass API key as query parameter (used here)
        reqspec.queryParam("q", "Delhi")
               .queryParam("appid", apiKey);

        // 🔁 Method 2: Pass API key as header (if supported by API)
        // reqspec.header("x-api-key", apiKey);

        // 🔁 Method 3: Pass API key in request body (for POST APIs)
        // reqspec.body("{ \"apikey\": \"" + apiKey + "\", \"q\": \"Delhi\" }");

        // Send GET request and capture response
        Response response = reqspec.get();

        // Print the full response body
        System.out.println("Response body: " + response.asString());

        // Validate that the response status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

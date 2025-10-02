/*
Sample JSON Response from API:
/*
[
   {
      "id": "1",
      "name": "Google Pixel 6 Pro",
      "data": {
         "color": "Cloudy White",
         "capacity": "128 GB"
      }
   },
   {
      "id": "2",
      "name": "Apple iPhone 12 Mini, 256GB, Blue",
      "data": null
   },
   {
      "id": "3",
      "name": "Apple iPhone 12 Pro Max",
      "data": {
         "color": "Cloudy White",
         "capacity GB": 512
      }
   },
   ...
]
Note:
- If the response is a JSON array, do NOT use .as(Class.class) directly.
- Instead, use ObjectMapper or TypeReference<List<YourPojo>> to deserialize it properly.
*/

/*
===========================
✅ Jackson ObjectMapper Guide
===========================

// 🔹 What is ObjectMapper?
// ObjectMapper is a class from the Jackson library used for converting JSON to Java objects (deserialization)
// and Java objects to JSON (serialization).

// 🔹 Why use ObjectMapper?
// - To map complex or nested JSON responses into Java POJOs
// - To handle JSON arrays and nested objects easily
// - To avoid manual parsing using JsonPath or JSONObject

// 🔹 When to use ObjectMapper?
// - When the response is a JSON array (e.g., List of products)
// - When the response contains nested JSON objects
// - When you want to work with strongly typed Java classes instead of raw strings or maps

// 🔹 How to use ObjectMapper correctly?
// Step 1: Extract JSON string from response using response.getBody().asString()
// Step 2: Use mapper.readValue(jsonString, new TypeReference<List<YourPojo>>() {}) for arrays
// Step 3: Use @JsonProperty to map JSON keys with spaces, special characters, or mismatched casing

===========================
✅ Common Mistakes & Fixes
===========================

// ❌ Mistake: Passing Response object directly to ObjectMapper
// mapper.readValue(response, ...) → This will fail with "Unrecognized token 'io'" error

// ✅ Fix: Always extract JSON string first
// String json = response.getBody().asString();

// ❌ Mistake: Using .toString() instead of .asString()
// response.getBody().toString() → Returns object reference, not actual JSON

// ✅ Fix: Use .asString() to get the actual JSON content
// String json = response.getBody().asString();

===========================
✅ POJO Field Mapping Tips
===========================

// ✅ Use camelCase for Java field names (e.g., strapColour, generation, price)
// ❌ Avoid capitalized field names like StrapColour or Generation

// ✅ Use @JsonProperty("JSON Key") to map JSON fields with:
// - Spaces (e.g., "Strap Colour")
// - Special characters (e.g., "CPU model")
// - Capitalized keys (e.g., "Generation")

// ✅ Example:
// @JsonProperty("Strap Colour")
// private String strapColour;

// ✅ Always provide matching getter and setter methods for each field
// public String getStrapColour() { return strapColour; }
// public void setStrapColour(String strapColour) { this.strapColour = strapColour; }

===========================
✅ Handling Null Values in JSON
===========================

// ✅ Some JSON objects may have "data": null
// Always check for null before accessing nested fields to avoid NullPointerException

// ✅ Example:
// ProductData data = product.getData();
// if (data != null) {
//     System.out.println(data.getStrapColour());
// } else {
//     System.out.println("Data is null for product: " + product.getName());
// }
*/

package Session20IntroToPOJO;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.pojo.ProductArrayResponse;
import com.restassured.pojo.ProductData;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeserializeProductArrayResponse {

    @Test
    public void test_ProductArrayResponseAndDeserilizeIt() throws Exception {

        // ✅ Step 1: Set base URI for the API
        RestAssured.baseURI = "https://api.restful-api.dev";

        // ✅ Step 2: Send GET request and capture response
        Response response = RestAssured.given()
            .contentType("application/json")
            .when()
            .get("/objects");

        // ✅ Step 3: Extract JSON string from response
        // ❌ Don't use response.getBody().toString() — it returns object reference, not JSON
        String jsonArray = response.getBody().asString();

        // ✅ Step 4: Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // ✅ Step 5: Deserialize JSON array into List of ProductArrayResponse objects
        // - ObjectMapper converts JSON string into Java objects
        // - TypeReference preserves generic type info (List<ProductArrayResponse>)
        List<ProductArrayResponse> productList = mapper.readValue(
            jsonArray,
            new TypeReference<List<ProductArrayResponse>>() {}
        );

        // ✅ Step 6: Loop through each product and safely access nested fields
        for (ProductArrayResponse product : productList) {
            ProductData d = product.getData();

            // ✅ Step 7: Handle null values in "data" field to avoid NullPointerException
            if (d != null) {
                // ✅ Access mapped fields using getters
                System.out.println("Strap Colour: " + d.getStrapColour());
                System.out.println("Generation: " + d.getGeneration());
            } else {
                System.out.println("Data is null for product: " + product.getName());
            }
        }
    }
}

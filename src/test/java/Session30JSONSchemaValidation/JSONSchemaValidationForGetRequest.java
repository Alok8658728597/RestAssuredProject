/*
🔹 What is a JSON Schema?

→ A JSON Schema is like a blueprint or rulebook that describes what a valid JSON response should look like.

It defines:
✅ What fields must be present
✅ What data types those fields should have
✅ Any constraints (like email format, number range, etc.)

🔹 Why do we need it in RestAssured?

→ When testing an API, we want to validate not just the values, but also the structure of the response.
→ JSON Schema helps us automatically check if the response format is correct.

✅ Example JSON Response:
{
   "id": "7",
   "name": "Apple MacBook Pro 16",
   "data": {
      "year": 2019,
      "price": 1849.99,
      "CPU model": "Intel Core i9",
      "Hard disk size": "1 TB"
   }
}

🔹 Schema Template for Above:
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "type": "object",
  "required": ["id", "name", "data"],
  "properties": {
    "id": { "type": "string" },
    "name": { "type": "string" },
    "data": {
      "type": "object",
      "required": ["year", "price", "CPU model", "Hard disk size"],
      "properties": {
        "year": { "type": "integer" },
        "price": { "type": "number" },
        "CPU model": { "type": "string" },
        "Hard disk size": { "type": "string" }
      }
    }
  }
}

🔹 Optional Constraints You Can Use:

→ For strings:
"minLength": 3,
"maxLength": 10

→ For email format:
"format": "email"

→ For arrays:
"items": {
  "type": "string"
}

📌 Tip:
→ Use these constraints only when needed.
→ They help make your schema more strict and accurate.
*/

package Session30JSONSchemaValidation;

import io.restassured.RestAssured; 

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaValidationForGetRequest {
	@Test
	public void schemaValidation() {
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.given().pathParam("id", 7).when().get("/objects/{id}").then().assertThat()
				.body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
	}
}
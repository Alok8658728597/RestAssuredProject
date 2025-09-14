/*
🔍 How to Identify JSON Types?

📌 Object → Uses { ... }
→ Contains key-value pairs inside curly braces.
✅ Example:
"data": {
   "color": "White",
   "price": 999.99
}

📌 Array → Uses [ ... ]
→ Contains a list of values or objects inside square brackets.
✅ Example:
"cast": ["Actor A", "Actor B", "Actor C"]

📌 Schema for Array:
"type": "array",
"items": {
   "type": "string"
}

📌 Optional Data Handling:
→ If a field is not always present in every object, do NOT include it in the "required" array.

✅ Example JSON with optional fields:
[
   {
      "id": "3",
      "name": "Apple iPhone 12 Pro Max",
      "data": {
         "color": "Cloudy White",
         "capacity GB": 512
      }
   },
   {
      "id": "5",
      "name": "Samsung Galaxy Z Fold2",
      "data": {
         "price": 689.99,
         "color": "Brown"
      }
   },
   {
      "id": "10",
      "name": "Apple iPad Mini 5th Gen",
      "data": {
         "Capacity": "64 GB",
         "Screen size": 7.9
      }
   }
]

📌 What does "required" mean in JSON Schema?

→ "required" tells which fields MUST be present in a JSON object.

✅ It is written as an array of field names:
"required": ["id", "name"]

📌 Where to use "required"?

→ Only inside objects (not arrays).
→ Can be used at any level: top-level or nested object.

📌 Example 1: Required fields
{
  "type": "object",
  "required": ["id", "name"],
  "properties": {
    "id": { "type": "string" },
    "name": { "type": "string" }
  }
}

📌 Example 2: Optional fields
{
  "type": "object",
  "properties": {
    "color": { "type": "string" },
    "price": { "type": "number" }
  }
}

📌 Important Rule:
→ If you write "required": ["color"], then "color" must be present in EVERY object.
→ If you don’t write "required", then all fields are optional by default.

📌 Tip:
→ Always check multiple JSON responses.
→ If a field is always present → make it required.
→ If a field is sometimes missing → keep it optional.

📌 Arrays: Don't write actual data in schema

✅ Example:
"cast": ["Actor A", "Actor B", "Actor C"]

❌ Wrong:
"items": {
   "Actor A": { "type": "string" }
}

✅ Correct:
"cast": {
  "type": "array",
  "items": {
    "type": "string"
  }
}
*/

package Session30JSONSchemaValidation;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;

public class JSONSchemaValidationWithArrayTypeResponse {
	@Test
	public void validateArrayJsonResponse() {
		RestAssured.given().baseUri("https://api.restful-api.dev").queryParam("id", 3).queryParam("id", 5)
				.queryParam("id", 10).when().get("/objects").then().assertThat()
				.body(matchesJsonSchemaInClasspath("schemas/schema_forarray.json"));
	}
}
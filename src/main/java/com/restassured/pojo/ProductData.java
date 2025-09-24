/*[
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
   {
      "id": "4",
      "name": "Apple iPhone 11, 64GB",
      "data": {
         "price": 389.99,
         "color": "Purple"
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
      "id": "6",
      "name": "Apple AirPods",
      "data": {
         "generation": "3rd",
         "price": 120
      }
   },
   {
      "id": "7",
      "name": "Apple MacBook Pro 16",
      "data": {
         "year": 2019,
         "price": 1849.99,
         "CPU model": "Intel Core i9",
         "Hard disk size": "1 TB"
      }
   },
   {
      "id": "8",
      "name": "Apple Watch Series 8",
      "data": {
         "Strap Colour": "Elderberry",
         "Case Size": "41mm"
      }
   },
   {
      "id": "9",
      "name": "Beats Studio3 Wireless",
      "data": {
         "Color": "Red",
         "Description": "High-performance wireless noise cancelling headphones"
      }
   },
   {
      "id": "10",
      "name": "Apple iPad Mini 5th Gen",
      "data": {
         "Capacity": "64 GB",
         "Screen size": 7.9
      }
   },
   {
      "id": "11",
      "name": "Apple iPad Mini 5th Gen",
      "data": {
         "Capacity": "254 GB",
         "Screen size": 7.9
      }
   },
   {
      "id": "12",
      "name": "Apple iPad Air",
      "data": {
         "Generation": "4th",
         "Price": "419.99",
         "Capacity": "64 GB"
      }
   },
   {
      "id": "13",
      "name": "Apple iPad Air",
      "data": {
         "Generation": "4th",
         "Price": "519.99",
         "Capacity": "256 GB"
      }
   }
]*/
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

package com.restassured.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData{
	@JsonProperty("Generation")
	private String generation;
	private String price;
	@JsonProperty("Strap Colour")
	private String strapColour;
	
}
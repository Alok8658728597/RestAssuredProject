package Session20IntroToPOJO;

import com.restassured.pojo.Data;
import com.restassured.pojo.Payload;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * === Serialization in API Automation ===
 *
 * 1. Serialization:Send(request)
 *    - Converts a Java object (POJO) to JSON.
 *    - Used when sending a request body (payload) to the server.
 *    - Example: .body(pojoObject)
 *
 * 2. Key Points:
 *    - For request body: Only serialization is needed (Java → JSON).
 *    - You never deserialize a request body because you already have the Java object.
 *    - RestAssured handles serialization automatically using Jackson or Gson.
 *
 * 3. Analogy:
 *    - When sending a request:
 *        We are sending a Java object (POJO), but the server expects JSON.
 *        That's why we need serialization (Java → JSON).
 */
public class PayloadPojoTestSerialization {

    @Test
    public void testPayloadPojo() {
        // Create nested POJO object
        Data data = new Data(2014, 1234.89);

        // Create main payload POJO object
        Payload payload = new Payload("Alok Is A Brand", data);

        /*
         * IMPORTANT REVISION POINT:
         * -------------------------
         * Never try to chain setters like this:
         *     payload.setData(data.setPrice(1278.99));
         * This is WRONG because:
         *   - data.setPrice(1278.99) returns void (nothing), not a Data object.
         *   - payload.setData() expects a Data object, not void.
         * 
         * CORRECT WAY:
         *   1. First, update the value using the setter:
         *        data.setPrice(1278.99);
         *   2. Then, if needed, set the updated data object in payload:
         *        payload.setData(data);
         *   (If payload already has the data object, just updating data is enough.)
         */
        data.setPrice(1278.99);   // Correct: update price in data object
        payload.setData(data);    // Optional: set updated data in payload (if needed)
        
        

        // Send POST request with serialized POJO
        Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .baseUri("https://api.restful-api.dev/objects")
            .body(payload)
            .post();

        // Validate response
        response.then()
            .statusCode(200)
            .statusLine(equalTo("HTTP/1.1 200 OK"))
            .body("name", equalTo("Alok Is A Brand"));

        // Print response for debugging
        Data data1=payload.getData();
        System.out.println(data1.getYear());
    }
}

/**
 * === Key Points for POJO Serialization Revision ===
 *
 * 1. POJO fields must match JSON keys and types.
 * 2. Always declare POJO fields in the value type, not the key type.
 *    Example: If JSON value is a number, use int/double, not String.
 * 3. Always use private fields and public getters/setters in POJO.
 *    - Getters let you read field values.
 *    - Setters let you update field values.
 *    - Frameworks like Jackson/Gson need them for JSON conversion.
 * 4. Add a no-argument constructor in POJO for serialization (good practice).
 * 5. RestAssured can convert POJO to JSON automatically if Jackson/Gson is present.
 * 6. Never chain setters like payload.setData(data.setPrice(...)); Always call setters separately.
 * 7. Always check status code and important fields in the response.
 * 8. Print response for debugging if needed.
 * 9. Use clear and meaningful class/method names.
 */

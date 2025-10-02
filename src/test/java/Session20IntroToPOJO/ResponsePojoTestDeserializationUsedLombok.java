package Session20IntroToPOJO;

import org.testng.annotations.Test;
import com.restassured.pojo.DataUsingLombok;
import com.restassured.pojo.PayloadUsingLombok;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Deserialization=download(response)
 * Deserialization Test using Lombok:
 * ----------------------------------
 * - Deserialization converts JSON → Java object (POJO).
 * - RestAssured uses Jackson internally to map JSON to POJO.
 * - Lombok auto-generates getters/setters, which Jackson uses during deserialization.
 * - During deserialization, values like 'id' and 'name' are auto-injected via Lombok-generated setter methods.
 * - Updating values via setters only affects the Java object in memory, not the server.
 * - To update server data, use PUT/PATCH with .body().
 * 
 * Sample JSON Response:
 * {
 *   "id": "7",
 *   "name": "Apple MacBook Pro 16",
 *   "data": {
 *     "year": 2019,
 *     "price": 1849.99,
 *     "CPU model": "Intel Core i9",
 *     "Hard disk size": "1 TB"
 *   }
 * }
 */
public class ResponsePojoTestDeserializationUsedLombok {

    @Test
    public void test_DeserializationUsingLombok() {
        // Set base URI
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Send GET request and receive response
        Response response = RestAssured
            .given().pathParam("id", "7")
            .when()
            .get("/objects/{id}");

        // Deserialize full JSON into PayloadUsingLombok
        PayloadUsingLombok lombokPayload = response.as(PayloadUsingLombok.class);

        // Access top-level fields
        System.out.println("Original ID from JSON: " + lombokPayload.getId());
        System.out.println("Original Name from JSON: " + lombokPayload.getName());

        // Access nested POJO (data object)
        DataUsingLombok dataOfNestedPojo = lombokPayload.getData();
        System.out.println("Hard Disk Size: " + dataOfNestedPojo.getHarddisksize());
        System.out.println("CPU Model: " + dataOfNestedPojo.getCPUmodel());

        // Update ID in Java object (does NOT affect server)
        lombokPayload.setId("9");
        System.out.println("Updated ID in Java object: " + lombokPayload.getId());

        // Update CPU model in nested POJO
        dataOfNestedPojo.setCPUmodel("Core i5");
        System.out.println("Updated CPU Model in Java object: " + dataOfNestedPojo.getCPUmodel());
    }
}

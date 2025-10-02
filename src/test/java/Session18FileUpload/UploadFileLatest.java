package Session18FileUpload;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UploadFileLatest {

    @Test
    public void verifyByFileUpload() {

        /*
         * Step 1: Create a File object pointing to the file you want to upload.
         * Make sure the file exists at the specified path.
         */
        File textFile = new File("src/test/resources/FileUpload.txt");

        /*
         * Step 2: Relax SSL validation to avoid certificate issues during HTTPS calls.
         * This is useful for testing with self-signed or untrusted certificates.
         */
        RestAssured.useRelaxedHTTPSValidation();

        /*
         * Step 3: Send a POST request to the file upload endpoint with multipart/form-data.
         * The .multiPart("file", textFile) method attaches the file to the request.
         *
         * 📌 Explanation of .multiPart("file", textFile)
         *
         * 1. "file" is the form field name expected by the server.
         *    - It can vary depending on the API (e.g., "document", "upload", "image").
         *    - You must match this name with what the server expects.
         *
         * 2. textFile is a Java File object pointing to the actual file to be uploaded.
         *    - You can upload any file type: .txt, .pdf, .jpg, .xlsx, etc.
         *    - Just ensure the file exists at the given path.
         *
         * 3. .multiPart(...) is used to send multipart/form-data requests.
         *    - Required for file uploads in RestAssured.
         *    - You can use it multiple times to upload multiple files.
         *
         * 4. To find the correct form field name:
         *    - Check API documentation.
         *    - Inspect HTML form or Postman request.
         *    - Use browser dev tools to inspect form data.
         *
         * ✅ Example:
         * .multiPart("resume", new File("src/test/resources/resume.pdf"))
         */
        Response response = RestAssured.given()
            .baseUri("https://practice.expandtesting.com")
            .multiPart("file", textFile)
            .when()
            .post("/upload");

        /*
         * Step 4: Print the status code to verify if the upload was successful.
         */
        System.out.println("Print the status code: " + response.getStatusCode());
    }
}

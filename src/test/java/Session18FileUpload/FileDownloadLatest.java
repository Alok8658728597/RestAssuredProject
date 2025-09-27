package Session18FileUpload;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadLatest {

    @Test
    public void verifyByFileDownload() throws Exception {

        /*
         * ✅ File Download in RestAssured
         *
         * 1. Send GET request to the file URL.
         * 2. Get file content as InputStream from the response.
         * 3. Save it locally using Files.copy().
         * 4. Close InputStream to release resources.
         *
         * 📌 Tip:
         * - Files.copy() is a cleaner alternative to manual byte stream handling.
         * - The downloaded file will be saved in 'src/test/resources' folder.
         */

        // Step 1: Relax SSL validation (useful for HTTPS endpoints with self-signed certs)
        RestAssured.useRelaxedHTTPSValidation();

        // Step 2: Send GET request to download the file
        Response response = RestAssured.given()
            .baseUri("https://practice.expandtesting.com")
            .when()
            .get("/download/1758870450439_sample.pdf");

        // Step 3: Get file content as InputStream
        InputStream inputStream = response.asInputStream();

        // Step 4: Save the file locally using Files.copy()
        Files.copy(inputStream, Paths.get("src/test/resources/downloaded_sample.pdf"));

        // Step 5: Close the stream
        inputStream.close();

        // Step 6: Print confirmation
        System.out.println("File downloaded successfully.");
    }
}

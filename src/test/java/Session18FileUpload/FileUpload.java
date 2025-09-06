package Session18FileUpload;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUpload {
	@Test(enabled=false)
	public void uploadfile() {
		//Create file object
		File uploadnewfile=new File("C:\\Users\\ALSWAIN\\Desktop\\Test.java");
		//Crate Request specification object
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://httpbin.org/post");
		reqspec.contentType("multipart/form-data");
		reqspec.multiPart("file",uploadnewfile);
		Response response=reqspec.post();
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test
	public void uploadImage() {
		File uploadimage=new File("C:\\Users\\ALSWAIN\\Downloads\\UI.png");
		//Crate Request specification object
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
		reqspec.contentType("multipart/form-data");
		reqspec.multiPart("file",uploadimage);
		Response response=reqspec.post();
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),200);
	}
}

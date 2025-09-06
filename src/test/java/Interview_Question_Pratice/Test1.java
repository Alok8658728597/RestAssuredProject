package Interview_Question_Pratice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestSpecification set=new RequestSpecBuilder()
				.setBaseUri("https://www.google.com")
				.setBasePath("/v3")
				.addHeader("Authorization", "Bearer token")
				.setContentType(ContentType.JSON)
				.build();
		given().spec(set).body("{ \"name\": \"John Doe\" }").when().post("/users").then()
		.assertThat().statusCode(201).body("name", equalTo("John Doe"));
		
		

	}

}

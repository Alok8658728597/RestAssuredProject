package Session10APIKey;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIKeyvalueuse {
	//b1a97a3e12fab50af7910aec4cddf67a
	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={b1a97a3e12fab50af7910aec4cddf67a}
	@Test
	public void getWeatherDatabyCity() {
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://api.openweathermap.org");
		reqspec.basePath("/data/2.5/weather");
		reqspec.queryParam("q", "Delhi").queryParam("appid", "b1a97a3e12fab50af7910aec4cddf67a");

		Response response=reqspec.get();
		System.out.println("Response body"+response.asString());
		Assert.assertEquals(response.getStatusCode(), 200);

	}
}

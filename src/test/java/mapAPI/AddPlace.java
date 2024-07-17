package mapAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AddPlace {

	@Test
	public void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		try {
			RequestSpecification inputRequest = given().queryParam("key", "qaclick123")
					.header("Content-Type", "application/json")
					.body("{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
							+ "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n"
							+ "  \"name\": \"Spitzvilla\",\r\n" + "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
							+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
							+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
							+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n"
							+ "}\r\n" + "");
			Response response = inputRequest.when().post("maps/api/place/add/json");
			response.then().assertThat().statusCode(200).extract().response();

			response.prettyPrint();

			// These lines help in debugging by printing the response status code and body.
//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

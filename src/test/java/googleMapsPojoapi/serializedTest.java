package googleMapsPojoapi;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.location;
import pojo.locationdata;

public class serializedTest {
	public static void main(String args[]) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		locationdata ld = new locationdata();
		ld.setAccuracy(50);
		ld.setAddress("aaaaa");
		ld.setLanguage("aaa");
		ld.setPhone_number("111111");
		ld.setName("location-111");
		ld.setWebsite("rahulshetty academy");
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("112");
		ld.setTypes(list);
		location loc = new location();
		loc.setLat(12);
		loc.setLng(12);
		ld.setLocation(loc);
		
		RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resthen = new ResponseSpecBuilder().expectStatusCode(200).build();
	
		RequestSpecification resgiven = given().spec(res).body(ld);
		
		Response reswhen = resgiven.when().post("/maps/api/place/add/json")
				.then().spec(resthen).extract().response();
		String responseout = reswhen.asString();
		
		System.out.println(responseout);
		

	}
}

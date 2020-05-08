package stepDefinition;
 
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
 

 
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.PendingException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.location;
import pojo.locationdata;
import resources.EnumResource;
import resources.TestDatabuild;
import resources.Utils;
 
public class Test_Steps extends Utils{
	RequestSpecification resgiven;
	ResponseSpecification resthen;
	Response reswhen;
	static String place_iddata;
	TestDatabuild data = new TestDatabuild();
	
	@Given("^Add place payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_place_payload_with(String name, String language, String adress) throws IOException {
		
		
		 
		 resgiven = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, adress));
		
	}

	@When("^usercalls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void usercalls_with_http_request(String resource, String type) {
		EnumResource resourceapi = EnumResource.valueOf(resource);
		System.out.println(resourceapi.getResource());
		
		if(type.equalsIgnoreCase("POST")) {
		reswhen = resgiven.when().post(resourceapi.getResource());
		}
		else if(type.equalsIgnoreCase("GET"))
		{
			reswhen = resgiven.when().get(resourceapi.getResource());
		}
	}

	@Then("^the api call is success with status code (\\d+)$")
	public void the_api_call_is_success_with_status_code(int arg1)  {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(reswhen.getStatusCode(),200);
	}

	@Then("^\"([^\"]*)\" is \"([^\"]*)\"$")
	public void is(String key, String value){
	    // Write code here that turns the phrase above into concrete actions
	
	  
	   assertEquals(getJsonpath(reswhen, key), value);	   
	}
	@Then("^verify place_id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	public void verify_place_id_created_maps_to_using(String resource, String name) throws IOException  {
		
		place_iddata =(getJsonpath(reswhen,"place_id")); 
		
		usercalls_with_http_request(resource, "GET");
		resgiven = given().spec(requestSpecification()).queryParam("place_id",place_iddata);
		System.out.println(place_iddata);
		
		
		
		String name1 =(getJsonpath(reswhen,"name")); 
		System.out.println(name);
		System.out.println(name1);
		assertEquals(name1 , name);
	  
	}
	@Given("^Delete place payload$")
	public void delete_place_payload() throws IOException  {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(place_iddata);
		resgiven = given().spec(requestSpecification()).body(data.Delete(place_iddata));
		System.out.println(resgiven);
	}
}
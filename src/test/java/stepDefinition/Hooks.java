package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenarios() throws IOException {
		
		Test_Steps ts = new Test_Steps();
		if(ts.place_iddata == null )
		{
			ts.add_place_payload_with("abc", "xyz", "def");
			ts.usercalls_with_http_request("AddPlaceApi", "POST");
			ts.verify_place_id_created_maps_to_using("abc", "POST");
		}
	}
}

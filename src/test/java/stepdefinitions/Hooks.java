package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforescnario() throws Throwable   {
		
		//execute this only if place id is null
		//write code to get place id
		
	
		StepDefinition sd=new StepDefinition();
		if(StepDefinition.place_id==null) {
		sd.add_place_payload_with("Sandy", "English", "haryana");
		sd.users_calls_something_api_with_something_http_request("AddPlaceAPI", "POST");
		sd.verify_place_Id_created_maps_to_using("Sandy", "getPlaceAPI");
		
	}
	}
}

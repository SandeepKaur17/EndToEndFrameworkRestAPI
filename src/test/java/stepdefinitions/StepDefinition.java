package stepdefinitions;


import static org.junit.Assert.*;

import java.io.IOException;

//import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resourses.APIResourses;
import resourses.TestDataBuild;
import resourses.Utils;

public class StepDefinition extends Utils {
	TestDataBuild testDataBuild=new TestDataBuild();
	//ResponseSpecification res;
	RequestSpecification req;
	Response response;
	static String place_id;
	APIResourses api;
	

	@Given("Add place payload with {string},{string},{string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		 
		req= given().spec(requestSpecification()).body(testDataBuild.addPlacepayload(name,language,address));
	      // System.out.println("given");
	    }

	@When("^users calls \"([^\"]*)\" API with \"([^\"]*)\" http request$")
    public void users_calls_something_api_with_something_http_request(String resource, String httpMethod) throws Throwable {
	    	// System.out.println("when");
		 api=APIResourses.valueOf(resource);//calling the constructor
		
		if(httpMethod.equalsIgnoreCase("Post")) {
	    	 response=req.when().post(api.getResource())
	    			.then().spec(responseSpecification()).extract().response();
	    }
		else if (httpMethod.equalsIgnoreCase("Get")) {
			
			response=req.when().get(api.getResource());
		}
	    
	}
	    @Then("^The API call is successfull with status code 200$")
	    public void the_api_call_is_successfull_with_status_code_200() throws Throwable {
	    	assertEquals(response.getStatusCode(),200);
	    	assertEquals(200,200);
	    }

	    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String key, String value) throws Throwable {
	    	
	    	assertEquals(getJsonPath(response,key),value);
	    
	    }
	    
	    @Then("verify place_Id created maps to {string} using {string}")
		public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws Throwable {
		
		   // requestSpec
		     place_id=getJsonPath(response,"place_id");
			 req=given().spec(requestSpecification()).queryParam("place_id",place_id);
			 users_calls_something_api_with_something_http_request(resource,"GET");
			  String actualName=getJsonPath(response,"name");
			  assertEquals(actualName,expectedName);
			 
		    
		}
	    
	    @Given("DeletePlace Payload")
	    public void deleteplace_Payload() throws IOException {
	        // Write code here that turns the phrase above into concrete actions
	       
	    	req =given().spec(requestSpecification()).body(testDataBuild.deletePlacePayload(place_id));

	    	

	}}


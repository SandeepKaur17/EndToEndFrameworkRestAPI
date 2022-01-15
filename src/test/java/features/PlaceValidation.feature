Feature: Validating place API's

@AddPlace @Regression
Scenario Outline: Verify if the place is getting added using Add place API
Given Add place payload with "<name>","<language>","<address>"
When users calls "AddPlaceAPI" API with "Post" http request
Then The API call is successfull with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getPlaceAPI"

Examples: 
 |name|language|address|
 |MyHouse|English|World Cost Center|
 #|2nd House|French|Shop 454|
 
@DeletePlace
Scenario: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When users calls "deletePlaceAPI" API with "POST" http request
	Then The API call is successfull with status code 200
	And "status" in response body is "OK"
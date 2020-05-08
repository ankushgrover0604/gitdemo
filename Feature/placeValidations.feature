Feature: Validating place api's

@AddPlace @Regression
Scenario Outline: verify if place is being successfully added using add place api
	Given Add place payload with "<name>" "<language>" "<address>"
	When usercalls "AddPlaceApi" with "Post" http request
	Then the api call is success with status code 200
	And "status" is "OK"
	And "scope" is "APP"
#	And verify place_id created maps to "<name>" using "GetPlace"

Examples:

|name    | language | adress |
|aaaaa   | English  |acxaxax |

@DeletePlace @Regression
Scenario: verify if delete place is working
	Given Delete place payload
	When usercalls "DeletePlaceApi" with "Post" http request
	Then the api call is success with status code 200
#	And "status" is "OK"


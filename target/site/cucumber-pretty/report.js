$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("placeValidations.feature");
formatter.feature({
  "line": 1,
  "name": "Validating place api\u0027s",
  "description": "",
  "id": "validating-place-api\u0027s",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 18,
  "name": "verify if delete place is working",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-delete-place-is-working",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@DeletePlace"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "Delete place payload",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "usercalls \"DeletePlaceApi\" with \"Post\" http request",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the api call is success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "Test_Steps.delete_place_payload()"
});
formatter.result({
  "duration": 1015629500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DeletePlaceApi",
      "offset": 11
    },
    {
      "val": "Post",
      "offset": 33
    }
  ],
  "location": "Test_Steps.usercalls_with_http_request(String,String)"
});
formatter.result({
  "duration": 2943114500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 41
    }
  ],
  "location": "Test_Steps.the_api_call_is_success_with_status_code(int)"
});
formatter.result({
  "duration": 1923000,
  "status": "passed"
});
});
Feature: Validating ReqRes APIs

Scenario: Verify User is addedd successfully
	Given Register API "pass"
	When user calls "RegisterAPI" with "post" http request
	Then the API call got success with status code "200"
	And user extracts the id

Scenario: Verify User is not addedd successfully
	Given Register API "fail"
	When user calls "RegisterAPI" with "post" http request
	Then the API call got success with status code "400"
	And user extracts the id
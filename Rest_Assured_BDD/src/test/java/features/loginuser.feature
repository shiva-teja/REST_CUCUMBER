Feature: Validating ReqRes APIs

Scenario: Verify User is logged successfully
	Given Login API "pass"
	When user calls "LoginAPI" with "post" http request
	Then the API call got success with status code "200"
	And user verifies the response

Scenario: Verify User is not logged successfully
	Given Login API "fail"
	When user calls "LoginAPI" with "post" http request
	Then the API call got success with status code "400"
#	And user verifies the response
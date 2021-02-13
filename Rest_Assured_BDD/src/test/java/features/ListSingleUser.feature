Feature: Validating ReqRes APIs

Scenario: Verify User is listed successfully
	Given List API "pass"
	When user calls "ListAPI" with "get" http request
	Then the API call got success with status code "200"
	And user recieved response data equal to request data
	
Scenario: Verify User is not listed successfully
	Given List API "pass"
	When user calls "ListAPI" with "getfail" http request
	Then the API call got success with status code "404"
	And user recieved response data equal to request data
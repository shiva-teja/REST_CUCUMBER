package step_definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import resources.TestDataBuild;
import resources.Utils;

public class Step_Definition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec ;
	Response response ;
	String responseString;
	TestDataBuild data=new TestDataBuild();

	//	String ID=null;
	@Given("Register API {string}")
	public void register_api(String code) throws IOException {
		if(code.contains("pass"))
		{
			res=given().spec(requestspecification())
					.body(data.registeruser());
		}
		else {
			res=given().spec(requestspecification())
					.body(data.registeruserfail());
		}
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string,String req) {
		resspec=new ResponseSpecBuilder().expectContentType("application/json; charset=utf-8").build();
		if(req.contentEquals("post")) {
			response =res.when().post("/api/register").
					then().spec(resspec).extract().response();
		}
		else if(req.contentEquals("get")) {
			response =res.when().get("/api/users/2").
								then().spec(resspec).extract().response();
		}
		else {
			response =res.when().get("/api/users/2666").
					then().spec(resspec).extract().response();
		}

	}
	@Then("the API call got success with status code {string}")
	public void the_api_call_got_success_with_status_code(String statuscode) {
		responseString=response.asString();
		System.out.println(responseString);
		System.out.println(response.getStatusCode());
		System.out.println(String.valueOf(response.getStatusCode()));
		//		assertEquals(response.getStatusCode(),statuscode);
		assertEquals(String.valueOf(response.getStatusCode()),statuscode);

	}
	@Then("user extracts the id")
	public void user_extracts_the_id() {
		JsonPath js=new JsonPath(responseString);
		System.out.println(js.get("id"));

	}
	@Given("Login API {string}")
	public void login_api(String code) throws IOException {
		if(code.contains("pass"))
		{
			res=given().spec(requestspecification())
					.body(data.loginuser());
		}
		else {
			res=given().spec(requestspecification())
					.body(data.loginuserfail());
		}
	}
	@Then("user verifies the response")
	public void user_verifies_the_response() {
		JsonPath js=new JsonPath(responseString);
		System.out.println(js.get("token"));
		String token=js.get("token");
		if(token.contentEquals("QpwL5tke4Pnpja7X4")) {
			System.out.println("Content is not NULL");
		}
		else {
			System.out.println("Content is"+token);
		}
	}
	@Given("List API {string}")
	public void list_api(String code) throws IOException {
		if(code.contains("pass"))
		{
			res=given().spec(requestspecification());
		}
		else {
			res=given().spec(requestspecification())
					.body(data.loginuserfail());
		}
	}
	@Then("user recieved response data equal to request data")
	public void user_recieved_response_data_equal_to_request_data(){
		JsonPath js=new JsonPath(responseString);
		System.out.println(js.get("data.id"));

	}

}

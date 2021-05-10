package StepDefinationsRunnerandHooks;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class StepdefsUserInfoApi {
	
	static RequestSpecification httprequest;
	static Response response;
	static ResponseBody responseBody;
	static int statusCode=0;
	
	@Given("^user get api to receive response from server$")
	public void user_get_api_to_receive_response_from_server() {
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		httprequest=RestAssured.given();
	}

	@When("^user send the request to the server$")
	public void user_send_the_request_to_the_server() {
		response=httprequest.request(Method.GET);
	}

	@Then("^verify if the status code is$")
	public void verify_if_the_status_code_is() {
		statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@And("^also verify the name and id$")
	public void also_verify_the_name_and_id() {
		responseBody=response.getBody();
		String bodyAsString=responseBody.asString();
		Assert.assertEquals(bodyAsString.contains("Byron’"), true);
	}
}

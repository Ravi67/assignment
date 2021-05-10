package StepDefinationsRunnerandHooks;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class StepdefsCreateUser {

	static RequestSpecification request;
	static Response response;
	static ResponseBody responseBody;
	JSONObject requestParams;
	static int statusCode = 0;

	@Given("^User have a name and job title to create user$")
	public void user_have_a_name_and_job_title_to_create_user() {

		RestAssured.baseURI = "https://reqres.in/api/users";
		request = RestAssured.given();
	}

	@When("^the user send request to create user with params$")
	public void the_user_send_request_to_create_user_with_params() {
		requestParams = new JSONObject();
		requestParams.put("name", "Bryant");
		requestParams.put("job", "BA");
		response = request.post();
	}

	@Then("^to verify that id generated to newly created user$")
	public void to_verify_that_id_generated_to_newly_created_user() {

	}

	@And("^verify the if the status code$")
	public void verify_the_if_the_status_code() {
		statusCode = response.getStatusCode();
		assertEquals(statusCode, "201");
	}

	@And("^verify the json reponse$")
	public void verify_the_json_reponse() {
		responseBody = response.body();
		String bodyAsString = responseBody.asString();
		Assert.assertEquals(bodyAsString, true);
	}

}

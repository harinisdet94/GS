package stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources_Enum;
import resources.API_enum;
import resources.TestData;
import resources.Utils;

public class PostRequestSteps extends Utils {

	ResponseSpecification res1;
	RequestSpecification req1;
	Response response;
	

	@Given("Add program payload with program details")
	public void add_program_payload_with_program_details() throws IOException

	{
		
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms")
				.setContentType(ContentType.JSON).build();
		res1=new ResponseSpecBuilder().expectStatusCode(201).build();

		req1 = given().spec(req).body(TestData.programPayload());
	}

	
	
	
	@When("user call {string} with {string} http request")
	public void user_call_with_http_request(String resource, String method)
	{
		API_enum resource_api = API_enum.valueOf(resource);
		if (method.equalsIgnoreCase("POST"))
		response = req1.post(resource_api.getresource());
	}
	
	@Then("API call is success with status code")
	public void api_call_is_success_with_status_code() {
		
	String s	=response.then().spec(res1).log().all().extract().response().toString();
	System.out.println(s);
	
	
		assertEquals(201,response.getStatusCode());
	}




	
}

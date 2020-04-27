/********************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check status code response
 
 ********************************************************************************************************/

package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class StatusCodeCheckofAPI {
	public static Logger log=Logger.getLogger(StatusCodeCheckofAPI.class);
	Response response;
	@Given("^Enter below enpoints \"([^\"]*)\"$")
	public void i_hit_below_enpoints_https_api_ratesapi_io_api_latest(String url) throws Throwable {
		response = given().when().get(url);
	}

	@When("^I get the success response as (\\d+)$")
	public void i_get_the_success_response_as(int arg1) throws Throwable {
		assertEquals("Incorrect status code",arg1, response.getStatusCode());
	    
	}

	@Then("^I am able to verify the details \"([^\"]*)\"$")
	public void i_am_able_to_verify_the_details(String value) throws Throwable {
		//System.out.println(value+" API is up and running");
		log.info(value+" API is up and running");
	}

}


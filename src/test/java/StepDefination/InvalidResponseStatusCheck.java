/*****************************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check status code in response on providing incorrect Rates API end point
 
 *****************************************************************************************************************/
package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class InvalidResponseStatusCheck {
	Response response;
	public static Logger log=Logger.getLogger(InvalidResponseStatusCheck.class);
	@Test
	@Given("^Enter below invalid enpoints \"([^\"]*)\"$")
	public void i_hit_below_enpoints_https_api_ratesapi_io_api_latest(String url) throws Throwable {
		response = given().when().get(url);
	}

	@When("^I get success response as (\\d+)$")
	public void i_get_the_success_response_as(int arg1) throws Throwable {
		int code=response.getStatusCode();
		//System.out.println(code);
		log.info(code);
		
		
		//try {
			//log.warn("Incorrect url is provided");
			assertEquals("Incorrect status code",400, response.getStatusCode());
			log.info("Got response with error code"+code);

/*		} catch (Exception e) {
			log.fatal("Provided incorrect error");
			log.error(e);
		}*/
	}

	@Then("^I am able to verify details \"([^\"]*)\"$")
	public void verify_the_details(String value) throws Throwable {
		//System.out.println(value+" API Retun error response");
		log.info(value + " API Retun error response");
	}

}

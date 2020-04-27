/*****************************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check Status code  on providing past date Rates APIs end point
 
 *****************************************************************************************************************/

package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;


public class StatusCodeCheckforpastDateAPI {
	public static Logger log=Logger.getLogger(StatusCodeCheckforpastDateAPI.class);
	Response response;
	@Given("^Enter below past date enpoints \"([^\"]*)\"$")
	public void pastDate_Rateapi_date(String url) throws Throwable {
		response = given().when().get(url);
		log.info("Endpoint post to get an response status code");
	}

	@When("^I get the past date response as (\\d+)$")
	public void pastDate__success_response_as(int arg1) throws Throwable {
		if(arg1==200){
		assertEquals("Incorrect status code",arg1, response.getStatusCode());
		log.info("Response Status code >"+response.getStatusCode());
		}
		else{
			String Error = response.jsonPath().getString("error");
			log.info("error>" + Error);
			log.info("Response Status code >"+response.getStatusCode());
			assertEquals("Incorrect status code",arg1, response.getStatusCode());
		}
		//ErrorCodeCheck errorcodecheck= new ErrorCodeCheck();
		//errorcodecheck.errorCheck(arg1,url);
	    
	}

	@Then("^I am able to verify the past date details \"([^\"]*)\"$")
	public void verify_the_detailsofpastDateAPI(String value) throws Throwable {
		//System.out.println(value+" API is up and running");
		log.info(value+" API is validated");
	}

}


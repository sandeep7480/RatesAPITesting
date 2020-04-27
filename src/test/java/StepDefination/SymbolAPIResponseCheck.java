/*****************************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check response  on providing Symbol Rates API end point
 
 *****************************************************************************************************************/
package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Map;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import FunctionLibrary.ResponseDate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class SymbolAPIResponseCheck {
	private SoftAssertions softAssertions;
	Response response;
	public static Logger log = Logger.getLogger(SymbolAPIResponseCheck.class);

	@Given("^Enter below enpoint \"([^\"]*)\"$")
	public void responsecheck(String url) {

		softAssertions = new SoftAssertions();
		response = given().when().get(url);
	}

	@When("^I get Symbol API response as (\\d+)$")
	public void i_sucessResponse_as(int arg1) throws Throwable {
		assertEquals("Incorrect status code", arg1, response.getStatusCode());

	}
	// assertEquals("Correct status code", 200, response.getStatusCode());

	@Then("^I get JSON response$")
	public void jsonResponseCheck() {

		// Get response body
		ResponseBody body = response.getBody();
		// Get response body as string
		String responseStringValue = body.asString();
		// Validate body if it has spefic values
		log.info(responseStringValue);

		String base = response.jsonPath().getString("base");
		String date = response.jsonPath().getString("date");
		Map<String, String> rates = response.jsonPath().getMap("rates");
		log.info("base>" + base);

		
		log.info(rates.get("USD"));
		log.info(rates.get("GBP"));
		
		log.info("date > " + date);
		Assert.assertEquals("EUR", base);
		Assert.assertNotNull(rates.get("USD"));
		Assert.assertNotNull(rates.get("GBP"));
		ResponseDate responsedate = new ResponseDate();
		responsedate.datecheck(date);
		log.info("Symbol API Response body is correct");

	}

}

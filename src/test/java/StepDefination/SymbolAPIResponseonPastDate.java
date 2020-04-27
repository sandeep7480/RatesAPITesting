/*****************************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check response  on providing past date Symbol Rates API end point
 
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

public class SymbolAPIResponseonPastDate {
	private SoftAssertions softAssertions;
	Response response;
	
	public static Logger log = Logger.getLogger(SymbolAPIResponseonPastDate.class);

	@Given("^Enter below SymbolPastDate API enpoint \"([^\"]*)\"$")
	public void SymbolPastDate_responsecheck(String url) {

		softAssertions = new SoftAssertions();
		response = given().when().get(url);
	}

	@When("^I get SymbolPastDate API response as  (\\d+)$")
	public void SymbolPastDateAPI_sucessResponse_as(int arg1) throws Throwable {
		assertEquals("Incorrect status code", arg1, response.getStatusCode());

	}
	

	@Then("^I get SymbolPastDate API JSON response \"([^\"]*)\" and \"([^\"]*)\"$")
	public void SymbolAPI_jsonResponseCheck(String url, String urldate) {

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
		
		log.info("date >" + date);
		
		Assert.assertEquals("EUR", base);
		
		
		Assert.assertNotNull(rates.get("GBP"));
		Assert.assertNotNull(rates.get("USD"));
		//System.out.println(url.contains(Date));
		LocalDate today = LocalDate.now();
		//LocalDate actualdate = LocalDate.parse(date);
		if(url.contains(urldate)){
			Assert.assertTrue(url.contains(urldate));
	        log.info("Date provided in API endpoint is past date");
		}
		else{
			log.info("Date provided in URL is future date");
		}
		ResponseDate responsedate = new ResponseDate();
		responsedate.datecheck(date);
		log.info("Symbol API with past date response body is correct.");
		

	}

}

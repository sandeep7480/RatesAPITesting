/*****************************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check response on providing past date Rates Symbol and Base API end point
 
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

public class PastDateSymbolAndBaseAPIResponse {
	private SoftAssertions softAssertions;
	Response response;
	
	public static Logger log = Logger.getLogger(PastDateSymbolAndBaseAPIResponse.class);

	@Given("^Enter below PastDateSymbolAndBase API enpoint \"([^\"]*)\"$")
	public void PastDateSymbolAndBase_responsecheck(String url) {

		softAssertions = new SoftAssertions();
		response = given().when().get(url);
	}

	@When("^I get PastDateSymbolAndBase API response as  (\\d+)$")
	public void PastDateSymbolAndBaseAPI_sucessResponse_as(int arg1) throws Throwable {
		assertEquals("Incorrect status code", arg1, response.getStatusCode());

	}
	

	@Then("^I get PastDateSymbolAndBase API JSON response \"([^\"]*)\" and \"([^\"]*)\"$")
	public void PastDateSymbolAndBaseAPI_jsonResponseCheck(String url, String urldate) {

		// Get response body
		ResponseBody body = response.getBody();
		// Get response body as string
		String responseStringValue = body.asString();
		// Validate body if it has spefic values
		log.info(responseStringValue);

		String base = response.jsonPath().getString("base");
		String resdate = response.jsonPath().getString("date");
		Map<String, String> rates = response.jsonPath().getMap("rates");
		log.info("base>" + base);

		
		log.info(rates.get("GBP"));
		
		log.info("date >" + resdate);
		
		Assert.assertEquals("USD", base);
		
		
		Assert.assertNotNull(rates.get("GBP"));
		
		//System.out.println(url.contains(Date));
		LocalDate today = LocalDate.now();
		//LocalDate actualdate = LocalDate.parse(date);
		if(url.contains(resdate)){
			Assert.assertTrue(url.contains(resdate));
	        log.info("Date provided in API endpoint is past date");
		}
		else{
			log.info("Date provided in URL is future date");
		}
		ResponseDate responsedate = new ResponseDate();
		responsedate.datecheck(resdate);
		log.info("PastDateSymbolAndBase API response body is correct.");
		

	}

}

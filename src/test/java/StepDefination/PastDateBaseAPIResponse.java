/*****************************************************************************************************************
 Author:Sandeep Dhote
 Create On:27-Apr-2020
 Description: Test cases develop to check response on providing past date Rates Base API end point
 
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

public class PastDateBaseAPIResponse {
	private SoftAssertions softAssertions;
	Response response;
	public static Logger log = Logger.getLogger(PastDateBaseAPIResponse.class);

	@Given("^Enter below PastDateBase API enpoint \"([^\"]*)\"$")
	public void PastDateBase_responsecheck(String url) {

		softAssertions = new SoftAssertions();
		response = given().when().get(url);
	}

	@When("^I get PastDateBase API response as (\\d+)$")
	public void PastDateBase_sucessResponse_as(int arg1) throws Throwable {
		assertEquals("Incorrect status code", arg1, response.getStatusCode());

	}
	

	@Then("^I get PastDateBase API JSON response \"([^\"]*)\" and \"([^\"]*)\"$")
	public void PastDateBaseAPI_jsonResponseCheck(String url, String urldate) {

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
        
		log.info(rates.get("EUR"));
		log.info(rates.get("USD"));
		log.info(rates.get("GBP"));
		log.info(rates.get("HKD"));
		log.info(rates.get("LVL"));
		log.info(rates.get("IDR"));
		log.info(rates.get("ILS"));
		log.info(rates.get("DKK"));
		log.info(rates.get("INR"));
		log.info(rates.get("CHF"));
		log.info(rates.get("MXN"));
		log.info(rates.get("CZK"));
		log.info(rates.get("SGD"));
		log.info(rates.get("THB"));
		log.info(rates.get("HRK"));
		log.info(rates.get("MYR"));
		log.info(rates.get("NOK"));
		log.info(rates.get("CNY"));
		log.info(rates.get("BGN"));
		log.info(rates.get("PHP"));
		log.info(rates.get("SEK"));
		log.info(rates.get("PLN"));
		log.info(rates.get("ZAR"));
		log.info(rates.get("CAD"));
		log.info(rates.get("ISK"));
		log.info(rates.get("BRL"));
		log.info(rates.get("RON"));
		log.info(rates.get("NZD"));
		log.info(rates.get("TRY"));
		log.info(rates.get("JPY"));
		log.info(rates.get("RUB"));
		log.info(rates.get("KRW"));
		log.info(rates.get("USD"));
		log.info(rates.get("HUF"));
		log.info(rates.get("AUD"));
		log.info(rates.get("LTL"));
		log.info(rates.get("EEK"));
		
		log.info("responsedate >" + resdate);
		
		Assert.assertEquals("USD", base);
		
		//Assert.assertNotNull(rates.get("ILS"));
		Assert.assertNotNull(rates.get("USD"));
		Assert.assertNotNull(rates.get("EUR"));
		Assert.assertNotNull(rates.get("GBP"));
		Assert.assertNotNull(rates.get("HKD"));
		Assert.assertNotNull(rates.get("LVL"));
		Assert.assertNotNull(rates.get("IDR"));
		Assert.assertNotNull(rates.get("DKK"));
		Assert.assertNotNull(rates.get("INR"));
		Assert.assertNotNull(rates.get("CHF"));
		Assert.assertNotNull(rates.get("MXN"));
		Assert.assertNotNull(rates.get("CZK"));
		Assert.assertNotNull(rates.get("SGD"));
		Assert.assertNotNull(rates.get("THB"));
		Assert.assertNotNull(rates.get("HRK"));
		Assert.assertNotNull(rates.get("MYR"));
		Assert.assertNotNull(rates.get("NOK"));
		Assert.assertNotNull(rates.get("CNY"));
		Assert.assertNotNull(rates.get("BGN"));
		Assert.assertNotNull(rates.get("PHP"));
		Assert.assertNotNull(rates.get("SEK"));
		Assert.assertNotNull(rates.get("PLN"));
		Assert.assertNotNull(rates.get("ZAR"));
		Assert.assertNotNull(rates.get("CAD"));
		Assert.assertNotNull(rates.get("BRL"));
		Assert.assertNotNull(rates.get("RON"));
		Assert.assertNotNull(rates.get("NZD"));
		Assert.assertNotNull(rates.get("TRY"));
		Assert.assertNotNull(rates.get("JPY"));
		Assert.assertNotNull(rates.get("RUB"));
		Assert.assertNotNull(rates.get("KRW"));
		Assert.assertNotNull(rates.get("USD"));
		Assert.assertNotNull(rates.get("HUF"));
		Assert.assertNotNull(rates.get("AUD"));
		Assert.assertNotNull(rates.get("LTL"));
		Assert.assertNotNull(rates.get("EEK"));
		
		if(urldate.contains(resdate)){
			Assert.assertTrue(url.contains(resdate));
	        log.info("Date provided in API endpoint is past date");
		}
		else{
			log.info("Date provided in URL is future date");
		}

		ResponseDate responsedate = new ResponseDate();
		responsedate.datecheck(resdate);
		log.info("PastDated Base API response body is correct");

	}

}

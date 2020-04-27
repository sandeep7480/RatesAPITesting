#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response matches with current dateresponse on providing future Date RatesAPI.

  @JSONResponseforfutureDate
  Scenario Outline: Verify Rate API response with future date
    Given Enter below FutureDates Rates APIs with "<futureDateurl>" and "<currentDateurl>"
    When I get Future Date Rates APIs JSONresponse as <code>
    Then I get Rates APIs matching JSON response

    Examples: 
      | futureDateurl                                               | code | currentDateurl                                              |
      | https://api.ratesapi.io/api/2020-12-07                      |  200 | https://api.ratesapi.io/api/2020-12-07                      |
      | https://api.ratesapi.io/api/2020-05-29?symbols=USD,GBP      |  200 | https://api.ratesapi.io/api/2020-04-24?symbols=USD,GBP      |
      | https://api.ratesapi.io/api/2020-05-22?base=USD             |  200 | https://api.ratesapi.io/api/2020-04-24?base=USD             |
      | https://api.ratesapi.io/api/2020-05-23?base=USD&symbols=GBP |  200 | https://api.ratesapi.io/api/2020-04-24?base=USD&symbols=GBP |

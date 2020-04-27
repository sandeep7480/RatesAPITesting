#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response matches with current date on providing future Date RatesAPI.

  @JSONResponseforfutureDate
  Scenario Outline: Verify Rate API response with future date
    Given Enter below Rates APIs with  "<futureDateurl>"
    When I get Rates APIs response as <code>
    Then I get Rates APIs JSON response on providing "<futureDateurl>" and "<urlDate>"

    Examples: 
      | futureDateurl                                               | code | urlDate    |
      | https://api.ratesapi.io/api/2020-12-07                      |  200 | 2020-12-07 |
      | https://api.ratesapi.io/api/2020-05-29?symbols=USD,GBP      |  200 | 2020-05-21 |
      | https://api.ratesapi.io/api/2020-05-22?base=USD             |  200 | 2020-05-22 |
      | https://api.ratesapi.io/api/2020-05-23?base=USD&symbols=GBP |  200 | 2020-05-23 |

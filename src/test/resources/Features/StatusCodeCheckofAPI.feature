#Author:Sandeep Dhote
#Created on 24-April-2020
Feature: Status code check by providing correct Rates APIs endpoint.

  @APIStatusCodeCheck
  Scenario Outline: To Check status code of all Rates APIs
    Given Enter below enpoints "<url>"
    When I get the success response as 200
    Then I am able to verify the details "<value>"

    Examples: 
      | url                                                     | value        |
      | https://api.ratesapi.io/api/latest                      | latest       |
      | https://api.ratesapi.io/api/latest?symbols=USD,GBP      | Symbols      |
      | https://api.ratesapi.io/api/latest?base=USD             | base         |
      | https://api.ratesapi.io/api/latest?base=USD&symbols=GBP | Symbols_base |

#Author:Sandeep Dhote
#Created on 24-April-2020
Feature: Status code check by providing incorrect Rates APIs endpoint.

  @IncorrectAPIsStatuscodeCheck
  Scenario Outline: To Check status code of all Rates APIs
    Given Enter below invalid enpoints "<url>"
    When I get success response as 400
    Then I am able to verify details "<value>"

    Examples: 
      | url                                                     | value        |
      | https://api.ratesapi.io/api/                            | latest       |
      | https://api.ratesapi.io/api/latest?symbols=USD,GBK      | Symbols      |
      | https://api.ratesapi.io/api/latest?base=USZ             | base         |
      | https://api.ratesapi.io/api/latest?base=USD&symbols=GBO | Symbols_base |

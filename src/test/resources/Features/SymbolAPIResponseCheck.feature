#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Rates API with Symbol

  @JSONResponseCheck
  Scenario Outline: Verify response body of each API
    Given Enter below enpoint "<url>"
    When I get Symbol API response as 200
    Then I get JSON response
    Examples: 
      | url                                                |
      | https://api.ratesapi.io/api/latest?symbols=USD,GBP |

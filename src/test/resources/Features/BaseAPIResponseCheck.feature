#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Rates API with Base 

  @JSONResponseCheck
  Scenario Outline: Verify response body of latest API
    Given Enter below base API enpoint "<url>"
    When I get base API response as 200
    Then I get base API JSON response

    Examples: 
      | url                                         |
      | https://api.ratesapi.io/api/latest?base=USD |

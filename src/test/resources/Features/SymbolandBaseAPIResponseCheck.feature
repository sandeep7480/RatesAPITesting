#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Rates API with Symbol&Base 

  @JSONResponseCheck
  Scenario Outline: Verify response body of each API
    Given Enter below Symbol and Base API enpoint "<url>"
    When I get Symbol and Base API response as 200
    Then I get Symbol and Base API JSON response

    Examples: 
      | url                                                     |
      | https://api.ratesapi.io/api/latest?base=USD&symbols=GBP |

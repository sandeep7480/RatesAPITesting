#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Lates Rates API

  @JSONResponseCheck
  Scenario Outline: Verify response body of latest API
    Given Enter below latest API enpoint "<url>"
    When I get latest API response as 200
    Then I get latest API JSON response

    Examples: 
      | url                                |
      | https://api.ratesapi.io/api/latest |

#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Date Rates API with past and specific date.

  @JSONResponseonSpecificdate
  Scenario Outline: Verify response body of latest API
    Given Enter below Date API enpoint "<url>"
    When I get Date API response as <code>
    Then I get Date API JSON response "<url>" and "<Date>"

    Examples: 
      | url                                    | code | Date       |
      | https://api.ratesapi.io/api/2010-01-12 |  200 | 2010-01-12 |

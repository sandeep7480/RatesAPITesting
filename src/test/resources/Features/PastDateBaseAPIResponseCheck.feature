#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Base Rates API with past and specific date.

  @JSONResponseonSpecificdate
  Scenario Outline: Verify response body of latest API
    Given Enter below PastDateBase API enpoint "<url>"
    When I get PastDateBase API response as <code>
    Then I get PastDateBase API JSON response "<url>" and "<urlDate>"

    Examples: 
      | url                                             | code | urlDate    |
      | https://api.ratesapi.io/api/2010-01-12?base=USD |  200 | 2010-01-12 |

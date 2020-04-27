#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Symbol and Base Rates API with past and specific date.

  @JSONResponseonSpecificdate
  Scenario Outline: Verify response body of latest API
    Given Enter below PastDateSymbolAndBase API enpoint "<url>"
    When I get PastDateSymbolAndBase API response as  <code>
    Then I get PastDateSymbolAndBase API JSON response "<url>" and "<Date>"

    Examples: 
      | url                                                         | code | Date       |
      | https://api.ratesapi.io/api/2010-01-12?base=USD&symbols=GBP |  200 | 2010-01-12 |

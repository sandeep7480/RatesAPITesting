#Author: sandeep Dhote
#Created on 24-April-2020
Feature: JSON response body check on providing Symbol Rates API with past and specific date.

  @JSONResponseonSpecificdate
  Scenario Outline: Verify response body of latest API
    Given Enter below SymbolPastDate API enpoint "<url>"
    When I get SymbolPastDate API response as  <code>
    Then I get SymbolPastDate API JSON response "<url>" and "<Date>"

    Examples: 
      | url                                                    | code | Date       |
      | https://api.ratesapi.io/api/2010-01-12?symbols=USD,GBP |  200 | 2010-01-12 |

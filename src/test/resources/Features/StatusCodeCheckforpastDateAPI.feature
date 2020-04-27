#Author:Sandeep Dhote
#Created on 24-April-2020
Feature: Status code and error messages validation by providing Rates APIs with past and invalid dates.

  @APIStatusCodeCheckwithPastDate
  Scenario Outline: To Check status code of all Rates APIs
    Given Enter below past date enpoints "<url>"
    When I get the past date response as <code>
    Then I am able to verify the past date details "<value>"

    Examples: 
      | url                                                         | code | value        |
      | https://api.ratesapi.io/api/2010-01-12                      |  200 | Date         |
      | https://api.ratesapi.io/api/2010-01-12?symbols=USD,GBP      |  200 | Symbols      |
      | https://api.ratesapi.io/api/2010-01-12?base=USD             |  200 | Base         |
      | https://api.ratesapi.io/api/2010-01-12?base=USD&symbols=GBP |  200 | Symbols&Base |
      | https://api.ratesapi.io/api/2010-01-12                      |  200 | Date         |
      | https://api.ratesapi.io/api/2010-01-12                      |  200 | Date         |
      | https://api.exchangeratesapi.io/api/1999-01-04              |  200 | Date         |
      | https://api.exchangeratesapi.io/api/1999-02-29              |  400 | Date         |
      | https://api.exchangeratesapi.io/api/0000-02-29              |  400 | Date         |
      | https://api.exchangeratesapi.io/api/1999-13-29              |  400 | Date         |
      | https://api.exchangeratesapi.io/api/1999-13-00              |  400 | Date         |

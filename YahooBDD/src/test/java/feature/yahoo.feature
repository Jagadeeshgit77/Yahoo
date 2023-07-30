Feature: Yahoo registration form

  Scenario Outline: Validate Login
    Given User is on login page
    When User enters details as <firstname> and <lastname>
    When User enters <Newemail> and <domain>
    When User enters <password>
    When User enter DOB as month <day> and <year>
    And User clicks on Countinue
    Then User enters mobile number

    Examples: 
      | firstname  | lastname  | Newemail         | domain  | day | year | password  |
      | Palavalasa | Jagadeesh | pavalasarecuit77 | myyahoo |  20 | 1999 | Recruit77 |

Feature: Login


  Scenario Outline: Register with valid data
    Given user has base url
    When user will enter '<firstName>' and '<lastName>' and '<emailAddress>'
    And enter '<password>' and '<reEnterPassword>'
    And click on the Register button
    Then User will register successfully

    Examples:
    |firstName|lastName| emailAddress  |password|reEnterPassword|
    |   AL    |IMRAN   |imran@gmail.com|1232435 |   1232435     |


  Scenario: click on reset
    When User will click on Reset button
    Then Fields will be blank

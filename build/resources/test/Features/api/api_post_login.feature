Feature: Login feature

  Scenario Outline: Validate response for login API
    Given User has '<end_point>' for single user
    When User will enter '<email>' and '<password>' for login
    And Post the request and validate the response code
    And Get the response body
    Then Validate the response for login API

    Examples:
    |end_point|email             |password  |
    |login    |eve.holt@reqres.in|cityslicka|

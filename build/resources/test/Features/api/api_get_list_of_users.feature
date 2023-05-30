Feature: Get List of Users

  Scenario Outline: Validate Get List of Users
    Given User has end point of usr list '<endPoint>'
    When User will hit url and header
    And Validate the response code of list user
    Then User will get the response

    Examples:
    |endPoint|
    |users?page=2|


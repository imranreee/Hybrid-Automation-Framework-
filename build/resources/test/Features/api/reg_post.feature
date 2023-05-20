Feature: User registration

  Scenario Outline: Validate user registration request and response
    Given User has the registration API '<apiPath>'
    When User will send '<email>' and '<password>'
    And Validate the response code
    And Get the API response
    Then Validate the response

    Examples:
    | apiPath  | email              | password |
    | register | eve.holt@reqres.in | pistol |



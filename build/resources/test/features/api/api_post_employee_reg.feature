Feature: Employee Registration

  Scenario Outline: Check user registration successfully or not
    Given User has the API '<path>'
    When User hit '<name>' and '<jobTitle>'
    And Call the API with body
    Then It will return created data

    Examples:
    |path |name |jobTitle|
    |users|imran|SDET    |
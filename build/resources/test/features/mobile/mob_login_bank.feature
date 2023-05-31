Feature: Login to Bank

  Scenario Outline: Login to ERI bank
    Given User has apk
    When User will enter '<username>' and '<password>'
    And Click on Login button
    Then Logged in successfully

    Examples:
    |username|password|
    | company|company|




Feature: Bank Manager Login

  @practice
  Scenario Outline: Add Customer
    Given User has base URL
    When User will click on Add Customer button
    And Enter '<firstName>' and '<lastName>' and '<postCode>'
    And Click on Add Customer button
    Then Customer will be added successfully

    Examples:
      |firstName|lastName|postCode|
      |   AL    |IMRAN   |1227    |
Feature: Bank Account create and delete

  @practice
  Scenario Outline: Add Customer
    Given User has base URL
    When User will click on Bank manager loign button
    And User will click on Add customer button
    And Enter '<firstName>' and '<lastName>' and '<postCode>'
    And Click on Add Customer button
    Then Customer will be added successfully

    Examples:
      |firstName|lastName|postCode|
      |   AL    |IMRAN   |1227    |

  @practice
  Scenario: Open Account
    When User will click on Open Account
    And User will select created customer from list
    And User will select country from list
    And User will click on Proceed button
    Then Account will be created successfully

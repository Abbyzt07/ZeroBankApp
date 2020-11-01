Feature: check the accounts summary

  Scenario: control the title
    Given the user is logged in
    When the user is on the account summary page
    Then the title should be "Zero - Account Summary"

  Scenario: page should have following types
    Given the user is logged in
    And the user is on the account summary page
    Then page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: credit accounts table
    Given the user is logged in
    And the user is on the account summary page
    Then credit accounts table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |
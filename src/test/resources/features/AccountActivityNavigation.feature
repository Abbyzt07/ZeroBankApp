Feature: Navigating to spesific accounts in Acoounts Activity


  Scenario Outline: <AccountType> account redirect
    Given the user is logged in
    When the user clicks on "<AccountType>" link on the Account Summary Page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<AccountType>" selected

    Examples:
      | AccountType |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |
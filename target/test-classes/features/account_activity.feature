Feature: account activity

  Scenario: title of page
    Given the user is logged in
    When the user navigates "Account Activity" tab
    Then the title should be "Zero - Account Activity"

  Scenario: dropdown default option
    Given the user is logged in
    When the user navigates "Account Activity" tab
    Then account dropdown default option should be Savings


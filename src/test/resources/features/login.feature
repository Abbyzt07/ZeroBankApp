@login
Feature: login conditions

  Background:
    Given the user is on the login page

  Scenario: only authorized users should be able to login
    When user logs with valid credentials
    Then account summary page should be displayed

  Scenario: with wrong username or password
    When user logs with wrong username or password
    Then user should not be able to login
    And Login and-or password are wrong should be displayed

  Scenario: with blank username or password
    When user logs with blank username or password
    Then user should not be able to login
    And Login and-or password are wrong should be displayed
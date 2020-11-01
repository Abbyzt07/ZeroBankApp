Feature: Find Transactions in Account Activity

  Scenario: Search date range
    Given the user accesses the Find Transaction tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And click search
    Then results table should be only transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And click search
    Then results table should be only transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"
  @wip
  Scenario: Search description
    Given the user accesses the Find Transaction tab
    When the user enters description "ONLINE"
    And click search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And click search
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"
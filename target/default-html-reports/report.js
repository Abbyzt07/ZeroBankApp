$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/FindTransactions.feature");
formatter.feature({
  "name": "Find Transactions in Account Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search description",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user accesses the Find Transaction tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.the_user_accesses_the_Find_Transaction_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters description \"ONLINE\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.the_user_enters_description(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click search",
  "keyword": "And "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.click_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show descriptions containing \"ONLINE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.results_table_should_only_show_descriptions_containing(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters description \"OFFICE\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.the_user_enters_description(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click search",
  "keyword": "And "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.click_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show descriptions containing \"OFFICE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.results_table_should_only_show_descriptions_containing(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should not show descriptions containing \"ONLINE\"",
  "keyword": "But "
});
formatter.match({
  "location": "com.bitrix.stepdefinitions.FindTransactionDefs.results_table_should_not_show_descriptions_containing(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
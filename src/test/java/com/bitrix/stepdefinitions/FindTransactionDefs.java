package com.bitrix.stepdefinitions;

import com.bitrix.pages.AccountActivityPage;
import com.bitrix.pages.AccountSummaryPage;
import com.bitrix.pages.LoginPage;
import com.bitrix.pages.MainPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionDefs {

    @Given("the user accesses the Find Transaction tab")
    public void the_user_accesses_the_Find_Transaction_tab() {
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        new MainPage().navigateToModule("Account Activity","Find Transactions");

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().toDate.clear();
        new AccountActivityPage().fromDate.sendKeys(string);
        new AccountActivityPage().toDate.sendKeys(string2);
    }

    @When("click search")
    public void click_search() {
        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should be only transactions dates between {string} to {string}")
    public void results_table_should_be_only_transactions_dates_between_to(String string, String string2) throws ParseException {
        new AccountActivityPage().verifyDateRange("2012-09-01", "2012-09-06",new AccountActivityPage().filteredTransactions);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        new AccountActivityPage().isSorted();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(new AccountActivityPage().filteredTransactions);
        List<Date> actualDates = new ArrayList<>();
        Date unwantedDate = dateFormat.parse(date);
        for (String stringDate : datesString) {
            actualDates.add(dateFormat.parse(stringDate));
        }
        for (Date actualDate : actualDates) {
            System.out.println(actualDate + " " + unwantedDate);
            Assert.assertNotEquals(actualDate, unwantedDate);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        new AccountActivityPage().descriptionBox.clear();
        new AccountActivityPage().descriptionBox.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        new AccountActivityPage().checkDescription(string);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        new AccountActivityPage().dontShowDescription(string);
    }

}

package com.bitrix.stepdefinitions;

import com.bitrix.pages.AccountSummaryPage;
import com.bitrix.pages.MainPage;
import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));

    }

    @When("the user is on the account summary page")
    public void the_user_is_on_the_account_summary_page() {
        MainPage accountSummaryPage = new MainPage();

    }

    @Then("the title should be {string}")
    public void the_title_should_be(String title) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(title));
    }

    @Then("page should have following account types")
    public void page_should_have_following_account_types(List<String> accountTypes) {
        BrowserUtils.waitFor(2);
        List<String> actualTypes = BrowserUtils.getElementsText(Driver.get().findElements(By.tagName("h2")));
        Assert.assertEquals(accountTypes,actualTypes);
    }

    @Then("credit accounts table must have following columns")
    public void credit_accounts_table_must_have_following_columns(List<String> creditAccountsTable) {
        BrowserUtils.waitFor(5);
        List<String> actualTable = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsTable);
        Assert.assertEquals(creditAccountsTable,actualTable);
        System.out.println("creditAccountsTb = " + creditAccountsTable);
        System.out.println("actualTable = " + actualTable);
    }



}

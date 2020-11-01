package com.bitrix.stepdefinitions;

import com.bitrix.pages.AccountActivityPage;
import com.bitrix.pages.AccountSummaryPage;
import com.bitrix.pages.MainPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityDefs {

    @When("the user navigates {string} tab")
    public void the_user_navigates_tab(String string) {
        new MainPage().accountActivityTab.click();
    }

    @Then("account dropdown default option should be Savings")
    public void account_dropdown_default_option_should_be_Savings() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(new AccountActivityPage().dropdownSavings.isDisplayed());
    }

    @When("the user clicks on {string} link on the Account Summary Page")
    public void the_user_clicks_on_link_on_the_Account_Summary_Page(String element) {
        new AccountSummaryPage().clickElement(element);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(string));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selectedDropDown) {
        new AccountActivityPage().selectedDropDown(selectedDropDown);
    }

}

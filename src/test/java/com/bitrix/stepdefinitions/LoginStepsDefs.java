package com.bitrix.stepdefinitions;

import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepsDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("user logs with valid credentials")
    public void user_logs_with_valid_credentials() {
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @Then("account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        String expectedTitle = "Account Summary";
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @When("user logs with wrong username or password")
    public void user_logs_with_wrong_username_or_password() {
        new LoginPage().login("asderwgh",ConfigurationReader.get("password"));
    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {
        String expectedUrl = "http://zero.webappsecurity.com/login.html?login_error=true";
        Assert.assertEquals(expectedUrl,Driver.get().getCurrentUrl());
    }

    @Then("Login and-or password are wrong should be displayed")
    public void login_and_or_password_are_wrong_should_be_displayed() {
        Driver.get().findElement(By.xpath("//div[@class='alert alert-error']")).isDisplayed();
    }

    @When("user logs with blank username or password")
    public void user_logs_with_blank_username_or_password() {
        new LoginPage().login("",ConfigurationReader.get("password"));
    }

}

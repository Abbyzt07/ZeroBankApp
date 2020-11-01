package com.bitrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(xpath = "//title")
    public WebElement title;

    @FindBy(xpath = "//h2[text()='Cash Accounts']")
    public WebElement cashAccounts;

    @FindBy(xpath = "//h2[text()='Investment Accounts']")
    public WebElement investmentAccounts;

    @FindBy(xpath = "//h2[text()='Credit Accounts']")
    public WebElement creditAccounts;

    @FindBy(xpath = "//h2[text()='Loan Accounts']")
    public WebElement loanAccounts;



}

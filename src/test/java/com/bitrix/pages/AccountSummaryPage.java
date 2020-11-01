package com.bitrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends MainPage{

    @FindBy(xpath = "(//table)[3]//th")
    public List<WebElement> creditAccountsTable;

    @FindBy(linkText = "Savings")
    public WebElement savings;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(linkText = "Loan")
    public WebElement loan;


    public void clickElement(String element) {
        if (element.equals("Savings")) {
            savings.click();
        } else if (element.equals("Brokerage")) {
            brokerage.click();
        } else if (element.equals("Checking")) {
            checking.click();
        } else if (element.equals("Credit Card")) {
            creditCard.click();
        } else if (element.equals("Loan")) {
            loan.click();
        }
    }

}

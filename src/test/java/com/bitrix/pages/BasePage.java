package com.bitrix.pages;

import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public abstract class BasePage {

    @FindBy(linkText = "Zero Bank")
    public WebElement pageSubtitle;

    @FindBy(id = "searchTerm")
    public WebElement searchBox;

    @FindBy(linkText = "Account Summary")
    public WebElement accountSummaryTab;

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivityTab;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFundsTab;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBillsTab;

    @FindBy(linkText = "My Money Map")
    public WebElement myMoneyMapTab;

    @FindBy(linkText = "Online Statements")
    public WebElement onlineStatementsTab;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle
        BrowserUtils.waitForStaleElement(pageSubtitle);
        return pageSubtitle.getText();
    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     */
    public void navigateToModule(String tab) {
        try {
            BrowserUtils.waitForPresenceOfElement(By.linkText(tab), 5);
            BrowserUtils.waitForVisibility(By.linkText(tab), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.linkText(tab)));
            Driver.get().findElement(By.linkText(tab)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.linkText(tab)),  5);
        }
    }

    public void navigateToModule(String tab, String subTab) {
        try {
            BrowserUtils.waitForPresenceOfElement(By.linkText(tab), 5);
            BrowserUtils.waitForVisibility(By.linkText(tab), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.linkText(tab)));
            Driver.get().findElement(By.linkText(tab)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.linkText(tab)),  5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.linkText(subTab), 5);
            BrowserUtils.waitForVisibility(By.linkText(subTab), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.linkText(tab)));
            Driver.get().findElement(By.linkText(subTab)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.linkText(subTab)),  5);
        }
    }



}

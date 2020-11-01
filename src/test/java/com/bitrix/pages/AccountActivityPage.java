package com.bitrix.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends MainPage{

    @FindBy(xpath = "//select[@id='aa_accountId']/option[1]")
    public WebElement dropdownSavings;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[2]")
    public WebElement dropdownChecking;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[3]")
    public WebElement dropdownSavings2;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[4]")
    public WebElement dropdownLoan;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[5]")
    public WebElement dropdownCreditCard;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[6]")
    public WebElement dropdownBookerage;

    @FindBy(tagName = "title")
    public WebElement title;

    @FindBy(linkText = "Show Transactions")
    public WebElement showTrasactions;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> filteredTransactions;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> filterForDescription;

    public void verifyDateRange(String fromDate,String toDate, List<WebElement> transactedDates) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDt = simpleDateFormat.parse(fromDate);
        Date toDt = simpleDateFormat.parse(toDate);
        for (WebElement date : transactedDates) {
            String dateText = date.getText();
            Date formattedDate = simpleDateFormat.parse(dateText);
            Assert.assertTrue(formattedDate.compareTo(fromDt)>=0 & formattedDate.compareTo(toDt)<=0);
        }
    }

    public void isSorted() throws ParseException {
        List<Date> sort = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for(WebElement each : filteredTransactions){
            sort.add(simpleDateFormat.parse(each.getText()));
        }
        for (int i = 0; i < filteredTransactions.size()-1; i++) {
             Assert.assertTrue(sort.get(i).compareTo(sort.get(i+1))>=0);

        }
    }

    public void selectedDropDown(String type){
        if(type.equals("Savings")){
            Assert.assertTrue(dropdownSavings.isSelected());
        }else if(type.equals("Brokerage")){
            Assert.assertTrue(dropdownBookerage.isSelected());
        }else if(type.equals("Checking")){
            Assert.assertTrue(dropdownChecking.isSelected());
        }else if(type.equals("Credit Card")){
            Assert.assertTrue(dropdownCreditCard.isSelected());
        }else if(type.equals("Loan")){
            Assert.assertTrue(dropdownLoan.isSelected());
        }
    }

    public void checkDescription(String description){
        for (WebElement element : filterForDescription) {
            Assert.assertTrue(element.getText().contains(description));
        }
    }

    public void dontShowDescription(String description){
        for (WebElement element : filterForDescription) {
            Assert.assertFalse(element.getText().contains(description));
        }
    }
}

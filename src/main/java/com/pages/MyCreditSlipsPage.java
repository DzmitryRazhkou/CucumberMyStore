package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCreditSlipsPage {

    private MyStorePage myStorePage;
    private AccountPage accountPage;

    private WebDriver driver;
    private WebDriverWait wait;

    public MyCreditSlipsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //    VALIDATE BREADCRUMB:

    private WebElement getMyCreditSlips() {
        By myCreditSlipsLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myCreditSlipsLocator));
        return driver.findElement(myCreditSlipsLocator);
    }

    public boolean getMyCreditSlipsBreadCrumb() {
        try {
            System.out.println(" ===> My credit slips breadcrumb is displayed. <=== ");
            System.out.println(getMyCreditSlips().getText());
            return getMyCreditSlips().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyCreditSlipsPageTitle(){
        System.out.println(" =====> My credit slips page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    Message:

    public String getMessage() {
        By messageLocator = By.cssSelector("#block-history:first-of-type");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
        String messageText = driver.findElement(messageLocator).getText();
        System.out.println(" =====> " +messageText+ " <===== ");
        return messageText;
    }

//    Back to your Account:

    private WebElement getBackToYourAccount(){
        By getBackToYourAccountLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public AccountPage doClickBackToToYourAccount(){
        getBackToYourAccount().click();
        return new AccountPage(driver);
    }

//    Home:

    private WebElement getHome(){
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[3]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome(){
        getHome().click();
        return new MyStorePage(driver);
    }

}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //    1. By Locators:
    private By emailId = By.id("email");
    private By passwordId = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.cssSelector("[title^='Recover your forgotten password']");

//    2. Constructor of the page class:

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//    3. Page actions: features (Behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(forgotPwdLink));
            return driver.findElement(forgotPwdLink).isDisplayed();
        } catch (TimeoutException error) {
            return false;
        }
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordId).sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    public AccountPage doLogin(String un, String pwd) {
        System.out.println("We going to log in using " + un + " and " + pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(passwordId).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountPage(driver);
    }
}

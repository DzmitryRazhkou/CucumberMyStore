package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverFactory {

    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return
     */

    public WebDriver initDriver(String browser) {
        System.out.println("Browser Value is: " + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());

        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            tlDriver.set(new SafariDriver());

        } else {
            System.out.println("Pass the Correct Browser Value: " + browser);
        }

//      WebDriver driver:

        getWebDriver().manage().deleteAllCookies();
        getWebDriver().manage().window().maximize();
        return getWebDriver();
    }

/**
*
* @return WebDriverWait wait
*/



/**
* this is used to get driver with ThreadLocal
* @return
*/

    public static synchronized WebDriver getWebDriver() {
        return tlDriver.get();   // WebDriver driver:
    }
}

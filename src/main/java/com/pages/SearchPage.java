package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getSearch() {
        By orderHistoryLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public boolean getSearchBreadCrumb() {
        try {
            System.out.println(" ===> Search breadcrumb is displayed. <=== ");
            System.out.println(getSearch().getText());
            return getSearch().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getSearchPageTitle() {
        System.out.println(" =====> Search page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    PRODUCT COUNT:

    public boolean getProductCount() {
        By productCountLocator = By.xpath("(//div[@class='product-count'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCountLocator));
        try {
            WebElement productCount = driver.findElement(productCountLocator);
            System.out.println("Text is: " + productCount.getText());
            return productCount.isDisplayed();
        } catch (TimeoutException y) {
            System.out.println("Provide an another locator");
        }
        return false;
    }

    public boolean getProduct(String productName) {
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        List<WebElement> productList = driver.findElements(getProductLocator);
        for (WebElement s : productList) {
            if (s.getText().trim().contains(productName) && s.isDisplayed()) {
                System.out.println("Product list contains: " +s.getText().trim());
                return true;
            }
        }
        return false;
    }

//    MORE BUTTON:

    private WebElement getProduct() {
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        return driver.findElement(getProductLocator);
    }

    public void doClickOnProduct() {
        getProduct().click();
    }

//    ADD TO CART (FROM FADED SHORT SLEEVE SHIRT):

    public WebElement getIFrame() {
        By iframeLocator = By.cssSelector("iframe[class='fancybox-iframe']");
        wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        return driver.findElement(iframeLocator);
    }

    public WebElement getQuantity() {
        By quantityLocator = By.cssSelector("input#quantity_wanted");
        wait.until(ExpectedConditions.presenceOfElementLocated(quantityLocator));
        return driver.findElement(quantityLocator);
    }

    public WebElement getPlusBtn() {
        By plusLocator = By.cssSelector("i.icon-plus");
        wait.until(ExpectedConditions.presenceOfElementLocated(plusLocator));
        return driver.findElement(plusLocator);
    }

    public WebElement getMinusBtn() {
        By minusLocator = By.cssSelector("i.icon-minus");
        wait.until(ExpectedConditions.presenceOfElementLocated(minusLocator));
        return driver.findElement(minusLocator);
    }

    public void getSize(String index) {
        By sizeLocator = By.cssSelector("select#group_1");
        wait.until(ExpectedConditions.presenceOfElementLocated(sizeLocator));
        WebElement size = driver.findElement(sizeLocator);

        Select sel = new Select(size);
        sel.selectByIndex(Integer.parseInt(index));
    }

    public WebElement getColor() {
        By colorLocator = By.cssSelector("ul#color_to_pick_list>li:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(colorLocator));
        return driver.findElement(colorLocator);
    }

    public WebElement getAddToCartButton() {
        By addToCartLocator = By.cssSelector("button[name='Submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLocator));
        return driver.findElement(addToCartLocator);
    }

    public boolean getSuccessMessageSearchPage() {
        By successMessageLocator = By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2");
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        WebElement successMessage = driver.findElement(successMessageLocator);
        System.out.println("Success message: " + successMessage.getText());
        return successMessage.isDisplayed();
    }

    public void customWait() {
        By addToCartChangedStateLocator = By.cssSelector("button[class='exclusive added']");
        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(addToCartChangedStateLocator);
            } catch (NoSuchElementException yy) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    private WebElement getProceedToCheckOutBtn() {
        By proceedToCheckOutBtnLocator = By.cssSelector("div[class='layer_cart_cart col-xs-12 col-md-6'] div a");
        wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckOutBtnLocator));
        return driver.findElement(proceedToCheckOutBtnLocator);
    }

    public OrderPage proceedToOrderPage() {
        getProceedToCheckOutBtn().click();
        return new OrderPage(driver);
    }

}

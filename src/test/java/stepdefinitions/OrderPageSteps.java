package stepdefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OrderPageSteps {


    private final OrderPage orderPage = new OrderPage(DriverFactory.getWebDriver());

    @When("User clicks at the proceed to order page")
    public void user_clicks_at_the_proceed_to_order_page() {

    }

    @When("User navigates at the order page")
    public void user_navigates_at_the_order_page() {
        Assert.assertTrue(orderPage.getYourShoppingCartBreadCrumb());
    }

    @Then("Page title of the order page should be {string}")
    public void page_title_of_the_order_page_should_be(String expOrderPageTitle) {
        String actOrderPageTitle = orderPage.getOrderPageTitle();
        Assert.assertEquals(expOrderPageTitle, actOrderPageTitle);
    }

    @Then("User validates prices")
    public void user_validates_prices() {
        Assert.assertEquals(orderPage.price(), orderPage.getTotal(), .01);
    }

}

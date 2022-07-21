package stepdefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchPageSteps {

    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private SearchPage searchPage = new SearchPage(DriverFactory.getWebDriver());
    private OrderPage orderPage = new OrderPage(DriverFactory.getWebDriver());

    @When("User enters in the search field {string}")
    public void user_enters_in_the_search_field(String productType) {
        accountPage.getSearchField().sendKeys(productType);
    }
    @When("User clicks on the search button at the my account page")
    public void user_clicks_on_the_search_button_at_the_my_account_page() {
        searchPage = accountPage.doClickOnSearchBtn();
    }

    @When("User navigates at the search page")
    public void user_navigates_at_the_search_page() {
        Assert.assertTrue(searchPage.getSearchBreadCrumb());
    }

    @Then("Page title of the search page should be {string}")
    public void page_title_of_the_search_page_should_be(String expSearchPageTitle) {
        String actSearchPageTitle = searchPage.getSearchPageTitle();
        Assert.assertEquals(actSearchPageTitle, expSearchPageTitle);
    }

    @Then("User gets amount of search product")
    public void user_gets_amount_of_search_product() {
        Assert.assertTrue(searchPage.getProductCount());
    }

    @Then("Product name contains the {string}")
    public void product_name_contains_the(String searchedProduct) {
        Assert.assertTrue(searchPage.getProduct(searchedProduct));
    }

    @Then("User clicks on the product for proceeding further")
    public void user_clicks_on_the_product_for_proceeding_further() {
        searchPage.doClickOnProduct();
    }

    @Then("User selects quantity of the product {string}")
    public void user_selects_quantity_of_the_product(String quantity) {
        DriverFactory.getWebDriver().switchTo().frame(searchPage.getIFrame());
        searchPage.getQuantity().clear();
        searchPage.getQuantity().sendKeys(quantity);
    }

    @Then("User selects size of the product {string}")
    public void user_selects_size_of_the_product(String size) {
        searchPage.getPlusBtn().click();
        searchPage.getMinusBtn().click();
        searchPage.getSize(size);
    }

    @Then("User selects color of the product")
    public void user_selects_color_of_the_product() {
        searchPage.getColor().click();
    }

    @Then("User clicks on the add to cart button")
    public void user_clicks_on_the_add_to_cart_button() {
        searchPage.getAddToCartButton().click();
        searchPage.customWait();
        DriverFactory.getWebDriver().switchTo().defaultContent();
    }

    @Then("Success message is showed up")
    public void success_message_is_showed_up() {
        Assert.assertTrue(searchPage.getSuccessMessageSearchPage());
    }

    @Then("User clicks on the proceed to order button")
    public OrderPage user_clicks_on_the_proceed_to_order_button() {
        orderPage = searchPage.proceedToOrderPage();
        return new OrderPage(DriverFactory.getWebDriver());
    }


}

Feature: Search Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User enters in the search field "T-shirt"
    And User clicks on the search button at the my account page

#  @Smoke
  Scenario: User navigates at the search page
    When User navigates at the search page
    Then Page title of the search page should be "Search - My Store"

#  @Smoke
  Scenario: User wants to validate search result
    Then User gets amount of search product
    And Product name contains the "Faded Short Sleeve T-shirts"

  @Smoke
  Scenario: User wants to add product to the cart
    Then User clicks on the product for proceeding further
    And User selects quantity of the product "1"
    And User selects size of the product "2"
    And User selects color of the product
    And User clicks on the add to cart button
    Then Success message is showed up
    And User clicks on the proceed to order button
    And User navigates at the order page
    Then Page title of the order page should be "Order - My Store"


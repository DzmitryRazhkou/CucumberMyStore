Feature: My Wishes Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User clicks on the my wishes section

  Scenario: User navigates to my wishes page
    And User navigates at the my wishes page title
    Then Page title of my wishes page should be "My Store"

  Scenario: User wants to get top seller products
    And User gets top seller products
    Then Amount of the top seller products should be 7
    And Top seller products should contain "Printed Summer Dress Long printed dress with thin adjustable straps. V-neckline and wiring... $28.98"

  Scenario: User creates new wish list
    And User enters wish list name
    And User clicks at the save button
    Then New wish list is created

  Scenario: User deletes existing wish list
    Then User clicks on the cross delete icon

  Scenario: User clicks on the back to your account button
    And User clicks on the back to your account button at the my wishes page
    Then Page title of my account page should be "My account - My Store"

  Scenario: User clicks on the home button
    And User clicks on the home button at the my wishes page
    Then Page title of my store page should be "My Store"
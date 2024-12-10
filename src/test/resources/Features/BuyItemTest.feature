Feature: User buys an item successfully

  Scenario: User buys an item successfully
    Given user logs in with username "standard_user" and password "secret_sauce"
    When user selects a product and adds it to the cart
    And user proceeds to checkout
    Then user should be redirected to the checkout page

Feature: User login and cart functionality

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username "standard_user" and password "secret_sauce"
    Then the user should be redirected to the products page

  Scenario: User logs in with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "invalid_user" and password "wrong_password"
    Then the user should see an error message

  Scenario: User adds a product to the cart
    Given the user is logged in and viewing the products page
    When the user adds the first product to the cart
    Then the cart should contain 1 item

  Scenario: User clicks on the shopping cart icon
    Given the user has products in the cart for checkout
    When the user clicks on the shopping cart icon
    Then the user should be redirected to the cart page

  Scenario: User proceeds to checkout with products in the cart
    Given the user has products in the cart for checkout
    When the user proceeds to checkout
    Then the user should be on the checkout page

  Scenario: User views the total price in the cart
    When the user views the cart
    Then the total price should be correctly calculated

Feature: Weather Shopper Application Basic Tests

  Scenario: User visits the homepage and sees the weather-based products
    Given user opens the Weather Shopper homepage
    Then user should see the sunscreen product

  Scenario: User should see the "About" link in the footer
    Given user opens the Weather Shopper homepage
    When user looks for the "About" link in the footer
    Then the "About" link should be displayed and clickable

  Scenario: User buys Alexander Almond & Honey Moisturiser and verifies it in the cart
    Given user opens the Weather product page
    And user selects the Alexander Almond & Honey Moisturiser and adds it to the cart
    Then user should see the product added to the cart

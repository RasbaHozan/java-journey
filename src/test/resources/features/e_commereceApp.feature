Feature: User registration and browsing hosting plans

  Scenario: User browses hosting plans and adds one to the cart
    Given the user is on the InMotion Hosting homepage
    When the user navigates to the Hosting Plans section
    And the user selects a hosting plan
    And the user adds the hosting plan to the cart
    And the user proceeds to checkout
    Then the user should be redirected to the checkout page

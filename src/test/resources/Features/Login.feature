Feature: Login functionality on Sauce Demo

  Scenario: Successful login with valid credentials
    Given User is on the login page of the Sauce Demo application
    When user enters username and password
    Then user should see the homepage with products

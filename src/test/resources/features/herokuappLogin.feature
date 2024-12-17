Feature: User login functionality on the Internet website

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username "tomsmith" and password "SuperSecretPassword!"
    Then the user should be redirected to the secure area

  Scenario: User logs in with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "wrong_user" and password "wrong_password"
    Then the user should see an error message

  Scenario: User logs out after a successful login
    Given the user is logged in and on the secure area page
    When the user clicks the logout button
    Then the user should be redirected to the login page


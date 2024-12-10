Feature: Checkbox functionality on The Internet website

  Scenario: Select a checkbox
    Given user opens the "checkboxes" page
    When user checks the first checkbox
    Then the first checkbox should be checked

  Scenario: Unselect a checkbox
    Given user opens the "checkboxes" page
    When user unchecks the first checkbox
    Then the first checkbox should be unchecked

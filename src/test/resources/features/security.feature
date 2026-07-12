Feature: Security

  Scenario: Invalid login
    Given the user is on the login page
    When the user enters invalid credentials
    And clicks the Sign in button
    Then an error message should be displayed
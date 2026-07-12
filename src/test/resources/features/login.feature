Feature: Login

  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the Sign in button
    Then the catalog page should be displayed
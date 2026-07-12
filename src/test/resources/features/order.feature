Feature: Order

  Background:
    Given the user is logged in

  Scenario: View placed order
    Given the user has placed an order
    When the user opens the order page
    Then the order status should be "PLACED"
    And the order total should be displayed
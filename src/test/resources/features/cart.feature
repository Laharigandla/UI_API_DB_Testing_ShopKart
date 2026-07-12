Feature: Cart

  Background:
    Given the user is logged in

  Scenario: Add product to cart
    When the user searches for "Focus Desk Lamp"
    And adds "Focus Desk Lamp" to the cart
    And opens the cart
    Then the cart should contain "Focus Desk Lamp"
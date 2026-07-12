Feature: Checkout

  Background:
    Given the user is logged in

  Scenario: Place an order
    Given the user has "Focus Desk Lamp" in the cart
    When the user proceeds to checkout
    And enters delivery address "Hyderabad, Telangana"
    And places the order
    Then the order should be created successfully
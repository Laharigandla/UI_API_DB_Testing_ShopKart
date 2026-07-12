Feature: Product Search

  Scenario: Search a product
    Given the user is logged in
    When the user searches for "Focus Desk Lamp"
    Then the product "Focus Desk Lamp" should be displayed
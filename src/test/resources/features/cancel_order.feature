Feature: Cancel Order

  Scenario: Cancel an already cancelled order
    Given Alice has an existing order
    When Alice cancels the order
    And Alice cancels the same order again
    Then the cancel request should return 409
Feature: Order Access Security

  Scenario: User cannot access another user's order
    Given Alice has placed an order
    When Bob requests Alice's order
    Then the API should return 403
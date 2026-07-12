Feature: End-to-End Checkout

  Background:
    Given the user is logged in

  Scenario: Verify order through UI API and Database
    When the user purchases "Focus Desk Lamp"
    Then the order should exist in the database
    Then the database should contain status "CONFIRMED"
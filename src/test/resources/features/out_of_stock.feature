Feature: Out Of Stock

  Scenario: User cannot add an out of stock product
    Given the product "Everyday Cap" is out of stock
    When Alice adds the product to the cart using the API
    Then adding the product should return 409
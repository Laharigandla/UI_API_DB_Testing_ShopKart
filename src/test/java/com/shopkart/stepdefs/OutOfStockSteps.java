package com.shopkart.stepdefs;

import com.shopkart.api.AuthClient;
import com.shopkart.api.CartClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutOfStockSteps {

    private final AuthClient authClient = new AuthClient();
    private final CartClient cartClient = new CartClient();

    private String token;
    private int cartId;

    private Response response;

    @Given("the product {string} is out of stock")
    public void theProductIsOutOfStock(String sku) {
        // Seed data already has SKU-CAP with stock = 0
    }

    @When("Alice adds the product to the cart using the API")
    public void aliceAddsTheProductToTheCartUsingTheAPI() {

        Response login = authClient.login(
                "alice@shopkart.test",
                "Alice@123");

        token = login.jsonPath().getString("token");

        Response cart = cartClient.createCart(token);

        cartId = cart.jsonPath().getInt("cartId");

        response = cartClient.addItem(
                token,
                cartId,
                "SKU-CAP",
                1);
    }

    @Then("adding the product should return 409")
    public void addingTheProductShouldReturn409() {
        assertEquals(409, response.statusCode());
    }

}
package com.shopkart.stepdefs;

import com.shopkart.api.AuthClient;
import com.shopkart.api.CartClient;
import com.shopkart.api.OrderClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancelOrderSteps {

    private final AuthClient authClient = new AuthClient();
    private final CartClient cartClient = new CartClient();
    private final OrderClient orderClient = new OrderClient();

    private String token;
    private int cartId;
    private int orderId;

    private Response response;

    @Given("Alice has an existing order")
    public void aliceHasAnExistingOrder() {

        Response login = authClient.login("alice@shopkart.test", "Alice@123");
        token = login.jsonPath().getString("token");

        Response cart = cartClient.createCart(token);
        cartId = cart.jsonPath().getInt("cartId");

        cartClient.addItem(token, cartId, "SKU-BAG", 1);

        Response order = orderClient.placeOrder(
                token,
                cartId,
                "Hyderabad, Bangalore"
        );

        orderId = order.jsonPath().getInt("orderId");
    }

    @When("Alice cancels the order")
    public void aliceCancelsTheOrder() {
        orderClient.cancelOrder(token, orderId);
    }

    @When("Alice cancels the same order again")
    public void aliceCancelsTheSameOrderAgain() {
        response = orderClient.cancelOrder(token, orderId);
    }

    @Then("the cancel request should return 409")
    public void theCancelRequestShouldReturn409() {
        assertEquals(409, response.statusCode());
    }
}
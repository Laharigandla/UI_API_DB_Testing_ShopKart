package com.shopkart.stepdefs;

import com.shopkart.api.AuthClient;
import com.shopkart.api.CartClient;
import com.shopkart.api.OrderClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderAccessSteps {

    private final AuthClient authClient = new AuthClient();
    private final CartClient cartClient = new CartClient();
    private final OrderClient orderClient = new OrderClient();

    private String aliceToken;
    private String bobToken;

    private int cartId;
    private int orderId;

    private Response response;

    @Given("Alice has placed an order")
    public void aliceHasPlacedAnOrder() {

        Response login = authClient.login("alice@shopkart.test", "Alice@123");

        aliceToken = login.jsonPath().getString("token");

        Response cart = cartClient.createCart(aliceToken);

        cartId = cart.jsonPath().getInt("cartId");

        cartClient.addItem(aliceToken, cartId, "Focus Desk Lamp", 1);

        Response order = orderClient.placeOrder(
                aliceToken,
                cartId,
                "Hyderabad, Bangalore"
        );

        orderId = order.jsonPath().getInt("orderId");
    }

    @When("Bob requests Alice's order")
    public void bobRequestsAlicesOrder() {

        Response login = authClient.login("bob@shopkart.test", "Bob@123");

        bobToken = login.jsonPath().getString("token");

        response = orderClient.getOrder(bobToken, orderId);
    }

    @Then("the API should return 403")
    public void theApiShouldReturn403() {

        assertEquals(403, response.statusCode());
    }
}
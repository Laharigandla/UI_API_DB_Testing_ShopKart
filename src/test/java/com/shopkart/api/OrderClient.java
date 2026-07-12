package com.shopkart.api;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class OrderClient {

    public Response placeOrder(String token, int cartId, String address) {

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(Map.of(
                        "cartId", cartId,
                        "address", address
                ))
                .post("/orders");
    }

    public Response getOrder(String token, int orderId) {

        return given()
                .header("Authorization", "Bearer " + token)
                .get("/orders/" + orderId);
    }

    public Response getOrderPublic(int orderId) {
        return given()
                .get("/orders/" + orderId);
    }

    public Response cancelOrder(String token, int orderId) {

        return given()
                .header("Authorization", "Bearer " + token)
                .post("/orders/" + orderId + "/cancel");
    }

}
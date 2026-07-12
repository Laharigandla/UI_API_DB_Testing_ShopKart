package com.shopkart.api;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response login(String email, String password) {

        Response resp = given()
            .contentType("application/json")
            .body(Map.of(
                "email", email,
                "password", password
            ))
            .post("/auth/login");

        if (resp.statusCode() != 200) {
            throw new RuntimeException("Login failed (" + resp.statusCode() + "): " + resp.asString());
        }

        return resp;
    }
}
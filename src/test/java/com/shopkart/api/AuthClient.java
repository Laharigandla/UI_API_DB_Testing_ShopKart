package com.shopkart.api;

import io.restassured.response.Response;

import java.util.Map;

public class AuthClient extends BaseApi {

    public Response login(String email, String password) {

        return request()
                .body(Map.of(
                        "email", email,
                        "password", password
                ))
                .post("/auth/login");
    }
}
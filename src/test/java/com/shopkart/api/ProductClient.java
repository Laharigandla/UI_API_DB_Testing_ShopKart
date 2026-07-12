package com.shopkart.api;

import com.shopkart.config.AppConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductClient {

    public Response getAllProducts() {
        return given()
                .baseUri(AppConfig.apiBaseUrl())
                .get("/products");
    }

    public Response searchProduct(String product) {
        return given()
                .baseUri(AppConfig.apiBaseUrl())
                .queryParam("q", product)
                .get("/products");
    }

}
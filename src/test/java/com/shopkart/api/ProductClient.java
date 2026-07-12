package com.shopkart.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ProductClient {

    public Response getAllProducts() {
        return given().get("/products");
    }

    public Response searchProduct(String product) {
        return given()
                .queryParam("q", product)
                .get("/products");
    }

    public Response getProduct(String sku) {
        return given()
                .get("/products/" + sku);
    }
}
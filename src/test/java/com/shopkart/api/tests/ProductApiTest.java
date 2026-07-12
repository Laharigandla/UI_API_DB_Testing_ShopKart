package com.shopkart.api.tests;

import com.shopkart.api.ProductClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductApiTest {

    private final ProductClient productClient = new ProductClient();

    @Test
    void shouldGetAllProducts() {

        Response response = productClient.getAllProducts();

        assertEquals(200, response.statusCode());
        assertFalse(response.jsonPath().getList("$").isEmpty());
    }

    @Test
    void shouldSearchProduct() {

        Response response = productClient.searchProduct("Focus Desk Lamp");

        assertEquals(200, response.statusCode());
        assertFalse(response.jsonPath().getList("$").isEmpty());
    }

}
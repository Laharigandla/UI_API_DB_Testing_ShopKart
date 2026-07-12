package com.shopkart.api.tests;

import com.shopkart.api.AuthClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginApiTest {

    private final AuthClient authClient = new AuthClient();

    @Test
    void validLogin() {

        Response response = authClient.login(
                "alice@shopkart.test",
                "Alice@123"
        );

        assertEquals(200, response.statusCode());

        String token = response.jsonPath().getString("token");

        assertNotNull(token);
        assertFalse(token.isBlank());
    }
}
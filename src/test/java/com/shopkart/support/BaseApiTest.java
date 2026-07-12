package com.shopkart.support;

import com.shopkart.config.AppConfig;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseApiTest {

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = AppConfig.apiBaseUrl();
    }

}
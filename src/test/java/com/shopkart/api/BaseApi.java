package com.shopkart.api;

import com.shopkart.config.AppConfig;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected RequestSpecification request() {
        RestAssured.baseURI = AppConfig.apiBaseUrl();

        return RestAssured.given()
                .contentType("application/json");
    }
}
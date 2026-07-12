package com.shopkart.support;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.shopkart.config.AppConfig;

public class DriverFactory {

    public static void startBrowser() {
        // Print config values for debugging which URL is used by Selenide
        System.out.println("[DriverFactory] Base URL = " + AppConfig.baseUrl());
        System.out.println("[DriverFactory] API URL = " + AppConfig.apiBaseUrl());
        Configuration.browser = AppConfig.browser();
        Configuration.baseUrl = AppConfig.baseUrl();
        Configuration.headless = AppConfig.headless();
        Configuration.timeout = AppConfig.timeout();

        // Open the explicit base URL to avoid relying on Configuration.baseUrl alone
        Selenide.open(AppConfig.baseUrl());


    }

    public static void closeBrowser() {
        Selenide.closeWebDriver();
    }

}
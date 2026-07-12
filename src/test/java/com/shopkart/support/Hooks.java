package com.shopkart.support;

import com.codeborne.selenide.Selenide;
import com.shopkart.config.AppConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        RestAssured.baseURI = AppConfig.apiBaseUrl();
        if (scenario.getSourceTagNames().contains("@ui")
                || scenario.getSourceTagNames().contains("@e2e")
                || scenario.getSourceTagNames().contains("@smoke")) {
            DriverFactory.startBrowser();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")
                || scenario.getSourceTagNames().contains("@e2e")
                || scenario.getSourceTagNames().contains("@smoke")) {
            byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
            DriverFactory.closeBrowser();
        }
    }
}
package com.shopkart.support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseUiTest {

    @BeforeEach
    void setUp() {
        DriverFactory.startBrowser();
    }

    @AfterEach
    void tearDown() {
        DriverFactory.closeBrowser();
    }

}
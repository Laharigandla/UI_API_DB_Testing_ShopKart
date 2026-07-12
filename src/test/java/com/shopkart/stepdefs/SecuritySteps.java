package com.shopkart.stepdefs;

import com.shopkart.ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SecuritySteps {

    private final LoginPage loginPage = new LoginPage();

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {

        loginPage.enterEmail("invalid@test.com")
                .enterPassword("wrongpassword");
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {

        assertFalse(loginPage.getErrorMessage().isEmpty());
    }
}
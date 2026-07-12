package com.shopkart.stepdefs;

import com.shopkart.data.builders.CustomerBuilder;
import com.shopkart.ui.pages.HomePage;
import com.shopkart.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.open();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {

        CustomerBuilder customer = CustomerBuilder.customer();

        loginPage.enterEmail(customer.getEmail())
                .enterPassword(customer.getPassword());
    }

    @When("clicks the Sign in button")
    public void clicksTheSignInButton() {
        loginPage.clickSignIn();
    }

    @Then("the catalog page should be displayed")
    public void theCatalogPageShouldBeDisplayed() {
        homePage.verifyHomePage();
    }
}
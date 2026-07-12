package com.shopkart.stepdefs;

import com.shopkart.data.builders.CustomerBuilder;
import com.shopkart.ui.pages.HomePage;
import com.shopkart.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {

        CustomerBuilder customer = CustomerBuilder.customer();

        loginPage.open()
                .enterEmail(customer.getEmail())
                .enterPassword(customer.getPassword())
                .clickSignIn();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String product) {
        homePage.searchProduct(product);
    }

    @Then("the product {string} should be displayed")
    public void theProductShouldBeDisplayed(String product) {
        homePage.verifyProductVisible(product);
    }
}
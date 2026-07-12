package com.shopkart.stepdefs;

import com.shopkart.ui.pages.CartPage;
import com.shopkart.ui.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

    private final HomePage homePage = new HomePage();
    private CartPage cartPage;

    @When("adds {string} to the cart")
    public void addsToTheCart(String product) {
        homePage.addToCart(product);
    }

    @When("opens the cart")
    public void opensTheCart() {
        cartPage = homePage.goToCart();
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String sku) {
        cartPage.verifyLineItem(sku);
    }
}
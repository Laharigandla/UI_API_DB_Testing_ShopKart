package com.shopkart.stepdefs;

import com.shopkart.ui.pages.CartPage;
import com.shopkart.ui.pages.CheckoutPage;
import com.shopkart.ui.pages.HomePage;
import com.shopkart.ui.pages.OrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private final HomePage homePage = new HomePage();
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderPage orderPage;

    @Given("the user has {string} in the cart")
    public void theUserHasInTheCart(String product) {
        homePage.searchProduct(product);
        homePage.addToCart(product);
        cartPage = homePage.goToCart();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        checkoutPage = cartPage.clickCheckout();
    }

    @When("enters delivery address {string}")
    public void entersDeliveryAddress(String address) {
        checkoutPage.enterAddress(address);
    }

    @When("places the order")
    public void placesTheOrder() {
        orderPage = checkoutPage.placeOrder();
    }

    @Then("the order should be created successfully")
    public void theOrderShouldBeCreatedSuccessfully() {
        orderPage.verifyOrderPage();
    }
}
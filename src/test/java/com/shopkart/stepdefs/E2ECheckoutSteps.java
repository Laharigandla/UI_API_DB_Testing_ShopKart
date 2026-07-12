package com.shopkart.stepdefs;

import com.shopkart.api.OrderAssertions;
import com.shopkart.ui.pages.CartPage;
import com.shopkart.ui.pages.CheckoutPage;
import com.shopkart.ui.pages.HomePage;
import com.shopkart.ui.pages.OrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class E2ECheckoutSteps {

    private final HomePage homePage = new HomePage();

    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderPage orderPage;

    private int orderId;

    @When("the user purchases {string}")
    public void theUserPurchases(String product) {

        homePage.searchProduct(product);
        homePage.addToCart(product);

        cartPage = homePage.goToCart();

        checkoutPage = cartPage.clickCheckout();

        checkoutPage.enterAddress("Hyderabad, Telangana");

        orderPage = checkoutPage.placeOrder();

        orderId = orderPage.getOrderId();
    }

    @Then("the order should exist in the database")
    public void theOrderShouldExistInTheDatabase() throws Exception {

        OrderAssertions.verifyOrderExists(orderId);
    }

    @Then("the database should contain status {string}")
    public void theDatabaseShouldContainStatus(String status) throws Exception {
        OrderAssertions.verifyStatus(orderId, status);
    }
}
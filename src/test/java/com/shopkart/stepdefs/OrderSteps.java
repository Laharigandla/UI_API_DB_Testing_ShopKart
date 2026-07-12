package com.shopkart.stepdefs;

import com.shopkart.ui.pages.CartPage;
import com.shopkart.ui.pages.CheckoutPage;
import com.shopkart.ui.pages.HomePage;
import com.shopkart.ui.pages.OrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderSteps {

    private final HomePage homePage = new HomePage();

    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderPage orderPage;

    @Given("the user has placed an order")
    public void theUserHasPlacedAnOrder() {

        homePage.searchProduct("Metro Carryall");
        homePage.addToCart("Metro Carryall");

        cartPage = homePage.goToCart();

        checkoutPage = cartPage.clickCheckout();

        checkoutPage.enterAddress("Hyderabad, Telangana");

        orderPage = checkoutPage.placeOrder();
    }

    @When("the user opens the order page")
    public void theUserOpensTheOrderPage() {
        // Already on Order page after placing order
    }

    @Then("the order status should be {string}")
    public void theOrderStatusShouldBe(String status) {
        orderPage.verifyStatus(status);
    }

    @Then("the order total should be displayed")
    public void theOrderTotalShouldBeDisplayed() {
        orderPage.verifyTotal("₹");
    }
}
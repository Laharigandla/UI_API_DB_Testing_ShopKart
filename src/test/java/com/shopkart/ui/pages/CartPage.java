package com.shopkart.ui.pages;

import com.shopkart.ui.locators.Xp;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public CartPage verifyLineItem(String productName) {
        $x("//tr[contains(@class,'cart-line')]//td[normalize-space()='" + productName + "']")
                .shouldHave(text(productName));
        return this;
    }

    public CartPage verifyTotal(String total) {
        $x(Xp.CART_TOTAL).shouldHave(text(total));
        return this;
    }

    public CheckoutPage clickCheckout() {
        $x(Xp.CHECKOUT).click();
        return new CheckoutPage();
    }

    public CartPage verifyCartPage() {
        $x("//h1").shouldHave(text("Your cart"));
        return this;
    }

}
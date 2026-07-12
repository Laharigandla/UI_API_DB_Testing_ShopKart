package com.shopkart.ui.pages;

import com.shopkart.ui.locators.Xp;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {

    public CheckoutPage enterAddress(String address) {
        $x(Xp.ADDRESS).setValue(address);
        return this;
    }

    public OrderPage placeOrder() {
        $x(Xp.PLACE_ORDER).click();
        return new OrderPage();
    }

}
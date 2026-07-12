package com.shopkart.ui.pages;

import com.shopkart.ui.locators.Xp;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    public OrderPage verifyOrderPage() {
        $x("//h1").shouldHave(text("Order confirmed"));
        return this;
    }

    public OrderPage verifyStatus(String status) {
        $x(Xp.ORDER_STATUS).shouldHave(text(status));
        return this;
    }

    public OrderPage verifyTotal(String total) {
        $x(Xp.ORDER_TOTAL).shouldHave(text(total));
        return this;
    }

    public int getOrderId() {

        String text = $x("//p[contains(.,'Order #')]").getText();

        return Integer.parseInt(text.replaceAll("\\D+", ""));
    }
}
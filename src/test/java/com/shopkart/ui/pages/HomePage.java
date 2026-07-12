package com.shopkart.ui.pages;

import com.codeborne.selenide.Condition;
import com.shopkart.ui.locators.Xp;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public HomePage searchProduct(String product) {
        $x(Xp.SEARCH).setValue(product);
        $x(Xp.SEARCH_BUTTON).click();
        $x(String.format(Xp.PRODUCT, product)).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public HomePage verifyProductVisible(String product) {
        $x(String.format(Xp.PRODUCT, product)).shouldHave(text(product));
        return this;
    }

    public HomePage addToCart(String product) {
        $x(String.format(Xp.ADD_TO_CART, product)).click();
        $x("//div[@role='status']").shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public CartPage goToCart() {
        $x("//button[contains(.,'Cart')]").click();
        return new CartPage();
    }

    public HomePage verifyHomePage() {
        $x("//h1").shouldHave(text("Useful things"));
        return this;
    }
}
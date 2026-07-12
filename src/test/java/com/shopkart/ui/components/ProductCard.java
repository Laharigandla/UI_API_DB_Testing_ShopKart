package com.shopkart.ui.components;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCard {

    private final String product;

    public ProductCard(String product) {
        this.product = product;
    }

    public void open() {
        $x(String.format(
                "//div[contains(@class,'product')][.//*[normalize-space()='%s']]",
                product))
                .click();
    }

    public void addToCart() {
        $x(String.format(
                "//div[contains(@class,'product')][.//*[normalize-space()='%s']]//button[normalize-space()='Add to cart']",
                product))
                .click();
    }
}
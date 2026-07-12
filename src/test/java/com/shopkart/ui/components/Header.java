package com.shopkart.ui.components;

import static com.codeborne.selenide.Selenide.$x;

import com.shopkart.ui.pages.CartPage;
import com.shopkart.ui.pages.HomePage;

public class Header {

    public HomePage clickCatalog() {
        $x("//button[contains(.,'Catalog')]").click();
        return new HomePage();
    }

    public CartPage clickCart() {
        $x("//button[contains(.,'Cart')]").click();
        return new CartPage();
    }

    public void logout() {
        $x("//button[contains(.,'Sign out')]").click();
    }
}
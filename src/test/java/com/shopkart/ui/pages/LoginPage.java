package com.shopkart.ui.pages;

import com.codeborne.selenide.Selenide;
import com.shopkart.config.AppConfig;
import com.shopkart.ui.locators.Xp;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public LoginPage open() {
        Selenide.open(AppConfig.baseUrl() + "/login");
        return this;
    }

    public LoginPage enterEmail(String email) {
        $x(Xp.EMAIL).setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $x(Xp.PASSWORD).setValue(password);
        return this;
    }

    public HomePage clickSignIn() {
        $x(Xp.LOGIN).click();
        return new HomePage();
    }

    public LoginPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
        return this;
    }

    public String getErrorMessage() {
        return $x("//div[@role='alert']").getText();
    }

}
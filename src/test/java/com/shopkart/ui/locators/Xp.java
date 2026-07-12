package com.shopkart.ui.locators;

public final class Xp {

    private Xp() {}

    // Login
    public static final String EMAIL = "//input[@id='email']";
    public static final String PASSWORD = "//input[@id='password']";
    public static final String LOGIN = "//button[@type='submit']";

    // Catalog
    public static final String SEARCH = "//input[@id='catalog-search']";
    public static final String SEARCH_BUTTON = "//button[normalize-space()='Search']";

    public static final String PRODUCT =
            "//div[contains(@class,'product')][.//h2[contains(normalize-space(.), '%s')]]";

    public static final String ADD_TO_CART =
            PRODUCT + "//button[contains(@class,'quick-add') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]";

    // Cart
    public static final String CART_LINE =
            "//tr[contains(@class,'cart-line')][td[normalize-space()='%s']]";

    public static final String CART_TOTAL =
            "//*[@data-role='cart-total']";

    public static final String CHECKOUT =
            "//button[normalize-space()='Checkout']";

    // Checkout
    public static final String ADDRESS =
            "//textarea[@id='address']";

    public static final String PLACE_ORDER =
            "//button[normalize-space()='Place order']";

    // Order
    public static final String ORDER_STATUS =
            "//*[@data-field='order-status']";

    public static final String ORDER_TOTAL =
            "//*[@data-field='order-total']";

}
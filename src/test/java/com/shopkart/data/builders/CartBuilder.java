package com.shopkart.data.builders;

public class CartBuilder {

    private String sku = "SKU-LMP";
    private int qty = 1;

    public static CartBuilder cart() {
        return new CartBuilder();
    }

    public CartBuilder withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public CartBuilder withQuantity(int qty) {
        this.qty = qty;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public int getQty() {
        return qty;
    }
}
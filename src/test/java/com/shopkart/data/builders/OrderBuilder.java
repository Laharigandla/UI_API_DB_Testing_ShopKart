package com.shopkart.data.builders;

public class OrderBuilder {

    private int cartId;
    private String address = "Arya Nivas";

    public static OrderBuilder order() {
        return new OrderBuilder();
    }

    public OrderBuilder withCartId(int cartId) {
        this.cartId = cartId;
        return this;
    }

    public OrderBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public int getCartId() {
        return cartId;
    }

    public String getAddress() {
        return address;
    }
}
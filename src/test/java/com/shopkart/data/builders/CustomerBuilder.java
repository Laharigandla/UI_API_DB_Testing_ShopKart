package com.shopkart.data.builders;

import com.shopkart.data.secret.Secrets;

public class CustomerBuilder {

    private String email = "alice@shopkart.test";
    private String password = Secrets.get("alice.password");

    public static CustomerBuilder customer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
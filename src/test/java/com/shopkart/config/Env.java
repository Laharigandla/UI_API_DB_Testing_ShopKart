package com.shopkart.config;

public enum Env {

    LOCAL,
    CI;

    public static Env current() {

        String env = System.getProperty("env", "LOCAL");

        return Env.valueOf(env.toUpperCase());
    }

}
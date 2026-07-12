package com.shopkart.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppConfig {

    private static final Properties properties = new Properties();

    static {

        String file = Env.current() == Env.CI
                ? "config/application-ci.properties"
                : "config/application-local.properties";

        try (InputStream input = AppConfig.class
                .getClassLoader()
                .getResourceAsStream(file)) {

            if (input == null) {
                throw new RuntimeException(file + " not found");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private AppConfig() {
    }

    public static String baseUrl() {
        return properties.getProperty("base.url");
    }

    public static String apiBaseUrl() {
        return properties.getProperty("api.base.url");
    }

    public static String browser() {
        return properties.getProperty("browser");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static long timeout() {
        return Long.parseLong(properties.getProperty("timeout"));
    }

    public static String dbHost() {
        return properties.getProperty("db.host");
    }

    public static String dbPort() {
        return properties.getProperty("db.port");
    }

    public static String dbName() {
        return properties.getProperty("db.name");
    }

    public static String dbUsername() {
        return properties.getProperty("db.username");
    }

    public static String dbPassword() {
        return properties.getProperty("db.password");
    }

}
package com.shopkart.data.secret;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Secrets {

    private static final Properties properties = new Properties();

    static {

        try (InputStream input = Secrets.class.getClassLoader()
                .getResourceAsStream("secrets.local.properties")) {

            if (input != null) {
                properties.load(input);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {

        String value = System.getenv(key);

        if (value != null) {
            return value;
        }

        return properties.getProperty(key);
    }

}
package com.shopkart.data.db;

import org.testcontainers.containers.MySQLContainer;

public class MySqlSupport {

    public static final MySQLContainer<?> mysql =
            new MySQLContainer<>("mysql:8.4")
                    .withDatabaseName("shopkart")
                    .withUsername("root")
                    .withPassword("root");

    static {
        mysql.start();
    }

}
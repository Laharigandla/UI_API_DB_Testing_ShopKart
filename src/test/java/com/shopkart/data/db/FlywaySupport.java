package com.shopkart.data.db;

import org.flywaydb.core.Flyway;

public class FlywaySupport {

    public static void migrate() {

        Flyway flyway = Flyway.configure()
                .dataSource(
                        MySqlSupport.mysql.getJdbcUrl(),
                        MySqlSupport.mysql.getUsername(),
                        MySqlSupport.mysql.getPassword())
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }

}
package com.shopkart.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHelper {

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(
                MySqlSupport.mysql.getJdbcUrl(),
                MySqlSupport.mysql.getUsername(),
                MySqlSupport.mysql.getPassword()
        );
    }

    public static String getOrderStatus(int orderId) throws Exception {

        String sql = "SELECT status FROM orders WHERE order_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("status");
            }

            return null;
        }
    }

    public static int getOrderTotal(int orderId) throws Exception {

        String sql = "SELECT total_paise FROM orders WHERE order_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("total_paise");
            }

            return 0;
        }
    }

    public static boolean orderExists(int orderId) throws Exception {

        String sql = "SELECT COUNT(*) FROM orders WHERE order_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            rs.next();

            return rs.getInt(1) > 0;
        }
    }

}
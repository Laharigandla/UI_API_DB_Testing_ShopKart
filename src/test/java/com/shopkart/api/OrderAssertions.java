package com.shopkart.api;

import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.shopkart.api.OrderClient;

public class OrderAssertions {

    public static void verifyOrderExists(int orderId) throws Exception {
        OrderClient oc = new OrderClient();
        Response resp = oc.getOrderPublic(orderId);
        assertEquals(200, resp.statusCode());
    }

    public static void verifyStatus(int orderId, String status) throws Exception {
        OrderClient oc = new OrderClient();
        Response resp = oc.getOrderPublic(orderId);
        assertEquals(200, resp.statusCode());
        String actual = resp.jsonPath().getString("status");
        assertEquals(status, actual);
    }

    public static void verifyTotal(int orderId, int total) throws Exception {
        OrderClient oc = new OrderClient();
        Response resp = oc.getOrderPublic(orderId);
        assertEquals(200, resp.statusCode());
        int actual = resp.jsonPath().getInt("total_paise");
        assertEquals(total, actual);
    }

}
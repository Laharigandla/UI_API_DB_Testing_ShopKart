package com.shopkart.api;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import com.shopkart.api.ProductClient;

public class CartClient {

    public Response createCart(String token) {

        Response resp = given()
                .header("Authorization", "Bearer " + token)
                .post("/carts");

        if (resp.statusCode() != 201 && resp.statusCode() != 200) {
            throw new RuntimeException("Create cart failed (" + resp.statusCode() + "): " + resp.asString());
        }

        return resp;
    }

    public Response addItem(String token, int cartId, String sku, int qty) {

        String resolvedSku = sku;

        // If caller passed a product name instead of SKU, try to resolve it
        if (sku != null && !sku.startsWith("SKU-")) {
            ProductClient pc = new ProductClient();
            Response pResp = pc.searchProduct(sku);
            try {
                List<Map<String, Object>> list = pResp.jsonPath().getList("$");
                if (list != null && !list.isEmpty()) {
                    Object s = list.get(0).get("sku");
                    if (s != null) resolvedSku = s.toString();
                }
            } catch (Exception ignored) {
                // fallback to original value
            }
        }

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(Map.of(
                        "sku", resolvedSku,
                        "qty", qty
                ))
                .post("/carts/" + cartId + "/items");
    }

    public Response getCart(String token, int cartId) {

        return given()
                .header("Authorization", "Bearer " + token)
                .get("/carts/" + cartId);
    }

}
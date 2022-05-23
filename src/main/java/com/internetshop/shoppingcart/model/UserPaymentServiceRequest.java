package com.internetshop.shoppingcart.model;

import com.fasterxml.jackson.databind.JsonNode;

public class UserPaymentServiceRequest {

    private String orderId;

    private JsonNode userInfo;

    private JsonNode cardInfo;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public JsonNode getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(JsonNode userInfo) {
        this.userInfo = userInfo;
    }

    public JsonNode getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(JsonNode cardInfo) {
        this.cardInfo = cardInfo;
    }
}

package com.internetshop.shoppingcart.model;

import com.fasterxml.jackson.databind.JsonNode;

public class ShoppingCartRequest {

    private String actionType;

    private String userId;

    private String referenceNumber;

    private JsonNode productInfo;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public JsonNode getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(JsonNode productInfo) {
        this.productInfo = productInfo;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}

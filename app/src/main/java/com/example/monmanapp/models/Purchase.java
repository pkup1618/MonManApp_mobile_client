package com.example.monmanapp.models;

import java.util.UUID;

public class Purchase {

    private UUID id;
    public UUID getId() {
        return id;
    }


    String purchaseName;
    public String getPurchaseName() { return purchaseName; }
    public void setPurchaseName(String purchaseName) { this.purchaseName = purchaseName; }

    String purchaseType;
    public String getPurchaseType() { return purchaseType; }
    public void setPurchaseType(String purchaseType) { this.purchaseType = purchaseType; }

    String purchaseCost;
    public String getPurchaseCost() { return purchaseCost; }
    public void setPurchaseCost(String purchaseCost) { this.purchaseCost = purchaseCost; }

    String count;
    public String getCount() { return count; }
    public void setCount(String count) { this.count = count; }

    String day;
    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    Integer dbId;
    public Integer getDbId() { return dbId; }
    public void setDbId(Integer dbId) { this.dbId = dbId; }

    String paymentType;
    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }


    public Purchase() {
        id = UUID.randomUUID();
    }
}

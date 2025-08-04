package com.order.constant;

public enum ProductStatus {

    PREPARING("준비중"),
    ACTIVE("활성"),
    INACTIVE("비활성");

    private String description;

    ProductStatus(String description) {
        this.description = description;
    }
}

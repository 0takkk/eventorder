package com.order.vo;

public record StockQuantity(int value) {

    public StockQuantity {
        if(value < 0) {
            throw new IllegalArgumentException("Stock  quantity cannot be negative");
        }
    }

    public boolean isAvailable(StockQuantity requestQuantity) {
        return value >= requestQuantity.value;
    }
}

package com.order.common.vo;

public record Money(long value) {

    public Money {
        if(value < 0) {
            throw new IllegalArgumentException("Money value must be positive");
        }
    }

    public Money multiply(int quantity) {
        return new Money(value * quantity);
    }
}

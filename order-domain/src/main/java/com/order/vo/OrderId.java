package com.order.vo;

public record OrderId(Long value) {

    public static OrderId empty() {
        return new OrderId(0L);
    }

    public boolean isEmpty() {
        return this.value == 0L;
    }
}

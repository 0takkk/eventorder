package com.order.exception.order;

public class OrderException extends RuntimeException {

    private OrderErrorCode code;

    public OrderException(OrderErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public OrderErrorCode getCode() {
        return code;
    }
}

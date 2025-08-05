package com.order.exception;

public enum OrderErrorCode {

    NOT_FOUND_ORDER("ORDER1000", "해당 주문을 찾을 수 없습니다.");

    private String code;

    private String message;

    OrderErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.order.exception.order;

public enum OrderErrorCode {

    NOT_FOUND_ORDER(100, "해당 주문을 찾을 수 없습니다."),
    PRODUCT_NOT_AVAILABLE(101, "상품이 활성 상태가 아닙니다.");

    private int code;

    private String message;

    OrderErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

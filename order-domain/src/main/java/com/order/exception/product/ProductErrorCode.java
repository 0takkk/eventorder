package com.order.exception.product;

public enum ProductErrorCode {

    NOT_FOUND_PRODUCT(200, "해당 상품을 찾을 수 없습니다.");

    private int code;

    private String message;

    ProductErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

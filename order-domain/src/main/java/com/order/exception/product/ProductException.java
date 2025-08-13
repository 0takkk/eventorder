package com.order.exception.product;

public class ProductException extends RuntimeException {

    private ProductErrorCode code;

    public ProductException(ProductErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public ProductErrorCode getCode() {
        return code;
    }
}

package com.order.vo;

public record Nickname(String value) {

    public Nickname {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Nickname cannot be blank");
        }
        if (value.length() > 20) {
            throw new IllegalArgumentException("Nickname cannot have more than 20 characters");
        }
    }
}

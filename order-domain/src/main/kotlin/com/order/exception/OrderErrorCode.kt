package com.order.exception

enum class OrderErrorCode(
    val code: String,
    val message: String,
) {
    NOT_FOUND_ORDER("ORDER1000", "해당 주문을 찾을 수 없어요."),
}
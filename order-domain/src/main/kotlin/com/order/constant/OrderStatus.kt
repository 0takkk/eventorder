package com.order.constant

enum class OrderStatus(
    val description: String,
) {
    CREATED("생성 단계"),
    CANCELED("주문 취소"),
    PAYMENT_PENDING("결제 대기"),
    PAYMENT_COMPLETED("결제 완료"),
    ORDER_COMPLETED("주문 완료"),
    REFUND_PAYMENT_PENDING("결제 환불 대기"),
    REFUND_PAYMENT_COMPLETED("결제 환불 완료"),
    ORDER_REFUND_COMPLETED("주문 환불 완료"),
}
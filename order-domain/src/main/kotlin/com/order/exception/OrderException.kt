package com.order.exception

class OrderException(
    val code: OrderErrorCode,
    override val message: String,
) : RuntimeException(message)

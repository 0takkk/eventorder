package com.order.common.vo

data class Money(
    val value: Long,
) {
    init {
        require(value > 0) { "Value must be positive" }
    }
}
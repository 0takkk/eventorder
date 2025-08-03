package com.order.vo

@JvmInline
value class Nickname(
    val value: String,
) {
    init {
        require(value.isNotBlank()) { "Nickname cannot be blank" }
        require(value.length <= 20) { "Nickname cannot have 20 characters" }
    }
}
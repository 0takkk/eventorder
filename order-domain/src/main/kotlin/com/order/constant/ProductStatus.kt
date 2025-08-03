package com.order.constant

enum class ProductStatus(
    val description: String,
) {
    PREPARING("준비중"),
    ACTIVE("활성"),
    INACTIVE("비활성"),
}
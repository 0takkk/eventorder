package com.order.entity

import com.order.common.vo.Money
import com.order.vo.ProductId
import com.order.constant.ProductStatus
import java.time.LocalDateTime

data class Product(
    val id: ProductId,
    val status: ProductStatus,
    val userAmount: Money,
    val supplyAmount: Money,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

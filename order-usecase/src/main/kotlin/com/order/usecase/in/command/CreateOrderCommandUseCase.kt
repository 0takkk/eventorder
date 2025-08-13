package com.order.usecase.`in`.command

import com.order.entity.Order
import com.order.vo.ProductId
import com.order.vo.StockQuantity
import com.order.vo.UserId

interface CreateOrderCommandUseCase {
    fun invoke(command: Command): Order

    data class Command(
        val userId: UserId,
        val productId: ProductId,
        val stockQuantity: StockQuantity
    )
}
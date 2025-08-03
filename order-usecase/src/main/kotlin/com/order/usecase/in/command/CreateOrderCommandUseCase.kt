package com.order.usecase.`in`.command

import com.order.common.vo.Money
import com.order.entity.Order
import com.order.vo.ProductId
import com.order.vo.UserId

interface CreateOrderCommandUseCase {
    fun invoke(command: Command): Order

    data class Command(
        val userId: UserId,
        val productId: ProductId,
        val amount: Money,
    )
}
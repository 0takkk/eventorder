package com.order.usecase.`in`.query

import com.order.entity.Order
import com.order.vo.OrderId

interface GetOrderQueryUseCase {
    fun invoke(query: Query): Order

    data class Query(
        val id: OrderId,
    )
}
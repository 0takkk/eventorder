package com.order.usecase.`in`.query.impl

import com.order.entity.Order
import com.order.exception.OrderErrorCode
import com.order.exception.OrderException
import com.order.repository.OrderRepository
import com.order.usecase.`in`.query.GetOrderQueryUseCase

class GetOrderQuery(
    private val orderRepository: OrderRepository,
) : GetOrderQueryUseCase {
    override fun invoke(query: GetOrderQueryUseCase.Query): Order {
        return orderRepository.findById(query.id)
            .orElseThrow { OrderException(OrderErrorCode.NOT_FOUND_ORDER, "Not found order - id(${query.id})") }
    }
}
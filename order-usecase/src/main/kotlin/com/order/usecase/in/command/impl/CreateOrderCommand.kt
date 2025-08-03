package com.order.usecase.`in`.command.impl

import com.order.entity.Order
import com.order.repository.OrderRepository
import com.order.usecase.`in`.command.CreateOrderCommandUseCase

class CreateOrderCommand(
    private val orderRepository: OrderRepository,
) : CreateOrderCommandUseCase {
    override fun invoke(command: CreateOrderCommandUseCase.Command): Order {
        val order = Order.of(
            userId = command.userId,
            productId = command.productId,
            amount = command.amount,
        )
        return orderRepository.save(order)
    }
}
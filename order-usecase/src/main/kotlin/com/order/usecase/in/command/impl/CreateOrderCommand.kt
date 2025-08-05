package com.order.usecase.`in`.command.impl

import com.order.entity.Order
import com.order.repository.OrderRepository
import com.order.usecase.`in`.command.CreateOrderCommandUseCase

class CreateOrderCommand(
    private val orderRepository: OrderRepository,
) : CreateOrderCommandUseCase {
    override fun invoke(command: CreateOrderCommandUseCase.Command): Order {
        val order = Order.of(command.userId, command.productId, command.amount)
        return orderRepository.save(order)
    }
}
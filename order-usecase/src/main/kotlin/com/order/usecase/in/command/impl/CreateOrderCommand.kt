package com.order.usecase.`in`.command.impl

import com.order.constant.ProductStatus
import com.order.entity.Order
import com.order.exception.order.OrderErrorCode
import com.order.exception.order.OrderException
import com.order.repository.OrderRepository
import com.order.usecase.`in`.command.CreateOrderCommandUseCase
import com.order.usecase.`in`.query.GetProductUseCase

class CreateOrderCommand(
    private val orderRepository: OrderRepository,
    private val getProductUseCase: GetProductUseCase
) : CreateOrderCommandUseCase {
    override fun invoke(command: CreateOrderCommandUseCase.Command): Order {
        val product = getProductUseCase.invoke(command.productId)

        if(product.status != ProductStatus.ACTIVE) {
            throw OrderException(OrderErrorCode.PRODUCT_NOT_AVAILABLE,
                "Product is not available for order - status(${product.status}), productId(${command.productId})")
        }

        if(!product.stockQuantity.isAvailable(command.stockQuantity)) {
            throw OrderException(OrderErrorCode.PRODUCT_STOCK_QUANTITY_NOT_AVAILABLE,
                "Product stock is not available for order - requested(${command.stockQuantity}), available(${product.stockQuantity.value()}), productId(${command.productId})")
        }

        val totalAmount = product.userAmount.multiply(command.stockQuantity.value());

        val order = Order.of(command.userId, command.productId, totalAmount)
        return orderRepository.save(order)
    }
}
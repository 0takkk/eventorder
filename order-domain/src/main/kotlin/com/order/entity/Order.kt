package com.order.entity

import com.order.common.vo.Money
import com.order.vo.OrderId
import com.order.constant.OrderStatus
import com.order.vo.ProductId
import com.order.vo.UserId
import java.time.LocalDateTime

data class Order(
    val id: OrderId,
    val userId: UserId,
    val productId: ProductId,
    val status: OrderStatus,
    val amount: Money,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    fun paymentPending(): Order {
        require(this.status == OrderStatus.CREATED)
        return this.copy(
            status = OrderStatus.PAYMENT_PENDING,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun paymentCompleted(): Order {
        require(this.status == OrderStatus.PAYMENT_PENDING)
        return this.copy(
            status = OrderStatus.PAYMENT_COMPLETED,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun orderCompleted(): Order {
        require(this.status == OrderStatus.PAYMENT_COMPLETED)
        return this.copy(
            status = OrderStatus.ORDER_COMPLETED,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun refundPaymentPending(): Order {
        require(this.status == OrderStatus.ORDER_COMPLETED)
        return this.copy(
            status = OrderStatus.REFUND_PAYMENT_PENDING,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun refundPaymentCompleted(): Order {
        require(this.status == OrderStatus.REFUND_PAYMENT_PENDING)
        return this.copy(
            status = OrderStatus.REFUND_PAYMENT_COMPLETED,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun orderRefundCompleted(): Order {
        require(this.status == OrderStatus.REFUND_PAYMENT_COMPLETED)
        return this.copy(
            status = OrderStatus.REFUND_PAYMENT_COMPLETED,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun cancel(): Order {
        require(this.status in listOf(OrderStatus.CREATED, OrderStatus.PAYMENT_PENDING))
        return this.copy(
            status = OrderStatus.CANCELED,
            updatedAt = LocalDateTime.now(),
        )
    }

    companion object {
        fun of(
            userId: UserId,
            productId: ProductId,
            amount: Money,
        ): Order {
            val now = LocalDateTime.now()
            return Order(
                id = OrderId(0L),
                userId = userId,
                productId = productId,
                status = OrderStatus.CREATED,
                amount = amount,
                createdAt = now,
                updatedAt = now,
            )
        }
    }
}

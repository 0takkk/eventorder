package com.order.repository

import com.order.vo.OrderId
import com.order.entity.Order

interface OrderRepository {
    fun save(order: Order): Order
    fun findById(id: OrderId): Order?
    fun findAllByIds(ids: List<OrderId>): List<Order>
}
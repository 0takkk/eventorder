package com.order.repository;

import com.order.entity.Order;
import com.order.vo.OrderId;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId id);

    List<Order> findAllByIds(List<OrderId> ids);
}

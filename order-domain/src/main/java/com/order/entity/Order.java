package com.order.entity;

import com.order.common.vo.Money;
import com.order.constant.OrderStatus;
import com.order.vo.OrderId;
import com.order.vo.ProductId;
import com.order.vo.UserId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Order {

    private OrderId id;

    private UserId userId;

    private ProductId productId;

    private OrderStatus status;

    private Money amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Order paymentPending() {
        if (status != OrderStatus.CREATED) {
            throw new IllegalArgumentException("Status must be CREATED");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.PAYMENT_PENDING,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public Order paymentCompleted() {
        if (status != OrderStatus.PAYMENT_PENDING) {
            throw new IllegalArgumentException("Status must be PAYMENT_PENDING");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.PAYMENT_COMPLETED,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public Order orderCompleted() {
        if (status != OrderStatus.PAYMENT_COMPLETED) {
            throw new IllegalArgumentException("Status mush be PAYMENT_COMPLETED");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.ORDER_COMPLETED,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public Order refundPaymentPending() {
        if (status != OrderStatus.PAYMENT_COMPLETED) {
            throw new IllegalArgumentException("Status mush be PAYMENT_COMPLETED");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.REFUND_PAYMENT_PENDING,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public Order refundPaymentCompleted() {
        if (status != OrderStatus.REFUND_PAYMENT_PENDING) {
            throw new IllegalArgumentException("Status must be REFUND_PAYMENT_PENDING");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.REFUND_PAYMENT_COMPLETED,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public Order orderRefundCompleted() {
        if (status != OrderStatus.REFUND_PAYMENT_COMPLETED) {
            throw new IllegalArgumentException("Status must be REFUND_PAYMENT_COMPLETED");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.REFUND_PAYMENT_COMPLETED,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public Order cancel() {
        List<OrderStatus> allowedStatuses = Arrays.asList(OrderStatus.CREATED, OrderStatus.PAYMENT_PENDING);
        if (!allowedStatuses.contains(status)) {
            throw new IllegalArgumentException("Status must be CREATED or PAYMENT_PENDING");
        }

        return new Order(
                this.id,
                this.userId,
                this.productId,
                OrderStatus.CANCELED,
                this.amount,
                this.createdAt,
                LocalDateTime.now()
        );
    }

    public static Order of(UserId userId, ProductId productId, Money amount) {
        LocalDateTime now = LocalDateTime.now();

        return new Order(
                OrderId.empty(),
                userId,
                productId,
                OrderStatus.CREATED,
                amount,
                now,
                now
        );
    }
}

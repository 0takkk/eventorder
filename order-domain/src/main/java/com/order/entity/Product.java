package com.order.entity;

import com.order.constant.ProductStatus;
import com.order.common.vo.Money;
import com.order.vo.ProductId;
import com.order.vo.StockQuantity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Product {

    private ProductId id;

    private ProductStatus status;

    private Money userAmount;

    private Money supplyAmount;

    private StockQuantity stockQuantity;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

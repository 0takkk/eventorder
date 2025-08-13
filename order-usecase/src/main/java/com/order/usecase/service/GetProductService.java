package com.order.usecase.service;

import com.order.entity.Product;
import com.order.exception.product.ProductErrorCode;
import com.order.exception.product.ProductException;
import com.order.repository.ProductRepository;
import com.order.usecase.in.query.GetProductUseCase;
import com.order.vo.ProductId;

public class GetProductService implements GetProductUseCase {

    private ProductRepository productRepository;

    @Override
    public Product invoke(ProductId productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT,
                        String.format("Not found product - id(%s)", productId.value())));
    }
}

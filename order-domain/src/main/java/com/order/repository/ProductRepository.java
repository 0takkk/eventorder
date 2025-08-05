package com.order.repository;

import com.order.entity.Product;
import com.order.vo.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(ProductId id);

    List<Product> findAllByIds(List<ProductId> ids);
}

package com.order.usecase.in.query;

import com.order.entity.Product;
import com.order.vo.ProductId;

public interface GetProductUseCase {

    Product invoke(ProductId productId);

}

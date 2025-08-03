package com.order.repository

import com.order.vo.ProductId
import com.order.entity.Product

interface ProductRepository {
    fun save(product: Product): Product
    fun findById(id: ProductId): Product?
    fun findAllByIds(ids: List<ProductId>): List<Product>
}
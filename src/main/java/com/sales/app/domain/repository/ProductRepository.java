package com.sales.app.domain.repository;

import com.sales.app.domain.ProductDomain;
import com.sales.app.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getScarceProducts(int quantity);
    Optional<ProductDomain> getProduct(int productId);
    ProductDomain save(ProductDomain productDomain);
    void delete(int productId);
}

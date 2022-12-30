package com.sales.app.persistence.crud;

import com.sales.app.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);
}

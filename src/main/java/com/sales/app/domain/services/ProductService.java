package com.sales.app.domain.services;

import com.sales.app.domain.ProductDomain;
import com.sales.app.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductDomain> getAll() {
        return productsRepository.getAll();
    }

    public Optional<ProductDomain> getProduct(int productId) {
        return productsRepository.getProduct(productId);
    }

    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        return productsRepository.getByCategory(categoryId);
    }

    public ProductDomain save(ProductDomain productDomain) {
        return productsRepository.save(productDomain);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productsRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}

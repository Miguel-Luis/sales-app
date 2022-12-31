package com.sales.app.web.controller;

import com.sales.app.domain.ProductDomain;
import com.sales.app.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDomain> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductDomain> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<ProductDomain>> getByCategory(@PathVariable("id") int id) {
        return productService.getByCategory(id);
    }

    @PostMapping()
    public ProductDomain save(ProductDomain productDomain) {
        return productService.save(productDomain);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return productService.delete(id);
    }
}

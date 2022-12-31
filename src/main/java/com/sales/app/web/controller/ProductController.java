package com.sales.app.web.controller;

import com.sales.app.domain.ProductDomain;
import com.sales.app.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDomain>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDomain> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(productDomain -> new ResponseEntity<>(productDomain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDomain>> getByCategory(@PathVariable("id") int id) {
        return productService.getByCategory(id)
                .map(productDomains -> new ResponseEntity<>(productDomains, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<ProductDomain> save(ProductDomain productDomain) {
        return new ResponseEntity<>(productService.save(productDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if(productService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

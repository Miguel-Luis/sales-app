package com.sales.app.persistence;

import com.sales.app.domain.ProductDomain;
import com.sales.app.domain.repository.ProductRepository;
import com.sales.app.persistence.crud.ProductCrudRepository;
import com.sales.app.persistence.entity.Product;
import com.sales.app.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsRepository implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> productList = (List<Product>) productCrudRepository.findAll();

        return mapper.toProducts(productList);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        List<Product> productList = productCrudRepository.findAllByCategoryIdOrderByNameAsc(categoryId);

        return Optional.of(mapper.toProducts(productList));
    }

    @Override
    public Optional<List<ProductDomain>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(quantity, true);

        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDomain> getProduct(int productId) {
         return  productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = mapper.toProduct(productDomain);

        return mapper.toProduct(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}

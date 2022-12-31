package com.sales.app.persistence.mapper;

import com.sales.app.domain.ProductDomain;
import com.sales.app.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "category", target = "category"),
    })
    ProductDomain toProduct(Product product);
    List<ProductDomain> toProducts(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct(ProductDomain productDomain);
}

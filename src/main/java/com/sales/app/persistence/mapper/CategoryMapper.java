package com.sales.app.persistence.mapper;

import com.sales.app.domain.CategoryDomain;
import com.sales.app.persistence.entity.Category;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "status", target = "status")
    })
    CategoryDomain toCategory(Category category);

    @InheritConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDomain category);
}

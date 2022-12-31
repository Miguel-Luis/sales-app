package com.sales.app.domain;

public class ProductDomain {
    private int productId;
    private int categoryId;
    private String description;
    private Double value;
    private int stock;
    private Boolean status;
    private CategoryDomain category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CategoryDomain getCategory() {
        return category;
    }

    public void setCategory(CategoryDomain category) {
        this.category = category;
    }
}

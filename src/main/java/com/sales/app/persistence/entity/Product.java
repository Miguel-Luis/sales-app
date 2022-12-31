package com.sales.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "description")
    private String name;

    private Double value;

    private Integer stock;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String description) {
        this.name = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

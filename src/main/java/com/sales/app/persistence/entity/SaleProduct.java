package com.sales.app.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "SaleProduct")
public class SaleProduct {
    @EmbeddedId
    private SaleProductPK id;

    private Integer quantity;

    @Column(name = "purchase_value")
    private Double purchaseValue;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public SaleProductPK getId() {
        return id;
    }

    public void setId(SaleProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(Double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

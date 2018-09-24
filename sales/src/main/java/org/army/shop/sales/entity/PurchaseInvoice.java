package org.army.shop.sales.entity;

import javax.persistence.Entity;

@Entity
public class PurchaseInvoice extends Invoice {

    private Long placedBy;

    private Long supplier;

    public Long getPlacedBy() {
        return placedBy;
    }

    public void setPlacedBy(Long placedBy) {
        this.placedBy = placedBy;
    }

    public Long getSupplier() {
        return supplier;
    }

    public void setSupplier(Long supplier) {
        this.supplier = supplier;
    }
}
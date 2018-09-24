package org.army.shop.sales.entity;

import javax.persistence.Entity;

@Entity
public class SalesInvoice extends Invoice {

    private Long soldBy;

    public Long getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(Long soldBy) {
        this.soldBy = soldBy;
    }
}
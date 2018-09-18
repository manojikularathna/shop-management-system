package org.army.shop.sales.entity;

import org.army.shop.inventory.entity.Supplier;
import org.army.shop.organization.entity.User;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class PurchaseInvoice extends Invoice {

    @Transient
    private User placedBy;

    @Transient
    private Supplier supplier;
}
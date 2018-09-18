package org.army.shop.sales.entity;

import org.army.shop.organization.entity.User;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class SalesInvoice extends Invoice {

    @Transient
    private User soldBy;

}
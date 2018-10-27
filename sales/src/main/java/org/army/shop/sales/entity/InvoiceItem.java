package org.army.shop.sales.entity;

import org.army.common.entity.BaseEntity;
import org.army.shop.common.entity.ItemQuantity;
import org.army.shop.common.entity.UnitPrice;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class InvoiceItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceItemId;

    private Long itemBatchId;

    @Embedded
    private ItemQuantity quantity;

    @Embedded
    private UnitPrice price;

    private BigDecimal amount;

    private String status;

    public Long getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Long invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Long getItemBatchId() {
        return itemBatchId;
    }

    public void setItemBatchId(Long itemBatchId) {
        this.itemBatchId = itemBatchId;
    }

    public ItemQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(ItemQuantity quantity) {
        this.quantity = quantity;
    }

    public UnitPrice getPrice() {
        return price;
    }

    public void setPrice(UnitPrice price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
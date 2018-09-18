package org.army.shop.sales.entity;

import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.ItemQuantity;
import org.army.shop.inventory.entity.UnitPrice;
import sun.dc.pr.PRError;

import java.math.BigDecimal;

public class InvoiceItem {

    private Long invoiceItemId;

    private ItemBatch item;

    private ItemQuantity quantity;

    private UnitPrice price;

    private BigDecimal amount;

    private String status;

    public Long getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Long invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public ItemBatch getItem() {
        return item;
    }

    public void setItem(ItemBatch item) {
        this.item = item;
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
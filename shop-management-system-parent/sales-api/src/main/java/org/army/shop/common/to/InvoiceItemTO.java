package org.army.shop.common.to;

import org.army.shop.inventory.to.ItemQuantityTO;
import org.army.shop.inventory.to.UnitPriceTO;

import java.math.BigDecimal;

public class InvoiceItemTO {

    private Long invoiceItemId;

    private ItemQuantityTO quantity;

    private UnitPriceTO price;

    private BigDecimal amount;

    private String status;

    public Long getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Long invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public ItemQuantityTO getQuantity() {
        return quantity;
    }

    public void setQuantity(ItemQuantityTO quantity) {
        this.quantity = quantity;
    }

    public UnitPriceTO getPrice() {
        return price;
    }

    public void setPrice(UnitPriceTO price) {
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
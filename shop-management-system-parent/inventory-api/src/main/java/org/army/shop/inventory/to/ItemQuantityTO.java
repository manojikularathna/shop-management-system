package org.army.shop.inventory.to;

import java.math.BigDecimal;

public class ItemQuantityTO {

    private String unit;

    private BigDecimal quantity;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
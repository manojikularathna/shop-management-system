package org.army.shop.inventory.entity;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class ItemQuantity {

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
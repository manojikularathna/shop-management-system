package org.army.shop.inventory.entity;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class UnitPrice {

    private String unitType;

    private BigDecimal price;

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
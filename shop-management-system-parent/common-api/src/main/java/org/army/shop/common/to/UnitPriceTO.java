package org.army.shop.common.to;

import java.math.BigDecimal;

public class UnitPriceTO {

    private String unit;

    private BigDecimal price;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
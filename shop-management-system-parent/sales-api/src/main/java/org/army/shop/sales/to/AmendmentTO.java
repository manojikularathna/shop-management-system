package org.army.shop.sales.to;

import java.math.BigDecimal;

public class AmendmentTO {

    private String name;

    private RateTO rate;

    private BigDecimal value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RateTO getRate() {
        return rate;
    }

    public void setRate(RateTO rate) {
        this.rate = rate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

package org.army.shop.common.to;

import java.math.BigDecimal;

public class ValueDefinition {

    private String type;
    private BigDecimal value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

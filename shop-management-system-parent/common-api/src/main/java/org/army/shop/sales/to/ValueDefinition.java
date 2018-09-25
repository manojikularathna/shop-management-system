package org.army.shop.sales.to;

import java.math.BigDecimal;

public class ValueDefinition {

    public enum Type {
        VALUE,
        PERCENTAGE
    }

    private Type type;
    private BigDecimal value;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

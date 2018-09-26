package org.army.shop.common.entity;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Value {

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


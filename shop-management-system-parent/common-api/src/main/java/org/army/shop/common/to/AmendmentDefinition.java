package org.army.shop.common.to;

public class AmendmentDefinition extends ValueDefinition {

    public enum Type {
        TAX
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

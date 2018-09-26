package org.army.shop.organization.to;

import org.army.shop.sales.to.NameTO;

public class UserTO {

    private Long userId;

    private NameTO name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public NameTO getName() {
        return name;
    }

    public void setName(NameTO name) {
        this.name = name;
    }
}
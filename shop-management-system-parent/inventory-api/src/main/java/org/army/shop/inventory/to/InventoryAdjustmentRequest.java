package org.army.shop.inventory.to;

import java.util.List;

public class InventoryAdjustmentRequest {

    private List<InventoryAdjustmentItemTO> items;

    public List<InventoryAdjustmentItemTO> getItems() {
        return items;
    }

    public void setItems(List<InventoryAdjustmentItemTO> items) {
        this.items = items;
    }
}

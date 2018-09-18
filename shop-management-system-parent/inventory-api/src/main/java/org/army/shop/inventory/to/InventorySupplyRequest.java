package org.army.shop.inventory.to;

import java.util.List;

public class InventorySupplyRequest {

    private List<ItemBatchTO> items;

    public List<ItemBatchTO> getItems() {
        return items;
    }

    public void setItems(List<ItemBatchTO> items) {
        this.items = items;
    }
}

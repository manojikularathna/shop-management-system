package org.army.shop.inventory.to;

import java.util.List;

public class InventorySupplyRequest {

    private Long supplierId;
    private List<InventorySupplyItemBatchTO> items;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public List<InventorySupplyItemBatchTO> getItems() {
        return items;
    }

    public void setItems(List<InventorySupplyItemBatchTO> items) {
        this.items = items;
    }
}

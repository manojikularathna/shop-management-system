package org.army.shop.inventory.to;

import java.util.List;

public class InventorySupplyRequest {

    private SupplierTO supplier;

    private List<InventorySupplyItemBatchTO> items;

    public SupplierTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierTO supplier) {
        this.supplier = supplier;
    }

    public List<InventorySupplyItemBatchTO> getItems() {
        return items;
    }

    public void setItems(List<InventorySupplyItemBatchTO> items) {
        this.items = items;
    }
}

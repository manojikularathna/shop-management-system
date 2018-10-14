package org.army.shop.inventory.to;

import org.army.shop.common.to.ItemQuantityTO;

public class InventoryAdjustmentItemTO {

    private Long itemBatchId;

    private ItemQuantityTO quantity;

    public Long getItemBatchId() {
        return itemBatchId;
    }

    public void setItemBatchId(Long itemBatchId) {
        this.itemBatchId = itemBatchId;
    }

    public ItemQuantityTO getQuantity() {
        return quantity;
    }

    public void setQuantity(ItemQuantityTO quantity) {
        this.quantity = quantity;
    }
}

package org.army.shop.inventory.to;

public class InventoryAdjustmentItemTO {

    private Long itemBatchStockId;

    private ItemQuantityTO quantity;

    public Long getItemBatchStockId() {
        return itemBatchStockId;
    }

    public void setItemBatchStockId(Long itemBatchStockId) {
        this.itemBatchStockId = itemBatchStockId;
    }

    public ItemQuantityTO getQuantity() {
        return quantity;
    }

    public void setQuantity(ItemQuantityTO quantity) {
        this.quantity = quantity;
    }
}

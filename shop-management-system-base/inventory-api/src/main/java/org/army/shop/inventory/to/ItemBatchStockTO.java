package org.army.shop.inventory.to;

import org.army.shop.common.to.ItemQuantityTO;
import org.army.shop.common.to.UnitPriceTO;

public class ItemBatchStockTO {

    private Long itemBatchStockId;

    private ItemBatchTO batch;

    private ItemQuantityTO remainingQuantity;

    private UnitPriceTO sellingPrice;

    public Long getItemBatchStockId() {
        return itemBatchStockId;
    }

    public void setItemBatchStockId(Long itemBatchStockId) {
        this.itemBatchStockId = itemBatchStockId;
    }

    public ItemBatchTO getBatch() {
        return batch;
    }

    public void setBatch(ItemBatchTO batch) {
        this.batch = batch;
    }

    public ItemQuantityTO getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(ItemQuantityTO remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public UnitPriceTO getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(UnitPriceTO sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
package org.army.shop.inventory.to;

import org.army.shop.sales.to.ValueDefinition;

public class InventorySupplyItemBatchTO extends BaseItemBatchTO {

    private ValueDefinition profit;

    private Long itemBrandId;

    private ItemQuantityTO purchasedQuantity;

    private UnitPriceTO purchasedPrice;

    private ItemQuantityTO lowStockBoundary;

    public ValueDefinition getProfit() {
        return profit;
    }

    public void setProfit(ValueDefinition profit) {
        this.profit = profit;
    }

    public Long getItemBrandId() {
        return itemBrandId;
    }

    public void setItemBrandId(Long itemBrandId) {
        this.itemBrandId = itemBrandId;
    }

    public ItemQuantityTO getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(ItemQuantityTO purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public UnitPriceTO getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(UnitPriceTO purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public ItemQuantityTO getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantityTO lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }
}

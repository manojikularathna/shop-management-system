package org.army.shop.inventory.to;

import org.army.shop.common.to.ItemQuantityTO;
import org.army.shop.common.to.UnitPriceTO;
import org.army.shop.common.to.ValueDefinition;

public class ItemBatchTO extends BaseItemBatchTO {

    private Long itemBatchId;

    private ValueDefinition profit;

    private ItemBrandTO itemBrand;

    private UnitPriceTO purchasedPrice;

    private SupplierTO supplier;

    private ItemQuantityTO lowStockBoundary;

    private ItemBatchStockTO stock;

    public Long getItemBatchId() {
        return itemBatchId;
    }

    public void setItemBatchId(Long itemBatchId) {
        this.itemBatchId = itemBatchId;
    }

    public ValueDefinition getProfit() {
        return profit;
    }

    public void setProfit(ValueDefinition profit) {
        this.profit = profit;
    }

    public ItemBrandTO getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(ItemBrandTO itemBrand) {
        this.itemBrand = itemBrand;
    }

    public UnitPriceTO getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(UnitPriceTO purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public SupplierTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierTO supplier) {
        this.supplier = supplier;
    }

    public ItemQuantityTO getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantityTO lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }

    public ItemBatchStockTO getStock() {
        return stock;
    }

    public void setStock(ItemBatchStockTO stock) {
        this.stock = stock;
    }
}
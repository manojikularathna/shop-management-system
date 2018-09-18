package org.army.shop.inventory.to;

public class SupplyItemTO {

    private Long supplyItemId;

    private ItemBrandTO itemBrand;

    private ItemQuantityTO minQuantity;

    private ItemQuantityTO maxQuantity;

    public Long getSupplyItemId() {
        return supplyItemId;
    }

    public void setSupplyItemId(Long supplyItemId) {
        this.supplyItemId = supplyItemId;
    }

    public ItemBrandTO getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(ItemBrandTO itemBrand) {
        this.itemBrand = itemBrand;
    }

    public ItemQuantityTO getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(ItemQuantityTO minQuantity) {
        this.minQuantity = minQuantity;
    }

    public ItemQuantityTO getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(ItemQuantityTO maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
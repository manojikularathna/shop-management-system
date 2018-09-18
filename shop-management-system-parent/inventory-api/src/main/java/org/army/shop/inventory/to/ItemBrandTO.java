package org.army.shop.inventory.to;

import java.math.BigDecimal;
import java.util.List;

public class ItemBrandTO {

    private Long itemBrandId;

    private ItemCategoryTO category;

    private String brandName;

    private BigDecimal profitPercentage;

    private ItemQuantityTO lowStockBoundary;

    private List<ItemBatchTO> batches;

    public Long getItemBrandId() {
        return itemBrandId;
    }

    public void setItemBrandId(Long itemBrandId) {
        this.itemBrandId = itemBrandId;
    }

    public ItemCategoryTO getCategory() {
        return category;
    }

    public void setCategory(ItemCategoryTO category) {
        this.category = category;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(BigDecimal profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public ItemQuantityTO getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantityTO lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }

    public List<ItemBatchTO> getBatches() {
        return batches;
    }

    public void setBatches(List<ItemBatchTO> batches) {
        this.batches = batches;
    }
}
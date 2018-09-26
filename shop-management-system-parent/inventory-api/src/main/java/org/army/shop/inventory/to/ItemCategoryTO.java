package org.army.shop.inventory.to;

import org.army.shop.sales.to.ValueDefinition;

import java.math.BigDecimal;
import java.util.List;

public class ItemCategoryTO {

    private Long itemCategoryId;

    private String itemCategoryCode;

    private String description;

    private ValueDefinition profit;

    private ItemQuantityTO lowStockBoundary;

    private List<ItemBrandTO> brands;

    public Long getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Long itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public String getItemCategoryCode() {
        return itemCategoryCode;
    }

    public void setItemCategoryCode(String itemCategoryCode) {
        this.itemCategoryCode = itemCategoryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ValueDefinition getProfit() {
        return profit;
    }

    public void setProfit(ValueDefinition profit) {
        this.profit = profit;
    }

    public ItemQuantityTO getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantityTO lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }

    public List<ItemBrandTO> getBrands() {
        return brands;
    }

    public void setBrands(List<ItemBrandTO> brands) {
        this.brands = brands;
    }
}
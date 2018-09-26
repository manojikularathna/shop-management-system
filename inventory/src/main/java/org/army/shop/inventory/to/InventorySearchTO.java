package org.army.shop.inventory.to;

import java.util.List;

public class InventorySearchTO {

    private Long branchId;
    private List<String> itemCategoryCode;
    private List<String> brandName;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public List<String> getItemCategoryCode() {
        return itemCategoryCode;
    }

    public void setItemCategoryCode(List<String> itemCategoryCode) {
        this.itemCategoryCode = itemCategoryCode;
    }

    public List<String> getBrandName() {
        return brandName;
    }

    public void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }
}

package org.army.shop.inventory.to;

public class InventorySearchRequest {

    private String view;
    private Long branchId;
    private String genericCriterion;
    private String itemCategoryCode;
    private String brandName;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getGenericCriterion() {
        return genericCriterion;
    }

    public void setGenericCriterion(String genericCriterion) {
        this.genericCriterion = genericCriterion;
    }

    public String getItemCategoryCode() {
        return itemCategoryCode;
    }

    public void setItemCategoryCode(String itemCategoryCode) {
        this.itemCategoryCode = itemCategoryCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

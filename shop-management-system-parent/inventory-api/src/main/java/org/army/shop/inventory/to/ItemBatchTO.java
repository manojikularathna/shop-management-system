package org.army.shop.inventory.to;

import java.math.BigDecimal;
import java.util.Date;

public class ItemBatchTO {

    private Long itemBatchId;

    private BigDecimal profitPercentage;

    private ItemBrandTO itemBrand;

    private Date purchasedDate;

    private ItemQuantityTO purchasedQuantity;

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

    public BigDecimal getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(BigDecimal profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public ItemBrandTO getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(ItemBrandTO itemBrand) {
        this.itemBrand = itemBrand;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
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
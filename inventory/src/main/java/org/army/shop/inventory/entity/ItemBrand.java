package org.army.shop.inventory.entity;

import org.army.shop.common.entity.ItemQuantity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemBrand {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemBrandId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_category_id")
    private ItemCategory category;

    private String brandName;

    private BigDecimal profitPercentage;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "low_stock_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "low_stock_quantity"))
    })
    private ItemQuantity lowStockBoundary;

    public Long getItemBrandId() {
        return itemBrandId;
    }

    public void setItemBrandId(Long itemBrandId) {
        this.itemBrandId = itemBrandId;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
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

    public ItemQuantity getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantity lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }
}
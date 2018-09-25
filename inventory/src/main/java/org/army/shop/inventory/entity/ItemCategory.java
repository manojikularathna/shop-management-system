package org.army.shop.inventory.entity;

import org.army.shop.common.entity.BaseEntity;
import org.army.shop.common.entity.ItemQuantity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemCategoryId;

    private String itemCategoryCode;

    private String description;

    private BigDecimal profitPercentage;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "low_stock_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "low_stock_quantity"))
    })
    private ItemQuantity lowStockBoundary;

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
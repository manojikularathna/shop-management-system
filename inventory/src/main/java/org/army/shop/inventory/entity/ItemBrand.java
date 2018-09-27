package org.army.shop.inventory.entity;

import org.army.shop.common.entity.ItemQuantity;
import org.army.shop.common.entity.Value;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItemBrand {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemBrandId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_category_id")
    private ItemCategory category;

    private String brandName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column ( name = "profit_type")),
            @AttributeOverride(name = "value", column = @Column ( name = "profit_value"))
    })
    private Value profit;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "low_stock_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "low_stock_quantity"))
    })
    private ItemQuantity lowStockBoundary;

    @OneToMany(mappedBy = "itemBrand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemBatch> batches;

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

    public Value getProfit() {
        return profit;
    }

    public void setProfit(Value profit) {
        this.profit = profit;
    }

    public ItemQuantity getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantity lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }

    public List<ItemBatch> getBatches() {
        return batches;
    }

    public void setBatches(List<ItemBatch> batches) {
        this.batches = batches;
    }
}
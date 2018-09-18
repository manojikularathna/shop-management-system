package org.army.shop.inventory.entity;

import javax.persistence.*;

@Entity
public class SupplyItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplyItemId;

    @Transient
    private ItemBrand itemBrand;

    @Transient
    private ItemQuantity minQuantity;

    @Transient
    private ItemQuantity maxQuantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Long getSupplyItemId() {
        return supplyItemId;
    }

    public void setSupplyItemId(Long supplyItemId) {
        this.supplyItemId = supplyItemId;
    }

    public ItemBrand getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(ItemBrand itemBrand) {
        this.itemBrand = itemBrand;
    }

    public ItemQuantity getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(ItemQuantity minQuantity) {
        this.minQuantity = minQuantity;
    }

    public ItemQuantity getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(ItemQuantity maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
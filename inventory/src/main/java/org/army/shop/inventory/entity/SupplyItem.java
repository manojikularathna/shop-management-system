package org.army.shop.inventory.entity;

import org.army.shop.common.entity.ItemQuantity;

import javax.persistence.*;

@Entity
public class SupplyItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplyItemId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_brand_id")
    private ItemBrand itemBrand;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "min_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "min_quantity"))
    })
    private ItemQuantity minQuantity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "max_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "max_quantity"))
    })
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
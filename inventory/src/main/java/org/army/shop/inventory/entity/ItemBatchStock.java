package org.army.shop.inventory.entity;

import org.army.shop.common.entity.ItemQuantity;
import org.army.shop.common.entity.UnitPrice;

import javax.persistence.*;

@Entity
public class ItemBatchStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemBatchStockId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ItemBatch batch;

    @Embedded
    private ItemQuantity remainingQuantity;

    @Embedded
    private UnitPrice sellingPrice;

    public Long getItemBatchStockId() {
        return itemBatchStockId;
    }

    public void setItemBatchStockId(Long itemBatchStockId) {
        this.itemBatchStockId = itemBatchStockId;
    }

    public ItemBatch getBatch() {
        return batch;
    }

    public void setBatch(ItemBatch batch) {
        this.batch = batch;
    }

    public ItemQuantity getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(ItemQuantity remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public UnitPrice getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(UnitPrice sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
package org.army.shop.inventory.entity;

import org.army.shop.common.entity.BaseEntity;
import org.army.shop.common.entity.ItemQuantity;
import org.army.shop.common.entity.UnitPrice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ItemBatch extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemBatchId;

    private BigDecimal profitPercentage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_brand_id")
    private ItemBrand itemBrand;

    private Date purchasedDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "purchased_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "purchased_quantity"))
    })
    private ItemQuantity purchasedQuantity;

    @Embedded
    private UnitPrice purchasedPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "unit", column = @Column ( name = "low_stock_unit")),
            @AttributeOverride(name = "quantity", column = @Column ( name = "low_stock_quantity"))
    })
    private ItemQuantity lowStockBoundary;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_batch_stock_id")
    private ItemBatchStock stock;

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

    public ItemBrand getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(ItemBrand itemBrand) {
        this.itemBrand = itemBrand;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public ItemQuantity getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(ItemQuantity purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public UnitPrice getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(UnitPrice purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ItemQuantity getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantity lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }

    public ItemBatchStock getStock() {
        return stock;
    }

    public void setStock(ItemBatchStock stock) {
        this.stock = stock;
    }
}
package org.army.shop.inventory.entity;

import org.army.base.common.entity.PrimaryContactInformation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierId;

    private String name;

    @Embedded
    private PrimaryContactInformation primaryContactInfo;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SupplyItem> supplyingItems;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryContactInformation getPrimaryContactInfo() {
        return primaryContactInfo;
    }

    public void setPrimaryContactInfo(PrimaryContactInformation primaryContactInfo) {
        this.primaryContactInfo = primaryContactInfo;
    }

    public List<SupplyItem> getSupplyingItems() {
        return supplyingItems;
    }

    public void setSupplyingItems(List<SupplyItem> supplyingItems) {
        this.supplyingItems = supplyingItems;
    }
}
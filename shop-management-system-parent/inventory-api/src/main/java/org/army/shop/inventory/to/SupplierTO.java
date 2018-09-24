package org.army.shop.inventory.to;

import org.army.shop.sales.to.PrimaryContactInformationTO;
import org.army.shop.sales.to.SecondaryContactInformationTO;

import java.util.List;

public class SupplierTO {

    private Long supplierId;

    private String name;

    private PrimaryContactInformationTO primaryContactInfo;

    private SecondaryContactInformationTO secondaryContactInfo;

    private List<SupplyItemTO> supplyingItems;

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

    public PrimaryContactInformationTO getPrimaryContactInfo() {
        return primaryContactInfo;
    }

    public void setPrimaryContactInfo(PrimaryContactInformationTO primaryContactInfo) {
        this.primaryContactInfo = primaryContactInfo;
    }

    public SecondaryContactInformationTO getSecondaryContactInfo() {
        return secondaryContactInfo;
    }

    public void setSecondaryContactInfo(SecondaryContactInformationTO secondaryContactInfo) {
        this.secondaryContactInfo = secondaryContactInfo;
    }

    public List<SupplyItemTO> getSupplyingItems() {
        return supplyingItems;
    }

    public void setSupplyingItems(List<SupplyItemTO> supplyingItems) {
        this.supplyingItems = supplyingItems;
    }
}
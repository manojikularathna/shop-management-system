package org.army.shop.inventory.to;

import org.army.shop.common.to.PrimaryContactInformationTO;
import org.army.shop.common.to.SecondaryContactInformationTO;

import java.util.List;

public class SupplierTO {

    private Long supplierId;

    private String name;

    private PrimaryContactInformationTO primaryContactInfo;

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

    public List<SupplyItemTO> getSupplyingItems() {
        return supplyingItems;
    }

    public void setSupplyingItems(List<SupplyItemTO> supplyingItems) {
        this.supplyingItems = supplyingItems;
    }
}
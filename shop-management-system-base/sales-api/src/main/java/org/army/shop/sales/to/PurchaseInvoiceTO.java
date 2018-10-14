package org.army.shop.sales.to;

import java.util.List;

public class PurchaseInvoiceTO extends InvoiceTO {

    private Long placedBy;

    private Long supplier;

    private List<PurchaseInvoiceItemTO> items;

    private Long branchId;

    public Long getPlacedBy() {
        return placedBy;
    }

    public void setPlacedBy(Long placedBy) {
        this.placedBy = placedBy;
    }

    public Long getSupplier() {
        return supplier;
    }

    public void setSupplier(Long supplier) {
        this.supplier = supplier;
    }

    public List<PurchaseInvoiceItemTO> getItems() {
        return items;
    }

    public void setItems(List<PurchaseInvoiceItemTO> items) {
        this.items = items;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
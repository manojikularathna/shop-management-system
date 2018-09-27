package org.army.shop.sales.to;

public class SalesInvoiceItemTO extends InvoiceItemTO {

    private Long itemBatchId;

    public Long getItemBatchId() {
        return itemBatchId;
    }

    public void setItemBatchId(Long itemBatchId) {
        this.itemBatchId = itemBatchId;
    }
}

package org.army.shop.sales.to;

import java.util.List;

public class SalesInvoiceTO extends InvoiceTO {

    private Long soldBy;

    private List<SalesInvoiceItemTO> items;

    public Long getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(Long soldBy) {
        this.soldBy = soldBy;
    }

    public List<SalesInvoiceItemTO> getItems() {
        return items;
    }

    public void setItems(List<SalesInvoiceItemTO> items) {
        this.items = items;
    }
}
package org.army.shop.sales.to;

public class SalesRequest {

    private SalesInvoiceTO invoice;

    public SalesInvoiceTO getInvoice() {
        return invoice;
    }

    public void setInvoice(SalesInvoiceTO invoice) {
        this.invoice = invoice;
    }
}

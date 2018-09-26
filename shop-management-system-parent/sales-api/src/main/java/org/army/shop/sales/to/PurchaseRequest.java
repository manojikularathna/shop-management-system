package org.army.shop.sales.to;

public class PurchaseRequest {

    private PurchaseInvoiceTO invoice;

    public PurchaseInvoiceTO getInvoice() {
        return invoice;
    }

    public void setInvoice(PurchaseInvoiceTO invoice) {
        this.invoice = invoice;
    }
}

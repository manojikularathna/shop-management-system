package org.army.shop.common.to;

public class PurchaseRequest {

    private PurchaseInvoiceTO invoice;

    public PurchaseInvoiceTO getInvoice() {
        return invoice;
    }

    public void setInvoice(PurchaseInvoiceTO invoice) {
        this.invoice = invoice;
    }
}

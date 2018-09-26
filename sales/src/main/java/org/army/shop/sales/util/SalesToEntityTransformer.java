package org.army.shop.sales.util;

import org.army.shop.sales.entity.PurchaseInvoice;
import org.army.shop.sales.to.PurchaseRequest;

public class SalesToEntityTransformer {

    public static PurchaseInvoice toPurchaseInvoice(PurchaseRequest purchaseRequest) {
        PurchaseInvoice purchaseInvoice = new PurchaseInvoice();

        return purchaseInvoice;
    }


}

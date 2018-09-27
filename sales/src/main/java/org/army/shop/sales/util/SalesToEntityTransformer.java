package org.army.shop.sales.util;

import org.army.shop.sales.entity.Amendment;
import org.army.shop.sales.entity.PurchaseInvoice;
import org.army.shop.sales.entity.SalesInvoice;
import org.army.shop.sales.to.AmendmentTO;
import org.army.shop.sales.to.PurchaseRequest;
import org.army.shop.sales.to.SalesRequest;

public class SalesToEntityTransformer {

    public static PurchaseInvoice toPurchaseInvoice(PurchaseRequest purchaseRequest) {
        PurchaseInvoice purchaseInvoice = new PurchaseInvoice();
//TODO
        return purchaseInvoice;
    }

    public static SalesInvoice toSalesInvoice(SalesRequest salesRequest) {
        SalesInvoice salesInvoice = new SalesInvoice();
//TODO

        return salesInvoice;
    }

    public static Amendment toAmendment(AmendmentTO amendmentTO) {
        Amendment amendment = new Amendment();
//TODO

        return amendment;
    }

}

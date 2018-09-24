package org.army.shop.sales.to;

import org.army.shop.inventory.to.SupplierTO;
import org.army.shop.organization.to.UserTO;

public class PurchaseInvoiceTO extends InvoiceTO {

    private UserTO placedBy;

    private SupplierTO supplier;
}
package org.army.shop.sales.util;

import org.army.shop.common.CommonConstants;
import org.army.shop.common.util.CommonToEntityTransformer;
import org.army.shop.sales.entity.Amendment;
import org.army.shop.sales.entity.InvoiceItem;
import org.army.shop.sales.entity.PurchaseInvoice;
import org.army.shop.sales.entity.SalesInvoice;
import org.army.shop.sales.to.*;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.stream.Collectors;

public class SalesToEntityTransformer {

    public static PurchaseInvoice toPurchaseInvoice(PurchaseRequest purchaseRequest) {
        PurchaseInvoice purchaseInvoice = new PurchaseInvoice();

        PurchaseInvoiceTO purchaseInvoiceTO = purchaseRequest.getInvoice();
        purchaseInvoice.setPlacedBy(purchaseInvoiceTO.getPlacedBy());
        purchaseInvoice.setSupplier(purchaseInvoice.getSupplier());
        purchaseInvoice.setItems(purchaseInvoiceTO.getItems()
                .stream()
                .map(SalesToEntityTransformer::toInvoiceItem)
                .collect(Collectors.toList()));
        purchaseInvoice.setDate(new Date());
        purchaseInvoice.setStatus(CommonConstants.Status.ACTIVE);
        purchaseInvoice.setTotal(SalesUtils.getInvoiceTotal(purchaseInvoice));


        return purchaseInvoice;
    }

    public static SalesInvoice toSalesInvoice(SalesRequest salesRequest) {
        SalesInvoice salesInvoice = new SalesInvoice();

        SalesInvoiceTO salesInvoiceTO = salesRequest.getInvoice();
        salesInvoice.setSoldBy(salesInvoiceTO.getSoldBy());
        salesInvoice.setItems(salesInvoiceTO.getItems()
                .stream()
                .map(SalesToEntityTransformer::toInvoiceItem)
                .collect(Collectors.toList()));
        salesInvoice.setDate(new Date());
        salesInvoice.setStatus(CommonConstants.Status.ACTIVE);
        salesInvoice.setTotal(SalesUtils.getInvoiceTotal(salesInvoice));

        return salesInvoice;
    }

    public static Amendment toAmendment(AmendmentTO amendmentTO) {
        Amendment amendment = new Amendment();
        amendment.setName(amendmentTO.getName());
        amendment.setAmount(amendmentTO.getAmount());

        return amendment;
    }

    public static InvoiceItem toInvoiceItem(InvoiceItemTO invoiceItemTO) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItemBatchId(invoiceItem.getItemBatchId());
        invoiceItem.setQuantity(CommonToEntityTransformer.toItemQuantity(invoiceItemTO.getQuantity()));
        invoiceItem.setPrice(CommonToEntityTransformer.toUnitPrice(invoiceItemTO.getPrice()));
        invoiceItem.setAmount(invoiceItemTO.getPrice().getPrice()
                .multiply(invoiceItemTO.getQuantity().getQuantity())
                .round(new MathContext(2, RoundingMode.CEILING)));
        invoiceItem.setStatus(CommonConstants.Status.ACTIVE);

        return invoiceItem;
    }

}

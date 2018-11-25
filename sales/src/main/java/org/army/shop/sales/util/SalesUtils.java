package org.army.shop.sales.util;

import org.army.shop.common.CommonConstants;
import org.army.shop.common.to.ItemQuantityTO;
import org.army.shop.common.to.UnitPriceTO;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySupplyItemBatchTO;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.sales.entity.Invoice;
import org.army.shop.sales.to.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class SalesUtils {

    public static InventorySupplyRequest toInventorySupplyRequest(PurchaseRequest purchaseRequest) {
        InventorySupplyRequest inventorySupplyRequest = new InventorySupplyRequest();

        PurchaseInvoiceTO purchaseInvoiceTO = purchaseRequest.getInvoice();
        inventorySupplyRequest.setSupplierId(purchaseInvoiceTO.getSupplier());
        inventorySupplyRequest.setItems(purchaseInvoiceTO.getItems()
                .stream()
                .map(purchaseInvoiceItemTO -> {
                    InventorySupplyItemBatchTO inventorySupplyItemBatchTO = SalesToTOTransformer.toIntInventorySupplyItemBatchTO(purchaseInvoiceItemTO);
                    inventorySupplyItemBatchTO.setBranchId(purchaseInvoiceTO.getBranchId());

                    return inventorySupplyItemBatchTO;
                })
                .collect(Collectors.toList()));

        return inventorySupplyRequest;
    }

    public static InventoryAdjustmentRequest toInventoryAdjustmentRequest(SalesRequest salesRequest) {
        InventoryAdjustmentRequest inventoryAdjustmentRequest = new InventoryAdjustmentRequest();

        SalesInvoiceTO salesInvoiceTO = salesRequest.getInvoice();
        inventoryAdjustmentRequest.setItems(salesInvoiceTO.getItems()
                .stream()
                .map(SalesToTOTransformer::toInventoryAdjustmentItemTO)
                .collect(Collectors.toList()));

        return inventoryAdjustmentRequest;
    }

    public static BigDecimal getSubTotal(List<? extends InvoiceItemTO> items) {
        AtomicReference<BigDecimal> total = new AtomicReference<>();
        total.set(BigDecimal.ZERO);

        items
                .forEach(item -> {
                    total.set(total.get().add(getAmount(item.getPrice(), item.getQuantity())));
                });

        return total.get();
    }

    public static BigDecimal getAmount(UnitPriceTO price, ItemQuantityTO quantity) {
        return price.getPrice()
                .multiply(quantity.getQuantity())
                .round(new MathContext(2, RoundingMode.CEILING));
    }

    public static BigDecimal getAmendmentsTotal(List<AmendmentTO> amendments) {
        AtomicReference<BigDecimal> total = new AtomicReference<>();
        total.set(BigDecimal.ZERO);

        amendments
                .forEach(amendment -> {
                    total.set(total.get().add(amendment.getAmount()));
                });

        return total.get();
    }

    public static BigDecimal getSubTotal(Invoice invoice) {

        AtomicReference<BigDecimal> total = new AtomicReference<>();
        total.set(BigDecimal.ZERO);

        invoice.getItems()
                .forEach(item -> {
                    total.set(total.get().add(item.getAmount()));
                });

        return total.get();
    }

    public static BigDecimal getInvoiceTotal(Invoice invoice) {

        AtomicReference<BigDecimal> total = new AtomicReference<>();
        total.set(getSubTotal(invoice));

        if (invoice.getAmendments() != null) {
            invoice.getAmendments()
                    .forEach(amendment -> {
                        total.set(total.get().add(amendment.getAmount()));
                    });
        }


        return total.get();
    }

    public static BigDecimal getAmendment(String valueType, BigDecimal value, BigDecimal amount) {

        BigDecimal amendment = BigDecimal.ZERO;

        switch (valueType) {
            case CommonConstants.ValueType.VALUE:
                amendment = value;
                break;
            case CommonConstants.ValueType.PERCENTAGE:
                amendment = amount.multiply(value)
                        .round(new MathContext(2, RoundingMode.CEILING));
                break;
        }

        return amendment;
    }
}

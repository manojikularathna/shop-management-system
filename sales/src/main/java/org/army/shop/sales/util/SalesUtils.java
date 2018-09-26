package org.army.shop.sales.util;

import org.army.shop.common.CommonConstants;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.sales.entity.Invoice;
import org.army.shop.sales.to.AmendmentTO;
import org.army.shop.sales.to.InvoiceItemTO;
import org.army.shop.sales.to.PurchaseRequest;
import org.army.shop.sales.to.SalesRequest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SalesUtils {

    public static InventorySupplyRequest toInventorySupplyRequest(PurchaseRequest purchaseRequest) {
        InventorySupplyRequest inventorySupplyRequest = new InventorySupplyRequest();

        return inventorySupplyRequest;
    }

    public static InventoryAdjustmentRequest toInventoryAdjustmentRequest(SalesRequest salesRequest) {
        InventoryAdjustmentRequest inventoryAdjustmentRequest = new InventoryAdjustmentRequest();

        return inventoryAdjustmentRequest;
    }

    public static BigDecimal getSubTotal(List<InvoiceItemTO> items) {
        AtomicReference<BigDecimal> total = new AtomicReference<>();
        total.set(BigDecimal.ZERO);

        items
                .forEach(item -> {
                    total.set(total.get().add(item.getAmount()));
                });

        return total.get();
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

        invoice.getAmendments()
                .forEach(amendment -> {
                    total.set(total.get().add(amendment.getAmount()));
                });


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

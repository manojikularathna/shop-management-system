package org.army.shop.sales.util;

import org.army.shop.inventory.to.InventoryAdjustmentItemTO;
import org.army.shop.inventory.to.InventorySupplyItemBatchTO;
import org.army.shop.sales.to.PurchaseInvoiceItemTO;
import org.army.shop.sales.to.SalesInvoiceItemTO;

public class SalesToTOTransformer {

    public static InventorySupplyItemBatchTO toIntInventorySupplyItemBatchTO(PurchaseInvoiceItemTO invoiceItemTO) {
        InventorySupplyItemBatchTO inventorySupplyItemBatchTO = new InventorySupplyItemBatchTO();
        inventorySupplyItemBatchTO.setItemBrandId(invoiceItemTO.getItemBrandId());
        inventorySupplyItemBatchTO.setLowStockBoundary(invoiceItemTO.getLowStockBoundary());
        inventorySupplyItemBatchTO.setProfit(invoiceItemTO.getProfit());
        inventorySupplyItemBatchTO.setPurchasedPrice(invoiceItemTO.getPrice());
        inventorySupplyItemBatchTO.setPurchasedQuantity(invoiceItemTO.getQuantity());

        return inventorySupplyItemBatchTO;
    }

    public static InventoryAdjustmentItemTO toInventoryAdjustmentItemTO(SalesInvoiceItemTO invoiceItemTO) {
        InventoryAdjustmentItemTO inventoryAdjustmentItemTO = new InventoryAdjustmentItemTO();
        inventoryAdjustmentItemTO.setItemBatchId(invoiceItemTO.getItemBatchId());
        inventoryAdjustmentItemTO.setQuantity(invoiceItemTO.getQuantity());

        return inventoryAdjustmentItemTO;
    }

}

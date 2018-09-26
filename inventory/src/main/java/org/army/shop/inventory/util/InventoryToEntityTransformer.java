package org.army.shop.inventory.util;

import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.Supplier;
import org.army.shop.inventory.to.InventorySupplyItemBatchTO;
import org.army.shop.inventory.to.SupplierTO;

public class InventoryToEntityTransformer {

    public static Supplier toSupplier(SupplierTO supplierTO) {
        Supplier supplier = new Supplier();

        return supplier;
    }

    public static ItemBatch toItemBatch(InventorySupplyItemBatchTO itemBatchTO) {
        ItemBatch itemBatch = new ItemBatch();

        return itemBatch;
    }

}

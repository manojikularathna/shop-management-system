package org.army.shop.inventory.util;

import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.ItemCategory;
import org.army.shop.inventory.entity.Supplier;
import org.army.shop.inventory.to.InventorySupplyItemBatchTO;
import org.army.shop.inventory.to.ItemCategoryTO;
import org.army.shop.inventory.to.SupplierTO;

public class InventoryToEntityTransformer {

    public static Supplier toSupplier(SupplierTO supplierTO) {
        Supplier supplier = new Supplier();
        mergeSupplier(supplier, supplierTO);

        return supplier;
    }

    public static void mergeSupplier(Supplier supplier, SupplierTO supplierTO) {

    }

    public static ItemBatch toItemBatch(InventorySupplyItemBatchTO itemBatchTO) {
        ItemBatch itemBatch = new ItemBatch();

        return itemBatch;
    }

    public static ItemCategory toItemCategory(ItemCategoryTO itemCategoryTO) {
        ItemCategory itemCategory = new ItemCategory();
        mergeItemCategory(itemCategory, itemCategoryTO);

        return itemCategory;
    }

    public static void mergeItemCategory(ItemCategory itemCategory, ItemCategoryTO itemCategoryTO) {

    }

}

package org.army.shop.inventory.util;

import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.ItemCategory;
import org.army.shop.inventory.entity.Supplier;
import org.army.shop.inventory.to.ItemBatchTO;
import org.army.shop.inventory.to.ItemCategoryTO;
import org.army.shop.inventory.to.SupplierTO;

public class InventoryToTOTransformer {

    public static ItemBatchTO toItemBatchTO(ItemBatch itemBatch) {
        ItemBatchTO itemBatchTO = new ItemBatchTO();


        return itemBatchTO;
    }

    public static SupplierTO toSupplierTO(Supplier supplier) {
        SupplierTO supplierTO = new SupplierTO();


        return supplierTO;
    }

    public static ItemCategoryTO toItemCategoryTO(ItemCategory itemCategory) {
        ItemCategoryTO itemCategoryTO = new ItemCategoryTO();

        return itemCategoryTO;
    }

}

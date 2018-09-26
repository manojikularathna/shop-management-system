package org.army.shop.inventory.bl;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;
import org.army.shop.inventory.to.ItemCategoryTO;

import java.util.List;

public interface InventoryBL {

    BaseResponse addItemCategory(ItemCategoryTO itemCategoryTO);

    BaseResponse updateItemCategory(ItemCategoryTO itemCategoryTO);

    List<ItemCategoryTO> getItemCategories();

    InventorySearchResponse search(InventorySearchRequest inventorySearch);

    BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment);

}

package org.army.shop.inventory.api;

import org.army.base.common.to.BaseResponse;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;
import org.army.shop.inventory.to.ItemCategoryTO;

import java.util.List;

public interface InventoryService {

    BaseResponse addItemCategory(ItemCategoryTO itemCategoryTO);

    BaseResponse updateItemCategory(ItemCategoryTO itemCategoryTO);

    List<ItemCategoryTO> getItemCategories();

    InventorySearchResponse searchBatches(InventorySearchRequest inventorySearch);

    InventorySearchResponse searchBrands(InventorySearchRequest inventorySearch);

    BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment);

}

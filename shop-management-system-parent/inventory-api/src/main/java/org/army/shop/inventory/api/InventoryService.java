package org.army.shop.inventory.api;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;

public interface InventoryService {

    InventorySearchResponse search(InventorySearchRequest inventorySearch);

    BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment);

}

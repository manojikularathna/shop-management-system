package org.army.shop.inventory.bl;

import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;
import org.army.shop.sales.to.BaseResponse;

public interface InventoryBL {

    InventorySearchResponse search(InventorySearchRequest inventorySearch);

    BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment);

}

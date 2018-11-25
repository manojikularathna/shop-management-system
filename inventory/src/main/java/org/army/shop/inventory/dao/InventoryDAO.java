package org.army.shop.inventory.dao;


import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.ItemBrand;
import org.army.shop.inventory.to.InventorySearchTO;

import java.util.List;

public interface InventoryDAO {

    List<ItemBatch> searchBatches(InventorySearchTO inventorySearch);

    List<ItemBrand> searchBrands(InventorySearchTO inventorySearch);

}

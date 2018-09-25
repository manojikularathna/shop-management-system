package org.army.shop.inventory.dao;


import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.to.InventorySearchTO;

import java.util.List;

public interface InventoryDAO {

    List<ItemBatch> search(InventorySearchTO inventorySearch);

}

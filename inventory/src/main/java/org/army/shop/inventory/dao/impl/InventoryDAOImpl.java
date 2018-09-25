package org.army.shop.inventory.dao.impl;

import org.army.shop.inventory.dao.InventoryDAO;
import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.to.InventorySearchTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ItemBatch> search(InventorySearchTO inventorySearch) {

        List<ItemBatch> items = entityManager
                .createQuery(" select ib from ItemBatch ib where ib  and ib.stock.remainingQuantity.quantity > 0")
                .getResultList();

        return null;
    }
}

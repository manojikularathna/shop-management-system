package org.army.shop.inventory.bl.impl;

import org.army.shop.common.conf.ApplicationConfiguration;
import org.army.shop.inventory.bl.InventoryBL;
import org.army.shop.inventory.dao.InventoryDAO;
import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.to.*;
import org.army.shop.inventory.util.InventoryToTOTransformer;
import org.army.shop.sales.to.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryBLImpl implements InventoryBL {

    @Autowired
    private ApplicationConfiguration configuration;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Override
    public InventorySearchResponse search(InventorySearchRequest inventorySearch) {

        InventorySearchTO inventorySearchTO = new InventorySearchTO();
        inventorySearchTO.setItemCategoryCode(inventorySearch.getGenericCriterion());
        inventorySearchTO.setBrandName(inventorySearch.getGenericCriterion());

        List<ItemBatch> items = inventoryDAO.search(inventorySearchTO);

        List<ItemBatchTO> tos = items
                .stream()
                .map(InventoryToTOTransformer::toItemBatchTO)
                .collect(Collectors.toList());

        InventorySearchResponse response = new InventorySearchResponse();
        response.setItems(tos);

        return response;
    }

    @Override
    public BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment) {
        return null;
    }
}

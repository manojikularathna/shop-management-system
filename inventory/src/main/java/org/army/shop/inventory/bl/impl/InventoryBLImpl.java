package org.army.shop.inventory.bl.impl;

import org.army.shop.common.conf.ApplicationConfiguration;
import org.army.shop.inventory.bl.InventoryBL;
import org.army.shop.inventory.dao.InventoryDAO;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;
import org.army.shop.sales.to.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryBLImpl implements InventoryBL {

    @Autowired
    private ApplicationConfiguration configuration;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Override
    public InventorySearchResponse search(InventorySearchRequest inventorySearch) {
        return null;
    }

    @Override
    public BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment) {
        return null;
    }
}

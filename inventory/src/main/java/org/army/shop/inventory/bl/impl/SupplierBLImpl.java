package org.army.shop.inventory.bl.impl;

import org.army.shop.inventory.bl.SupplierBL;
import org.army.shop.inventory.dao.SupplierDAO;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.army.shop.sales.to.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierBLImpl implements SupplierBL {

    @Autowired
    private SupplierDAO supplierDAO;

    @Override
    public List<SupplierTO> getSuppliers() {
        return null;
    }

    @Override
    public BaseResponse addSupplier(SupplierTO supplier) {
        return null;
    }

    @Override
    public BaseResponse supply(InventorySupplyRequest request) {
        return null;
    }
}

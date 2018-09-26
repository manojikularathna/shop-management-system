package org.army.shop.inventory.bl.impl;

import org.army.shop.common.conf.ApplicationConfiguration;
import org.army.shop.common.dao.CommonDAO;
import org.army.shop.inventory.bl.SupplierBL;
import org.army.shop.inventory.dao.SupplierDAO;
import org.army.shop.inventory.entity.Supplier;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.army.shop.inventory.util.InventoryToEntityTransformer;
import org.army.shop.inventory.util.InventoryToTOTransformer;
import org.army.shop.sales.to.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierBLImpl implements SupplierBL {

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private ApplicationConfiguration configuration;

    @Override
    public List<SupplierTO> getSuppliers() {

        List<Supplier> suppliers = commonDAO.get(Supplier.class);

        List<SupplierTO> supplierTOs = suppliers
                .stream()
                .map(InventoryToTOTransformer::toSupplierTO)
                .collect(Collectors.toList());

        return supplierTOs;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse addSupplier(SupplierTO supplier) {

        Supplier s = InventoryToEntityTransformer.toSupplier(supplier);
        s = commonDAO.add(s);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse updateSupplier(SupplierTO supplier) {
        return null;
    }

    @Override
    public BaseResponse supply(InventorySupplyRequest request) {
        return null;
    }
}

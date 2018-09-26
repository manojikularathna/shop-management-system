package org.army.shop.inventory.bl.impl;

import org.army.shop.common.conf.ApplicationConfiguration;
import org.army.shop.common.dao.CommonDAO;
import org.army.shop.common.entity.UnitPrice;
import org.army.shop.common.entity.Value;
import org.army.shop.inventory.bl.SupplierBL;
import org.army.shop.inventory.dao.SupplierDAO;
import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.ItemBrand;
import org.army.shop.inventory.entity.Supplier;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.army.shop.inventory.util.InventoryToEntityTransformer;
import org.army.shop.inventory.util.InventoryToTOTransformer;
import org.army.shop.sales.to.BaseResponse;
import org.army.shop.inventory.util.InventoryUtils;
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

    public BaseResponse updateSupplier(SupplierTO supplier) {
//        TODO --
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse supply(InventorySupplyRequest request) {

        Supplier supplier = commonDAO.get(Supplier.class, request.getSupplierId());

        List<ItemBatch> batches = request.getItems()
                .stream()
                .map(item -> {

                    ItemBrand brand = commonDAO.get(ItemBrand.class, item.getItemBrandId());
                    ItemBatch batch = InventoryToEntityTransformer.toItemBatch(item);

                    batch.setSupplier(supplier);
                    batch.setItemBrand(brand);

                    Value value = null;
                    if (brand.getProfit() != null) {
                        value = brand.getProfit();
                    } else if (brand.getCategory().getProfit() != null) {
                        value = brand.getCategory().getProfit();
                    } else {
                        value = new Value();
                        value.setType(configuration.getProfit().getType());
                        value.setValue(configuration.getProfit().getValue());
                    }

                    UnitPrice sellingPrice = InventoryUtils.getSellingPrice(batch.getPurchasedPrice(), value);
                    batch.getStock().setSellingPrice(sellingPrice);

                    return batch;
                })
                .collect(Collectors.toList());

        commonDAO.add(batches);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);

        return response;
    }
}

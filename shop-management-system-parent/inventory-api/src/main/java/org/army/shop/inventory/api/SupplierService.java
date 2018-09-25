package org.army.shop.inventory.api;

import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.army.shop.sales.to.BaseResponse;

import java.util.List;

public interface SupplierService {

    List<SupplierTO> getSuppliers();

    BaseResponse addSupplier(SupplierTO supplier);

    BaseResponse supply(InventorySupplyRequest request);
}
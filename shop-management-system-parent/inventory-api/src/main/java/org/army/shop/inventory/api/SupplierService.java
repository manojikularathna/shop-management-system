package org.army.shop.inventory.api;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;

import java.util.List;

public interface SupplierService {

    List<SupplierTO> getSuppliers();

    BaseResponse addSupplier();

    BaseResponse supply(InventorySupplyRequest request);
}

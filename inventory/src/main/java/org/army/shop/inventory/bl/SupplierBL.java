package org.army.shop.inventory.bl;

import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.army.shop.common.to.BaseResponse;

import java.util.List;

public interface SupplierBL {

    List<SupplierTO> getSuppliers();

    BaseResponse addSupplier(SupplierTO supplier);

    BaseResponse updateSupplier(SupplierTO supplier);

    BaseResponse supply(InventorySupplyRequest request);
}

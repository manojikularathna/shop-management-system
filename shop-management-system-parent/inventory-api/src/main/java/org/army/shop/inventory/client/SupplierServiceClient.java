package org.army.shop.inventory.client;

import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.common.to.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
public interface SupplierServiceClient {

    BaseResponse supply(InventorySupplyRequest request);
}

package org.army.shop.inventory.client;

import org.army.base.common.to.BaseResponse;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "inventory", url = "http://localhost:8080/inventory")
public interface InventoryServiceClient {

    @RequestMapping(path = "/remove", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BaseResponse remove(@RequestBody InventoryAdjustmentRequest inventoryAdjustment);

}

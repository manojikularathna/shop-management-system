package org.army.shop.inventory.client;

import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.common.to.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "supplier", url = "http://localhost:8080/supplier")
public interface SupplierServiceClient {

    @RequestMapping(path = "/supply", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BaseResponse supply(@RequestBody InventorySupplyRequest request);
}

package org.army.shop.inventory.service;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.api.InventoryService;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryServiceImpl implements InventoryService {

    @RequestMapping(path = "/search", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InventorySearchResponse search(InventorySearchRequest inventorySearch) {
        return null;
    }

    @RequestMapping(path = "/remove", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment) {
        return null;
    }
}

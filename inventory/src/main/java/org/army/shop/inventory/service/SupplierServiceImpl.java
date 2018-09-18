package org.army.shop.inventory.service;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.api.SupplierService;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/supplier")
public class SupplierServiceImpl implements SupplierService {

    @RequestMapping(path = "/all", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SupplierTO> getSuppliers() {
        return null;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addSupplier() {
        return null;
    }

    @RequestMapping(path = "/supply", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse supply(InventorySupplyRequest request) {
        return null;
    }
}

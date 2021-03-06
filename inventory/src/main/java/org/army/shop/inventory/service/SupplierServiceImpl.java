package org.army.shop.inventory.service;

import org.army.base.common.to.BaseResponse;
import org.army.shop.inventory.api.SupplierService;
import org.army.shop.inventory.bl.SupplierBL;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.inventory.to.SupplierTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/supplier")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierBL supplierBL;

    @RequestMapping(path = "/all", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SupplierTO> getSuppliers() {
        return supplierBL.getSuppliers();
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addSupplier(@RequestBody SupplierTO supplier) {
        return supplierBL.addSupplier(supplier);
    }


    @RequestMapping(path = "/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateSupplier(SupplierTO supplier) {
        return supplierBL.updateSupplier(supplier);
    }

    @RequestMapping(path = "/supply", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse supply(@RequestBody InventorySupplyRequest request) {
        return supplierBL.supply(request);
    }
}

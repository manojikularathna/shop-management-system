package org.army.shop.sales.service;

import org.army.shop.sales.api.PurchaseService;
import org.army.shop.common.to.BaseResponse;
import org.army.shop.common.to.CancelTransactionRequest;
import org.army.shop.common.to.PurchaseRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/purchase")
public class PurchaseServiceImpl implements PurchaseService {

    @RequestMapping(path = "/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse purchase(@RequestBody PurchaseRequest purchaseOrder) {
        return null;
    }

    @RequestMapping(path = "/cancel", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse cancelPurchase(@RequestBody CancelTransactionRequest cancel) {
        return null;
    }
}

package org.army.shop.sales.bl.impl;

import org.army.shop.inventory.client.SupplierServiceClient;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.sales.bl.PurchaseServiceBL;
import org.army.shop.common.to.BaseResponse;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.PurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceBLImpl implements PurchaseServiceBL {

    @Autowired
    private SupplierServiceClient supplierServiceClient;


    @Override
    public BaseResponse purchase(PurchaseRequest purchaseOrder) {



        InventorySupplyRequest inventorySupplyRequest = new InventorySupplyRequest();
        supplierServiceClient.supply(inventorySupplyRequest);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);

        return response;
    }

    @Override
    public BaseResponse cancelPurchase(CancelTransactionRequest cancel) {
        return null;
    }
}

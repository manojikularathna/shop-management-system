package org.army.shop.sales.bl.impl;

import org.army.base.common.to.BaseResponse;
import org.army.common.dao.CommonDAO;
import org.army.shop.inventory.client.SupplierServiceClient;
import org.army.shop.inventory.to.InventorySupplyRequest;
import org.army.shop.sales.bl.PurchaseServiceBL;
import org.army.shop.sales.entity.PurchaseInvoice;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.PurchaseRequest;
import org.army.shop.sales.util.SalesToEntityTransformer;
import org.army.shop.sales.util.SalesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceBLImpl implements PurchaseServiceBL {

    @Autowired
    private SupplierServiceClient supplierServiceClient;

    @Autowired
    private CommonDAO commonDAO;

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse purchase(PurchaseRequest purchaseOrder) {

        PurchaseInvoice purchaseInvoice = SalesToEntityTransformer.toPurchaseInvoice(purchaseOrder);
        purchaseInvoice.setTotal(SalesUtils.getInvoiceTotal(purchaseInvoice));

        commonDAO.add(purchaseInvoice);

        InventorySupplyRequest inventorySupplyRequest = SalesUtils.toInventorySupplyRequest(purchaseOrder);
        supplierServiceClient.supply(inventorySupplyRequest);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);

        return response;
    }

    @Override
    public BaseResponse cancelPurchase(CancelTransactionRequest cancel) {
//        TODO
        return null;
    }
}

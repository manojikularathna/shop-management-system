package org.army.shop.sales.bl.impl;

import org.army.base.common.to.BaseResponse;
import org.army.common.accounting.client.TransactionServiceClient;
import org.army.common.accounting.to.AccountingRequest;
import org.army.common.accounting.to.common.OrganizationTO;
import org.army.common.accounting.to.transaction.TransactionTO;
import org.army.common.dao.CommonDAO;
import org.army.shop.common.CommonConstants;
import org.army.shop.common.conf.AccountingConfiguration;
import org.army.shop.common.conf.ShopManagementApplicationConfiguration;
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

import java.util.Date;

@Service
public class PurchaseServiceBLImpl implements PurchaseServiceBL {

    @Autowired
    private SupplierServiceClient supplierServiceClient;

    @Autowired
    private TransactionServiceClient transactionServiceClient;

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private ShopManagementApplicationConfiguration configuration;

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse purchase(PurchaseRequest purchaseOrder) {

        PurchaseInvoice purchaseInvoice = SalesToEntityTransformer.toPurchaseInvoice(purchaseOrder);
        purchaseInvoice.setTotal(SalesUtils.getInvoiceTotal(purchaseInvoice));

        commonDAO.add(purchaseInvoice);

        InventorySupplyRequest inventorySupplyRequest = SalesUtils.toInventorySupplyRequest(purchaseOrder);
        supplierServiceClient.supply(inventorySupplyRequest);

        AccountingConfiguration accounting = configuration.getAccounting();

        AccountingRequest<TransactionTO> accountingRequest = new AccountingRequest<>();

        OrganizationTO organizationTO = new OrganizationTO();
        organizationTO.setOrganization(accounting.getOrganization());

        TransactionTO transactionTO = new TransactionTO();
        transactionTO.setDate(new Date());
        transactionTO.setTransactionTypeCode(CommonConstants.TransactionTypeCode.PURCHASE);
        transactionTO.setAmount(purchaseInvoice.getTotal());
        transactionTO.setCashBookCode(accounting.getCashbooks().get("CASH")); // TODO -- need to be sent in request

        accountingRequest.setOrganization(organizationTO);
        accountingRequest.setPayload(transactionTO);

        transactionServiceClient.submit(accountingRequest);

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

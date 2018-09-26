package org.army.shop.sales.bl;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.PurchaseRequest;

public interface PurchaseServiceBL {

    BaseResponse purchase(PurchaseRequest purchaseOrder);

    BaseResponse cancelPurchase(CancelTransactionRequest cancel);
}

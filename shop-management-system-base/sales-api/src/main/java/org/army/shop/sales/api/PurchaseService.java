package org.army.shop.sales.api;

import org.army.base.common.to.BaseResponse;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.PurchaseRequest;

public interface PurchaseService {

    BaseResponse purchase(PurchaseRequest purchaseOrder);

    BaseResponse cancelPurchase(CancelTransactionRequest cancel);

}

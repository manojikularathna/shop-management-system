package org.army.shop.common.api;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.common.to.CancelTransactionRequest;
import org.army.shop.common.to.PurchaseRequest;

public interface PurchaseService {

    BaseResponse purchase(PurchaseRequest purchaseOrder);

    BaseResponse cancelPurchase(CancelTransactionRequest cancel);

}

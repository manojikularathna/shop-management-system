package org.army.shop.common.api;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.common.to.CancelTransactionRequest;
import org.army.shop.common.to.SalesRequest;

public interface SalesService {

    BaseResponse sale(SalesRequest sales);

    BaseResponse cancelSale(CancelTransactionRequest cancel);

}

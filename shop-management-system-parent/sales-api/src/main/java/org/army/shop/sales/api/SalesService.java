package org.army.shop.sales.api;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.common.to.CancelTransactionRequest;
import org.army.shop.common.to.SalesCalculationResponse;
import org.army.shop.common.to.SalesRequest;

public interface SalesService {

    SalesCalculationResponse calculate(SalesRequest sales);

    BaseResponse sale(SalesRequest sales);

    BaseResponse cancelSale(CancelTransactionRequest cancel);

}

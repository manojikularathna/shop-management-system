package org.army.shop.sales.api;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.SalesCalculationResponse;
import org.army.shop.sales.to.SalesRequest;

public interface SalesService {

    SalesCalculationResponse calculate(SalesRequest sales);

    BaseResponse sell(SalesRequest sales);

    BaseResponse cancelSale(CancelTransactionRequest cancel);

}

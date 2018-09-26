package org.army.shop.sales.bl.impl;

import org.army.shop.sales.bl.SalesServiceBL;
import org.army.shop.common.to.BaseResponse;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.SalesCalculationResponse;
import org.army.shop.sales.to.SalesRequest;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceBLImpl implements SalesServiceBL {

    @Override
    public SalesCalculationResponse calculate(SalesRequest sales) {
        return null;
    }

    @Override
    public BaseResponse sell(SalesRequest sales) {
        return null;
    }

    @Override
    public BaseResponse cancelSale(CancelTransactionRequest cancel) {
        return null;
    }
}

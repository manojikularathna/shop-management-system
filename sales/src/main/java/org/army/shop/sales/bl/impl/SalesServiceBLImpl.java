package org.army.shop.sales.bl.impl;

import org.army.shop.common.conf.ApplicationConfiguration;
import org.army.shop.common.dao.CommonDAO;
import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.client.InventoryServiceClient;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.sales.bl.SalesServiceBL;
import org.army.shop.sales.entity.Amendment;
import org.army.shop.sales.entity.SalesInvoice;
import org.army.shop.sales.to.AmendmentTO;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.SalesCalculationResponse;
import org.army.shop.sales.to.SalesRequest;
import org.army.shop.sales.util.SalesToEntityTransformer;
import org.army.shop.sales.util.SalesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesServiceBLImpl implements SalesServiceBL {

    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private ApplicationConfiguration configuration;

    @Override
    public SalesCalculationResponse calculate(SalesRequest sales) {

        SalesCalculationResponse salesCalculationResponse = new SalesCalculationResponse();

        BigDecimal subtotal = SalesUtils.getSubTotal(sales.getInvoice().getItems());
        salesCalculationResponse.setSubTotal(subtotal);

        List<AmendmentTO> amendments = new ArrayList<>();
        configuration.getAmendments()
                .forEach((type, list) -> {
                    list.forEach(definition -> {
                        AmendmentTO amendmentTO = new AmendmentTO();
                        amendmentTO.setName(definition.getName());
                        amendmentTO.setAmount(SalesUtils.getAmendment(definition.getType(), definition.getValue(), subtotal));

                        amendments.add(amendmentTO);
                    });
                });

        salesCalculationResponse.setAmendments(amendments);
        salesCalculationResponse.setFinalTotal(salesCalculationResponse.getSubTotal().add(SalesUtils.getAmendmentsTotal(amendments)));

        return salesCalculationResponse;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse sell(SalesRequest sales) {

        SalesCalculationResponse salesCalculationResponse = calculate(sales);

        SalesInvoice salesInvoice = SalesToEntityTransformer.toSalesInvoice(sales);
        List<Amendment> amendments = salesCalculationResponse.getAmendments()
                .stream()
                .map(SalesToEntityTransformer::toAmendment)
                .collect(Collectors.toList());
        salesInvoice.setAmendments(amendments);

        salesInvoice.setTotal(SalesUtils.getInvoiceTotal(salesInvoice));

        commonDAO.add(salesInvoice);

        InventoryAdjustmentRequest inventoryAdjustmentRequest = SalesUtils.toInventoryAdjustmentRequest(sales);
        inventoryServiceClient.remove(inventoryAdjustmentRequest);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);

        return response;
    }

    @Override
    public BaseResponse cancelSale(CancelTransactionRequest cancel) {
//        TODO
        return null;
    }
}

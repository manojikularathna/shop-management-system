package org.army.shop.sales.bl.impl;

import org.army.common.accounting.client.TransactionServiceClient;
import org.army.common.accounting.to.AccountingRequest;
import org.army.common.accounting.to.common.OrganizationTO;
import org.army.common.accounting.to.transaction.TransactionTO;
import org.army.shop.common.CommonConstants;
import org.army.shop.common.conf.AccountingConfiguration;
import org.army.shop.common.conf.ShopManagementApplicationConfiguration;
import org.army.shop.sales.dao.SalesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class SalesSchedule {

    @Autowired
    private ShopManagementApplicationConfiguration configuration;

    @Autowired
    private TransactionServiceClient transactionServiceClient;

    @Autowired
    private SalesDAO salesDAO;

    @Scheduled(fixedRate = 5000)
    public void submitSales() {

        AccountingConfiguration accounting = configuration.getAccounting();
        LocalDate previousDate = LocalDate.now().minus(1, ChronoUnit.DAYS);

        Date salesDate = Date.from(previousDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        BigDecimal totalSales = salesDAO.totalSales(previousDate);

        AccountingRequest<TransactionTO> accountingRequest = new AccountingRequest<>();

        OrganizationTO organizationTO = new OrganizationTO();
        organizationTO.setOrganization(accounting.getOrganization());

        TransactionTO transactionTO = new TransactionTO();
        transactionTO.setDate(salesDate);
        transactionTO.setTransactionTypeCode(CommonConstants.TransactionTypeCode.SALES);
        transactionTO.setAmount(totalSales);
        transactionTO.setCashBookCode(accounting.getCashbooks().get("CASH")); // TODO -- need to be sent in request

        accountingRequest.setOrganization(organizationTO);
        accountingRequest.setPayload(transactionTO);

        transactionServiceClient.aggregate(accountingRequest);

    }

}

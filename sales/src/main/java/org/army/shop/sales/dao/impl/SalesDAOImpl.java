package org.army.shop.sales.dao.impl;

import org.army.shop.sales.dao.SalesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Repository
public class SalesDAOImpl implements SalesDAO {

    @Autowired
    private EntityManager entityManager;

    public BigDecimal totalSales(LocalDate date) {

        Date fromDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(date.plus(1, ChronoUnit.DAYS).atStartOfDay(ZoneId.systemDefault()).toInstant());

        BigDecimal totalSales;
        Object total =  entityManager
                .createQuery(" select sum (i.total) from SalesInvoice i where i.date >= :fromDate and i.date < :toDate ")
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getSingleResult();

        if (total != null) {
            totalSales = (BigDecimal) total;
        } else {
            totalSales = BigDecimal.ZERO;
        }
        return totalSales;
    }
}
